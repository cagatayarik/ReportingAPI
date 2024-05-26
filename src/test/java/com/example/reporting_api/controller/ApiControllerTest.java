package com.example.reporting_api.controller;

import com.example.reporting_api.model.request.LoginRequest;
import com.example.reporting_api.model.response.JwtResponse;
import com.example.reporting_api.service.ApiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(ApiController.class)
public class ApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ApiService apiService;

    @Test
    public void testLogin() throws Exception {
        // Prepare mock response
        LoginRequest loginRequest = new LoginRequest("demo@financialhouse.io", "cjaiU8CV");
        JwtResponse jwtResponse = new JwtResponse("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJtZXJjaGFudFVzZXJJZCI6NTMsInJvbGUiOiJ1c2VyIiwibWVyY2hhbnRJZCI6Mywic3ViTWVyY2hhbnRJZHMiOlszLDc0LDkzLDExOTEsMTI5NSwxMTEsMTM3LDEzOCwxNDIsMTQ1LDE0NiwxNTMsMzM0LDE3NSwxODQsMjIwLDIyMSwyMjIsMjIzLDI5NCwzMjIsMzIzLDMyNywzMjksMzMwLDM0OSwzOTAsMzkxLDQ1NSw0NTYsNDc5LDQ4OCw1NjMsMTE0OSw1NzAsMTEzOCwxMTU2LDExNTcsMTE1OCwxMTc5LDEyOTMsMTI5NCwxMzA2LDEzMDcsMTMyNCwxMzMxLDEzMzgsMTMzOSwxMzQxLDEzNDYsMTM0NywxMzQ4LDEzNDksMTM1MywxMzgzLDEzODQsMTM4NV0sInRpbWVzdGFtcCI6MTcxNjY2NzgyNn0.2sjs5QT272mbImBxArtfSTnjBSiNtMH7DUXDHDixXxQ", "Approved");

        // Mock the service call
        when(apiService.login(loginRequest)).thenReturn(jwtResponse);

        // Convert the loginRequest object to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRequest = objectMapper.writeValueAsString(loginRequest);

        // Perform the POST request and verify the response
        mockMvc.perform(post("/api/v3/merchant/user/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"token\":\"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJtZXJjaGFudFVzZXJJZCI6NTMsInJvbGUiOiJ1c2VyIiwibWVyY2hhbnRJZCI6Mywic3ViTWVyY2hhbnRJZHMiOlszLDc0LDkzLDExOTEsMTI5NSwxMTEsMTM3LDEzOCwxNDIsMTQ1LDE0NiwxNTMsMzM0LDE3NSwxODQsMjIwLDIyMSwyMjIsMjIzLDI5NCwzMjIsMzIzLDMyNywzMjksMzMwLDM0OSwzOTAsMzkxLDQ1NSw0NTYsNDc5LDQ4OCw1NjMsMTE0OSw1NzAsMTEzOCwxMTU2LDExNTcsMTE1OCwxMTc5LDEyOTMsMTI5NCwxMzA2LDEzMDcsMTMyNCwxMzMxLDEzMzgsMTMzOSwxMzQxLDEzNDYsMTM0NywxMzQ4LDEzNDksMTM1MywxMzgzLDEzODQsMTM4NV0sInRpbWVzdGFtcCI6MTcxNjY2NzgyNn0.2sjs5QT272mbImBxArtfSTnjBSiNtMH7DUXDHDixXxQ\"}"));
    }
}
