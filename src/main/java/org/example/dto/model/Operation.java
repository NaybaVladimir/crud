package org.example.dto.model;

public enum Operation {
    SEARCH("search"),
    STAT("stat"),
    ERROR("error");

    private String typeOperation;

    Operation(String typeOperation) {
        this.typeOperation = typeOperation.toLowerCase();;
    }


}
