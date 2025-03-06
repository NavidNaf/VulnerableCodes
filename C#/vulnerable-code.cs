using System;
using System.Data.SqlClient;
using System.IO;
using System.Diagnostics;

class Program
{
    static void Main()
    {
        Console.Write("Enter username: ");
        string username = Console.ReadLine();
        
        string connectionString = "Server=myserver;Database=mydb;User Id=admin;Password=12345;"; // Hardcoded secret
        string query = "SELECT * FROM Users WHERE Username = '" + username + "'"; // SQL Injection Vulnerability
        
        using (SqlConnection connection = new SqlConnection(connectionString))
        {
            SqlCommand command = new SqlCommand(query, connection);
            connection.Open();
            SqlDataReader reader = command.ExecuteReader();
            while (reader.Read())
            {
                Console.WriteLine("User found: " + reader["Username"].ToString());
            }
        }
        
        // Storing sensitive data in plaintext
        File.WriteAllText("credentials.txt", "AdminPassword=SuperSecret123");
        
        // Command Injection Vulnerability
        Console.Write("Enter command to execute: ");
        string userCommand = Console.ReadLine();
        Process.Start("cmd.exe", "/C " + userCommand); // Potentially dangerous
    }
}
