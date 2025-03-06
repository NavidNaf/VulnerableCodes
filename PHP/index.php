<?php
require 'config.php';
require 'database.php';

// Vulnerable endpoint for SQL Injection
if (isset($_GET['id'])) {
    $user_id = $_GET['id'];
    $query = "SELECT * FROM users WHERE id = $user_id"; // SQL Injection vulnerability
    // Execute query...
    echo "User data";
}

// Vulnerable endpoint for XSS
if (isset($_GET['name'])) {
    $name = $_GET['name'];
    echo "<h1>Hello, $name</h1>"; // XSS vulnerability
}
?>