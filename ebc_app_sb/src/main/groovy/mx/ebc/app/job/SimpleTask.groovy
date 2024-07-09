package mx.ebc.app.job

import groovy.util.logging.Slf4j
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
@Slf4j
class SimpleTask {

  @Scheduled(cron = "0/5 * * * * ?")
  void doTheJob(){
    log.info("Saludos a las ${new Date()}")
  }

  @Scheduled(cron = "10,30,45 * * * * ?")
  void doAnotherJob(){
    log.info("Otro job a las ${new Date()}")
  }
}
