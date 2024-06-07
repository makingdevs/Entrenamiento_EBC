c = { a, b, c -> 
    if(!c) a + b + 0
    else a + b + c
}

println c(7, 9, null)
