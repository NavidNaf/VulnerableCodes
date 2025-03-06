using System;
using System.Data.SqlClient;
using System.Web.Mvc;

namespace VulnerableApp.Controllers
{
    public class HomeController : Controller
    {
        private string connectionString = "Server=myserver;Database=mydb;User Id=admin;Password=12345;"; // Hardcoded Secret

        public ActionResult Index()
        {
            return View();
        }

        public ActionResult GetUser(string username)
        {
            string query = "SELECT * FROM Users WHERE Username = '" + username + "'"; // SQL Injection Vulnerability
            
            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                SqlCommand command = new SqlCommand(query, connection);
                connection.Open();
                SqlDataReader reader = command.ExecuteReader();
                while (reader.Read())
                {
                    ViewBag.Message = "User found: " + reader["Username"].ToString();
                }
            }
            return View();
        }
    }
}
