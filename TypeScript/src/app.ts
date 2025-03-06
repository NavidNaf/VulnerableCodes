import express from 'express';
import { connectToDatabase } from './database';
import { dbPassword } from './config';

const app = express();

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

app.listen(3000, () => {
    console.log('App listening on port 3000');
    connectToDatabase();
});