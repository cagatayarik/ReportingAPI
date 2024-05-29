package com.example.reporting_api.controller;

import com.example.reporting_api.config.SecurityConfig;
import com.example.reporting_api.model.request.LoginRequest;
import com.example.reporting_api.model.response.JwtResponse;
import com.example.reporting_api.service.ApiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.*;

@WebMvcTest(ApiController.class)
@AutoConfigureMockMvc(addFilters = false)
@Import(SecurityConfig.class)
public class ApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ApiService apiService;

    @Test
    public void testLogin() throws Exception {
        LoginRequest loginRequest = new LoginRequest("demo@financialhouse.io", "cjaiU8CV");
        JwtResponse jwtResponse = new JwtResponse("token", "APPROVED");

        when(apiService.login(any(LoginRequest.class))).thenReturn(ResponseEntity.ok(jwtResponse));

        mockMvc.perform(post("/api/v3/merchant/user/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\":\"demo@financialhouse.io\",\"password\":\"cjaiU8CV\"}"))
                .andExpect(status().isOk());

        verify(apiService).login(any(LoginRequest.class));
    }
}
