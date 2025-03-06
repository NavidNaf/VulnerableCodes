# Vulnerable PHP Application

This application is intentionally vulnerable and contains the following issues:
- Plaintext secrets in `config.php`
- SQL Injection vulnerability in the `index.php` endpoint
- Cross-Site Scripting (XSS) vulnerability in the `index.php` endpoint
- Command injection vulnerability (not explicitly shown but can be implemented)

## Installation

Run `composer install` to install dependencies.

## Running the Application

Use a local server to run the application, e.g., `php -S localhost:8000`.