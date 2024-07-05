package mx.ebc.data

import org.springframework.jdbc.core.*
import java.sql.ResultSet
import mx.ebc.model.Empleado

class EmpleadoRowMapper implements RowMapper<Empleado> {

  Empleado mapRow(ResultSet rs, int rowNum){
    new Empleado(
      trab_id: rs.getString("TRAB_ID"),
      paterno: rs.getString("PATERNO"),
      materno: rs.getString("MATERNO"),
      nombre: rs.getString("NOMBRE")
    )
  }
}
