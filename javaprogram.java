1.// Arraylist
  import java.util.ArrayList;
import java.util.Scanner;

class StringListOperations {
    private ArrayList<String> stringList;

    public StringListOperations() {
        stringList = new ArrayList<>();
    }

    public void insertItem(String item) {
        stringList.add(item);
        System.out.println("Inserted successfully");
    }

    public void searchItem(String item) {
        if (stringList.contains(item)) {
            System.out.println("Item found in the list.");
        } else {
            System.out.println("Item not found in the list.");
        }
    }

    public void deleteItem(String item) {
        if (stringList.contains(item)) {
            stringList.remove(item);
            System.out.println("Deleted successfully");
        } else {
            System.out.println("Item does not exist.");
        }
    }

    public void displayItems() {
        System.out.println("The Items in the list are :");
        for (String item : stringList) {
            System.out.println(item);
        }
    }
}

public class arraylist {
    public static void main(String[] args) {
        StringListOperations slist = new StringListOperations();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Insert");
            System.out.println("2. Search");
            System.out.println("3. Delete");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.println("Enter your choice:");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.println("Enter the item to be inserted:");
                    String itemToInsert = scanner.nextLine();
                    slist.insertItem(itemToInsert);
                    break;
                case 2:
                    System.out.println("Enter the item to search:");
                    String itemToSearch = scanner.nextLine();
                    slist.searchItem(itemToSearch);
                    break;
                case 3:
                    System.out.println("Enter the item to delete:");
                    String itemToDelete = scanner.nextLine();
                    slist.deleteItem(itemToDelete);
                    break;
                case 4:
                    slist.displayItems();
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }
}
// 2. calculator
  import java.util.Scanner;
abstract class Account {
    double interestRate;
    double amount;

    abstract double calculateInterest() throws IllegalArgumentException;
}
class FDAccount extends Account {
    int noOfDays;
    int ageOfAccountHolder;

    @Override
    double calculateInterest() throws IllegalArgumentException {
        if (amount <= 0 || noOfDays <= 0) {
            throw new IllegalArgumentException("Amount and number of days must be positive values.");
        }
        if (amount <= 10000000) {
            if (noOfDays >= 7 && noOfDays <= 14)
                return amount * 0.045;
            else if (noOfDays >= 15 && noOfDays <= 29)
                return amount * 0.0475;
            else if (noOfDays >= 30 && noOfDays <= 45)
                return amount * 0.055;
        } else {
            if (noOfDays >= 7 && noOfDays <= 14)
                return amount * 0.065;
            else if (noOfDays >= 15 && noOfDays <= 29)
                return amount * 0.0675;
        }
        throw new IllegalArgumentException("Invalid number of days.");
    }
}

class SBAccount extends Account {
    @Override
    double calculateInterest() throws IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be a positive value.");
        }
        return amount * 0.04; 
    }
}

class RDAccount extends Account {
    int noOfMonths;
    double monthlyAmount;
    @Override
    double calculateInterest() throws IllegalArgumentException {
        if (monthlyAmount <= 0 || noOfMonths <= 0) {
            throw new IllegalArgumentException("Monthly amount and number of months must be positive values.");
        }
        if (noOfMonths == 6)
            return monthlyAmount * 6 * 0.075;
        else if (noOfMonths == 9)
            return monthlyAmount * 9 * 0.0775;
        else if (noOfMonths == 12)
            return monthlyAmount * 12 * 0.08;
        throw new IllegalArgumentException("Invalid number of months.");
    }
}

public class calculator{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select the option:");
            System.out.println("1. Interest Calculator –SB");
            System.out.println("2. Interest Calculator –FD");
            System.out.println("3. Interest Calculator –RD");
            System.out.println("4. Exit");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    SBAccount sbAccount = new SBAccount();
                    System.out.println("Enter the Average amount in your account:");
                    sbAccount.amount = scanner.nextDouble();
                    try {
                        System.out.println("Interest gained: Rs. " + sbAccount.calculateInterest());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    FDAccount fdAccount = new FDAccount();
                    System.out.println("Enter the FD amount:");
                    fdAccount.amount = scanner.nextDouble();
                    System.out.println("Enter the number of days:");
                    fdAccount.noOfDays = scanner.nextInt();
                    System.out.println("Enter your age:");
                    fdAccount.ageOfAccountHolder = scanner.nextInt();
                    try {
                        System.out.println("Interest gained is: " + fdAccount.calculateInterest());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    RDAccount rdAccount = new RDAccount();
                    System.out.println("Enter the RD monthly amount:");
                    rdAccount.monthlyAmount = scanner.nextDouble();
                    System.out.println("Enter the number of months:");
                    rdAccount.noOfMonths = scanner.nextInt();
                    try {
                        System.out.println("Interest gained is: " + rdAccount.calculateInterest());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please select again.");
                    break;
            }
        }
    }
}
// 3.cards
  import java.util.*;
class Card {
    String symbol;
    int number;
    public Card(String symbol, int number) {
        this.symbol = symbol;
        this.number = number;
    }
}
public class cards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Number of Cards: ");
        int n = scanner.nextInt();
        Map<String, List<Card>> cardMap = new TreeMap<>();
        for (int i = 0; i < n; ++i) {
            System.out.println("Enter card " + (i + 1) + ":");
            String symbol = scanner.next();
            int number = scanner.nextInt();
            Card card = new Card(symbol, number);
            cardMap.computeIfAbsent(symbol, k -> new ArrayList<>()).add(card);
        }
        System.out.println("Distinct Symbols are:");
        for (String symbol : cardMap.keySet()) {
            System.out.print(symbol + " ");
        }
        System.out.println();
        for (Map.Entry<String, List<Card>> entry : cardMap.entrySet()) {
            String symbol = entry.getKey();
            System.out.println("Cards in " + symbol + " Symbol:");
            List<Card> cards = entry.getValue();
            int sum = 0;
            for (Card card : cards) {
                System.out.println(card.symbol + " " + card.number);
                sum += card.number;
            }
            System.out.println("Number of cards: " + cards.size());
            System.out.println("Sum of Numbers: " + sum);
        }
    }
}
// Employee exp 2.4
  
import java.io.*;
import java.util.*;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private int age;
    private double salary;

    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + age + " " + salary;
    }
}

public class emp2_4 {
    private static final String FILE_NAME = "employee_data.txt";
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        loadDataFromFile();

        while (true) {
            System.out.println("\nMain Menu");
            System.out.println("1. Add an Employee");
            System.out.println("2. Display All");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    displayAllEmployees();
                    break;
                case 3:
                    saveDataToFile();
                    System.out.println("Exiting the System");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Employee Age: ");
        int age = scanner.nextInt();
        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();

        employees.add(new Employee(id, name, age, salary));
        System.out.println("Employee added successfully.");
    }

    private static void displayAllEmployees() {
        System.out.println("----Report-----");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
        System.out.println("----End of Report-----");
    }

    private static void saveDataToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
            System.out.println("Data saved to file: " + FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private static void loadDataFromFile() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
                employees.addAll((List<Employee>) ois.readObject());
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
// Palindrome no
import java.util.Scanner;
public class  palindroome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String longestPalindrome = createLongestPalindrome(input);
        System.out.println("Longest Palindrome: " + longestPalindrome);
    }
    public static String createLongestPalindrome(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(input);
        String reversedInput = new StringBuilder(input).reverse().toString();
        stringBuilder.append(reversedInput);
        return stringBuilder.toString();
    }
}

// videostore launcher

class Video {
    private String title;
    private boolean checkedOut;
    private double averageRating;
    private int numberOfRatings;

    public Video(String title) {
        this.title = title;
        this.checkedOut = false;
        this.averageRating = 0.0;
        this.numberOfRatings = 0;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void checkOut() {
        checkedOut = true;
    }

    public void returnVideo() {
        checkedOut = false;
    }

    public void receiveRating(int rating) {
        averageRating = (averageRating * numberOfRatings + rating) / (numberOfRatings + 1);
        numberOfRatings++;
    }

    public double getAverageRating() {
        return averageRating;
    }
}

class VideoStore {
    private Video[] inventory;

    public VideoStore() {
        this.inventory = new Video[10];
    }

    public void addVideo(String title) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null) {
                inventory[i] = new Video(title);
                System.out.println("Video '" + title + "' added to the inventory.");
                return;
            }
        }
        System.out.println("Error: Inventory is full. Cannot add video '" + title + "'.");
    }

    public void checkOut(String title) {
        for (Video video : inventory) {
            if (video != null && video.getTitle().equals(title) && !video.isCheckedOut()) {
                video.checkOut();
                System.out.println("Video '" + title + "' checked out.");
                return;
            }
        }
        System.out.println("Error: Video '" + title + "' not found or already checked out.");
    }

    public void returnVideo(String title) {
        for (Video video : inventory) {
            if (video != null && video.getTitle().equals(title) && video.isCheckedOut()) {
                video.returnVideo();
                System.out.println("Video '" + title + "' returned.");
                return;
            }
        }
        System.out.println("Error: Video '" + title + "' not found or not checked out.");
    }

    public void receiveRating(String title, int rating) {
        for (Video video : inventory) {
            if (video != null && video.getTitle().equals(title)) {
                video.receiveRating(rating);
                System.out.println("Rating of " + rating + " received for video '" + title + "'.");
                return;
            }
        }
        System.out.println("Error: Video '" + title + "' not found.");
    }

    public void listInventory() {
        System.out.println("Current Inventory:");
        for (Video video : inventory) {
            if (video != null) {
                System.out.println("Title: " + video.getTitle() +
                        ", Checked Out: " + video.isCheckedOut() +
                        ", Average Rating: " + video.getAverageRating());
            }
        }
    }
}

public class VideoStoreLauncher {
    public static void main(String[] args) {
        VideoStore videoStore = new VideoStore();

        // Add videos to the inventory
        videoStore.addVideo("The Matrix");
        videoStore.addVideo("Godfather II");
        videoStore.addVideo("Star Wars Episode IV: A New Hope");

        // Give ratings to the videos
        videoStore.receiveRating("The Matrix", 4);
        videoStore.receiveRating("The Matrix", 5);
        videoStore.receiveRating("Godfather II", 5);
        videoStore.receiveRating("Godfather II", 4);
        videoStore.receiveRating("Star Wars Episode IV: A New Hope", 3);

        // Rent and return videos
        videoStore.checkOut("The Matrix");
        videoStore.returnVideo("The Matrix");

        videoStore.checkOut("Godfather II");
        videoStore.returnVideo("Godfather II");

        videoStore.checkOut("Star Wars Episode IV: A New Hope");
        videoStore.returnVideo("Star Wars Episode IV: A New Hope");

        // List inventory
        videoStore.listInventory();
    }
}







