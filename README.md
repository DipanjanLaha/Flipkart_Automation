# Flipkart Automation

## Overview
This project automates the checkout process on Flipkart using Selenium WebDriver. It navigates through product selection, cart addition, payment details entry, and final order placement.

## Features
- Opens Flipkart and searches for a product
- Adds the product to the cart
- Proceeds to checkout
- Fills in shipping and billing details
- Selects a payment method (Credit/Debit/UPI)
- Completes the checkout process

## Tech Stack
- **Language**: Java
- **Testing Framework**: TestNG
- **Automation Tool**: Selenium WebDriver
- **Build Tool**: Maven

## Prerequisites
Ensure you have the following installed:
- **Java 8+**
- **Maven**
- **ChromeDriver** (matching your Chrome version)
- **Selenium WebDriver dependencies** (managed via Maven)

## Installation & Setup
1. **Clone the repository**:
   ```sh
   git clone https://github.com/DipanjanLaha/Flipkart_Automation.git
   cd Flipkart_Automation
   ```
2. **Install dependencies**:
   ```sh
   mvn clean install
   ```
3. **Set up WebDriver**:
   - Ensure `chromedriver.exe` is available in your system path or update `webdriver.chrome.driver` in the code.

## Running the Tests
The main test case is located in:
```
src/test/java/com/flipkart/tests/secondTest.java
```
Run the test using Maven:
```sh
mvn test
```

Or run it directly in an IDE (e.g., IntelliJ, Eclipse) by executing `secondTest.java`.

## Test Flow
1. Open **Flipkart**
2. Search and select a product
3. Add it to the cart
4. Enter delivery details
5. Select payment method
6. Place the order

## Implicit Wait Handling
The script includes an **implicit wait of 4 seconds**:
```java
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
```
This ensures that elements are given enough time to load before actions are performed.

## Contributors
- **Dipanjan Laha** ([@DipanjanLaha](https://github.com/DipanjanLaha))

## License
This project is open-source and available under the **MIT License**.

