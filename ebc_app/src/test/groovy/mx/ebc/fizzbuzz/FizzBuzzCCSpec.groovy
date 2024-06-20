package mx.ebc.fizzbuzz

import spock.lang.Specification

class FizzBuzzCCSpec extends Specification {

    def "Prueba de FizzBuzz para n numeros"() {
        given:
        FizzBuzzCC fizzbuzz = new FizzBuzzCC()

        when:
        String result = fizzbuzz.exec(_input)

        then:
        result == _output

        where:
        _input | _output 
        1     | "1"
        3     | "Fizz"
        5     | "Buzz"
        7     | "7"
        9     | "Fizz"
        10    | "Buzz"
        15    | "FizzBuzz"
    }
}