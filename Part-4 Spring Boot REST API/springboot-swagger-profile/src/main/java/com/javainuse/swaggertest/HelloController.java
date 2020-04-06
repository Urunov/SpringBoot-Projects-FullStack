package com.javainuse.swaggertest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping(method = RequestMethod.GET, value = "/api/javainuse")
<<<<<<< HEAD

	public String sayHello() {
		return "Swagger Hello World";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/api/javainuse")

	public String update() {
		return "POST ";
	}

=======
	public String sayHello() {
		return "Swagger Hello World";
	}
>>>>>>> a608fe36a37e7194bb4a3524350efcd6110d82ea
}
