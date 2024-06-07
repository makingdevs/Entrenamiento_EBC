// area_triangulo = {base, altura -> area_rectangulo(base, altura) / 2}
// area_rectangulo = {base, altura -> base * altura / 2}

def area_triangulo(base, altura) {
    area_rectangulo(base, altura) / 2
}

def area_rectangulo(base, altura) {
    base * altura
}

println "Rectángulo(3,4) = Area ${area_rectangulo(3, 4)}"

println "Triángulo(3,4) = Area ${area_triangulo(3, 4)}"