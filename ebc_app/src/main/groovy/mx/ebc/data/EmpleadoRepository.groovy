package mx.ebc.data

import org.springframework.stereotype.*
import org.springframework.beans.factory.annotation.*
import org.springframework.jdbc.core.JdbcTemplate
import mx.ebc.model.Empleado

@Repository
class EmpleadoRepository {

  @Autowired
  JdbcTemplate jdbcTemplate

  Integer countEmpleados(){
    jdbcTemplate.queryForObject('SELECT COUNT(*) as num FROM EMPLEADOSPRUEBA', Integer)
  }

  Integer createEmpleado(Empleado empleado) {
    String insertQuery = "INSERT INTO EMPLEADOSPRUEBA(NOMBRE, PATERNO, MATERNO, TRAB_ID) VALUES(?, ?, ?, ?)"
    jdbcTemplate.update(insertQuery, empleado.nombre, empleado.paterno, empleado.materno, empleado.trab_id)
  }

  List<Empleado> listEmpleados() {
    String query = "SELECT TRAB_ID, PATERNO, MATERNO, NOMBRE FROM EMPLEADOSPRUEBA"
    jdbcTemplate.query(query, new EmpleadoRowMapper())
  }

}
