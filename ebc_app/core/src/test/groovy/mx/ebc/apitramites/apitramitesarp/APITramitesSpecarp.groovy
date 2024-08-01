package mx.ebc.apitramitesarp

import spock.lang.Specification

class APITramitesarpSpec extends Specification {

  def "Obtener todos los niveles académicos"(){
    given:
      APITramitesarp instance = APITramitesarp.instance
    when:
      List<AcademicLevel> levels = instance.allAcademicLevels(true)
    then:
      true

  }
}
