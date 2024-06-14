@GrabConfig(systemClassLoader=true)
@Grapes(
  @Grab(group='com.oracle.database.jdbc', module='ojdbc11', version='21.3.0.0')
)

import groovy.sql.Sql
import oracle.jdbc.OracleTypes
import groovy.sql.OutParameter;
import java.util.logging.*

// Configura el logger para groovy.sql.Sql
Logger sqlLogger = Logger.getLogger('groovy.sql.Sql')
sqlLogger.setLevel(Level.FINE)
ConsoleHandler handler = new ConsoleHandler()
handler.setLevel(Level.FINE)
sqlLogger.addHandler(handler)


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


CURSOR_PARAMETER = { OracleTypes.CURSOR } as OutParameter

P_CODE = '202420'
sp = "{call GENPUB.PC_APIBANNER_ALL_TERMS.PR_ALL_TERMS(?, ?)}"
sql.callWithAllRows(sp, [P_CODE, CURSOR_PARAMETER]) { cursor ->
  cursor.eachRow { row ->
    def columna1 = row.TERM_CODE
    def columna2 = row.TERM_DESC
    println "Columna 1: $columna1, Columna 2: $columna2"
  }
}

id = new Date().time.toString()
nombre = "Juan"
paterno = "Reyes"
materno = "Zuñiga"

insert_query = """
  insert into EMPLEADOSPRUEBA(TRAB_ID, NOMBRE, PATERNO, MATERNO)
  values(?, ?, ?, ?)
"""
sql.execute insert_query, [id, nombre, paterno, materno]

insert_query = """
  insert into EMPLEADOSPRUEBA(TRAB_ID, NOMBRE, PATERNO, MATERNO)
  values(:id, :nombre, :paterno, :materno)
"""
sql.execute insert_query, [paterno: "Barbachano", materno: "EBC", nombre: "Gerardo", id: new Date().time]

results = sql.execute "update EMPLEADOSPRUEBA set PATERNO=? where PATERNO = ?", ["NUEVO", "Barbachano"]

println results
println sql.updateCount

sql.eachRow("select * from EMPLEADOSPRUEBA"){ empleado ->
  println empleado
}

println "-"*50
dataset = sql.dataSet("EMPLEADOSPRUEBA")
dataset.add([paterno: "Pineda", materno: "EBC", nombre: "Reyna", trab_id: new Date().time])

busqueda = dataset.findAll { p -> p.paterno == 'Pineda' }
busqueda.each { println it }
