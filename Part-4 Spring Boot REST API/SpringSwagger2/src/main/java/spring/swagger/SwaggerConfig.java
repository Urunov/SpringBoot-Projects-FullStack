package spring.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import static com.google.common.base.Predicates.or;

import static springfox.documentation.builders.PathSelectors.regex;
import com.google.common.base.Predicate;
/**
 * @Author: apple
 * @created on 04/04/2020
 * @Project is SpringSwagger2
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    //
    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
                .apiInfo(apiInfo()).select().paths(postPaths()).build();
    }

    private Predicate<String> postPaths() {
        return (Predicate<String>) or (regex("/api/posts.*"), regex("/api/javainuse.*"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Aspera API in FASTProject")
                .description("Apsera API based on FASPproject")
                .termsOfServiceUrl("http://javainuse.com")
                .contact("myindexu@gmail.com").license("Aspera in IBM license")
                .licenseUrl("myindexuz@gmail.com").version("1.0").build();
    }
}
