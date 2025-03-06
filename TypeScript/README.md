# Vulnerable TypeScript Application

This application is intentionally vulnerable and contains the following issues:
- Plaintext secrets in `config.ts`
- SQL Injection vulnerability in the `/user` endpoint
- Cross-Site Scripting (XSS) vulnerability in the `/greet` endpoint
- Command injection vulnerability (not explicitly shown but can be implemented)

## Installation

Run `npm install` to install dependencies.

## Running the Application

Use `npm start` to run the application.