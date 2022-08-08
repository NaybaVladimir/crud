package service.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class IoUtils {
    private static final Logger log = Logger.getLogger(String.valueOf(FileUtils.class));

    public static String readFileContent(Path filePath) {
        try (Stream<String> lines = Files.lines(filePath)) {
            String value = lines.reduce("", String::concat);
            return value;
        } catch (IOException e) {
            log.warning("file read error");
            System.exit(1);
        }

        return null;
    }
}
