package mx.ebc

class Employee {

  String name
  String lastName
  Date bornDate
  Integer weight
  Boolean active

  Date dateCreated
  Date lastUpdated

  static hasMany = [addresses: Address]

  static constraints = {
    name(blank: false, minSize: 3)
    lastName(blank: false, minSize: 4)
    weight(blank: false, min: 10)
  }

  static mapping =  {
    table 'employeejj'
  }
}
