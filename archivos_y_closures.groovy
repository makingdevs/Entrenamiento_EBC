texto = new File("./MOCK_DATA.csv").text

lineas = texto.split("\n")

println lineas.size()

class Person {
  Integer id
  String name
  String lastName
  String email
  String genre
  String ipAddress
}

people = []
// Quito el encabezado
lineas.drop(1).each { linea ->
  attrs = linea.split(",")
  person = new Person(id: attrs[0].toInteger(), name: attrs[1], lastName: attrs[2], email:attrs[3], genre: attrs[4], ipAddress: attrs[5])
  people << person
}

println people
