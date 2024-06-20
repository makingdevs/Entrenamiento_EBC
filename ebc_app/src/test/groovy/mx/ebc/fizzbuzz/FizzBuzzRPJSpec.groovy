package mx.ebc.fizzbuzz

import spock.lang.Specification

class FizzBuzzRPJSpec extends Specification {

  def "Prueba fizzbuzz para n numéros"() {
    given:
    FizzBuzzRPJ fizzbuzz = new FizzBuzzRPJ()

    when:
    String result = fizzbuzz.exec(_input)

    then:
    result == _output

    where:
    _input | _output
    1   | "1"
    3   | "Fizz"
    5   | "Buzz"
    9   | "Fizz"
    10  | "Buzz"
    15  | "FizzBuzz"


  }
}