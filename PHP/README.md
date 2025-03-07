# Vulnerable PHP Application

This application is intentionally vulnerable and contains the following issues:
- Plaintext secrets
- SQL Injection vulnerability
- Cross-Site Scripting (XSS) vulnerability
- Command injection vulnerability

## Installation

Run `composer install` to install dependencies (if any).

## Running the Application

### Option 1: Using Docker

1. Build the Docker image:
   ```bash
   docker build -t php-vulnerable-app .

   ```
2. Run the Docker container:
   ```bash
   docker run -d -p 8080:80 php-vulnerable-app
   ```
3. Access the application at http://localhost:8080

### Option 2: Using PHP built-in web server 

Use a local server to run the application:

```bash
php -S localhost:8080
```
Then, navigate to http://localhost:8000 in your web browser.
