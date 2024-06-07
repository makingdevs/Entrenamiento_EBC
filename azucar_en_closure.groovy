def block(n, c){
  for(int i = 1; i <= n; i++)
    c(i)
}

closure = { println it%2 == 0 ? "${it} PAR" :"${it} IMPAR" }

block(10, closure)
