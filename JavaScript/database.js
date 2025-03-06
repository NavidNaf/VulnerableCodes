const mysql = require('mysql');
const config = require('./config');

function connectToDatabase() {
    const connection = mysql.createConnection({
        host: 'localhost',
        user: 'root',
        password: config.dbPassword,
        database: 'test'
    });

    connection.connect((err) => {
        if (err) throw err;
        console.log("Connected to database");
    });
}

module.exports = { connectToDatabase };