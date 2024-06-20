map = ["uno":1, "dos":2, "tres":3,"papas": ["Juan", "José", "Pedro"],otro_mapa: [:]]

map.each {
    println it
}

map.each { key, value ->
    println value
}

//  println map.collect { key, value -> key }
println "*" * 50

p1 = [nombre: "Juan", clave: "PI323"]
p2 = [nombre: "José", clave: "PI324"]
p3 = [nombre: "Pedro", clave: "PI322"]

personas = [p1, p2, p3]

println "#"*50
nombres = []
personas.each { persona -> nombres << persona.nombre }
println nombres

println "#"*50

nombres = personas.collect { persona -> persona.nombre }
println nombres

println "#"*50

nombres = personas*.nombre
println nombres
