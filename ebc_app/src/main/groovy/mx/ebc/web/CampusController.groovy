package mx.ebc.web

import mx.ebc.model.StvCamp
import org.springframework.stereotype.*
import org.springframework.beans.factory.annotation.*
import mx.ebc.service.CampusService
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class CampusController {

  @Autowired
  CampusService campusService

  @RequestMapping(value = "/hello", method = RequestMethod.GET)
  String home(Map model) {
    List<StvCamp> campuses = campusService.allCampus()
    model.mensaje = "Saludo desde el controller"
    model.campuses = campuses
    "home"
  }

  @RequestMapping(value = "/hello", method = RequestMethod.POST)
  String form(@RequestParam("campo") String campo1) {
    println campo1
    "home"
  }

}