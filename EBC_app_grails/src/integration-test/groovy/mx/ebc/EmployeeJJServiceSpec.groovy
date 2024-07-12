package mx.ebc

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class EmployeeJJServiceSpec extends Specification {

    EmployeeJJService employeeJJService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new EmployeeJJ(...).save(flush: true, failOnError: true)
        //new EmployeeJJ(...).save(flush: true, failOnError: true)
        //EmployeeJJ employeeJJ = new EmployeeJJ(...).save(flush: true, failOnError: true)
        //new EmployeeJJ(...).save(flush: true, failOnError: true)
        //new EmployeeJJ(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //employeeJJ.id
    }

    void "test get"() {
        setupData()

        expect:
        employeeJJService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<EmployeeJJ> employeeJJList = employeeJJService.list(max: 2, offset: 2)

        then:
        employeeJJList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        employeeJJService.count() == 5
    }

    void "test delete"() {
        Long employeeJJId = setupData()

        expect:
        employeeJJService.count() == 5

        when:
        employeeJJService.delete(employeeJJId)
        sessionFactory.currentSession.flush()

        then:
        employeeJJService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        EmployeeJJ employeeJJ = new EmployeeJJ()
        employeeJJService.save(employeeJJ)

        then:
        employeeJJ.id != null
    }
}
