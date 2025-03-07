<?php
require 'config.php';
require 'database.php';

// Database connection to demo.db
$db = new PDO('sqlite:/Users/navidfazle.rabbi/Documents/Project/smithy-visualizer/VulnerableCodes/PHP/demo.db');

// Enable error reporting for debugging
error_reporting(E_ALL);
ini_set('display_errors', 1);

// Secure endpoint for SQL Injection
if (isset($_GET['id'])) {
    $user_id = $_GET['id'];

    // Allowing for SQL Injection testing (for demonstration only)
    // Directly use the input in the SQL query without sanitization
    $query = "SELECT * FROM users WHERE id = '$user_id'"; // Vulnerable to SQL injection
    $stmt = $db->prepare($query);
    $stmt->execute();
    $users = $stmt->fetchAll(PDO::FETCH_ASSOC);
    
    if ($users) {
        echo "User data: " . htmlspecialchars(json_encode($users)); // Output user data safely
    } else {
        echo "No users found.";
    }
}

if (isset($_GET['name'])) {
    $name = $_GET['name'];
    echo "<h1>Hello, " . $name . "</h1>"; // This will allow XSS to execute if not sanitized
}

// Command Injection Vulnerability
if (isset($_GET['command'])) {
    $command = $_GET['command'];
    // Execute the command directly without sanitization
    $output = shell_exec($command);
    echo "<pre>Command Output: " . htmlspecialchars($output) . "</pre>"; // Display output
}
?>

<!-- HTML Form for User Interaction -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Interaction</title>
</head>
<body>
    <h1>Check User Data</h1>
    <form method="GET" action="">
        <label for="id">User ID:</label>
        <input type="text" id="id" name="id" required>
        <button type="submit">Get User Data</button>
    </form>

    <h1>Say Hello</h1>
    <form method="GET" action="">
        <label for="name">Your Name:</label>
        <input type="text" id="name" name="name" required>
        <button type="submit">Greet Me</button>
    </form>

    <h1>Execute Command</h1>
    <form method="GET" action="">
        <label for="command">Command:</label>
        <input type="text" id="command" name="command" required>
        <button type="submit">Execute</button>
    </form>
</body>
</html>