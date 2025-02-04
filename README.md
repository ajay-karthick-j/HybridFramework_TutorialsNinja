# Selenium Java Hybrid Automation Framework

## Project Overview
This project is a Selenium-based hybrid test automation framework developed in Java. It automates the testing of the TutorialsNinja e-commerce website, leveraging a combination of the Page Object Model (POM), Page Factory Model, and Data-Driven Testing.

## Key Features

### ✅ Hybrid Framework Implementation
The framework effectively integrates **Data-Driven Testing**, **Page Object Model (POM)**, and **Page Factory** to ensure scalability and maintainability. This hybrid approach allows for better organization of code and easier updates.

### ✅ TestNG Integration
The test execution flow is well-structured using **TestNG annotations**, **suite files**, and **parallel execution support**. This ensures efficient test management and execution.

### ✅ Extent Reports with Listeners
The framework includes a proper implementation of **TestNG listeners** to generate detailed execution reports. These reports make debugging easier and provide insights into test execution results.

### ✅ Code Optimization & Modularity
The framework leverages the **Page Object Model (POM)** with **Page Factory** to improve code reusability and readability. Additionally, a **properties file** is used to avoid hardcoded values, ensuring flexibility and configurability.

### ✅ Data-Driven Approach
Test data is managed using **Apache POI**, which fetches values from Excel sheets. This enables dynamic test execution and allows for easy maintenance of test data.

### ✅ Exception Handling
The framework includes proper handling of **StaleElementReferenceException** through **Page Factory**, reducing test flakiness and improving reliability.

### ✅ CI/CD Readiness
The project uses **Maven** for dependency management and **Git/GitHub** for version control. This setup makes it easy to integrate with **Jenkins** for continuous execution, ensuring seamless CI/CD pipeline integration.

## Prerequisites
- Java (JDK 21)
- Maven
- Selenium WebDriver
- TestNG
- Apache POI
- Extent Reports
- Git & GitHub
- Jenkins (optional for CI/CD)

## Installation
1. Clone the repository:
   ```sh
   git clone https://github.com/ajay-karthick-j/HybridFramework_TutorialsNinja.git
   ```
2. Navigate to the project directory:
   ```sh
   cd HybridFramework_TutorialsNinja
   ```
3. Install dependencies:
   ```sh
   mvn clean install
   ```

## Project Structure
```
HybridFramework_TutorialsNinja/
│-- src/main/java/ (Main framework code)
│-- src/test/java/ (Test scripts)
│-- src/test/resources/ (Test data and config files)
│-- test-output/ (Extent Reports and logs)
│-- pom.xml (Maven dependencies)
│-- testng.xml (TestNG test suite)
```

## Running Tests
To execute tests using TestNG, run:
```sh
mvn test
```
Or, execute specific test cases from the IDE.

## Reporting
- **Extent Reports**: Detailed test execution reports are generated in the `test-output/` directory.
- **Screenshots**: Captured for failed test cases and stored in the `screenshots/` directory.

## Key Implementations
- Used **TestNG Listeners** to integrate Extent Reports.
- Implemented **Page Factory** to reduce the risk of StaleElementReferenceException.
- Replaced hardcoded test data with an external **Properties file**.
- Optimized code to improve execution speed and maintainability.

## Contact
For queries, reach out to [ajaykarthick.jeyaraman@gmail.com](mailto:ajaykarthick.jeyaraman@gmail.com).

