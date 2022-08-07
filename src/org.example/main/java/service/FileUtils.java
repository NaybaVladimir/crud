package service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Logger;

public class FileUtils {
    private static final Logger log = Logger.getLogger(String.valueOf(FileUtils.class));

    private static final String EXTENSION = ".json";

    /**
     * Проверка существования файла
     * @param path
     */
    public static void checkFleExistence(String path) {
        if (!new File(path).isFile()) {
            log.warning("file does not exist " + path);
            System.exit(1);
        }
    }

    /**
     * Проверка расширения
     * @param path
     */
    public static void checkFileExtensionJson(String path) {
        String thisExtension = path.substring(path.lastIndexOf(".")).toLowerCase();
        if (!EXTENSION.equals(thisExtension)) {
            log.warning("Invalid file extension - " + path);
            System.exit(1);
        }
    }

    /**
     * Получить экземпляр класса Path и обработка исключения
     * @param path
     * @return
     */
    public static Path createTempFile(String path) {
        Path tempFile = null;

        try {
            tempFile = Files.createTempFile(path, ".json");
        } catch (IOException e) {
            System.exit(1);
        }

        return tempFile;
    }
}
