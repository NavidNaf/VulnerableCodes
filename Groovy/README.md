# Vulnerable Groovy Application

This application is intentionally vulnerable and contains the following issues:
- Plaintext secrets in the database connection string
- SQL Injection vulnerability in the `/user` endpoint
- Cross-Site Scripting (XSS) vulnerability in the `/greet` endpoint
- Command injection vulnerability in the `/exec` endpoint
- A large number of dependency issues (15+)

## Installation

Run `gradle build` to install dependencies.

## Running the Application

Use `gradle run` to run the application.