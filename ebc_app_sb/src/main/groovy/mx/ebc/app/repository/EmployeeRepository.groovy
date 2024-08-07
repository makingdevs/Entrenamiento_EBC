package mx.ebc.app.repository

import mx.ebc.app.model.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.webmvc.RepositoryRestController
import org.springframework.stereotype.Repository

@Repository
@RepositoryRestController(path = "/api/employees")
interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {
  List<Employee> findByLastName(@Param("lastname") String lastName)

  @Query("SELECT e FROM Employee e LEFT JOIN FETCH e.addresses WHERE e.id = :id")
  Optional<Employee> findByIdWithAddresses(@Param("id") Integer id);

}