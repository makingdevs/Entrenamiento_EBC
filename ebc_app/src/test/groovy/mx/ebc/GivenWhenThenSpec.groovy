package mx.ebc

import spock.lang.Specification

class GivenWhenThenSpec extends Specification {

  def "Agrega un elemento a una lista"() {
    given:
      def lista = [2,4,5,5,6,6,7]
    when:
      lista << 1
    then:
      lista.size() == 8
  }

}
