import groovy.xml.XmlSlurper

factura = new XmlSlurper().parse("Factura_13475.xml").declareNamespace(cfdi: "http://www.sat.gob.mx/cfd/4")
println "${factura.@Fecha} - ${factura.@Folio} - ${factura.@Moneda}"

println "*"*50

factura.Conceptos.Concepto.each {
  println it.@Descripcion
}

println "*"*50
factura.Conceptos.'cfdi:Concepto'.each { c ->
  c.Impuestos.'cfdi:Traslados'.Traslado.each { t ->
    println t.@Base
  }
}

println "*"*50

factura.'cfdi:Traslados'.Traslado.each { t ->
  println t.@Base
}

println factura.Conceptos.Concepto*.'@ClaveUnidad'
println factura.'cfdi:Concepto'*.'@ClaveUnidad'
