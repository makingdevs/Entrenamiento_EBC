import groovy.xml.XmlSlurper

factura = new XmlSlurper().parse("Factura_13475.xml").declareNamespace(cfdi: "cfdi")
println "${factura.@Fecha} - ${factura.@Folio} - ${factura.@Moneda}"

println "*"*50

factura.Conceptos.Concepto.each {
  println it.@Descripcion
}
