String s = ")())())"

s.split("")

contador = 0

for(int i = 0; i < s.size(); i++) {
    if(s[i] == "(") contador++
    if(s[i] == ")") contador--
}

println contador

// ---------------------------------

numeros = []
s.split("").each {
  if(it == "(") numeros.add(1)
  else numeros.add(-1)
}
numeros.sum()

// ---------------------------------

s.split("").collect { if(it == "(") 1 else -1 }.sum()

// ---------------------------------

s.split("").collect { it == "(" ? 1 : -1 }.sum()
