import sqlite3

def connect_to_database():
    conn = sqlite3.connect('vulnerable.db')
    print("Connected to database")
    return conn