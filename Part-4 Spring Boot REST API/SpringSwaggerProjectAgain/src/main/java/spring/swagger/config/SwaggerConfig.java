package spring.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * @Created 06 / 04 / 2020 - 9:50 AM
 * @project SpringSwaggerProjectAgain
 * @Author Hamdamboy
 */

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket productApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.techprimers.springboot.swaggerexample"))
                .paths(regex("/rest.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo(){

        Contact contact = new Contact("TechPrimers", "techprimerschannel@gmail.com", "https://www.youtube.com/TechPrimers");
        return new ApiInfoBuilder()


               .title("Spring Boot Swagger Example API")
                .description("Spring Boot Swagger API ")
                .version("1.0.0")
                .license("Apache 2.0")
                .contact(contact)
                .licenseUrl("https://www.apache.org/licesen.html")
                .build();
  }
}
