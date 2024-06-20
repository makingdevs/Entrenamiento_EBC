package mx.ebc.fizzbuzz

import spock.lang.Specification

class FizzBuzzJJSpec extends Specification {

  def "FizzBuzz de #_input es #_output"() {
    given:
    FizzBuzzJJ fizzbuzz = new FizzBuzzJJ()

    when:
    String result = fizzbuzz.exec(_input)

    then:
    result == _output

    where:
    _input | _output
    1      | "1"
    3      | "Fizz"
    5      | "Buzz"
    7      | "7"
    9      | "Fizz"
    10     | "Buzz"
    15     | "FizzBuzz"
  }
}