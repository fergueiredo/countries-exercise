package com.fergueiredo.countryloader;

import com.fergueiredo.PropertiesLoader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CountryLoaderTest {
    @BeforeAll
    public static void init() {
        (new PropertiesLoader()).load();
    }
    @Test
    void constructorMustReceiveExecuteAsFirstParameter() {
        String args[] = {"execute", System.getProperty("filepath")};
        CountryLoader loader = new CountryLoader(args);
        loader.start();
        Assertions.assertNotNull(loader);
    }

    @Test
    void constructorMustReceiveMonitorAsFirstParameter() {
        String args[] = {"monitor", System.getProperty("directoryPath")};
        CountryLoader loader = new CountryLoader(args);
        loader.start();
        Assertions.assertNotNull(loader);
    }

    @Test
    void constructorMustThrowExceptionWhenTheFirstParameterIsNotExecuteNorMonitor() {
        String args[] = {"test", "path"};
        Throwable exception = Assertions.assertThrows(RuntimeException.class, () -> {
            new CountryLoader(args);
        });

        Assertions.assertEquals(exception.getMessage(), "Invalid arguments.");

    }

    @Test
    void constructorMustThrowExceptionWhenLessThanTwoParameters() {
        String args[] = {};

        Throwable exception = Assertions.assertThrows(RuntimeException.class, () -> {
            new CountryLoader(args);
        });

        Assertions.assertEquals(exception.getMessage(), "Invalid arguments.");
    }

    @Test
    void constructorMustThrowExceptionWhenMoreThanTwoParameters() {
        String args[] = {"execute", "file.csv", "wrong parameter"};

        Throwable exception = Assertions.assertThrows(RuntimeException.class, () -> {
            new CountryLoader(args);
        });

        Assertions.assertEquals(exception.getMessage(), "Invalid arguments.");
    }

}
