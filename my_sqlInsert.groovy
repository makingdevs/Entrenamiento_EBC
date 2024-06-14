@GrabConfig(systemClassLoader=true)
@Grapes(
  @Grab(group='com.oracle.database.jdbc', module='ojdbc8', version='19.23.0.0')
)
import groovy.sql.Sql

def db = [
  url:'jdbc:oracle:thin:@172.16.60.17:3521:EBCDEVL',
  user:'baninst1',
  password:'u_pick_it',
  driver:'oracle.jdbc.OracleDriver'
]
def sql = Sql.newInstance(db.url, db.user, db.password,db.driver)

texto = new File("./MOCK_DATA.csv").text

lineas = texto.split("\n")

println lineas.size()

@groovy.transform.ToString
class Person {
  Integer id
  String name
  String lastName
  String email
  String genre
  String ipAddress
}


lineas.drop(1).each { linea ->
  attrs = linea.split(",")
  person = new Person(
    id: attrs[0].toInteger(),
    name: attrs[1],
    lastName: attrs[2],
    email:attrs[3],
    genre: attrs[4],
    ipAddress: attrs[5])

insert_query = """
  insert into person_mock(id,name,lastName,email,genre,ipAddress)
  values(?, ?, ?, ?, ?, ?)
"""
sql.execute insert_query, [person.id, person.name, person.lastName, person.email, person.genre, person.ipAddress]

}




