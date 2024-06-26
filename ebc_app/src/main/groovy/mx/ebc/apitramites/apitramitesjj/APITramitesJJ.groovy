package mx.ebc.apitramitesjj

import wslite.rest.*
import groovy.util.logging.Slf4j

@Slf4j
@Singleton
class APITramitesJJ {

  String url = "https://api-tramites.ebc.edu.mx/api-tramites-escolares"
  RESTClient client = new RESTClient(url)

  List<AcademicLevel> allAcademicLevels(Boolean bannerLevel) {
    def response = client.get(
      path: "/v1/api/academic_level",
      query: [bannerLevel: bannerLevel])
    log.debug "Response from URL: ${response}"
    response.json.collect { params -> new AcademicLevel(params) }
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
