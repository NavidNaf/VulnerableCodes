import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@SpringBootApplication
@RestController
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    // Vulnerable endpoint for SQL Injection
    @GetMapping("/user")
    public String getUser(@RequestParam String id) {
        String query = "SELECT * FROM users WHERE id = " + id; // SQL Injection vulnerability
        // Execute query...

        return "User data";
    }

    // Vulnerable endpoint for XSS
    @GetMapping("/greet")
    public String greet(@RequestParam String name) {
        return "<h1>Hello, " + name + "</h1>"; // XSS vulnerability
    }

    // Vulnerable endpoint for Command Injection
    @GetMapping("/exec")
    public String execCommand(@RequestParam String cmd) {
        try {
            Process process = Runtime.getRuntime().exec(cmd); // Command Injection vulnerability
            return "Executed command: " + cmd;
        } catch (Exception e) {
            return "Error executing command.";
        }
    }

    // Database connection method
    public Connection connectToDatabase() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "supersecretpassword"); // Plaintext secret
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}