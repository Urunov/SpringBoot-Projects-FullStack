package uz.bepro.formbasedauthentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"uz.bepro.formbasedauthentication.controller"})
public class FormBasedAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormBasedAuthenticationApplication.class, args);
	}

}
