import groovy.json.JsonSlurper

jsonSlurper = new JsonSlurper()
json = jsonSlurper.parse(new URL("https://pokeapi.co/api/v2/pokemon/pikachu"))

json.sprites.findAll{ k, v -> v.class == String }.each { k, v ->

  cmd = "curl ${v} -o ${k}.png"
  println cmd
  //println cmd.execute()

}

println "*"
println json.sprites
println "*"
println json.stats
