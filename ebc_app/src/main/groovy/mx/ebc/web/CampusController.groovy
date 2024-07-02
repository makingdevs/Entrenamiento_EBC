package mx.ebc.web

import org.springframework.stereotype.*
import org.springframework.beans.factory.annotation.*
import mx.ebc.service.CampusService
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class CampusController {

  @Autowired
  CampusService campusService

  @RequestMapping(value = "/hello", method = RequestMethod.GET)
  String home(Model model) {
    model.addAttribute("mensaje", "Saludo desde el controller")
    // Hacemos cosas!!!!
    "home"
  }

}