const express = require('express');
const { connectToDatabase } = require('./database');
const config = require('./config');

const app = express();
app.use(express.json());

// Vulnerable endpoint for SQL Injection
app.get('/user', (req, res) => {
    const userId = req.query.id;
    const query = `SELECT * FROM users WHERE id = ${userId};`; // SQL Injection vulnerability
    // Execute query...

    res.send("User data");
});

// Vulnerable endpoint for XSS
app.get('/greet', (req, res) => {
    const name = req.query.name;
    res.send(`<h1>Hello, ${name}</h1>`); // XSS vulnerability
});

// Vulnerable endpoint for Command Injection
app.get('/exec', (req, res) => {
    const command = req.query.cmd;
    require('child_process').exec(command, (error, stdout, stderr) => {
        res.send(stdout); // Command Injection vulnerability
    });
});

app.listen(3000, () => {
    console.log('App listening on port 3000');
    connectToDatabase();
});