package mx.ebc

import geb.spock.GebSpec
import grails.testing.mixin.integration.Integration

@Integration
class HomePageSpec extends GebSpec {

  void "verifies the home page"() {
    when:
    go '/'

    then:
    $('h1').text() == "Welcome to EBC App"
  }

}
