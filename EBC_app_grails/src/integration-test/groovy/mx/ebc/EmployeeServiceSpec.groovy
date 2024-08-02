package mx.ebc

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class EmployeeServiceSpec extends Specification {

  EmployeeService employeeService
  SessionFactory sessionFactory

  private Long setupData() {
    new Employee(name: "Juan", lastName: "Reyes", bornDate: new Date().parse("dd-MM-yyyy", "01-01-1990"), weight: 216, active: true).save(flush: true, failOnError: true)
    new Employee(name: "Jose", lastName: "Zuniga", bornDate: new Date().parse("dd-MM-yyyy", "01-01-1991"), weight: 3287, active: true).save(flush: true, failOnError: true)
    Employee employee = new Employee(name: "Arturo", lastName: "Rescalvo", bornDate: new Date().parse("dd-MM-yyyy", "01-01-1993"), weight: 389, active: true).save(flush: true, failOnError: true)
    new Employee(name: "Reyna", lastName: "Pineda", bornDate: new Date().parse("dd-MM-yyyy", "01-01-1992"), weight: 32, active: true).save(flush: true, failOnError: true)
    new Employee(name: "Oscar", lastName: "Navi", bornDate: new Date().parse("dd-MM-yyyy", "01-01-1997"), weight: 388, active: true).save(flush: true, failOnError: true)
    // assert false, "TODO: Provide a setupData() implementation for this generated test suite"
    employee.id
  }

  void "test get"() {
    setupData()

    expect:
    employeeService.get(1) != null
  }

  void "test list"() {
    setupData()

    when:
    List<Employee> employeeList = employeeService.list(max: 2, offset: 2)

    then:
    employeeList.size() == 2
  }

  void "test count"() {
    setupData()

    expect:
    employeeService.count() == 5
  }

  void "test delete"() {
    Long employeeId = setupData()

    expect:
    employeeService.count() == 5

    when:
    employeeService.delete(employeeId)
    sessionFactory.currentSession.flush()

    then:
    employeeService.count() == 4
  }

  void "test save"() {
    when:
    Employee employee = new Employee(
      name: "Cami",
      lastName: "Cabrera",
      bornDate: new Date().parse("dd-MM-yyyy", "01-01-2005"),
      weight: 388,
      active: true)
    employeeService.save(employee)

    then:
    employee.id != null
  }
}
