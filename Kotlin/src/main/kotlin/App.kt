import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.features.*
import io.ktor.request.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

fun main() {
    embeddedServer(Netty, port = 8080) {
        install(StatusPages) {
            exception<Throwable> { cause ->
                call.respond(HttpStatusCode.InternalServerError, cause.localizedMessage)
            }
        }
        Database.connect("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;", driver = "org.h2.Driver")
        transaction {
            SchemaUtils.create(Users)
        }
        routing {
            get("/user") {
                val userId = call.request.queryParameters["id"]
                val query = "SELECT * FROM users WHERE id = $userId" // SQL Injection vulnerability
                // Execute query...

                call.respondText("User data")
            }

            get("/greet") {
                val name = call.request.queryParameters["name"]
                call.respondText("<h1>Hello, $name</h1>", ContentType.Text.Html) // XSS vulnerability
            }
        }
    }.start(wait = true)
}

object Users : Table() {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 50)
}