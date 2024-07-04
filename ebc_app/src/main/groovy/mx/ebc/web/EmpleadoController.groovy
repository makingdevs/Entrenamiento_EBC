package mx.ebc.web

import mx.ebc.model.Empleado
import mx.ebc.service.EmpleadoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

@Controller
class EmpleadoController {

    @Autowired
    EmpleadoService empleadoService

    @GetMapping("/empleado")
    String showForm(Map model){
        model.empleado = new Empleado()
        "empleado/show"
    }

    @PostMapping("/empleado")
    String submitForm(@ModelAttribute Empleado empleado){
        println empleado.properties
        "empleado/show"
    }
}
