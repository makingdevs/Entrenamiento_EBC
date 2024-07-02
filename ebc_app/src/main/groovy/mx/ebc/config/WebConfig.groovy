package mx.ebc.config

import org.springframework.context.annotation.*
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = ["mx.ebc.web"])
class WebConfig {
}
