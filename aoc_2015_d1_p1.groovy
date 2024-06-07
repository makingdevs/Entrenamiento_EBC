String s = ")())())"

s.split("")

contador = 0

for(int i = 0; i < s.size(); i++) {
    if(s[i] == "(") contador++
    if(s[i] == ")") contador--
}

println contador