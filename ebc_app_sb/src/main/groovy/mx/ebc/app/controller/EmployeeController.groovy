package mx.ebc.app.controller

import mx.ebc.app.model.Employee
import mx.ebc.app.repository.EmployeeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/employees")
class EmployeeController {
  @Autowired
  EmployeeRepository employeeRepository

  @GetMapping
  String listEmployees(Map map){
    map.employees = employeeRepository.findAll()
    "employees/list"
  }

  @GetMapping
  String employeeForm(Map map){
    map.employee = new Employee()
    "employees/form"
  }

  @PostMapping
  String saveEmployee(@ModelAttribute Employee employee){
    employeeRepository.save(employee)
    "redirect:/employees"
  }
}
