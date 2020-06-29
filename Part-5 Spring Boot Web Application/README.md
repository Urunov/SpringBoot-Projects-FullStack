#                                           Spring Boot Projects - Full Stack

## Most small project related to Web (JPS and Themeleaf). Spring MVC implementation etc. 
   * Spring MVC + Spring Boot2 + JSP + JPA + Hibernate 5 + MySQL Example
   * Spring Boot 2 MVC Web Application Thymeleaf JPA MySQL Example
   * Spring Boot 2 - Spring MVC + Thymeleaf Input Form Validation
   * Spring Boot JPA Multiple Data Sources Example
   
   * SpringBootFormValidationJSP
         - Below are some constraints defined by Java Bean Validation API:

         @NotEmpty: specifies that the annotated field must not be null or empty.
         @NotBlank: the annotated field must not be null and must contain at least one non-whitespace character.
         @NotNull: the annotated field must not be null.
         @Email: the string has to be a well-formed email address.
         @Min: the field must be a number whose value must be higher or equal to the specified minimum value.
         @Max: the field must be a number whose value must be lower or equal to the specified maximum value.
         @Size: the field must have size falls within the specified range. Applied for string, collections and arrays.
         All these annotations come from the javax.validation.constraints package. For the complete list of Java Bean Validation annotations, see this page.

And thanks to Spring Boot which applies automatic configuration, we don’t have configure anything to use Java Bean validation API. It’s automatically included in the spring-boot-starter-web dependency.

   * SpringBootThymeleafFormValidation 
        -  This Spring Boot tutorial helps you learn to code validation for form fields in a Spring Boot application with JSP/Thymeleaf   view.  
         - Form validation is necessary for any web forms to prevent the users from submitting inappropriate values for form fields. For example, the following screenshot shows the error messages reported after the user tries to submit the form when all fields are left blank.
