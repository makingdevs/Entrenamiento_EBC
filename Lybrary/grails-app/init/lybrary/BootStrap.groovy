package lybrary

import mx.ebc.User
import mx.ebc.Role
import mx.ebc.UserRole
import grails.gorm.transactions.Transactional

class BootStrap {

  def init = { servletContext ->
    addUsers()
  }
  def destroy = {
  }

  @Transactional
  void addUsers() {
    if(!User.count()){
      Role adminRole = new Role(authority: "ROLE_ADMIN").save()
      User admin = new User(username: "admin", password: "admin").save()

      UserRole.create(admin, adminRole)

      UserRole.withSession { session ->
        session.flush()
        session.clear()
      }
    }
  }
}
