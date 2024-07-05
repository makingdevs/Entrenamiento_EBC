package mx.ebc.data.jpa

import mx.ebc.model.StvCamp
import org.springframework.data.repository.CrudRepository

interface StvCampJPARepository extends CrudRepository<StvCamp, String> {

}