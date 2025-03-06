# Vulnerable Code Samples

This repository contains a collection of intentionally vulnerable applications written in various programming languages. The purpose of these samples is to demonstrate common security vulnerabilities that can be used for testing Static Application Security Testing (SAST) and Software Composition Analysis (SCA) tools.

## Directory Overview

- **ASP.NET**: Contains a vulnerable ASP.NET application that demonstrates SQL injection, cross-site scripting (XSS), command injection, and plaintext secrets in configuration files.

- **C**: Includes a vulnerable C application that demonstrates buffer overflow and SQL injection vulnerabilities.

- **C++**: Contains a vulnerable C++ application that showcases buffer overflow and command injection vulnerabilities.

- **C#**: Features a vulnerable C# application that includes SQL injection, XSS, command injection, and plaintext secrets.

- **Java**: Contains a vulnerable Java application that demonstrates SQL injection, XSS, command injection, and plaintext secrets.

- **JavaScript**: Includes a vulnerable JavaScript application that showcases SQL injection, XSS, command injection, and plaintext secrets.

- **Python**: Contains a vulnerable Python application that demonstrates SQL injection, XSS, command injection, and cryptographic issues.

- **Groovy**: Contains a vulnerable Groovy application that illustrates SQL injection, XSS, command injection, and plaintext secrets.

- **PHP**: Contains a vulnerable PHP application that demonstrates SQL injection, XSS, command injection, and plaintext secrets.

- **TypeScript**: Includes a vulnerable TypeScript application that showcases SQL injection, XSS, command injection, and plaintext secrets.

- **Ruby**: Contains a vulnerable Ruby application that demonstrates SQL injection, XSS, command injection, and plaintext secrets.

- **Go**: Includes a vulnerable Go application that showcases SQL injection, XSS, command injection, and plaintext secrets.

- **Perl**: Contains a vulnerable Perl application that demonstrates SQL injection, XSS, command injection, and plaintext secrets.

- **CoffeeScript**: Includes a vulnerable CoffeeScript application that showcases SQL injection, XSS, command injection, and plaintext secrets.

- **Dart**: Contains a vulnerable Dart application that demonstrates SQL injection, XSS, command injection, and plaintext secrets.

- **Scala**: Includes a vulnerable Scala application that showcases SQL injection, XSS, command injection, and plaintext secrets.

## Using SAST and SCA Scanners

To analyze the vulnerabilities in this directory, you can use various SAST and SCA tools. Here are some general steps:

1. **Choose Your Tools**: Select appropriate SAST and SCA tools based on your requirements. Popular options include:
   - SAST Tools: SonarQube, Checkmarx, Fortify, Veracode
   - SCA Tools: OWASP Dependency-Check, Snyk, Black Duck

2. **Run SAST Scans**:
   - Configure the SAST tool to point to the root of this directory.
   - Run the scan to identify vulnerabilities in the codebase, such as SQL injection, XSS, command injection, and buffer overflows.

3. **Run SCA Scans**:
   - Use SCA tools to analyze the dependencies listed in the project files (e.g., `package.json`, `pom.xml`, `appsettings.json`, etc.).
   - Identify any known vulnerabilities in the dependencies and check for outdated or insecure libraries.

4. **Review Reports**:
   - After running the scans, review the generated reports to understand the vulnerabilities present in the applications.
   - Prioritize remediation efforts based on the severity of the vulnerabilities identified.

5. **Remediation**:
   - Address the vulnerabilities as per the recommendations provided by the SAST and SCA tools. This may include code fixes, updating dependencies, and implementing secure coding practices.

## Disclaimer

These applications are intentionally vulnerable and should only be used in a controlled environment for educational purposes. Do not deploy these applications in a production environment.