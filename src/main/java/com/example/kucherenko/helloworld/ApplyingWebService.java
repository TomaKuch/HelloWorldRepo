package com.example.kucherenko.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class ApplyingWebService {
    @Autowired
    RestTemplate restTemplate;


    @GetMapping(value = "hello/world")
    public String getHello(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return restTemplate
                .exchange("http://localhost:8080/hello/World",HttpMethod.GET,entity,String.class)
                .getBody();
    }


}
