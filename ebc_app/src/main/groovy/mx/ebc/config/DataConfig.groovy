package mx.ebc.config

import org.springframework.context.annotation.*
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.jdbc.core.JdbcTemplate

@Configuration
@ComponentScan(basePackages = ["mx.ebc.data"])
class DataConfig {

  @Bean
  DriverManagerDataSource dataSource(){
    Map db = [
      url:'jdbc:oracle:thin:@172.16.60.17:3521:EBCDEVL',
      username:'baninst1',
      password:'u_pick_it'
    ]
    new DriverManagerDataSource(db)
  }

  @Bean
  JdbcTemplate jdbcTemplate(){
    new JdbcTemplate(dataSource())
  }

}
