package mx.ebc.service

import mx.ebc.data.jpa.StvCampJPARepository
import mx.ebc.model.Empleado
import mx.ebc.model.StvCamp
import org.springframework.stereotype.*
import org.springframework.beans.factory.annotation.*

@Service
class CampusServiceImpl implements CampusService {

  @Autowired
  StvCampJPARepository stvCampJPARepository

  List<StvCamp> allCampus(){
    stvCampJPARepository.findAll()
  }

  Empleado assignCampusToPerson(Integer pidm, String stvcampCode) {

  }

}
