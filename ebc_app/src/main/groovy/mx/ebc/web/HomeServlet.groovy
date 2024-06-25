package mx.ebc.web

import javax.servlet.annotation.WebServlet
import javax.servlet.http.*

@WebServlet("/")
class HomeServlet extends HttpServlet {

  void doGet(HttpServletRequest request, HttpServletResponse response){
    println request.properties
    println "*"*50
    println response.properties

    response.writer.println """
    <!DOCTYPE html>
    <html lang="en">
    <head>
      <meta charset="UTF-8">
      <title></title>
    </head>
    <body>
      <h1>Hola mundo EBC</h1>
    </body>
    </html>
    """
  }
}
