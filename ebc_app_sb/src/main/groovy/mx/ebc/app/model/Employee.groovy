package mx.ebc.app.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name= "EMPLOYEE_JJ")
class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_jj_id_seq")
  @SequenceGenerator(name="employee_jj_id_seq", sequenceName = "employee_jj_id_seq", allocationSize = 1)
  Integer id
  @Column(name = "firstname")
  String firstName
  @Column(name = "lastname")
  String lastName
  String email

}
