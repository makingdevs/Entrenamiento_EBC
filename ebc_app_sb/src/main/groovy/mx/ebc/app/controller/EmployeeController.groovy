package mx.ebc.app.controller

import mx.ebc.app.model.Employee
import mx.ebc.app.repository.EmployeeRepository
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

  @GetMapping
  String listEmployees(Map map){
    map.employees = employeeRepository.findAll()
    "employees/list"
  }

  @GetMapping("/new")
  String employeeForm(Map map){
    map.employee = new Employee()
    "employees/form"
  }

  @PostMapping
  String saveEmployee(@ModelAttribute("employee") Employee employee){
    employeeRepository.save(employee)
    "redirect:/employees"
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
    "redirect:/employees"
  }
}
