from flask import Flask, request, render_template_string
from markupsafe import escape  # Import escape from markupsafe
import sqlite3

app = Flask(__name__)

# Database setup (for demonstration purposes)
def init_db():
    conn = sqlite3.connect('demo.db')
    c = conn.cursor()
    c.execute('CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY, username TEXT, password TEXT)')
    c.execute("INSERT INTO users (username, password) VALUES ('admin', 'password123')")
    c.execute("INSERT INTO users (username, password) VALUES ('user', 'userpass')")
    conn.commit()
    conn.close()

@app.route('/')
def home():
    return '''
        <h1>Welcome to the Vulnerable App</h1>
        <form action="/sqli" method="GET">
            <label for="user_id">User ID:</label>
            <input type="text" name="user_id" required>
            <button type="submit">Get User Data</button>
        </form>
        <form action="/xss" method="GET">
            <label for="name">Your Name:</label>
            <input type="text" name="name" required>
            <button type="submit">Greet Me</button>
        </form>
        <form action="/command" method="GET">
            <label for="command">Command:</label>
            <input type="text" name="command" required>
            <button type="submit">Execute</button>
        </form>
    '''

@app.route('/sqli')
def sqli():
    user_id = request.args.get('user_id')
    # Vulnerable to SQL Injection
    conn = sqlite3.connect('demo.db')
    c = conn.cursor()
    query = f"SELECT * FROM users WHERE id = {user_id}"  # Vulnerable to SQL injection
    c.execute(query)
    user = c.fetchall()
    conn.close()
    
    return f"User data: {user}"

@app.route('/xss')
def xss():
    name = request.args.get('name')
    # Vulnerable to XSS
    return f"<h1>Hello, {name}</h1>"  # Output without escaping to allow XSS

@app.route('/command')
def command_injection():
    command = request.args.get('command')
    # Vulnerable to Command Injection
    import os
    output = os.popen(command).read()
    return f"<pre>Command Output: {escape(output)}</pre>"

if __name__ == '__main__':
    init_db()  # Initialize the database
    app.run(debug=True, host='0.0.0.0', port=6789)