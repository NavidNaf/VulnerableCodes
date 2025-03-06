express = require 'express'
app = express()

# Vulnerable endpoint for SQL Injection
app.get '/user', (req, res) ->
  userId = req.query.id
  sql = "SELECT * FROM users WHERE id = #{userId};"  # SQL Injection vulnerability
  # Execute SQL query...

  res.send "User data"

app.listen 3000, ->
  console.log "App listening on port 3000"