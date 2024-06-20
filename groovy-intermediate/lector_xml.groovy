import groovy.xml.XmlSlurper

catalog = new XmlSlurper().parse("books.xml")
catalog.book.each {
  println "${it.@id} - $it.title - $it.genre"
}
