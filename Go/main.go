package main

import (
    "database/sql"
    "fmt"
    "log"
    "net/http"
    _ "github.com/go-sql-driver/mysql" // MySQL driver
    "html/template"
)

var db *sql.DB

// Vulnerable endpoint for SQL Injection
func userHandler(w http.ResponseWriter, r *http.Request) {
    userId := r.URL.Query().Get("id")
    query := fmt.Sprintf("SELECT * FROM users WHERE id = %s;", userId) // SQL Injection vulnerability
    // Execute query...

    fmt.Fprintf(w, "User data")
}

// Vulnerable endpoint for XSS
func greetHandler(w http.ResponseWriter, r *http.Request) {
    name := r.URL.Query().Get("name")
    tmpl := `<h1>Hello, %s</h1>` // XSS vulnerability
    fmt.Fprintf(w, tmpl, name)
}

func main() {
    var err error
    db, err = sql.Open("mysql", "user:password@/dbname") // Placeholder for database connection
    if err != nil {
        log.Fatal(err)
    }

    http.HandleFunc("/user", userHandler)
    http.HandleFunc("/greet", greetHandler)
    log.Fatal(http.ListenAndServe(":8080", nil))
}