require 'sinatra'
require 'sqlite3'
require_relative 'database'
require_relative 'config'

# Vulnerable endpoint for SQL Injection
get '/user' do
  user_id = params['id']
  query = "SELECT * FROM users WHERE id = #{user_id};" # SQL Injection vulnerability
  # Execute query...

  "User data"
end

# Vulnerable endpoint for XSS
get '/greet' do
  name = params['name']
  "<h1>Hello, #{name}</h1>" # XSS vulnerability
end

run! if app_file == $0