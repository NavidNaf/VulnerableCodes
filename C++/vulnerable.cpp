#include <iostream>
#include <string>
#include <cstdlib>
#include <cstring>

using namespace std;

// Vulnerable function with buffer overflow
void vulnerableFunction(char *input) {
    char buffer[50];
    strcpy(buffer, input); // Buffer overflow vulnerability
    cout << "Buffer content: " << buffer << endl;
}

// Command Injection example
void commandInjectionExample(char *userInput) {
    char command[100];
    sprintf(command, "echo %s", userInput); // Command Injection vulnerability
    system(command);
}

int main(int argc, char *argv[]) {
    if (argc < 2) {
        cout << "Usage: " << argv[0] << " <input>" << endl;
        return 1;
    }

    // Test buffer overflow
    vulnerableFunction(argv[1]);

    // Test command injection
    commandInjectionExample(argv[1]);

    return 0;
}