package mx.ebc.web

import mx.ebc.model.StvCamp
import mx.ebc.service.CampusService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class CampusController {

  @Autowired
  CampusService campusService

  @GetMapping("/hello")
  String home(Map model) {
    List<StvCamp> campuses = campusService.allCampus()
    model.mensaje = "Saludo desde el controller"
    model.campuses = campuses
    "home"
  }

  @PostMapping("hello")
  String form(@RequestParam("campo") String campo1) {
    println campo1
    "home"
  }

}