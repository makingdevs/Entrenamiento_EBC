import groovy.xml.XmlSlurper
import groovy.xml.XmlParser

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

traslados = factura.'**'.findAll { it.name() == 'Traslado' }

// Imprimir los detalles de cada 'Traslado'
traslados.each { traslado ->
    println "Traslado - Base: ${traslado.@Base}, Importe: ${traslado.@Importe}, Impuesto: ${traslado.@Impuesto}, TasaOCuota: ${traslado.@TasaOCuota}, TipoFactor: ${traslado.@TipoFactor}"
}
