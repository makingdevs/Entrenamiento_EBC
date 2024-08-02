package mx.ebc

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class EmployeeSpec extends Specification implements DomainUnitTest<Employee> {

  void "explore the Trait DomainUnitTest<Employee>"() {
    when:
    println domain
    println domain.properties
    println domain.validate()

    then:
    domain

  }

  void "persist and count Employees"() {
    when:
    new Employee(
      name: "Juan",
      lastName: "Reyes",
      bornDate: new Date().parse("dd-MM-yyyy", "01-01-1990"),
      weight: 323,
      active: true
    ).save(flush: true)

    new Employee(
      name: "Jose",
      lastName: "Zuñiga",
      bornDate: new Date().parse("dd-MM-yyyy", "01-01-1995"),
      weight: 324,
      active: false
    ).save(flush: true)

    then:
    Employee.count() == 2

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
