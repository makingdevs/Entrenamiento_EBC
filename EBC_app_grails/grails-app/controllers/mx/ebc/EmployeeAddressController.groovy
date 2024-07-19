package mx.ebc

class EmployeeAddressController {

  def dataSource

  def index() {
    [message: "Hola mundo ${new Date()}", dataSource: dataSource, employees: []]
  }
}
