package es.iespuertodelacruz.rl.NewInstituto;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import ch.qos.logback.classic.Logger;
import es.iespuertodelacruz.rl.controlador.AsignaturaRest;

@SpringBootApplication
public class NewInstitutoApplication {

	
	
	public static void main(String[] args) {
		
		SpringApplication.run(NewInstitutoApplication.class, args);
	}
	
	@EnableGlobalMethodSecurity(prePostEnabled = true)
	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {
		
		@Override	
		public void configure(WebSecurity webSecurity) throws Exception{
			webSecurity
			.ignoring()
			.antMatchers("/**");
		}
	}
}
