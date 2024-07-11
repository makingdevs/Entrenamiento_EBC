package mx.ebc.app.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Component

@Component
class MailService {

  @Autowired
  JavaMailSender javaMailSender

  void sendSimpleMessage(String to, String subject, String text){
    SimpleMailMessage msg = new SimpleMailMessage(to: to, subject: subject, text:  text)
    javaMailSender.send(msg)
  }
}
