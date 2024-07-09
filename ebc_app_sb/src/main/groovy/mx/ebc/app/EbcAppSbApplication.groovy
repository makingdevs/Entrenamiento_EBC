package mx.ebc.app

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class EbcAppSbApplication {

	static void main(String[] args) {
		SpringApplication.run(EbcAppSbApplication, args)
	}

}
