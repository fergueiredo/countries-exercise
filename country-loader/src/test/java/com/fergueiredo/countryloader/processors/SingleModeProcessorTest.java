package com.fergueiredo.countryloader.processors;

import com.fergueiredo.PropertiesLoader;
import com.fergueiredo.countryloader.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SingleModeProcessorTest {
    @BeforeAll
    public static void init() {
        (new PropertiesLoader()).load();
    }
    @Test
    void pathMustExistAndBeACSVFile() {
        String path = System.getProperty("filepath");
        SingleModeProcessor processor = new SingleModeProcessor();
        processor.loadPath(path);
    }
    @Test
    void pathShouldThrowsExceptionWhenDirectory() {
        String path = System.getProperty("invalid.file.filepath");
        Throwable exception = Assertions.assertThrows(RuntimeException.class, () -> {
            SingleModeProcessor processor = new SingleModeProcessor();
            processor.loadPath(path);
        });

        Assertions.assertEquals(SingleModeProcessor.INVALID_FILE_MESSAGE, exception.getMessage());
    }
    @Test
    void invalidExtensionShouldThrowException() {
        String path = System.getProperty("invalid.extension.filepath");
        Throwable exception = Assertions.assertThrows(RuntimeException.class, () -> {
            SingleModeProcessor processor = new SingleModeProcessor();
            processor.loadPath(path);
        });

        Assertions.assertEquals(CSVReader.INVALID_CSV_FILE_MESSAGE, exception.getMessage());
    }
    @Test
    void invalidPathShouldThrowException() {
        String path = System.getProperty("invalid.filepath");
        Throwable exception = Assertions.assertThrows(RuntimeException.class, () -> {
            SingleModeProcessor processor = new SingleModeProcessor();
            processor.loadPath(path);
        });

        Assertions.assertEquals(SingleModeProcessor.INVALID_FILE_MESSAGE, exception.getMessage());
    }
}
