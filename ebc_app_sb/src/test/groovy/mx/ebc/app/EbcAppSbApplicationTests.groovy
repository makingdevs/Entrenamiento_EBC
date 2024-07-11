package mx.ebc.app

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import org.springframework.mail.MailSender

import javax.sql.DataSource

@SpringBootTest
class EbcAppSbApplicationTests {

	@Autowired
	ApplicationContext applicationContext
	@Autowired
	DataSource dataSource
	@Autowired
	MailSender mailSender

	@Test
	void contextLoads() {
		assert applicationContext
		assert dataSource
		assert mailSender
		println mailSender.properties
	}

}
