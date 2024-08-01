package mx.ebc.apitramitesjj

import spock.lang.Specification

class APITramitesSpec extends Specification {

  def "Obtener todos los niveles académicos"(){
    given:
      APITramitesJJ instance = APITramitesJJ.instance
    when:
      List<AcademicLevel> levels = instance.allAcademicLevels(true)
    then:
      levels.size() > 0
      levels.size()
      levels
      levels*.id
  }

  def "Busca personas en el API"(){
    given:
      APITramitesJJ instance = APITramitesJJ.instance
    when:
      EBCPerson person = instance.findPersonBy(0, "a.rescalvo")
    then:
      person.firstName == "ARTURO"
  }
}
