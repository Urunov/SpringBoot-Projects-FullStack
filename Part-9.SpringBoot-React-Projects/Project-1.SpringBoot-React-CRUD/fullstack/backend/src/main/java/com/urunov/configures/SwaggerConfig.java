package com.urunov.configures;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.function.Predicate;
import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by:
 * User: hamdamboy
 * Project: IntelliJ IDEA
 * Github: @urunov
 */
public class SwaggerConfig {

    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
                .apiInfo(apiInfo()).select().paths((com.google.common.base.Predicate<String>) postPaths()).build();
    }

    private Predicate<String> postPaths() {
        return (Predicate<String>) or(regex("/api/posts.*"), regex("/api/javainuse.*"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("JavaInUse API")
                .description("JavaInUse API reference for developers")
                .termsOfServiceUrl("http://javainuse.com")
                .contact("javainuse@gmail.com").license("JavaInUse License")
                .licenseUrl("javainuse@gmail.com").version("1.0").build();
    }
}
