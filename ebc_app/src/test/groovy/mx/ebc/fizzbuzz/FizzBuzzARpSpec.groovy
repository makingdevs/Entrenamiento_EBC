package mx.ebc.fizzbuzz

import spock.lang.Specification

class FizzBuzzARpSpec extends Specification {

    def "prueba fizzbuzz de n números" (){
        given:
        FizzBuzzARp bizzbuzz= new FizzBuzzARp()
        when:
         String result = bizzbuzz.exec(_input)

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