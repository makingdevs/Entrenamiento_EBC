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
    bornDate(validator: { valDate, obj ->
      Date hoy = new Date()
      Integer edad = hoy.year - valDate.year - ((hoy.month < valDate.month ||
      (hoy.month == valDate.month && hoy.date < valDate.date) ? 1 : 0))
      if(edad < 18) ["employee.bornDate.invalid"]
    })
    // addresses(minSize: 1)
  }

  static mapping =  {
    table 'employeejj'
  }
}
