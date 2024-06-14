@Grapes(
@Grab(group='log4j', module='log4j', version='1.2.17')
)

import groovy.util.logging.*

@Log4j
class OtroServicio {
  def metodo(){
    log.error "Mexican Debugger!!!"
    log.info "Mexican Debugger!!!"
    log.debug "Mexican Debugger!!!"
  }
}

o = new OtroServicio()
o.metodo()
