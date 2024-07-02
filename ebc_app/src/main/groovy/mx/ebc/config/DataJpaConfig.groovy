package mx.ebc.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.jdbc.support.JdbcTransactionManager
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.TransactionManager

@Configuration
@ComponentScan(basePackages = ["mx.ebc.data.jpa"])
@EnableJpaRepositories(basePackages = ["mx.ebc.data.jpa"])
class DataJpaConfig {

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
  LocalContainerEntityManagerFactoryBean entityManagerFactory(){
    new LocalContainerEntityManagerFactoryBean(
            dataSource: dataSource(),
            packagesToScan: ["mx.ebc.model"],
            jpaVendorAdapter: new HibernateJpaVendorAdapter(),
    jpaProperties: ["hibernate.dialect": "org.hibernate.dialect.Oracle10gDialect"])
  }

  @Bean
  TransactionManager transactionManager(){
    new JpaTransactionManager(entityManagerFactory: entityManagerFactory().object)
  }

}
