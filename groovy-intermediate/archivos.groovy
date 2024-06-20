currentDir = new File(".")

currentDir.eachFile { println it }
println "*"*50
currentDir.eachDir { println it }

println "*"*50
println currentDir.dump()
println currentDir.directory
println currentDir.canonicalPath
println currentDir.absolutePath
