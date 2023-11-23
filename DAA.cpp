Develop a program and analyze complexity to find all occurrences of a pattern P in a given string S.
#include <iostream>
#include <vector>
using namespace std;
vector<int> find_all_occurrences(string pattern, string string) {
  vector<int> occurrences;
  int index = 0;
  while (true) {
    index = string.find(pattern, index);
    if (index == -1) {
      break;
    }
    occurrences.push_back(index);
    index += pattern.length();
  }
  return occurrences;
}
int main() {
  string pattern = "abc";
  string string = "abcabcdef";

  vector<int> occurrences = find_all_occurrences(pattern, string);

  cout << "Occurrences of the pattern '" << pattern << "' in the string '" << string << "':" << endl;
  for (int occurrence : occurrences) {
    cout << occurrence << endl;
  }

  return 0;
}
Develop a program and analyze complexity to find shortest paths in a graph with positive edge weights using Dijkstra’s algorithm.
#include <iostream>
#include <vector>
#include <set>
#include <climits>
using namespace std;
const int V = 6;
int minDistance(vector<int>& dist, set<int>& sptSet) {
    int min = INT_MAX, min_index;
    for (int v = 0; v < V; v++) {
        if (!sptSet.count(v) && dist[v] <= min) {
            min = dist[v];
            min_index = v;
        }
    }
    return min_index;
}
void printSolution(vector<int>& dist) {
    cout << "Vertex \t Distance from Source\n";
    for (int i = 0; i < V; i++)
        cout << i << "\t" << dist[i] << endl;
}
void dijkstra(int graph[V][V], int src) {
    vector<int> dist(V, INT_MAX);
    set<int> sptSet;

    dist[src] = 0;

    for (int count = 0; count < V - 1; count++) {
        int u = minDistance(dist, sptSet);
        sptSet.insert(u);

        for (int v = 0; v < V; v++) {
            if (!sptSet.count(v) && graph[u][v] && dist[u] != INT_MAX && dist[u] + graph[u][v] < dist[v])
                dist[v] = dist[u] + graph[u][v];
        }
    }

    printSolution(dist);
}
int main() {
    int graph[V][V] = {
        {0, 4, 0, 0, 0, 0},
        {4, 0, 8, 0, 0, 0},
        {0, 8, 0, 7, 0, 4},
        {0, 0, 7, 0, 9, 14},
        {0, 0, 0, 9, 0, 10},
        {0, 0, 4, 14, 10, 0}
    };

    dijkstra(graph, 0);

    return 0;
}
Develop  a  program and analyze complexity  to do a depth-first search (DFS) on an undirected graph. Implementing an application of DFS such as (i) to find the topological sort of a directed acyclic graph, OR (ii) to find a path from source to goal in a maze.
#include <iostream>
#include <vector>
#include <stack>
using namespace std;
class Graph {
private:
    int V;
    vector<vector<int>> adj;

    void topologicalSortUtil(int v, vector<bool>& visited, stack<int>& stack) {
        visited[v] = true;
        
        for (int i : adj[v]) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }
        
        stack.push(v);
    }
public:
    Graph(int vertices) {
        V = vertices;
        adj.resize(V);
    }

    void addEdge(int u, int v) {
        adj[u].push_back(v);
    }
    vector<int> topologicalSort() {
        vector<bool> visited(V, false);
        stack<int> stack;
        
        for (int i = 0; i < V; ++i) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }
        
        vector<int> result;
        while (!stack.empty()) {
            result.push_back(stack.top());
            stack.pop();
        }
        return result;
    }
};

int main() {
    Graph g(6);
    g.addEdge(5, 2);
    g.addEdge(5, 0);
    g.addEdge(4, 0);
    g.addEdge(4, 1);
    g.addEdge(2, 3);
    g.addEdge(3, 1);
    vector<int> topologicalOrder = g.topologicalSort();
    cout << "Topological Sort: ";
    for (int vertex : topologicalOrder) {
        cout << vertex << " ";
    }
    cout << endl;
    return 0;
}
Develop a program and analyze complexity to implement 0-1 Knapsack using Dynamic Programming.
#include <iostream>
#include <vector>
using namespace std;
int knapsack_01(vector<int>& weights, vector<int>& values, int capacity) {
    int n = weights.size();
    vector<vector<int>> dp(n + 1, vector<int>(capacity + 1, 0));
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= capacity; j++) {
            if (weights[i - 1] <= j) {
                dp[i][j] = max(values[i - 1] + dp[i - 1][j - weights[i - 1]], dp[i - 1][j]);
            } 
            else {
                dp[i][j] = dp[i - 1][j];
            }
        }
    }
    return dp[n][capacity];
}
int main() {
    vector<int> weights = {1, 3, 4, 5};
    vector<int> values = {1, 4, 5, 7};
    int capacity = 7;
    int result = knapsack_01(weights, values, capacity);
    cout << "The maximum value that can be obtained is: " << result << endl;
    return 0;
}
Develop a program and analyze complexity to implement subset-sum problem using Dynamic Programming.
#include <iostream>
#include <vector>

using namespace std;

bool isSubsetSum(vector<int>& nums, int target_sum) {
    int n = nums.size();
    vector<vector<bool>> dp(n + 1, vector<bool>(target_sum + 1, false));
    for (int i = 0; i <= n; ++i) {
        dp[i][0] = true;
    }
    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= target_sum; ++j) {
            if (nums[i - 1] <= j) {
                dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
            } else {
                dp[i][j] = dp[i - 1][j];
            }
        }
    }
    return dp[n][target_sum];
}

int main() {
    vector<int> nums = {3, 34, 4, 12, 5, 2};
    int target_sum = 9;
    bool result = isSubsetSum(nums, target_sum);
    
    if (result) {
        cout << "Subset with the given sum exists." << endl;
    } else {
        cout << "No subset with the given sum exists." << endl;
    }
    
    return 0;
} 
Code to implement Quick sort
#include <iostream>
using namespace std;
void swap(int *a, int *b) {
  int temp = *a;
  *a = *b;
  *b = temp;
}
int partition(int arr[], int low, int high) {
  int pivot = arr[high];
  int i = (low - 1);

  for (int j = low; j < high; j++) {
    if (arr[j] <= pivot) {
      i++;
      swap(&arr[i], &arr[j]);
    }
  }
  swap(&arr[i + 1], &arr[high]);
  return (i + 1);
}
void quickSort(int arr[], int low, int high) {
  if (low < high) {
    int pi = partition(arr, low, high);
    quickSort(arr, low, pi - 1);
    quickSort(arr, pi + 1, high);
  }
}
int main() {
  int arr[] = {12, 17, 6, 25, 1, 5};
  int n = sizeof(arr) / sizeof(arr[0]);

  quickSort(arr, 0, n - 1);

  for (int i = 0; i < n; i++) {
    cout << arr[i] << " ";
  }

  cout << endl;

  return 0;
}
Code to perform operation on singly and doubly Linked list
//singly
#include <iostream>
class Node {
public:
    int value;
    Node* next;
    Node(int val) {
        value = val;
        next = nullptr;
    }
};
Node* insertAtBeginning(Node* head, int value) {
    Node* newNode = new Node(value);
    newNode->next = head;
    head = newNode;
    return head;
}
Node* insertAtEnd(Node* head, int value) {
    Node* newNode = new Node(value);
    if (!head) {
        head = newNode;
    } else {
        Node* current = head;
        while (current->next) {
            current = current->next;
        }
        current->next = newNode;
    }
    return head;
}
Node* deleteAtBeginning(Node* head) {
    if (!head) {
        return nullptr;
    }
    Node* newHead = head->next;
    delete head;
    return newHead;
}
Node* deleteAtEnd(Node* head) {
    if (!head) {
        return nullptr;
    }
    if (!head->next) {
        delete head;
        return nullptr;
    }
    Node* current = head;
    while (current->next->next) {
        current = current->next;
    }
    delete current->next;
    current->next = nullptr;
    return head;
}
void printLinkedList(Node* head) {
    Node* current = head;
    while (current) {
        std::cout << current->value << " ";
        current = current->next;
    }
    std::cout << std::endl;
}

int main() {
    Node* head = nullptr;
    head = insertAtBeginning(head, 10);
    head = insertAtBeginning(head, 5);
    head = insertAtEnd(head, 20);
    printLinkedList(head);
    head = deleteAtBeginning(head);
    head = deleteAtEnd(head);
    printLinkedList(head);
    while (head) {
        Node* temp = head;
        head = head->next;
        delete temp;
    }

    return 0;
}
B.
//doubly
#include <iostream>

class Node {
public:
    int value;
    Node* prev;
    Node* next;

    Node(int val) {
        value = val;
        prev = nullptr;
        next = nullptr;
    }
};

Node* insertAtBeginning(Node* head, int value) {
    Node* newNode = new Node(value);
    if (!head) {
        head = newNode;
    } else {
        newNode->next = head;
        head->prev = newNode;
        head = newNode;
    }
    return head;
}
Node* insertAtEnd(Node* head, int value) {
    Node* newNode = new Node(value);
    if (!head) {
        head = newNode;
    } else {
        Node* current = head;
        while (current->next) {
            current = current->next;
        }
        current->next = newNode;
        newNode->prev = current;
    }
    return head;
}
Node* deleteAtBeginning(Node* head) {
    if (!head) {
        return nullptr;
    }
    Node* newHead = head->next;
    if (newHead) {
        newHead->prev = nullptr;
    }
    delete head;
    return newHead;
}
Node* deleteAtEnd(Node* head) {
    if (!head) {
        return nullptr;
    }
    if (!head->next) {
        delete head;
        return nullptr;
    }
    Node* current = head;
    while (current->next) {
        current = current->next;
    }
    if (current->prev) {
        current->prev->next = nullptr;
    }
    delete current;
    return head;
}
void printLinkedListForward(Node* head) {
    Node* current = head;
    while (current) {
        std::cout << current->value << " ";
        current = current->next;
    }
    std::cout << std::endl;
}
void printLinkedListBackward(Node* tail) {
    Node* current = tail;
    while (current) {
        std::cout << current->value << " ";
        current = current->prev;
    }
    std::cout << std::endl;
}

int main() {
    Node* head = nullptr;
    head = insertAtBeginning(head, 10);
    head = insertAtBeginning(head, 5);
    head = insertAtEnd(head, 20);
    printLinkedListForward(head);
    Node* tail = head;
    while (tail->next) {
        tail = tail->next;
    }
    printLinkedListBackward(tail);
    head = deleteAtBeginning(head);
    head = deleteAtEnd(head);
    printLinkedListForward(head);
    while (head) {
        Node* temp = head;
        head = head->next;
        delete temp;
    }

    return 0;
}

