package mx.ebc

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class EmployeeSpec extends Specification implements DomainUnitTest<Employee> {

  void "persist some Employees"() {
    when:
    println domain
    println domain.properties
    println domain.validate()

    then:
    domain

  }

  void "persist another Employees"() {
    when:
    new Employee(
      name: "Juan",
      lastName: "Reyes",
      bornDate: new Date() - 365,
      weight: 323,
      active: true
    ).save(flush: true)

    println "*"*50
    println Employee.count()
    println "*"*50

    then:
    Employee.count()

  }

  void "errors in Employees"() {
    when:
    Employee e = new Employee(
      name: "Yo",
      lastName: "Meh",
      bornDate: new Date() - 365,
      weight: 5,
      active: true
    )
    e.validate()

    println "*"*50
    println e.errors
    println "*"*50

    then:
    e.errors

  }
}
