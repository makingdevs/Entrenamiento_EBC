package mx.ebc

class EmployeeJJ {

  String name
  String lastName
  Date bornDate
  Integer weight
  Boolean active

  Date dateCreated
  Date lastUpdated

  static constraints = {
    name(blank: false, minSize: 4)
    lastName(blank: false, minSize: 4)
    weight(blank: false, min: 10)
  }
}
