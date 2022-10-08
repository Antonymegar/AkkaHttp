import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.Http.ServerBinding
import akka.http.scaladsl.server.Directives.{complete, get, path, pathEndOrSingleSlash, pathPrefix, post}
import akka.stream.ActorMaterializer

import scala.util.{Failure, Success, Try}
import scala.concurrent.ExecutionContext

object Server extends  App {

  val host = "0.0.0.0"
  val port = 9000


  implicit val system: ActorSystem = ActorSystem("helloworld")
  implicit val executor: ExecutionContext = system.dispatcher
  implicit val materializer: ActorMaterializer = ActorMaterializer()


  def route = path("hello") {
    get {
      complete("Hello, World!")
    }

  }

  val bindingFuture = Http().bindAndHandle(route, host, port)

  bindingFuture.onComplete {

    case Success(serverBinding: ServerBinding)=>println(s"listening to ${serverBinding.localAddress}")
    case Failure(error) => println(s"error: ${error.getMessage}")
  }
}


