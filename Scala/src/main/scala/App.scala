import org.http4s._
import org.http4s.dsl.Http4sDsl
import org.http4s.blaze.server.BlazeServerBuilder
import cats.effect._
import doobie._
import doobie.implicits._
import scala.concurrent.ExecutionContext.global

object App extends IOApp {
  val dsl = new Http4sDsl[IO]{}
  import dsl._

  // Vulnerable endpoint for SQL Injection
  def userRoute: HttpRoutes[IO] = HttpRoutes.of[IO] {
    case GET -> Root / "user" / id =>
      val query = s"SELECT * FROM users WHERE id = $id;" // SQL Injection vulnerability
      // Execute query...

      Ok("User data")
  }

  // Vulnerable endpoint for XSS
  def greetRoute: HttpRoutes[IO] = HttpRoutes.of[IO] {
    case GET -> Root / "greet" / name =>
      Ok(s"<h1>Hello, $name</h1>") // XSS vulnerability
  }

  def httpApp: HttpApp[IO] = (userRoute <+> greetRoute).orNotFound

  def run(args: List[String]): IO[ExitCode] = {
    BlazeServerBuilder[IO](global)
      .bindHttp(8080, "localhost")
      .withHttpApp(httpApp)
      .serve
      .compile
      .drain
      .as(ExitCode.Success)
  }
}