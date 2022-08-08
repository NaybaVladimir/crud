package dto;

import model.Operation;

import java.nio.file.Path;

public class ParameterDto {
    private Operation operation;
    private Path inputFilePath;
    private Path outputFilePath;
    private InputFileDataDto content;

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

    public InputFileDataDto getContent() {
        return content;
    }

    public void setContent(InputFileDataDto content) {
        this.content = content;
    }
}
