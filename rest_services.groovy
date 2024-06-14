@Grapes(
  @Grab(group='com.github.groovy-wslite', module='groovy-wslite', version='1.1.3')
)

import wslite.rest.*

@groovy.transform.Canonical
class AcademicLevel {
  String bannerId
  String description
  Integer id
}

@Singleton
class APITramites {
  def url = "https://api-tramites.ebc.edu.mx/api-tramites-escolares"
  def client = new RESTClient(url)

  List<AcademicLevel> allAcademicLevels(Boolean bannerLevel) {
    def response = client.get(
      path:'/v1/api/academic_level',
      query:[bannerLevel: bannerLevel])
    response.json.collect { new AcademicLevel(it) }
  }
}

println APITramites.instance.allAcademicLevels(true)
println APITramites.instance.allAcademicLevels(false)
