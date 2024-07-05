package mx.ebc.service

import mx.ebc.data.jpa.EmpleadoJPARepository
import mx.ebc.model.Empleado
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    EmpleadoJPARepository empleadoJPARepository

    @Override
    Empleado create(Map params) {
        empleadoJPARepository.save(new Empleado(
                trab_id: new Date().time.toString(),
                paterno: params.paterno,
                materno: params.materno,
                nombre: params.nombre
        ))
    }

    @Override
    Empleado update(Empleado empleado) {
        empleadoJPARepository.save(empleado)
    }

    @Override
    List<Empleado> listAll() {
        empleadoJPARepository.findAll()
    }

    @Override
    Empleado findEmpleadoById(String id) {
        Optional<Empleado> optional = empleadoJPARepository.findById(id)
        optional.get()
    }
}
