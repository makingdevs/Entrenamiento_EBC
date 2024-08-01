package mx.ebc.data.jpa

import mx.ebc.model.StvCamp
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.*

@Repository
interface StvCampJPARepository extends CrudRepository<StvCamp, String> {

}
