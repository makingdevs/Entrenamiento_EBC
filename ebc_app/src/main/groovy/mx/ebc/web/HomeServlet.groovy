package mx.ebc.web

import javax.servlet.annotation.WebServlet
import javax.servlet.http.*

@WebServlet("/")
class HomeServlet extends HttpServlet {

  void doGet(HttpServletRequest request, HttpServletResponse response){
    println request.properties
    println "*"*50
    println response.properties
  }
}
