package com.example.territory.controller;

import com.example.territory.model.TerritoryNode;
import com.example.territory.service.TerritoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(TerritoryController.class)
@AutoConfigureMockMvc
class TerritoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TerritoryService territoryService;


    @Test
    void shouldReturnAncestorsForChennai() throws Exception {

        mockMvc.perform(get("/api/ancestors/infopark"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }


    @Test
    void shouldReturnAncestorsForIndia() throws Exception {
        mockMvc.perform(get("/api/ancestors/India"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }
    @Test
    void shouldReturnAncestorsForUnknown() throws Exception {
        // Define the expected response message
        String expectedResponse = "This place is not in the list";
        // Perform the GET request and verify the result
        Mockito.when(territoryService.findAncestors(ArgumentMatchers.any(),ArgumentMatchers.anyString())).thenReturn(null);
        mockMvc.perform(get("/api/ancestors/unknown"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedResponse));
    }

}
