package org.example.dto.service;

import lombok.AllArgsConstructor;
import org.example.dto.model.Operation;
import org.example.dto.model.dto.RequestDto;
import org.example.dto.model.dto.ParameterDto;
import org.example.dto.service.Utils.FileUtils;
import org.example.dto.service.Utils.IoUtils;
import org.example.dto.service.Utils.JsonUtils;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.logging.Logger;

@Service
@AllArgsConstructor
public class ProcessedService {
    private static final Logger log = Logger.getLogger(String.valueOf(ProcessedService.class));

    private ClientService clientService;
    private ProductService productService;
    private PurchaseService purchaseService;


    /**
     * Дилегирующий метод класса - процессинга
     *
     * @param args
     */
    public void processed(String[] args) {
//        Product product = new Product();
//        product.setName("JDK");
//        product.setPrice("01");
//
//        Client client = new Client();
//        client.setFamilyName("Developer");
//        client.setName("Java");
//
//        Purchases purchases = new Purchases();
//        purchases.setClient(client);
//        purchases.setPurchaseDate(new Date());
//        purchases.getProduct().add(product);
//
//
//        clientService.save(client);
//        productService.save(product);
//        purchaseService.save(purchases);
        if (args.length < 3) {
            System.exit(0);
        }
        ParameterDto parameterDto = getParameterDto(args);

        String content = IoUtils.readFileContent(parameterDto.getInputFilePath());
        RequestDto contentDto = JsonUtils.fromJson(content);
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
        Path inputFile = FileUtils.getPathFromString(args[1]);
        Path outputFile = FileUtils.getPathFromString(args[2]);
        return new ParameterDto(operation, inputFile, outputFile);
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
