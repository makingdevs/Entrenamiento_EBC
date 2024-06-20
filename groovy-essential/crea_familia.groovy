persona = new Persona(nombre: "Juan", apellidoPaterno: "Reyes", apellidoMaterno: "Zuñiga")
persona.fechaDeNacimiento = new Date() - (30*365)
persona.estatura = 180

persona2 = new Persona(nombre: "Ernesto", apellidoPaterno: "Reyes", apellidoMaterno: "Zuñiga")
persona2.fechaDeNacimiento = new Date() - (40*365)
persona2.estatura = 190

familia = new Familia(miembros: [:])
familia.miembros.hermanos = [persona]
familia.miembros.papas = [persona2]

println """
${persona2.nombre}(${persona2.estatura})
es mayor que
${persona.nombre}(${persona.estatura}) ??
${persona2 > persona ? 'SI' : 'NO'}
"""

println familia
