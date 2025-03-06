# Vulnerable Dart Application

This application is intentionally vulnerable and contains the following issues:
- Plaintext secrets in `config.dart`
- SQL Injection vulnerability in the `/user` endpoint
- Cross-Site Scripting (XSS) vulnerability in the `/greet` endpoint
- Command injection vulnerability (not explicitly shown but can be implemented)

## Installation

Run `pub get` to install dependencies.

## Running the Application

Use `dart run bin/main.dart` to run the application.