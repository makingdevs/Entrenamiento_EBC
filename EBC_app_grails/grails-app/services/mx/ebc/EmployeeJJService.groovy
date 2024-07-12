package mx.ebc

import grails.gorm.services.Service

@Service(EmployeeJJ)
interface EmployeeJJService {

    EmployeeJJ get(Serializable id)

    List<EmployeeJJ> list(Map args)

    Long count()

    void delete(Serializable id)

    EmployeeJJ save(EmployeeJJ employeeJJ)

}