package mx.ebc.app.controller

import mx.ebc.app.model.Employee
import mx.ebc.app.repository.EmployeeRepository
import mx.ebc.app.service.MailService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/empleados")
class EmployeeController {
  @Autowired
  EmployeeRepository employeeRepository
  @Autowired
  MailService mailService

  @GetMapping
  String listEmployees(Map map){
    map.employees = employeeRepository.findAll()
    "employees/list"
  }

  @GetMapping("/{id}")
  String showEmployee(@PathVariable("id") Integer id, Map model){
    Employee employee = employeeRepository.findByIdWithAddresses(id)?.get()
    model.employee = employee
    "employees/show"
  }

  @GetMapping("/report")
  String employeeReport(Map map){
    mailService.sendSimpleMessage("juan@makingdevs.com", "Saludos", "Saludos desde la APP")
    "redirect:/empleados"
  }

  @GetMapping("/new")
  String employeeForm(Map map){
    map.employee = new Employee()
    "employees/form"
  }

  @PostMapping
  String saveEmployee(@ModelAttribute("employee") Employee employee){
    employeeRepository.save(employee)
    "redirect:/empleados"
  }

  @GetMapping("/edit/{id}")
  String showEditForm(@PathVariable("id") Integer id, Map model){
    Employee employee = employeeRepository.findById(id).orElseThrow({
      new RuntimeException("No se encuentra el empleado")})
    model.employee = employee
    "employees/form"
  }

  @GetMapping("/delete/{id}")
  String deleteEmployee(@PathVariable("id") Integer id, Map model){
    Employee employee = employeeRepository.findById(id).orElseThrow({
      new RuntimeException("No se encuentra el empleado")})
    employeeRepository.delete(employee)
    "redirect:/empleados"
  }
}
