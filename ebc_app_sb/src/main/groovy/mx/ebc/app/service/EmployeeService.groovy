package mx.ebc.app.service

import mx.ebc.app.model.Address
import mx.ebc.app.model.Employee
import mx.ebc.app.repository.AddressRepository
import mx.ebc.app.repository.EmployeeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EmployeeService {
  @Autowired
  EmployeeRepository employeeRepository
  @Autowired
  AddressRepository addressRepository

  Employee addAddressToEmployee(Integer employeeId, Address address){
    Employee employee = employeeRepository.findById(employeeId).orElseThrow({
      new RuntimeException("No se encuentra el empleado")})
    employee.getAddresses()
    employee.addresses << address
    employeeRepository.save(employee)
  }
}
