# Vulnerable Perl Application

This application is intentionally vulnerable and contains the following issues:
- Plaintext secrets in `config.pl`
- SQL Injection vulnerability in the `app.pl` endpoint
- Cross-Site Scripting (XSS) vulnerability in the `app.pl` endpoint
- Command injection vulnerability (not explicitly shown but can be implemented)

## Installation

Run `cpanm --installdeps .` to install dependencies.

## Running the Application

Use a local server to run the application, e.g., `perl app.pl`.