# Selenium Java Hybrid Automation Framework

## Project Overview
This project is a Selenium-based hybrid test automation framework developed in Java. It automates the testing of the TutorialsNinja e-commerce website, leveraging a combination of the Page Object Model (POM), Page Factory Model, and Data-Driven Testing.

## Features
- **Hybrid Framework**: Combines Data-Driven Testing, Page Object Model (POM), and Page Factory.
- **Selenium WebDriver**: Used for browser automation.
- **TestNG**: Manages test execution and reporting.
- **Listeners for Extent Reports**: Integrated to generate detailed test execution reports.
- **Apache POI**: Handles Excel-based test data.
- **Properties File**: Stores configuration values to replace hardcoded data.
- **Code Optimization**: Implemented best practices to enhance maintainability.
- **Screenshot Capture**: Automated screenshots using Selenium functions.
- **Page Factory Design**: Helps prevent StaleElementReferenceException.
- **CI/CD Integration**: Configured with Jenkins for continuous testing.

## Prerequisites
- Java (JDK 21)
- Maven
- Selenium WebDriver
- TestNG
- Apache POI
- Extent Reports
- Git & GitHub
- Jenkins (optional for CI/CD)
- Browser Drivers (ChromeDriver, GeckoDriver, etc.)

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
For queries, reach out to [your-email@example.com](mailto:ajaykarthick.jeyaraman@gmail.com).

