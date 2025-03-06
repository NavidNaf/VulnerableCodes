# Vulnerable Scala Application

This application is intentionally vulnerable and contains the following issues:
- Plaintext secrets in the application (not explicitly shown)
- SQL Injection vulnerability in the `/user` endpoint
- Cross-Site Scripting (XSS) vulnerability in the `/greet` endpoint
- Command injection vulnerability (not explicitly shown but can be implemented)

## Installation

Run `sbt compile` to install dependencies.

## Running the Application

Use `sbt run` to run the application.