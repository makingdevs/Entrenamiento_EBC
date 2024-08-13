package mx.ebc

import geb.spock.GebSpec
import grails.testing.mixin.integration.Integration

@Integration
class HomePageSpec extends GebSpec {

  void "verifies the home page"() {
    when:
    go '/'

    then:
    $('h1').text() == "Welcome to EBC APP"
  }

  void "go to address controller"() {
    when:
    go '/'

    and:
    def links = $("li.controller").children()
    links[0].click()
    Thread.sleep(3000)

    then:
    $('h1').text() == "Address Lista"
  }

}
