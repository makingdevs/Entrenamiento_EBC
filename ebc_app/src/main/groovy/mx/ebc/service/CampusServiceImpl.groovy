package mx.ebc.service

import org.springframework.stereotype.*
import org.springframework.beans.factory.annotation.*
import mx.ebc.data.CampusRepository

@Service
class CampusServiceImpl implements CampusService {

  @Autowired
  CampusRepository campusRepository

}
