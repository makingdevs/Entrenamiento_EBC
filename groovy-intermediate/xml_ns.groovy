import groovy.xml.XmlSlurper

// Parsear el archivo con el namespace
entrenamiento = new XmlSlurper().parse('makingdevs_ns.xml').declareNamespace(fundamentals:'Essential')
println "Entrenamiento: "
println entrenamiento.roadmap.category.course.collect { "\t * ${it.@name}" }.join('\n')

println "Entrenamiento esencial: "
println entrenamiento.roadmap.category.'fundamentals:course'.collect { "\t * ${it.@name}" }.join('\n')

// Creamos un mapa con el contenido del archivo
def entrenamientoMap = [:]
entrenamiento.roadmap.category.each{ cat ->
  entrenamientoMap."${cat.@name}" = cat.course.collect { c ->
    ['duration':"${c.@duration}",'sessions':"${c.@sessions}",'name':"${c.@name}"]
  }
}

// Definimos un closure que crea un nodo a mano
def listaDeCursos(lista) {
  def nodo = "<cursos>"
  nodo += lista.collect { c ->
    """\
      <curso>
      <duracion>${c.duration}</duracion>
      <sesiones>${c.sessions}</sesiones>
      <nombre>${c.name}</nombre>
      </curso>
      """
  }.join('')
  nodo += "</cursos>"
}

// Creamos un buffer para iterar los cursos y crear los nodos
String buffer = ""
buffer+="<entrenamiento>"
entrenamientoMap.each{ key,value ->
  buffer += """\
    <categoria>
    <nombre>$key</nombre>
    ${owner.listaDeCursos(value.flatten())}
  </categoria>
    """
}
buffer+="</entrenamiento>"

// O bien,mejor ocupamos StreamingMarkupBuilder

xmlDocument = new groovy.xml.StreamingMarkupBuilder().bind{
  mkp.xmlDeclaration()
  mkp.declareNamespace(makingdevs:"MakingDevs")
  entrenamiento{
    comment << "Documento con StreamingMarkupBuilder"
    entrenamientoMap.each{ cat,cursos ->
      makingdevs.categoria(nombre:cat){
        cursos.each { c ->
          curso(nombre:c.name){
            duracion(c.duration)
            sesiones(c.sessions)
          }
        }
      }
    }
  }
}

println xmlDocument
