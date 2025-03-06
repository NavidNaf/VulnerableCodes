# Vulnerable Python Application

This application is intentionally vulnerable and contains the following issues:
- Plaintext secrets in `config.py`
- SQL Injection vulnerability in the `/user` endpoint
- Cross-Site Scripting (XSS) vulnerability in the `/greet` endpoint
- Command injection vulnerability (not explicitly shown but can be implemented)
- Cryptographic issues in `insecure_crypto.py`

## Installation

Run `pip install -r requirements.txt` to install dependencies.

## Running the Application

Use `python app.py` to run the application.