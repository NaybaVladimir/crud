package model;

public enum Operation {
    SEARCH("search"),
    STAT("stat"),
    ERROR("error");

    private String typeOperation;

    Operation(String typeOperation) {
        typeOperation = typeOperation.toLowerCase();
        this.typeOperation = typeOperation;
    }


}
