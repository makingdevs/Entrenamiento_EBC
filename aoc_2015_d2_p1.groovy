area_alto = { l, w, h -> 2 * l * w}
area_ancho = { l, w, h -> 2 * w * h}
area_largo = { l, w, h -> 2 * h * l}

area_lado_pequeño = {l, w, h ->
  [
    l*w,
    l*h,
    w*h
  ].min()
}

def papelNecesarioParaLaCaja(caja) {
  lados = caja.split("x")
  (alto, largo, ancho) = lados*.toInteger()

  area_alto(alto, ancho, largo) +
  area_ancho(alto, ancho, largo) +
  area_largo(alto, ancho, largo) +
  area_lado_pequeño(alto, ancho, largo)
}

regalo1 = "2x3x4"
regalo2 = "1x1x10"

papel_necesario_1 = papelNecesarioParaLaCaja(regalo1)
papel_necesario_2 = papelNecesarioParaLaCaja(regalo2)

println papel_necesario_1
println papel_necesario_2

regalos = new File("regalos.txt").text
cajas = regalos.split("\n").collect { caja -> papelNecesarioParaLaCaja(caja) }
println cajas
println cajas.sum()
