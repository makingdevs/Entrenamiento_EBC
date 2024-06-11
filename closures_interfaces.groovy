import javax.swing.*
import java.awt.*
import java.awt.event.*

frame = new JFrame(size: [300,300], layout: new FlowLayout(), defaultCloseOperation: WindowConstants.EXIT_ON_CLOSE)

// Sección de un sólo boton, para una interfaz con un solo método
button = new JButton("Click")
frame.getContentPane().add(button)
button.addActionListener({ event ->
  println "Presionaste el botón de nuevo con Groovy"
} as ActionListener)

// Uso un Closure para varios métodos en varias interfaces
positionLabel = new JLabel("")
frame.contentPane.add(positionLabel)
displayMouseLocation = { positionLabel.text = "${it.x}, ${it.y}" }
frame.addMouseListener( displayMouseLocation as MouseListener )
frame.addMouseMotionListener( displayMouseLocation as MouseMotionListener )

frame.show()
