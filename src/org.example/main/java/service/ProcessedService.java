package service;

import dto.InputFileDataDto;
import dto.ParameterDto;
import model.Operation;
import service.Utils.FileUtils;
import service.Utils.IoUtils;
import service.Utils.JsonUtils;

import java.nio.file.Path;
import java.util.logging.Logger;

public class ProcessedService {
    private static final Logger log = Logger.getLogger(String.valueOf(ProcessedService.class));


    /**
     * Дилегирующий метод класса - процессинга
     *
     * @param args
     */
    public void processed(String[] args) {
        ParameterDto parameterDto = getParameterDto(args);

        String content = IoUtils.readFileContent(parameterDto.getInputFilePath());
        InputFileDataDto contentDto = JsonUtils.fromJson(content);
        parameterDto.setContent(contentDto);


    }

    /**
     * Получаем Дто входных параметров
     *
     * @param args - входной массив с параметрами
     * @return отдаем ДТО
     */
    private ParameterDto getParameterDto(String... args) {
        Operation operation = getOperation(args[0]);
        Path inputFile = getPathFromString(args[1]);
        Path outputFile = getPathFromString(args[2]);
        return new ParameterDto(operation, inputFile, outputFile);
    }

    /**
     * Получить экземпляр класса Path из String - для этого также процессим проверку расширения и наличия файла
     *
     * @param path Путь строкой
     * @return отдаем Path
     */
    private Path getPathFromString(String path) {
        FileUtils.checkFleExistence(path);
        FileUtils.checkFileExtensionJson(path);
        return FileUtils.createPath(path);
    }

    /**
     * Отдает тип операции
     *
     * @param method
     * @return
     */
    private Operation getOperation(String method) {
        method = method.toLowerCase();
        Operation operation;

        switch (method) {
            case "stat":
                operation = Operation.STAT;
                break;
            case "search":
                operation = Operation.SEARCH;
                break;
            default:
                operation = Operation.ERROR;
                log.warning("not a valid method - " + method);
                break;
        }

        return operation;
    }
}
