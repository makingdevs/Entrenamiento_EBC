import javax.swing.*
import java.awt.*
import java.awt.event.*

frame = new JFrame(size: [300,300], layout: new FlowLayout(), defaultCloseOperation: WindowConstants.EXIT_ON_CLOSE)

button = new JButton("Click")
frame.getContentPane().add(button)



button.addActionListener({ event ->
  println "Presionaste el botón de nuevo con Groovy"
} as ActionListener)

frame.show()
