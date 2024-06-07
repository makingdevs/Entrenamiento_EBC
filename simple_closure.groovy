c = { a, b, c -> 
    a + b + (c ? c : 0)
}

println c(7, 9, null)
