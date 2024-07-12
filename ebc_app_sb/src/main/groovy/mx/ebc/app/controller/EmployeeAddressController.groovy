package mx.ebc.app.controller

import mx.ebc.app.model.Address
import mx.ebc.app.model.Employee
import mx.ebc.app.repository.EmployeeRepository
import mx.ebc.app.service.EmployeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/empleados/{empleadoId}/addresses")
class EmployeeAddressController {

  @Autowired
  EmployeeRepository employeeRepository

  @Autowired
  EmployeeService employeeService

  @GetMapping
  String addressForm(@PathVariable("empleadoId") Integer empleadoId, Map model){
    Employee employee = employeeRepository.findById(empleadoId)?.get()
    Address address = new Address(employee: employee)
    model.address = address
    "addresses/form"
  }
  @PostMapping
  String saveAddress(@PathVariable("empleadoId") Integer empleadoId, @ModelAttribute("address") Address address){
    employeeService.addAddressToEmployee(empleadoId, address)
    "redirect:/empleados/${empleadoId}"
  }
}
