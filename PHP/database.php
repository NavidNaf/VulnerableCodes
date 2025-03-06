<?php
function connect_to_database() {
    $conn = new mysqli('localhost', 'user', DB_PASSWORD, 'dbname');
    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }
    echo "Connected to database";
    return $conn;
}
?>