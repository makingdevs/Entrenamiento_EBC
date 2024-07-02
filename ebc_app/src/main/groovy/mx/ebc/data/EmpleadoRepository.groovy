package mx.ebc.data

import mx.ebc.model.Empleado
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository

import java.sql.ResultSet

@Repository("empleadoRepository")
class EmpleadoRepository {

  @Autowired
  JdbcTemplate jdbcTemplate

  RowMapper empleadoMapper = { ResultSet rs, int rowNum ->
    new Empleado(
      trab_id: rs.getString("TRAB_ID"),
      paterno: rs.getString("PATERNO"),
      materno: rs.getString("MATERNO"),
      nombre: rs.getString("NOMBRE")
    )
  } as RowMapper<Empleado>

  Integer countEmpleados(){
    jdbcTemplate.queryForObject('SELECT COUNT(*) as num FROM EMPLEADOSPRUEBA', Integer)
  }

  Integer createEmpleado(Empleado empleado) {
    String insertQuery = "INSERT INTO EMPLEADOSPRUEBA(NOMBRE, PATERNO, MATERNO, TRAB_ID) VALUES(?, ?, ?, ?)"
    jdbcTemplate.update(insertQuery, empleado.nombre, empleado.paterno, empleado.materno, empleado.trab_id)
  }

  List<Empleado> listEmpleados() {
    String query = "SELECT TRAB_ID, PATERNO, MATERNO, NOMBRE FROM EMPLEADOSPRUEBA"
    // jdbcTemplate.query(query, new EmpleadoRowMapper())
    jdbcTemplate.query(query, empleadoMapper)
  }

  Empleado findEmpleadoById(String trabId){
    String query = "SELECT TRAB_ID, PATERNO, MATERNO, NOMBRE FROM EMPLEADOSPRUEBA WHERE TRAB_ID = ?"
    jdbcTemplate.queryForObject(query, empleadoMapper, trabId)
  }

}
