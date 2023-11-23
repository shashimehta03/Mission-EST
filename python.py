Implement K-Nearest Neighbor on any data set

import numpy as np
from sklearn import datasets
from sklearn.model_selection import train_test_split
from sklearn.neighbors import KNeighborsClassifier
from sklearn.metrics import accuracy_score

iris = datasets.load_iris()
X = iris.data
y = iris.target

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.3, random_state=42)

k = 3
knn = KNeighborsClassifier(n_neighbors=k)
knn.fit(X_train, y_train)
y_pred = knn.predict(X_test)
accuracy = accuracy_score(y_test, y_pred)
print(f"Accuracy: {accuracy:.2f}")

new_data_point = np.array([[5.1, 3.5, 1.4, 0.2]])
predicted_class = knn.predict(new_data_point)
print(f"Predicted class for new data point: {iris.target_names[predicted_class][0]}")

Implementation of Python basic Libraries such as Math, Numpy and Scipy .  
  
import numpy as np 
from sklearn.linear_model import LinearRegression 
import matplotlib.pyplot as plt 
 
X	= np.array([1, 2, 3, 4, 5]) 
Y	= np.array([2, 4, 5, 4, 5]) 
 
X = X.reshape(-1, 1) 
 
model = LinearRegression() 
 
model.fit(X, Y) 
 
Y_pred = model.predict(X) 
 
plt.scatter(X, Y, label='Data Points')
plt.xlabel('X') 
plt.ylabel('Y') 
plt.legend()
plt.show() 

import numpy as np
import matplotlib.pyplot as plt
from sklearn.linear_model import LogisticRegression

# Training data
X = np.array([[1], [2], [3], [4], [5], [6], [7], [8]])  # Independent variable
y = np.array([0, 0, 0, 0, 1, 1, 1, 1])  # Binary dependent variable (0 or 1)

# Create and fit a logistic regression model
model = LogisticRegression()
model.fit(X, y)

slope = model.coef_[0][0]
intercept = model.intercept_[0]

equation = f"p = 1 / (1 + e^(-({slope:.2f}x + {intercept:.2f})))"
print("Logistic Equation:", equation)

X_new = np.array([[9], [10]])
probabilities = model.predict_proba(X_new)
print("Predicted probabilities for new values:", probabilities)

X_range = np.linspace(0, 10, 100).reshape(-1, 1)
probabilities_range = model.predict_proba(X_range)[:, 1]

plt.scatter(X, y, label='Data')
plt.plot(X_range, probabilities_range, color='red', linewidth=2, label='Logistic Regression')
plt.xlabel('X')
plt.ylabel('Probability')
plt.legend()
plt.title('Logistic Regression Example')
plt.grid(True)
plt.show()

Implementation of Python basic Libraries such as Math, Numpy and Scipy .
import math
square_root = math.sqrt(16)
print("the squre root is ",square_root)
radius = 5
area = math.pi * radius ** 2
print("the area is ",area)
number = 5
factorial = math.factorial(number)
print("the factorial is ",factorial)
import numpy as np
array = np.array([1, 2, 3, 4, 5])
print("the array is ",array)
sum = np.sum(array)
print("the sm of array element is ",sum)
mean = np.mean(array)
print("the mean of array is ",mean)
import scipy.linalg as linalg
A = np.array([[1, 2], [3, 4]])
b = np.array([5, 6])
x = linalg.solve(A, b)
print(x)


Implementation of Python Libraries for ML application such as Pandas and  Matplotlib 
import matplotlib.pyplot as plt

x = [1, 2, 3, 4, 5]
y = [10, 15, 7, 12, 9]

plt.plot(x, y)
plt.xlabel('X-axis')
plt.ylabel('Y-axis')
plt.title('Basic Line Plot')
plt.show()

#scatter plot
plt.scatter(x, y, color='red', marker='o', label='Data Points')
plt.legend()
plt.show()




