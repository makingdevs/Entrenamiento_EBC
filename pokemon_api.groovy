import groovy.json.JsonSlurper

url = "https://pokeapi.co/api/v2/pokemon/pikachu"

httpConnection = new URL(url)

jsonSlurper = new JsonSlurper()
json = jsonSlurper.parseText(httpConnection.text)

json.sprites.findAll{ k, v -> v.class == String }.each { k, v ->

  cmd = "curl ${v} -o ${k}.png"
  println cmd
  println cmd.execute()

}
