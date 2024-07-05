package mx.ebc.model

import groovy.transform.ToString

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
@ToString
class StvCamp {
    @Id
    @Column(name="stvcamp_code")
    String stvcampCode
    @Column(name="stvcamp_desc")
    String stvcampDesc
}
