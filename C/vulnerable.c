#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Vulnerable function with buffer overflow
void vulnerableFunction(char *input) {
    char buffer[50];
    strcpy(buffer, input); // Buffer overflow vulnerability
    printf("Buffer content: %s\n", buffer);
}

// SQL Injection example
void sqlInjectionExample(char *userInput) {
    char query[100];
    sprintf(query, "SELECT * FROM users WHERE username = '%s';", userInput); // SQL Injection vulnerability
    printf("SQL Query: %s\n", query);
}

int main(int argc, char *argv[]) {
    if (argc < 2) {
        printf("Usage: %s <input>\n", argv[0]);
        return 1;
    }

    // Test buffer overflow
    vulnerableFunction(argv[1]);

    // Test SQL injection
    sqlInjectionExample(argv[1]);

    return 0;
}