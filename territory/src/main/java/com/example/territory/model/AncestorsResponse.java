package com.example.territory.model;

import java.util.Collections;
import java.util.List;

public class AncestorsResponse {
    private List<String> ancestors;

    public AncestorsResponse(List<String> ancestors) {
        this.ancestors = ancestors;
    }

    public AncestorsResponse(String message) {
        this.ancestors = Collections.singletonList(message);
    }

    public List<String> getAncestors() {
        return ancestors;
    }

    public void setAncestors(List<String> ancestors) {
        this.ancestors = ancestors;
    }
}
