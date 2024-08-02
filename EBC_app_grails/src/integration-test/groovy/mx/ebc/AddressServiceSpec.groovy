package mx.ebc

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AddressServiceSpec extends Specification {

  AddressService addressService
  SessionFactory sessionFactory

  private List<Employee> setupEmployees(){
    Employee employee1 = new Employee(name: "Arturo", lastName: "Rescalvo", bornDate: new Date().parse("dd-MM-yyyy", "01-01-1993"), weight: 389, active: true).save(flush: true, failOnError: true)
    Employee employee2 = new Employee(name: "Reyna", lastName: "Pineda", bornDate: new Date().parse("dd-MM-yyyy", "01-01-1992"), weight: 32, active: true).save(flush: true, failOnError: true)
    [employee1, employee2]
  }

  private Long setupData() {
    List<Employee> employees = setupEmployees()
    new Address(street: "Marsella", externalNumber: "232", zipCode: "04000", employee: employees[0]).save(flush: true, failOnError: true)
    new Address(street: "Cracovia", externalNumber: "32", zipCode: "04000", employee: employees[1]).save(flush: true, failOnError: true)
    Address address = new Address(street: "Varsovia", externalNumber: "445", zipCode: "04000", employee: employees[0]).save(flush: true, failOnError: true)
    new Address(street: "Hamburgo", externalNumber: "445", zipCode: "04000", employee: employees[1]).save(flush: true, failOnError: true)
    new Address(street: "Orlando", externalNumber: "393", zipCode: "04000", employee: employees[0]).save(flush: true, failOnError: true)
    address.id
  }

  void "test get"() {
    Long addressId = setupData()

    expect:
    addressService.get(addressId) != null
  }

  void "test list"() {
    setupData()

    when:
    List<Address> addressList = addressService.list(max: 2, offset: 2)

    then:
    addressList.size() == 2
  }

  void "test count"() {
    setupData()

    expect:
    addressService.count() == 5
  }

  void "test delete"() {
    Long addressId = setupData()

    expect:
    addressService.count() == 5

    when:
    addressService.delete(addressId)
    sessionFactory.currentSession.flush()

    then:
    addressService.count() == 4
  }

  void "test save"() {
    when:
    List<Employee> employees = setupEmployees()
    Address address = new Address(street: "Orlando", externalNumber: "393", zipCode: "04000", employee: employees[1]).save(flush: true, failOnError: true)
    addressService.save(address)

    then:
    address.id != null
  }
}
