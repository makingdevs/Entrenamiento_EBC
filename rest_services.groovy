@Grapes([
  @Grab(group='com.github.groovy-wslite', module='groovy-wslite', version='1.1.3'),
  @Grab(group='log4j', module='log4j', version='1.2.17')
])

import wslite.rest.*
import groovy.transform.Canonical
import groovy.util.logging.Log4j

@Canonical
class AcademicLevel {
  String bannerId
  String description
  Integer id
}

@Canonical
class EBCPerson {
  Integer pidm
  String firstName
  String lastName
  String idEnrollment
}

@Singleton
@Log4j
class APITramites {
  def url = "https://api-tramites.ebc.edu.mx/api-tramites-escolares"
  def client = new RESTClient(url)

  List<AcademicLevel> allAcademicLevels(Boolean bannerLevel) {
    def response = client.get(
      path:'/v1/api/academic_level',
      query:[bannerLevel: bannerLevel])
    response.json.collect { new AcademicLevel(it) }
  }

  EBCPerson findPersonBy(Integer pidm = 0, String username = "", String idEnrollment = ""){
    def response = client.get(
      path:'/v1/api/persons',
      query:[idEnrollment: idEnrollment, pidm: pidm, username: username])
    if(response.statusCode == 204)
      log.error("Usuario no encontrado!!!")
    new EBCPerson(response.json)
  }
}

println APITramites.instance.allAcademicLevels(true)
println APITramites.instance.allAcademicLevels(false)

println APITramites.instance.findPersonBy(0, "a.rescalvo")
println APITramites.instance.findPersonBy()
