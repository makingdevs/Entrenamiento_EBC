package mx.ebc.app.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name= "EMPLOYEE_JJ")
class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id
  @Column(name = "FIRST_NAME")
  String firstName
  @Column(name = "LAST_NAME")
  String lastName
  String email

}
