package mx.ebc.service

import mx.ebc.model.Empleado

interface EmpleadoService {

    Empleado create(Map params)
    Empleado update(Empleado empleado)
    List<Empleado> listAll()
    Empleado findEmpleadoById(String id)

}