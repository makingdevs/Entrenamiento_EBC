def block(n, c){
  for(int i = 1; i <= n; i++)
    c(i)
}

block(10) { n ->
  println n%2 == 0 ? "${n} PAR" :"${n} IMPAR"
}
