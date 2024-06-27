package mx.ebc.apitramiteson

import spock.lang.Specification

class APITramitesSpec extends Specification {

  def "Obtener todos los niveles académicos"(){
    given:
      APITramites instance = APITramites.instance
    when:
      List<AcademicLevel> levels = instance.allAcademicLevels(true)
    then:
      levels.size() > 0
      levels.size()
      levels
      levels*.id
  }
}
