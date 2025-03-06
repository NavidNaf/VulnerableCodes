using Microsoft.AspNetCore.Mvc;
using System.Data.SqlClient;
using System.Threading.Tasks;

namespace VulnerableAspNetApp.Controllers
{
    public class HomeController : Controller
    {
        private string connectionString = "Server=localhost;Database=test;User Id=sa;Password=supersecretpassword;"; // Plaintext secret

        public IActionResult Index(string id)
        {
            // Vulnerable endpoint for SQL Injection
            string query = $"SELECT * FROM Users WHERE Id = {id};"; // SQL Injection vulnerability
            // Execute query...

            return View();
        }

        public IActionResult Greet(string name)
        {
            // Vulnerable endpoint for XSS
            return View("Greet", name); // XSS vulnerability
        }
    }
}