# Selenium Java Hybrid Automation Framework

## Project Overview
This project is a Selenium-based hybrid test automation framework developed in Java. It automates the testing of the TutorialsNinja e-commerce website, leveraging a combination of the Page Object Model (POM), Page Factory Model, and Data-Driven Testing.

## Features
✅ Hybrid Framework Implementation – Your project effectively combines Data-Driven Testing, Page Object Model (POM), and Page Factory, which enhances scalability and maintainability.

✅ TestNG Integration – Well-structured test execution flow using TestNG annotations, suite files, and parallel execution support.

✅ Extent Reports with Listeners – Proper implementation of TestNG listeners to generate detailed execution reports, making debugging easier.

✅ Code Optimization & Modularity – Efficient usage of Page Object Model (POM) with Page Factory to improve reusability and readability. The properties file ensures flexibility by avoiding hardcoded values.

✅ Data-Driven Approach – Test data is managed using Apache POI to fetch values from Excel, enabling dynamic test execution.

✅ Exception Handling – Proper handling of StaleElementReferenceException through Page Factory, reducing test flakiness.

✅ CI/CD Readiness – Maven for dependency management and version control with Git/GitHub, making it easy to integrate with Jenkins for continuous execution.

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

