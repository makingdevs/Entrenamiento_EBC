
@Singleton
class Servicio {
  int contador
}

s = Servicio.getInstance()
s.contador++
println s
println s.contador

s2 = Servicio.instance
s2.contador++
println s2
println s2.contador

s3 = Servicio.instance
s3.contador++
println s3
println s3.contador
