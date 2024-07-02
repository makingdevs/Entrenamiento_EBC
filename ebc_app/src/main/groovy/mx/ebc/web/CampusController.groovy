package mx.ebc.web

import org.springframework.stereotype.*
import org.springframework.beans.factory.annotation.*
import mx.ebc.service.CampusService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class CampusController {

  @Autowired
  CampusService campusService

  @ResponseBody
  @RequestMapping("/hello")
  String home() {
    "Hola mundo!!! cómo estás?"
  }

}