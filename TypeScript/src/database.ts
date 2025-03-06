import { Client } from 'pg';

export const connectToDatabase = () => {
    const client = new Client({
        user: 'user',
        host: 'localhost',
        database: 'dbname',
        password: 'password',
        port: 5432,
    });
    client.connect();
    console.log("Connected to database");
};