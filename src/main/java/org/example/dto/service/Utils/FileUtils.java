package org.example.dto.service.Utils;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class FileUtils {
    private static final Logger log = Logger.getLogger(String.valueOf(FileUtils.class));

    private static final String EXTENSION = ".json";

    /**
     * Проверка существования файла
     *
     * @param path
     */
    public static void checkFleExistence(String path) {
        if (!new File(path).isFile()) {
            log.warning("file does not exist " + path);
            System.exit(0);
        }
    }

    /**
     * Проверка расширения
     *
     * @param path
     */
    public static void checkFileExtensionJson(String path) {
        String thisExtension = path.substring(path.lastIndexOf(".")).toLowerCase();
        if (!EXTENSION.equals(thisExtension)) {
            log.warning("Invalid file extension - " + path);
            System.exit(0);
        }
    }

    /**
     * Получить экземпляр класса Path и обработка исключения
     *
     * @param path
     * @return
     */
    public static Path createPath(String path) {
        return Paths.get(path);
    }


    /**
     * Получить экземпляр класса Path из String - для этого также процессим проверку расширения и наличия файла
     *
     * @param path Путь строкой
     * @return отдаем Path
     */
    public static Path getPathFromString(String path) {
        checkFleExistence(path);
        checkFileExtensionJson(path);
        return FileUtils.createPath(path);
    }
}
