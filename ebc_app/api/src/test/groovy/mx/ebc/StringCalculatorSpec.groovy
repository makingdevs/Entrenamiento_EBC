package mx.ebc

import spock.lang.Specification

class StringCalculatorSpec extends Specification {
  
  def "El resultado de 1 es 1 "() {
    given:
        StringCalculator sCalculator= new StringCalculator()
     
    when:
       int resultado=sCalculator.add("1")
      
    then:
        resultado==1
      
  }

  def "El resultado de 2 es 2 "() {
    given:
        StringCalculator sCalculator= new StringCalculator()
     
    when:
       int resultado=sCalculator.add("2")
      
    then:
        resultado==2
      
  }

}