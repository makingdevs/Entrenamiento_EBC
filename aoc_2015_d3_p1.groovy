indicaciones = "^>v<"

posiciones = [ [0, 0] ]

camino = indicaciones.split("")
println camino

camino.each { i ->
  (x,y) = posiciones[-1]
  switch(i) {
    case ">":
      posiciones << [x+1, y]
      break
    case "<":
      posiciones << [x-1, y]
      break
    case "^":
      posiciones << [x, y+1]
      break
    case "v":
      posiciones << [x, y-1]
      break
  }
}

println posiciones
println posiciones.unique()
println posiciones.unique().size()
