bldr = new groovy.swing.SwingBuilder()

contador = 0

frame = bldr.frame(
  title:"Swing",
  size:[200,100],
  layout:new java.awt.FlowLayout(),
  defaultCloseOperation: javax.swing.WindowConstants.EXIT_ON_CLOSE
){
  lbl = label(text:"Prueba")
  btn = button(text:'Presioname', actionPerformed:{
    contador++
    btn.text="Presionado ${contador} veces"
    lbl.text="Groovy mostrado $contador veces"
  })
}
frame.show()

frame2 = bldr.frame(title:'Demo'){
  menuBar{
    menu('File'){
      menuItem 'New...'
      menuItem 'Open...'
    }
  }
  panel{
    label 'Etiqueta'
    slider()
    comboBox(items:['uno','dos','tres'])
  }
}
frame2.pack()
frame2.show()
