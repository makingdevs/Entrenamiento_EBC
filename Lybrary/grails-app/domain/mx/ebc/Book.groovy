package mx.ebc

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Book {

  String title
  String ISBN

  static belongsTo = [author: Author]

  static constraints = {
  }
}
