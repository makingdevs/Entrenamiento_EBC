package mx.ebc.app.service

import mx.ebc.app.model.Address
import mx.ebc.app.model.Employee
import mx.ebc.app.repository.EmployeeRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class EmployeeServiceTests {

  @Autowired
  EmployeeService employeeService

  @Autowired
  EmployeeRepository employeeRepository

  @Test
  void testAddAddressToEmployee(){
    // Creo un Employee de manera inicial
    Employee employee = new Employee(firstName: "Juan", lastName: "Reyes", email: "juan@makingdevs.com")
    employee = employeeRepository.save(employee)

    // Creo un posible Address
    Address address = new Address(street: "Some", number: "number", zipCode: "12345")
    Employee updatedEmployee = employeeService.addAddressToEmployee(employee.id, address)

    println updatedEmployee.properties
  }
}
