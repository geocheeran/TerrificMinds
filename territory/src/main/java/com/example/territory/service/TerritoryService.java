package com.example.territory.service;

import com.example.territory.model.Territory;
import com.example.territory.model.TerritoryNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@Service
public class TerritoryService {

    private List<Territory> territories;
    private TerritoryNode rootNode;

    @Value("${territories.file.path}")
    private String territoriesFilePath;

    public List<Territory> readJSON() {
        List<Territory> territories = new ArrayList<>();
        try {
            // Read the file and parse the JSON content
            String content = Files.readString(Paths.get(territoriesFilePath));
            ObjectMapper mapper = new ObjectMapper();
            Map<String, List<Territory>> map = mapper.readValue(content,
                    new TypeReference<Map<String, List<Territory>>>() {
                    });
            territories = map.get("territories");
        } catch (IOException e) {
            // Log the exception or handle it as needed
            e.printStackTrace();
        }
        return territories;
    }

    public TerritoryNode convertToTree(List<Territory> territories) {
        Map<Integer, TerritoryNode> nodeMap = new HashMap<>();

        for (Territory territory : territories) {
            nodeMap.put(territory.getId(), new TerritoryNode(territory, new ArrayList<>()));
        }

        for (Territory territory : territories) {
            if (territory.getParentId() != 0) {
                TerritoryNode parentNode = nodeMap.get(territory.getParentId());
                TerritoryNode currentNode = nodeMap.get(territory.getId());
                parentNode.getChildren().add(currentNode);
            } else {
                rootNode = nodeMap.get(territory.getId());
            }
        }
        return rootNode;
    }

    public List<String> findAncestors(TerritoryNode root, String input) {
        List<String> ancestors = new ArrayList<>();
        if (findAncestorsHelper(root, input, ancestors)) {
            Collections.reverse(ancestors);
            return ancestors;
        }
        return null;
    }

    private boolean findAncestorsHelper(TerritoryNode node, String input, List<String> ancestors) {
        if (node == null) {
            return false;
        }
        if (node.getTerritory().getName().equalsIgnoreCase(input)) {
            return true;
        }
        ancestors.add(node.getTerritory().getName());
        for (TerritoryNode child : node.getChildren()) {
            if (findAncestorsHelper(child, input, ancestors)) {
                return true;
            }
        }
        ancestors.remove(ancestors.size() - 1);
        return false;
    }

    public TerritoryNode getRootNode() {
        if (rootNode == null) {
            territories = readJSON();
            rootNode = convertToTree(territories);
        }
        return rootNode;
    }
}
