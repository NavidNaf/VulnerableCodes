require 'sqlite3'

def connect_to_database
  db = SQLite3::Database.new "vulnerable.db"
  puts "Connected to database"
  db
end