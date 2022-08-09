package org.example.dto.model.dto;

import org.example.dto.model.Operation;

import java.nio.file.Path;

public class ParameterDto {
    private Operation operation;
    private Path inputFilePath;
    private Path outputFilePath;
    private RequestDto content;

    public ParameterDto(Operation operation, Path inputFilePath, Path outputFiltPath) {
        this.operation = operation;
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFiltPath;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Path getInputFilePath() {
        return inputFilePath;
    }

    public void setInputFilePath(Path inputFilePath) {
        this.inputFilePath = inputFilePath;
    }

    public Path getOutputFilePath() {
        return outputFilePath;
    }

    public void setOutputFilePath(Path outputFilePath) {
        this.outputFilePath = outputFilePath;
    }

    public RequestDto getContent() {
        return content;
    }

    public void setContent(RequestDto content) {
        this.content = content;
    }
}
