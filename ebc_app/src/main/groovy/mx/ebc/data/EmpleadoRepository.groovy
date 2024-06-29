package mx.ebc.data

import org.springframework.stereotype.*
import org.springframework.beans.factory.annotation.*
import org.springframework.jdbc.core.JdbcTemplate

@Repository
class EmpleadoRepository {

  @Autowired
  JdbcTemplate jdbcTemplate

  Integer countEmpleados(){
    jdbcTemplate.queryForObject('SELECT COUNT(*) as num FROM EMPLEADOSPRUEBA', Integer)
  }

}
