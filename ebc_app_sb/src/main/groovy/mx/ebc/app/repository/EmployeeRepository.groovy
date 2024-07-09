package mx.ebc.app.repository

import mx.ebc.app.model.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}