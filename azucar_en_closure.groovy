def block(n, c){
  for(int i = 1; i <= n; i++)
    c(i)
}

block(10) { println it%2 == 0 ? "${it} PAR" :"${it} IMPAR" }
