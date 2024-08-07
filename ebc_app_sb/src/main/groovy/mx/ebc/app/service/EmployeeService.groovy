package mx.ebc.app.service

import groovy.transform.CompileStatic
import mx.ebc.app.model.Address
import mx.ebc.app.model.Employee
import mx.ebc.app.repository.AddressRepository
import mx.ebc.app.repository.EmployeeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class EmployeeService {
  @Autowired
  EmployeeRepository employeeRepository
  @Autowired
  AddressRepository addressRepository

  Employee addAddressToEmployee(Integer employeeId, Address address){
    Employee employee = employeeRepository.findByIdWithAddresses(employeeId)?.get()
    employee.addresses << address
    address.employee = employee
    addressRepository.save(address)
    employeeRepository.save(employee)
  }

  Employee addManyAddresesToEmployee(Integer employeeId, List<Address> addresses) {
    addresses.collect { address -> addAddressToEmployee(employeeId, address) }.last()
  }
}
