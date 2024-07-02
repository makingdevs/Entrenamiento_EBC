package mx.ebc.service

import mx.ebc.model.Empleado
import mx.ebc.model.StvCamp

interface CampusService {
    List<StvCamp> allCampus()
    Empleado assignCampusToPerson(Integer pidm, String stvcampCode)
}
