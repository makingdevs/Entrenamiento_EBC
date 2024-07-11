package mx.ebc.app.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name= "EMPLOYEE_JJ")
class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_generator")
  @SequenceGenerator(name="employee_generator", sequenceName = "employee_jj_id_seq", allocationSize = 1)
  Integer id
  @Column(name = "firstname")
  String firstName
  @Column(name = "lastname")
  String lastName
  String email

  @OneToMany(mappedBy = "ADDRESS_JJ", fetch = FetchType.EAGER)
  List<Address> addresses
}
