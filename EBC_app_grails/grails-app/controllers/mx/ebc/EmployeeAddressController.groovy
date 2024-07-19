package mx.ebc

class EmployeeAddressController {

  def index() {
    respond [message: "Hola mundo ${new Date()}"]
  }
}
