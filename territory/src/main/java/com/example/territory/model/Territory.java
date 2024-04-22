package com.example.territory.model;

public class Territory {
    private int id;
    private String name;
    private int parentId;

    public Territory(int id, String name, int parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }
    public Territory() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
