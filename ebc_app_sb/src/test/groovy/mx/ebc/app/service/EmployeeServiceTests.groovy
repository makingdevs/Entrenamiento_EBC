package mx.ebc.app.service

import mx.ebc.app.model.Address
import mx.ebc.app.model.Employee
import mx.ebc.app.repository.EmployeeRepository
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation)
class EmployeeServiceTests {

  @Autowired
  EmployeeService employeeService

  @Autowired
  EmployeeRepository employeeRepository

  static Integer employeeId

  @Test
  @Order(1)
  void testCreateEmployee() {
    // Creo un Employee de manera inicial
    Employee employee = new Employee(firstName: "Juan", lastName: "Reyes", email: "juan@makingdevs.com")
    employee = employeeRepository.save(employee)
    this.employeeId = employee.id
    assert this.employeeId
  }

  @Test
  @Order(2)
  void testAddAddressToEmployee(){
    assert this.employeeId
    // Creo un posible Address
    Address address = new Address(street: "Some", externalNumber: "number", zipCode: "12345")
    Employee updatedEmployee = employeeService.addAddressToEmployee(this.employeeId, address)

    assert updatedEmployee.addresses
  }

  @Test
  @Order(3)
  void testAddMoreAddressesToEmployee(){
    assert this.employeeId
    // Creo un posible Address
    Address address1 = new Address(street: "Some ${new Random().nextInt()}", externalNumber: "number", zipCode: "12346")
    Address address2 = new Address(street: "Some ${new Random().nextInt()}", externalNumber: "number", zipCode: "12347")

    Employee updatedEmployee = employeeService.addManyAddresesToEmployee(this.employeeId, [address1, address2])

    assert updatedEmployee.addresses
  }
}
