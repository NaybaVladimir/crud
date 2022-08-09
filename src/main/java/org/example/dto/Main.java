package org.example.dto;

import org.example.dto.service.ProcessedService;
import org.example.dto.service.Utils.BeanUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String[] args) {
        ProcessedService processedService = BeanUtils.getBean(ProcessedService.class);
        processedService.processed(args);
    }
}
