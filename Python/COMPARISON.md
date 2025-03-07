# SAST and SCA Comparison

This document compares the findings from the Semgrep and Snyk static analysis tools for the Python application.

## Semgrep Findings

Semgrep identified a total of **14 code findings** across the application, including:

1. **SQL Injection Vulnerabilities**:
   - **Severity**: High
   - **Details**: User-controlled data is passed to the `execute()` function, which could lead to SQL injection.
   - **Affected Code**: 
     ```python
     query = f"SELECT * FROM users WHERE id = {user_id}"
     ```

2. **Cross-Site Scripting (XSS)**:
   - **Severity**: High
   - **Details**: Directly returning a formatted string that includes user input can lead to XSS.
   - **Affected Code**:
     ```python
     return f"<h1>Hello, {name}</h1>"
     ```

3. **Command Injection**:
   - **Severity**: High
   - **Details**: User-controlled data is used in a system call, which could allow command injection.
   - **Affected Code**:
     ```python
     output = os.popen(command).read()
     ```

4. **Other Security Issues**:
   - Several other findings related to formatted SQL queries and unsafe practices in Flask were also reported.

## Snyk Findings

Snyk identified a total of **8 code issues**, categorized as follows:

1. **Hardcoded Credentials**:
   - **Severity**: Low to High
   - **Details**: Hardcoded credentials found in `config.py`.
   - **Affected Code**: 
     ```python
     DB_PASSWORD = "hardcoded_password"
     ```

2. **Debug Mode Enabled**:
   - **Severity**: Medium
   - **Details**: Running the application in debug mode poses a security risk.
   - **Affected Code**:
     ```python
     app.run(debug=True)
     ```

3. **Cross-Site Scripting (XSS)**:
   - **Severity**: Medium to High
   - **Details**: Unsanitized input can lead to XSS vulnerabilities in both the `/sqli` and `/xss` endpoints.
   - **Affected Code**:
     ```python
     return f"<h1>Hello, {name}</h1>"
     ```

4. **Command Injection**:
   - **Severity**: High
   - **Details**: Unsanitized input used in a system call could lead to command injection.
   - **Affected Code**:
     ```python
     output = os.popen(command).read()
     ```

## Summary of Findings

- **Semgrep** found **14 issues** with a focus on SQL injection, XSS, and command injection.
- **Snyk** found **8 issues**, including hardcoded credentials and debug mode risks, alongside similar vulnerabilities to those identified by Semgrep.

Both tools highlight critical vulnerabilities that need to be addressed to secure the application effectively.