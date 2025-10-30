
# 🛍️ Demo Web Shop Automation Framework

## Overview
This project is an automated testing framework for the [Demo Web Shop](https://demowebshop.tricentis.com/) application.  
It is built with **Java**, **Selenium WebDriver**, and **TestNG**, following the **Page Object Model (POM)** design pattern to keep the codebase organized, scalable, and easy to maintain.  
The project is managed using **Maven** for dependency management and build automation.

---

## 🧩 Features
- Built with **Selenium WebDriver** and **TestNG**
- Implements the **Page Object Model (POM)** structure for maintainability
- Modular folder structure for pages, tests, and configurations
- Reusable element locators and actions
- Configurable through Maven and testng.xml
- Easy to extend for new test scenarios

---

## 📁 Project Structure
```

DemoWebShop_Selenium/
│
├── src/
│   ├── main/java/          # Page classes and reusable utilities
│   └── test/java/          # Test classes organized by feature
│
├── testng.xml              # TestNG configuration file
├── pom.xml                 # Maven dependencies and build setup
└── README.md               # Project documentation

````

---

## 🧠 Test Scenarios Covered
Currently, the framework includes **basic functional test cases** for:
- **User Registration**: verifying that a new user can successfully register  
- **Login**: checking valid and invalid login credentials  
- **Product Page**: basic interactions such as viewing products and verifying product details  

> 📝 *The framework is designed to be easily extendable for future scenarios such as cart operations, checkout, and search functionality.*

---

## ⚙️ Setup Instructions

### 1. Clone the repository
```bash
git clone https://github.com/Gholami-Bahareh/DemoWebShop_Selenium.git
cd DemoWebShop_Selenium
````

### 2. Open the project in IntelliJ IDEA or Eclipse

Just import the project as a **Maven Project**.

### 3. Install dependencies

Maven will automatically download all required dependencies when you build the project.

### 4. Run the tests

You can run the tests using:

```bash
mvn clean test
```

Or directly through the **TestNG suite file** (`testng.xml`).

---

## 🧰 Technologies Used

* **Java 17+**
* **Selenium WebDriver**
* **TestNG**
* **Maven**
* **Page Object Model (POM)**

---

## 🚀 Future Improvements

* Add **ExtentReports** or **Allure** for advanced reporting
* Expand test coverage (Cart, Checkout, Search, etc.)
* Add CI/CD integration (e.g., GitHub Actions or Jenkins)
* Implement data-driven testing and reusable utilities

---

## 👩‍💻 Author

**Bahar Gholami**
📍 GitHub: [Gholami-Bahareh](https://github.com/Gholami-Bahareh)

---

## 📘 About

**DemoWebShop_Selenium** is an automation testing framework developed for validating key functionalities of the Demo Web Shop application using **Selenium WebDriver**, **TestNG**, and the **Page Object Model (POM)** design pattern.
It provides a clean, modular, and scalable structure that supports the creation of maintainable and extensible automated test suites for web applications.




