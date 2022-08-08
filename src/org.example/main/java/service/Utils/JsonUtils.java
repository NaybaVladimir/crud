package service.Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.InputFileDataDto;
import service.ProcessedService;

import java.util.logging.Logger;

public class JsonUtils {
    private static final Logger log = Logger.getLogger(String.valueOf(ProcessedService.class));

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static InputFileDataDto fromJson(String json) {
        try {
            return objectMapper.readValue(json, InputFileDataDto.class);
        } catch (JsonProcessingException e) {
            log.warning("problems with converting json to DTO");
            System.exit(1);
        }
        return null;
    }
}
