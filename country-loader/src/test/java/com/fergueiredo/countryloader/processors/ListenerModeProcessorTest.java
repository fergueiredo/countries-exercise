package com.fergueiredo.countryloader.processors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ListenerModeProcessorTest {
    @Test
    void pathShouldBeAnExistingDirectory() {
        String path = "/home/fergueiredo/Projetos/countries";
        ListenerModeProcessor processor = new ListenerModeProcessor();
        processor.loadPath(path);

    }
    @Test
    void pathShouldNotBeAFile() {
        String path = "/home/fergueiredo/Projetos/countries/test.csv";

        Throwable exception = Assertions.assertThrows(RuntimeException.class, () -> {
            ListenerModeProcessor processor = new ListenerModeProcessor();
            processor.loadPath(path);
        });

        Assertions.assertEquals(exception.getMessage(), ListenerModeProcessor.INVALID_DIRECTORY_MESSAGE);
    }
}
