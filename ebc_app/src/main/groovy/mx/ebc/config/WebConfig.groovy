package mx.ebc.config

import org.springframework.context.annotation.*
import org.springframework.web.servlet.ViewResolver
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.view.InternalResourceViewResolver

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = ["mx.ebc.web"])
class WebConfig implements WebMvcConfigurer {

    @Bean
    ViewResolver jspViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver()
        resolver.prefix = "/WEB-INF/views/"
        resolver.suffix = ".jsp"
        resolver
    }
}
