package mx.ebc.app.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name="ADDRESS_JJ")
class Address {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_generator")
  @SequenceGenerator(name="address_generator", sequenceName = "address_jj_id_seq", allocationSize = 1)
  Long id
  String street
  String externalNumber
  String zipCode

  @ManyToOne
  @JoinColumn(name="employee_id", nullable = false)
  Employee employee
}
