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

def client = new RESTClient("https://api-tramites.ebc.edu.mx/api-tramites-escolares")
def response = client.get(path:'/v1/api/academic_level', query:[bannerLevel: true])

//println response.properties
println "*"*30
println response.json.collect { new AcademicLevel(it) }
