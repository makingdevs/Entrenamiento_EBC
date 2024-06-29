package mx.ebc.web

import org.springframework.stereotype.*
import org.springframework.beans.factory.annotation.*
import mx.ebc.service.CampusService

@Controller
class CampusController {

  @Autowired
  CampusService campusService

}
