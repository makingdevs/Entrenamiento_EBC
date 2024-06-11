@Grapes(
  @Grab(group='org.springframework', module='spring-context', version='5.3.36')
)

import org.springframework.context.support.ClassPathXmlApplicationContext

ctx = new ClassPathXmlApplicationContext()

println ctx.properties
println ctx.dump()
