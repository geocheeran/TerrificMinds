package com.example.territory.model;

import java.util.List;

public class TerritoryNode {
    private Territory territory;
    private List<TerritoryNode> children;

    public TerritoryNode(Territory territory, List<TerritoryNode> children) {
        this.territory = territory;
        this.children = children;
    }

    public Territory getTerritory() {
        return territory;
    }

    public void setTerritory(Territory territory) {
        this.territory = territory;
    }

    public List<TerritoryNode> getChildren() {
        return children;
    }

    public void setChildren(List<TerritoryNode> children) {
        this.children = children;
    }
}
