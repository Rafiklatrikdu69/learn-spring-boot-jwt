package com.spring_boot_jwt.learn_spring_boot_jwt;

import com.spring_boot_jwt.learn_spring_boot_jwt.request.AuthenticationRequest;
import com.spring_boot_jwt.learn_spring_boot_jwt.response.AuthenticationResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static com.jayway.jsonpath.internal.path.PathCompiler.fail;
import static org.junit.jupiter.api.Assertions.*;

public class SpringBootJwtApplicationTests {
    private String path = "http://localhost:9898";
    @Test
    public void testGetProductFailed() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response;
        try {
            response = restTemplate.getForEntity(path + "/products",
                    String.class);
        } catch (HttpClientErrorException.Forbidden e) {
            assertEquals(1, 1);
        }
    }
    @Test
    public void testGetProduct() {
        RestTemplate restTemplate = new RestTemplate();
        AuthenticationRequest authen = new AuthenticationRequest();
        authen.setUsername("toto");
        authen.setPassword("titi");
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-type", "application/json;charset=UTF-8");
        HttpEntity<AuthenticationRequest> request = new HttpEntity<>(authen,
                headers);
        AuthenticationResponse authenticationResponse =
                restTemplate.postForObject(path + "/authenticate", request,
                        AuthenticationResponse.class);
        String token = authenticationResponse.getJwttoken();
        assertNotNull(token);
        restTemplate = new RestTemplate();
        headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        ResponseEntity<String> response;
        request = new HttpEntity(headers);
        try {
            response = restTemplate.exchange(path + "/products",
                    HttpMethod.GET, request, String.class);
            assertEquals(response.getBody(), "welcome");
        } catch (HttpClientErrorException e) {
            fail("erreur");
        }
        request = new HttpEntity(headers);
        try {
            response = restTemplate.exchange(path + "/products",
                    HttpMethod.GET, request, String.class);
            assertEquals(response.getBody(), "welcome");
        } catch (HttpClientErrorException e) {
            fail("erreur");
        }
        request = new HttpEntity(headers);
        try {
            response = restTemplate.exchange(path + "/products",
                    HttpMethod.GET, request, String.class);
            assertEquals(response.getBody(), "welcome");
        } catch (HttpClientErrorException e) {
            fail("erreur");
        }
    }
    @Test
    public void testAuthentificationBadLogin() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            AuthenticationRequest authen = new AuthenticationRequest();
            authen.setUsername("tata");
            authen.setPassword("titi");
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-type", "application/json;charset=UTF-8");
            HttpEntity<AuthenticationRequest> request = new
                    HttpEntity<>(authen, headers);
            AuthenticationResponse authenticationResponse =
                    restTemplate.postForObject(path + "/authenticate", request,
                            AuthenticationResponse.class);
            String token = authenticationResponse.getJwttoken();
        }
        catch (Exception e)
        {
            assertTrue(true);
        }
    }
}
