from flask import Flask, request, render_template_string
import sqlite3
from config import DB_PASSWORD

app = Flask(__name__)

# Vulnerable endpoint for SQL Injection
@app.route('/user', methods=['GET'])
def user():
    user_id = request.args.get('id')
    query = f"SELECT * FROM users WHERE id = {user_id};"  # SQL Injection vulnerability
    # Execute query...

    return "User data"

# Vulnerable endpoint for XSS
@app.route('/greet', methods=['GET'])
def greet():
    name = request.args.get('name')
    return render_template_string(f"<h1>Hello, {name}</h1>")  # XSS vulnerability

if __name__ == '__main__':
    app.run(debug=True)