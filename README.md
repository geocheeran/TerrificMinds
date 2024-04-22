# Territory API

This repository contains the source code for the Territory API project. The API allows users to manage and retrieve information about territories and their ancestors.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [Testing the APIs](#testing-the-apis)
- [Running the Unit Tests](#running-the-unit-tests)
- [Contributing](#contributing)
- [License](#license)

## Prerequisites

Before you begin, make sure you have the following installed on your machine:

- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) or a compatible version.
- [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/) or another IDE with Java support.
- [Postman](https://www.postman.com/) for testing the APIs.

## Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/yourusername/territory-api.git
    ```

2. Change into the project directory:

    ```bash
    cd territory-api
    ```

3. Build the project using Maven:

    ```bash
    mvn clean install
    ```

## Running the Application

1. Open the project in IntelliJ IDEA or your preferred IDE.
2. Navigate to the `TerritoryApplication` class in the `src/main/java/com/example/Territory` directory.
3. Run the `main` method in the `TerritoryApplication` class.
4. The application will start on `http://localhost:8080`.

## Testing the APIs

1. Launch Postman and create a new request.
2. Set the request method (e.g., `GET`, `POST`, etc.) and the URL for the API endpoint.
3. Set any necessary headers and request body based on the API documentation.
4. Send the request and observe the response.

## Running the Unit Tests

1. Open the project in IntelliJ IDEA or your preferred IDE.
2. Navigate to the `src/test/java/com/example/Territory` directory.
3. Right-click on the test classes (e.g., `TerritoryServiceTest` or `TerritoryControllerTest`) and select "Run" to execute the tests.
4. You can also run all tests in the project by navigating to the `src/test` directory, right-clicking, and selecting "Run All Tests."

## Contributing

Contributions are welcome! If you would like to contribute, please follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b my-feature-branch`).
3. Make your changes and commit them (`git commit -m "Add new feature"`).
4. Push to the branch (`git push origin my-feature-branch`).
5. Open a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.
