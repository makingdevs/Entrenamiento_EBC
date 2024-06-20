class Tiempo {
  static Date hoy = new Date()
  static contador = 0

  static hora() {
    contador++
    hoy.format("hh:mm")
  }

  static getContador(){ contador }
}

println Tiempo.hora()
println Tiempo.getHoy().hashCode()
println Tiempo.hora()
println Tiempo.getHoy().hashCode()
println Tiempo.hora()
println Tiempo.getHoy().hashCode()
println Tiempo.hora()
println Tiempo.getHoy().hashCode()
println Tiempo.hora()
println Tiempo.getHoy().hashCode()
println Tiempo.hora()
println Tiempo.getHoy().hashCode()
println Tiempo.hora()
println Tiempo.contador

println Tiempo.getHoy().hashCode()
