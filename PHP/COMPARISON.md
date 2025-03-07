# SAST and SCA Comparison for PHP Application

This document compares the findings from the Semgrep and Snyk static analysis tools for the PHP application.

## Semgrep Findings

Semgrep identified a total of **6 code findings** across the application, including:

1. **Command Injection**:
   - **Severity**: High
   - **Details**: User-controlled data flows into `shell_exec`, which could allow command injection.
   - **Affected Code**:
     ```php
     $output = shell_exec($command);
     ```

2. **SQL Injection**:
   - **Severity**: High
   - **Details**: User-controlled data flows into a manually constructed SQL query, making it vulnerable to SQL injection.
   - **Affected Code**:
     ```php
     $query = f"SELECT * FROM users WHERE id = {user_id}";
     ```

3. **Cross-Site Scripting (XSS)**:
   - **Severity**: High
   - **Details**: Unsanitized input flows into an HTML response, which may lead to XSS.
   - **Affected Code**:
     ```php
     return f"<h1>Hello, {name}</h1>";
     ```

## Snyk Findings

Snyk identified a total of **3 code issues**, categorized as follows:

1. **Command Injection**:
   - **Severity**: High
   - **Details**: Unsanitized input from an HTTP parameter flows into `shell_exec`, leading to command injection.
   - **Affected Code**:
     ```php
     $output = shell_exec($command);
     ```

2. **SQL Injection**:
   - **Severity**: High
   - **Details**: Unsanitized input from an HTTP parameter flows into a SQL query, making it vulnerable to SQL injection.
   - **Affected Code**:
     ```php
     $query = f"SELECT * FROM users WHERE id = {user_id}";
     ```

3. **Cross-Site Scripting (XSS)**:
   - **Severity**: High
   - **Details**: Unsanitized input flows into an HTML response, which may lead to XSS.
   - **Affected Code**:
     ```php
     return f"<h1>Hello, {name}</h1>";
     ```

## Summary of Findings

- **Semgrep** found **6 issues** with a focus on command injection, SQL injection, and XSS.
- **Snyk** found **3 issues**, highlighting similar vulnerabilities to those identified by Semgrep.

Both tools highlight critical vulnerabilities that need to be addressed to secure the application effectively.