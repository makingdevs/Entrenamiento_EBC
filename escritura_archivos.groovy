file = new File("hola.txt")

file.write("Hola mundo!!!\n")


file.append("Cómo están en el curso?\n")
file << "Escribiendo a la forma Groovy ${new Date()} \n"

println file.text

new File("copy_hola.txt").write(file.text)
