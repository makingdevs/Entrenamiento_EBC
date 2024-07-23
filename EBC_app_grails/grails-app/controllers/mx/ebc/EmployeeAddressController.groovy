package mx.ebc

class EmployeeAddressController {

  EmployeeService employeeService

  def index() {
    [
      message: "Hola mundo ${new Date()}",
      employees: employeeService.list([:])
    ]
  }
}
