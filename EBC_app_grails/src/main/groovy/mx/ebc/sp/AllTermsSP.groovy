package mx.ebc.sp

import org.springframework.jdbc.core.*
import org.springframework.jdbc.object.StoredProcedure
import java.sql.ResultSet
import oracle.jdbc.OracleTypes

class AllTermsSP extends StoredProcedure {

  RowMapper termMapper = { ResultSet rs, int rowNum ->
    [
      term_code: rs.getString("TERM_CODE"),
      term_desc: rs.getString("TERM_DESC")
    ]
  } as RowMapper<List>

  AllTermsSP(JdbcTemplate jdbcTemplate) {
    super(jdbcTemplate, "GENPUB.PC_APIBANNER_ALL_TERMS.PR_ALL_TERMS")
    declareParameter(new SqlParameter("TERM_CODE", OracleTypes.VARCHAR))
    declareParameter(new SqlOutParameter("OUT_INFO", OracleTypes.CURSOR, termMapper))
  }

  List execute(String termCode){
    (List) super.execute(TERM_CODE: termCode).get("OUT_INFO")
  }

}
