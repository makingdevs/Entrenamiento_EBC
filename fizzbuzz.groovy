for(int i = 1; i <= 100; i++){
    if(i%5 == 0 && i%3 == 0)
        println "FizzBuzz"
    else if(i%5 == 0)
        println "Buzz"
    else if(i%3 == 0)
        println "Fizz"
    else 
        println i
}