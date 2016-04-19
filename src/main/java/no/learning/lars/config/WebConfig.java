package no.learning.lars.config;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.h2.server.web.WebServlet;

@Configuration
public class WebConfig {
    /*
    * Since we don't have access to the Embedded Tomcat server web.xml file we can use this Servlet to get access to the h2 console
    * Maps the h2 console to /console
    * */
    @Bean
    ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }
}
