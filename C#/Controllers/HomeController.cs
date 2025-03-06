using Microsoft.AspNetCore.Mvc;
using System.Data.SqlClient;

namespace VulnerableCSharpApp.Controllers
{
    public class HomeController : Controller
    {
        private string connectionString = "Server=localhost;Database=test;User Id=sa;Password=supersecretpassword;"; // Plaintext secret

        public IActionResult Index(string id)
        {
            // Vulnerable endpoint for SQL Injection
            string query = $"SELECT * FROM Users WHERE Id = {id}"; // SQL Injection vulnerability
            // Execute query...

            return View();
        }

        public IActionResult Greet(string name)
        {
            // Vulnerable endpoint for XSS
            return View("Greet", name); // XSS vulnerability
        }

        public IActionResult Exec(string command)
        {
            // Vulnerable endpoint for Command Injection
            var process = new System.Diagnostics.Process();
            process.StartInfo.FileName = "cmd.exe";
            process.StartInfo.Arguments = $"/C {command}"; // Command Injection vulnerability
            process.StartInfo.RedirectStandardOutput = true;
            process.Start();
            return Content(process.StandardOutput.ReadToEnd());
        }
    }
}