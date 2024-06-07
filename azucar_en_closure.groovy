def block(n, c){
  for(int i = 1; i <= n; i++)
    c()
}

closure = { println "Hola mundo" }

block(10, closure)
