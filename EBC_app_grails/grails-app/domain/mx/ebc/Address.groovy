package mx.ebc

class Address {

  String street
  String externalNumber
  String zipCode

  Date dateCreated
  Date lastUpdated

  static belongsTo = [employee: Employee]

  static constraints = {
    street()
    externalNumber()
    zipCode(size: 5..5)
  }

  static mapping = {
    table 'addressjj'
  }

}
