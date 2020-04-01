package spring.restapi.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import spring.restapi.model.Developer;

import java.net.http.HttpHeaders;
import java.time.Instant;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * @Created 31 / 03 / 2020 - 5:21 PM
 * @project SpringRestAPI
 * @Author Hamdamboy
 */


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootCrudRestApplicationTests.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringBootCrudRestApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl(){
        return "http://localhost:" + port;
    }

    @Test
    public void contextLoads(){

    }

//    @Test
//    public void testGetAllDevelopers(){
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//
//        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/users", HttpMethod.GET, entity, String.class);
//
//        assertNotNull(response.getBody());
//    }

    @Test
    public void testGetDeveloperById() {
        //
        Developer developer = restTemplate.getForObject(getRootUrl() + "/dev/1", Developer.class);
        System.out.println(developer.getFirstName());
        assertNotNull(developer);
    }

    @Test
    public void testCreateDeveloper(){
        Developer developer = new Developer();
        developer.setEmailId("hamdamboy.urunov@gmail.com");
        developer.setFirstName("Hamdamboy");
        developer.setLastName("Urunov");
//        developer.setCreateAt(null);
//        developer.setUpdatedAt(null);

        ResponseEntity<Developer> postResponse = restTemplate.postForEntity(getRootUrl() + "/devs", developer, Developer.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdatePost(){
        int id = 1;
        Developer developer = restTemplate.getForObject(getRootUrl() + "/developers/" + id, Developer.class);
        developer.setFirstName("hamdambek");
        developer.setLastName("urunov");

        restTemplate.put(getRootUrl() + "/developer/" + id, developer);

        Developer updateDevelop = restTemplate.getForObject(getRootUrl() + "/developers/" + id, Developer.class);
        assertNotNull(updateDevelop);
    }

    @Test
    public void testDeletePost(){
        //
        int id = 2;
        Developer developer = restTemplate.getForObject(getRootUrl() + "/developers/" + id, Developer.class);
        assertNotNull(developer);

        restTemplate.delete(getRootUrl() + "/developers/" + id);

        try {
            developer = restTemplate.getForObject(getRootUrl() + "/developer/" + id, Developer.class);

        } catch (final HttpClientErrorException e){
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
