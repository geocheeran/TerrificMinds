# Territory API

This repository contains the source code for the Territory API project. The API allows users to manage and retrieve information about territories and their ancestors.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [Testing the APIs](#testing-the-apis)
- [Running the Unit Tests](#running-the-unit-tests)

## Prerequisites

Before you begin, make sure you have the following installed on your machine:

- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) or a compatible version.
- [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/) or another IDE with Java support.
- [Postman](https://www.postman.com/) for testing the APIs.

## Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/geocheeran/TerrificMinds.git
    ```

2. Change into the project directory:

    ```bash
    cd TerrificMinds
    cd territory
    ```

3. Build the project using Maven:

    ```bash
    mvn clean install
    ```

## Running the Application

1. Open the project in IntelliJ IDEA or your preferred IDE.
2. Navigate to the `TerritoryApplication` class in the `src/main/java/com/example/territory` directory.
3. Run the `main` method in the `TerritoryApplication` class.
4. The application will start on `http://localhost:8080`.
5. You can modify the list of territories in the JSON file located at `src/main/resources/territories.json`.

## Testing the APIs

1. Launch Postman and create a new request.
2. Set the request method `GET` and the URL for the API endpoint `http://localhost:8080/api/ancestors/{name}`.
3. You can type the name of the place instead of `name` eg:`http://localhost:8080/api/ancestors/chennai`
4. Keep headers and request body as default.
5. Send the request and observe the response.
6. Response will be the Object containing array of ancestors. eg:
   `{
    "ancestors": [
        "Tamil Nadu",
        "India"
    ]
}`

## Running the Unit Tests

1. Open the project in IntelliJ IDEA or your preferred IDE.
2. Navigate to the `src/test/java/com/example/Territory` directory.
3. Right-click on the test classes `TerritoryControllerTest` and select "Run" to execute the tests.
4. You can also run all tests in the project by navigating to the `src/test` directory, right-clicking, and selecting "Run All Tests."


