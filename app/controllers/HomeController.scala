package controllers

import javax.inject._

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper
import play.api.libs.ws.WSClient
import play.api.mvc._
import play.api.libs.json._

import scala.concurrent.ExecutionContext

@Singleton
class HomeController @Inject() (implicit context: ExecutionContext, ws: WSClient) extends Controller {

  def index = Action {
    Ok(views.html.index("Elastic Search Client"))
  }

  def search = Action.async { implicit request =>
    val values = request.body.asFormUrlEncoded;
    val field = values.get("field")(0)
    val term = values.get("term")(0)
    val searchType = values.get("searchType")(0)
    ws.url("http://localhost:8084/SpringRestCrud/es/" + searchType).withQueryString("field" -> field, "term" -> term).get().map { response =>
      val mapper = new ObjectMapper() with ScalaObjectMapper
      mapper.registerModule(DefaultScalaModule)
      val obj = mapper.readValue[Map[String, Object]](response.body)
      val hits = obj.get("hits").asInstanceOf[Some[Map[String, Object]]]
      val total = hits.toList(0).get("total").asInstanceOf[Some[Int]]
      val hitsSome = hits.toList(0).get("hits").asInstanceOf[Some[Map[String, Object]]]
      val hitsList = hitsSome.toList(0).asInstanceOf[List[Map[String, Object]]]
      Ok(views.html.result("Results", hitsList, total.toList(0).toString))
    }
  }
}
