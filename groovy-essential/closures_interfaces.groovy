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

// Un mapa de closures para una interfaz con varios métodos
msgLabel = new JLabel("")
frame.contentPane.add(msgLabel)
frame.contentPane.add(new JTextField())
// handleFocus = [
//   focusGained: {msgLabel.text = "Gained"},
//   focusLost: {msgLabel.text = "Lost"}
// ]

//button.addFocusListener(handleFocus as FocusListener)

handleFocus = [
    focusGained: { FocusEvent e ->
      println "Gained Closure"
      msgLabel.text = "Gained Closure"
    },

    focusLost: { FocusEvent e ->
      println "Lost Closure"
      msgLabel.text = "Lost Closure"
    }
  ]

button.addFocusListener(handleFocus  as FocusListener)

frame.show()
