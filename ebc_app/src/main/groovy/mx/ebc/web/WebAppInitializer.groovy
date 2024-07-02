package mx.ebc.web

import mx.ebc.config.DataJpaConfig
import mx.ebc.config.ServiceConfig
import mx.ebc.config.WebConfig
import org.springframework.web.WebApplicationInitializer
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import org.springframework.web.servlet.DispatcherServlet

import javax.servlet.ServletContext
import javax.servlet.ServletException
import javax.servlet.ServletRegistration

class WebAppInitializer implements WebApplicationInitializer {
    @Override
    void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext()
        ctx.register(DataJpaConfig, ServiceConfig, WebConfig)

        DispatcherServlet dispatcherServlet = new DispatcherServlet(ctx)
        ServletRegistration.Dynamic servlet = servletContext.addServlet("mvc-dispatcher", dispatcherServlet)
        servlet.addMapping("/")
        servlet.loadOnStartup = 1
    }
}
