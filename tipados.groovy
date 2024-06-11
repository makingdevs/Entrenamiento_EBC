@groovy.transform.TypeChecked
def saluda(String s) {
  println s.toUpperCase()
}

saluda("hola")
saluda('c')
// saluda(3828)

@groovy.transform.TypeChecked
class P {
  String nombre
  String apellido
  String getFullName() { "$nombre $apellido" }
}

def p = new P(nombre: "Juan", apellido: "Reyes")

@groovy.transform.TypeChecked
int metodo() {
  if(false) { 'String'.size() }
  else { 42 }
}

println metodo()
