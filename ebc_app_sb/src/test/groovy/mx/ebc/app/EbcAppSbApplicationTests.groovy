package mx.ebc.app

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext

import javax.sql.DataSource

@SpringBootTest
class EbcAppSbApplicationTests {

	@Autowired
	ApplicationContext applicationContext
	@Autowired
	DataSource dataSource

	@Test
	void contextLoads() {
		assert applicationContext
		assert !dataSource
	}

}
