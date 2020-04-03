package spring.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.function.Predicate;
import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * @Created 03 / 04 / 2020 - 3:23 PM
 * @project SpringSwaggerBeginner
 * @Author Hamdamboy
 */

@Configuration
@EnableSwagger2
@Profile("swagger-enable-for-qa")
public class SpringSwaggerConfig {
    //
    @Bean
    public Docket postsApi(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
                .apiInfo(apiInfo()).select().paths((com.google.common.base.Predicate<String>) postPaths()).build();
    }

    private Predicate<String> postPaths(){
        return (Predicate<String>) or(regex("/api/posts.*"), regex("/api/projects.*"));
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("Project Aspera API in Spring Boot 2")
                .description("Projects Spring Swagger API reference for developers")
                .termsOfServiceUrl("http://javainuse.com")
                .contact("myindexu@gmail.com").license("JavaUnite license")
                .licenseUrl("myindexu@gmail.com").version("1.0").build();
    }

}
