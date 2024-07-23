package mx.ebc

import mx.ebc.sp.AllTermsSP

class EmployeeAddressController {

  EmployeeService employeeService
  AddressService addressService
  AllTermsSP allTermsSp

  static allowedMethods = [saveAddress: "POST"]

  def index() {
    log.info "${allTermsSp.execute("202420")}"
    [
      message: "Hola mundo ${new Date()}",
      employees: employeeService.list([:])
    ]
  }

  def saveAddress(params) {
    log.info "${params}"
    Employee employee = employeeService.get(params.employeeId)
    Address address = new Address(params)
    address.employee = employee
    address = addressService.save(address)

    flash.message = message(code: 'default.created.message', args: [message(code: 'address.label', default: 'Address'), address.id])

    redirect action: "index"
  }
}
