package mx.ebc.apitramitesCC

import spock.lang.Specification

class ApitramitesCCSpec extends Specification {
    
    def "Obtén todos los niveles académicos"() {
        given:
        ApitramitesCC instance = ApitramitesCC.instance 

        when:
        List<AcademiclevelCC> levels = instance.allAcademicLevels(true)

        then:
        levels.size() > 0
        levels.size()
        levels
        levels*.id
    }
}