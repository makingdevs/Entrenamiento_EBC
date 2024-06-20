package mx.ebc.fizzbuzz
class FizzBuzzARp {

  String exec(int nt){
    if (nt % 3==0 && nt % 5==0){
       return "FizzBuzz"
    } else if ( nt % 3==0){
     return "Fizz"
    } else if (nt % 5==0){
     return  "Buzz"
    } else {
     return String.valueOf(nt)
    }
  }
}