@Grapes(
  @Grab(group='com.github.groovy-wslite', module='groovy-wslite', version='1.1.3')
)

import wslite.rest.*

def client = new RESTClient("https://api-tramites.ebc.edu.mx/api-tramites-escolares")
def response = client.get(path:'/v1/api/academic_level', query:[bannerLevel: true])

println response.properties
println "*"*30
response.json.each {
  println it
}
