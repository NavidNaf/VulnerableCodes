import 'package:express/express.dart';
import '../lib/database.dart';
import 'config.dart';

void main() {
  var app = Express();

  // Vulnerable endpoint for SQL Injection
  app.get('/user', (req, res) {
    var userId = req.query['id'];
    var sql = "SELECT * FROM users WHERE id = $userId;";  // SQL Injection vulnerability
    // Execute SQL query...

    res.send("User data");
  });

  // Vulnerable endpoint for XSS
  app.get('/greet', (req, res) {
    var name = req.query['name'];
    res.send("<h1>Hello, $name</h1>");  // XSS vulnerability
  });

  app.listen(3000, () {
    print("App listening on port 3000");
  });
}