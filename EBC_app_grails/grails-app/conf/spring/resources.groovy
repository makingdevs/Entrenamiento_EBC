// Place your Spring DSL code here
beans = {
  jdbcTemplate(org.springframework.jdbc.core.JdbcTemplate) {
    dataSource = ref('dataSource')
  }

  allTermsSp(mx.ebc.sp.AllTermsSP) {
    jdbcTemplate = ref('jdbcTemplate')
  }
}
