   ## Part-6: Spring Boot + Security 

# 
## All project for spreated secutrity level on it. Figure-1. Security environment and implemenation, step by step. 
![SecuritySpring](https://user-images.githubusercontent.com/11626327/85666443-6c65a700-b6f7-11ea-8bcb-1d3f74f799ff.jpg)
  
## Project-0. SpringUnSecureProject (You may see in README in the Project0..._)
   * Simple project provides Spring Boot and No - Security dependency and using @Security annotation. 
   * The mainly 2 parameters: Annotaion with logic and dependency (maven)
   
## Project-1. SpringHttpBasicSecure
  * Simple project provides Spring Boot and Security dependency and using @Security annotation. 
   
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-security</artifactId>
            </dependency>

![securityHTTP](https://user-images.githubusercontent.com/11626327/85667622-bef39300-b6f8-11ea-8d61-d8e8c9b93c09.JPG)

## Project-2 Spring Security Role Based
   * Spring Boot + Web + Security
   * Dependecy adding in Maven

![signSecurity](https://user-images.githubusercontent.com/11626327/85668222-6cff3d00-b6f9-11ea-911f-48cc82a4a331.JPG)

## Project-3. SpringSecureRestControl
   * Spring Boot + Web + Security
   * Dependecy adding in Maven
   
![sighsecuriyt](https://user-images.githubusercontent.com/11626327/85668666-f6167400-b6f9-11ea-87e0-7c85993edbd9.JPG)

## Project-4. SpringSecureAuthorization

   * Spring Boot + Web + Security
   * Dependecy adding in Maven
   
## Project-5. SpringHttpsSecurity
  -> Project-5.0.1 SpringHttptoHttps
  -> Project-6. SpringSecureSSLHttps
* Http to HTTPS 
* Server configuration Security
 #
        server.port=8443
        server.ssl.enabled=true
       
        ## The path to the keystore containing the certificate
         server.ssl.key-store = src/main/resources/securePC.p12
        #
        ## The format used for the keystore. It could be set to JKS in case it is a JKS file
         server.ssl.key-store-type = PKCS12
        ## The password used to generate the certificate
        server.ssl.key-store-password = 123456
        
![sighSecurityagarin](https://user-images.githubusercontent.com/11626327/85672851-468fd080-b6fe-11ea-9c05-854e2ad945a9.JPG)

## Project-7. SpringSecureDB

* Security DB
* Server configuration in the secutrity with DB

              <dependency>
                  <groupId>org.springframework.boot</groupId>
                  <artifactId>spring-boot-starter-data-jpa</artifactId>
              </dependency>
              <dependency>
                  <groupId>org.springframework.boot</groupId>
                  <artifactId>spring-boot-starter-security</artifactId>
              </dependency>
                   https://mvnrepository.com/artifact/mysql/mysql-connector-java 
              <dependency>
                  <groupId>mysql</groupId>
                  <artifactId>mysql-connector-java</artifactId>
                  <version>8.0.15</version>
              </dependency>
              
## Project-8. SpringSecureDB

* Security DB
* Server configuration in the secutrity with DB
             
    
