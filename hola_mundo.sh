#!/usr/bin/env groovy

class HolaMundo {
  String nombre
  def saluda() { "Hola ${nombre} !!!" }
}

def obj = new HolaMundo(nombre: "EBC")
println obj.saluda()
