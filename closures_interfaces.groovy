import javax.swing.*
import java.awt.*
import java.awt.event.*

frame = new JFrame(size: [300,300], layout: new FlowLayout(), defaultCloseOperation: WindowConstants.EXIT_ON_CLOSE)

button = new JButton("Click")
frame.getContentPane().add(button)


class MyActionListener implements ActionListener {
  void actionPerformed(ActionEvent event){
    println "Presionaste el botón de nuevo"
  }
}

button.addActionListener(new MyActionListener())

frame.show()
