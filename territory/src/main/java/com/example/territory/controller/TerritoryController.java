package com.example.territory.controller;

import com.example.territory.model.AncestorsResponse;
import com.example.territory.model.TerritoryNode;
import com.example.territory.service.TerritoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TerritoryController {

    private final TerritoryService territoryService;

    @Autowired
    public TerritoryController(TerritoryService territoryService) {
        this.territoryService = territoryService;
    }

    @GetMapping("/ancestors/{name}")
    public ResponseEntity<?> getAncestors(@PathVariable String name) {
        TerritoryNode rootNode = territoryService.getRootNode();
        List<String> ancestors = territoryService.findAncestors(rootNode, name);

        // Check if the provided name is in the list but has no ancestors
        if (ancestors != null) {
            if (ancestors.isEmpty()) {
                // Return an empty array in AncestorsResponse if the name is in the list but has
                // no ancestors
                AncestorsResponse response = new AncestorsResponse(Collections.emptyList());
                return ResponseEntity.ok(response);
            } else {
                // Create an instance of AncestorsResponse with the list of ancestors
                AncestorsResponse response = new AncestorsResponse(ancestors);
                return ResponseEntity.ok(response);
            }
        }

        // If the provided name is not in the list, return a message
        return ResponseEntity.ok("This place is not in the list");
    }

}
