@groovy.transform.TypeChecked
class GenericosGroovy {
  def usaLista() {
    ArrayList<Integer> list = new ArrayList<Integer>()
    list.add(12)
    list.add(22)
    // list.add(21.3)
    // list.add("hello")
    // list.add(true)
    list
  }
}

def g = new GenericosGroovy()
println g.usaLista()
