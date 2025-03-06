# Vulnerable Go Application

This application is intentionally vulnerable and contains the following issues:
- Plaintext secrets in `config.go`
- SQL Injection vulnerability in the `/user` endpoint
- Cross-Site Scripting (XSS) vulnerability in the `/greet` endpoint
- Command injection vulnerability (not explicitly shown but can be implemented)

## Installation

Run `go mod tidy` to install dependencies.

## Running the Application

Use `go run main.go` to run the application.