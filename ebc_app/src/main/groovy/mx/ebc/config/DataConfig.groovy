package mx.ebc.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.jdbc.support.JdbcTransactionManager
import org.springframework.transaction.TransactionManager

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

  @Bean
  TransactionManager transactionManager(){
    new JdbcTransactionManager(dataSource())
  }
}
