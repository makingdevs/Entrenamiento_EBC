@GrabConfig(systemClassLoader=true)
@Grapes(
  @Grab(group='com.oracle.database.jdbc', module='ojdbc11', version='21.3.0.0')
)

import groovy.sql.Sql

def db = [
  url:'jdbc:oracle:thin:@172.16.60.17:3521:EBCDEVL',
  user:'baninst1',
  password:'u_pick_it'
]
def sql = Sql.newInstance(db.url, db.user, db.password)

query = "select * from FALTASRMG where NIDFALTAS <= 109"
// sql.eachRow(query) {
//   println it
// }
lista = sql.rows(query)
println lista.size()
 println lista*.NIDFALTAS
