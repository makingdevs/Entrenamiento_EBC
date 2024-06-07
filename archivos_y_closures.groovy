texto = new File("./MOCK_DATA.csv").text

lineas = texto.split("\n")

println lineas.size()

@groovy.transform.ToString
class Person {
  Integer id
  String name
  String lastName
  String email
  Genre genre
  String ipAddress
}

enum Genre {
  Male,
  Female,
  Bigender,
  Genderqueer,
  Agender,
  Genderfluid,
  Non_binary,
  Polygender
}

people = []
// Quito el encabezado
lineas.drop(1).each { linea ->
  attrs = linea.split(",")
  person = new Person(
    id: attrs[0].toInteger(),
    name: attrs[1],
    lastName: attrs[2],
    email:attrs[3],
    genre: Genre.valueOf(attrs[4].replaceAll("-", "_")),
    ipAddress: attrs[5])
  people << person
}

println people.findAll { p -> p.genre != "Male" && p.genre != "Female" }

println people.size()

println people.findAll { p -> p.email.endsWith(".com") }*.email
