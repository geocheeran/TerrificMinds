package com.example.territory.controller;

import com.example.territory.model.TerritoryNode;
import com.example.territory.service.TerritoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
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

    private TerritoryNode rootNode;
    private List<TerritoryNode> children;

    @BeforeEach
    void setUp() {
        // Initialize the rootNode as required and set up the mock territoryService behavior
        rootNode = new TerritoryNode(null, children); // Assuming no Territory object in TerritoryNode constructor
        given(territoryService.getRootNode()).willReturn(rootNode);
    }

    @Test
    void shouldReturnAncestorsForChennai() throws Exception {
        // Define the expected ancestors list
        List<String> expectedAncestors = new ArrayList<>();
        expectedAncestors.add("India");
        expectedAncestors.add("Tamil Nadu");

        // Mock the behavior of TerritoryService.findAncestors method
        given(territoryService.findAncestors(rootNode, "Chennai")).willReturn(expectedAncestors);

        // Perform the GET request and verify the result
        mockMvc.perform(get("/api/ancestors/Chennai"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.ancestors").value(expectedAncestors));
    }


    @Test
    void shouldReturnAncestorsForIndia() throws Exception {
        // Define the expected ancestors list
        ArrayList<String> expectedAncestors = new ArrayList<>();
        // Mock behavior for the TerritoryService.findAncestors method
        given(territoryService.findAncestors(rootNode, "India")).willReturn(expectedAncestors);

        // Perform the GET request and verify the result
        mockMvc.perform(get("/api/ancestors/India"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.ancestors").value(expectedAncestors));
    }
    @Test
    void shouldReturnAncestorsForUnknown() throws Exception {
        // Define the expected response message
        String expectedResponse = "This place is not in the list";

        // Mock behavior for the TerritoryService.findAncestors method
        given(territoryService.findAncestors(rootNode, "unknown")).willReturn(null);

        // Perform the GET request and verify the result
        mockMvc.perform(get("/api/ancestors/unknown"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedResponse));
    }

}
