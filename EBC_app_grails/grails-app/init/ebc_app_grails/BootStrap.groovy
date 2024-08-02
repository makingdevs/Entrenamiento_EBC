package ebc_app_grails

import mx.ebc.EmployeeService
import mx.ebc.Employee

class BootStrap {

  EmployeeService employeeService

  def init = { servletContext ->
    // if(!employeeService.count()) {
    //   String path = "/Users/makingdevs/Entrenamiento_EBC/EBC_app_grails/MOCK_DATA-2.csv"
    //   String text = new File(path).text
    //   text.split("\n").drop(1).collect() { line ->
    //     def record = line.split(",")
    //     Employee employee = new Employee(
    //       id: record[0].toInteger(),
    //       name: record[1],
    //       lastName:  record[2],
    //       bornDate: new Date().parse("dd/mm/yyyy", record[3]),
    //       weight: record[4].toInteger(),
    //       active: record[5].toBoolean()
    //     )
    //     employeeService.save(employee)
    //   }
    // }
  }

  def destroy = {
  }
}
