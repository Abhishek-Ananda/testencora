package com.assesment.employee.urlservice;

import java.util.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ThirdApiCall {

    @Value("${url.xyz.company}") // ✅ Correct format for @Value
    private String randomUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public String callThirdPartyApi() {
        String username = "yourUsername";
        String password = "yourPassword";

        // Encode credentials
        String credentials = username + ":" + password;
        String base64Creds = Base64.getEncoder().encodeToString(credentials.getBytes());

        // Set up headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Basic " + base64Creds);
        headers.set("Custom-Header", "custom-value");

        // Prepare entity
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Perform GET call
        ResponseEntity<String> response = restTemplate.exchange(
            randomUrl,
            HttpMethod.GET,
            entity,
            String.class
        );

        return response.getBody(); // Or handle the response as needed
    }
}
