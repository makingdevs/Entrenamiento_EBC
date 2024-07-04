package mx.ebc.web

import mx.ebc.model.Empleado
import mx.ebc.service.EmpleadoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.method.annotation.RequestParamMethodArgumentResolver

@Controller
@RequestMapping("/empleado")
class EmpleadoController {

    @Autowired
    EmpleadoService empleadoService

    @GetMapping
    String showAll(Map model) {
        List<Empleado> empleados = empleadoService.listAll()
        model.empleados = empleados
        "empleado/list"
    }

    @GetMapping("/show/{id}")
    String show(@PathVariable("id") String id, Map model){
       Empleado empleado = empleadoService.findEmpleadoById(id)
       model.empleado = empleado
       "empleado/show"
    }

    @GetMapping("/create")
    String showForm(Map model){
        model.empleado = new Empleado()
        "empleado/form"
    }

    @PostMapping("/create")
    String submitForm(@ModelAttribute Empleado empleado){
        Empleado saveEmpleado = empleadoService.create(empleado.properties)
        "redirect:/empleado"
    }

    @GetMapping("/update")
    String showFormForUpdate(@RequestParam("trab_id") String id, Map model){
        Empleado empleado = empleadoService.findEmpleadoById(id)
        model.empleado = empleado
        "empleado/form"
    }

    @PostMapping("/update")
    String submitFormUpdate(@ModelAttribute Empleado empleado){
        Empleado saveEmpleado = empleadoService.update(empleado)
        "redirect:/empleado"
    }
}
