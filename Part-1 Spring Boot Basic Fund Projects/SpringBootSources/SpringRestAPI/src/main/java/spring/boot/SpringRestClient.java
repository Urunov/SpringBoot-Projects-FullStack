package spring.boot;

import org.springframework.web.client.RestTemplate;

/**
 * @Created 25 / 03 / 2020 - 5:17 PM
 * @project SpringRestAPI
 * @Author Hamdamboy
 */
public class SpringRestClient {
    //
    private static final String GET_EMPLOYEES_ENDPOINT_URL =  "http://localhost:8080/api/v1/employees";
    private static final String GET_EMPLOYEE_ENDPOINT_URL = "http://localhost:8080/api/v1/employees/{id}";
    private static final String CREATE_EMPLOYEE_ENDPOINT_URL = "http://localhost:8080/api/v1/employees";
    private static final String UPDATE_EMPLOYEE_ENDPOINT_URL = "http://localhost:8080/api/v1/employees/{id}";
    private static final String DELETE_EMPLOYEE_ENDPOINT_URL = "http://localhost:8080/api/v1/employees/{id}";
    private static RestTemplate restTemplate = new RestTemplate();

    public static void main(String []args) {
        //
        SpringRestClient springRestClient = new SpringRestClient();

        // Step-1: The first create a new employee
        springRestClient.createEmployee();

    }
}
