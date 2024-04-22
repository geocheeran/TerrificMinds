package com.example.territory.service;

import com.example.territory.model.TerritoryNode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TerritoryServiceTest {

    @Autowired
    private TerritoryService territoryService;

    @Test
    void testFindAncestors() {
        // Get the root node from TerritoryService
        TerritoryNode rootNode = territoryService.getRootNode();

        // Test finding ancestors for a known place
        List<String> expectedAncestors = Arrays.asList("India", "Tamil Nadu");
        List<String> actualAncestors = territoryService.findAncestors(rootNode, "Chennai");
        assertEquals(expectedAncestors, actualAncestors);


        // Test finding ancestors for a place with no ancestors
        List<String> expectedNoAncestors = Arrays.asList();
        List<String> actualNoAncestors = territoryService.findAncestors(rootNode, "UnknownPlace");
        assertEquals(expectedNoAncestors, actualNoAncestors);
    }
}
