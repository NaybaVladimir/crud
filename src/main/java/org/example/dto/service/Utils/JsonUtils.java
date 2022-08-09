package org.example.dto.service.Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.model.dto.RequestDto;

import java.util.logging.Logger;

public class JsonUtils {
    private static final Logger log = Logger.getLogger(String.valueOf(JsonUtils.class));

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static RequestDto fromJson(String json) {
        try {
            return objectMapper.readValue(json, RequestDto.class);
        } catch (JsonProcessingException e) {
            log.warning("problems with converting json to DTO");
            System.exit(0);
        }
        return null;
    }
}
