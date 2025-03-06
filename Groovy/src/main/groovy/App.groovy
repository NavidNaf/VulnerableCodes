import groovy.sql.Sql
import spark.Spark

class App {
    static void main(String[] args) {
        Sql sql = Sql.newInstance("jdbc:mysql://localhost:3306/test", "root", "supersecretpassword", "com.mysql.cj.jdbc.Driver") // Plaintext secret

        Spark.get("/user", { req, res ->
            String userId = req.queryParams("id")
            String query = "SELECT * FROM users WHERE id = ${userId};" // SQL Injection vulnerability
            // Execute query...

            return "User data"
        })

        Spark.get("/greet", { req, res ->
            String name = req.queryParams("name")
            return "<h1>Hello, ${name}</h1>" // XSS vulnerability
        })

        Spark.get("/exec", { req, res ->
            String command = req.queryParams("cmd")
            def process = "cmd /c ${command}".execute() // Command Injection vulnerability
            return process.text
        })

        Spark.init()
    }
}