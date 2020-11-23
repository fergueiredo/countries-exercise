package com.fergueiredo.countryloader;

import com.fergueiredo.countryloader.processors.ListenerModeProcessor;
import com.fergueiredo.countryloader.processors.LoadProcessor;
import com.fergueiredo.countryloader.processors.SingleModeProcessor;

public class CountryLoader {
    private static final String EXECUTE_MODE = "execute";
    private static final String LISTENER_MODE = "monitor";
    private static final String INVALID_ARGUMENTS_MESSAGE = "Invalid arguments.";

    private LoadProcessor processor;
    private String path;

    public CountryLoader(String[] args) {
        validateNumberOfArguments(args);
        loadMode(args[0]);
        loadPath(args[1]);
    }

    private void validateNumberOfArguments(String[] args) {
        if (args.length != 2) throw new RuntimeException(INVALID_ARGUMENTS_MESSAGE);
    }

    private void loadMode(String mode) {
        if (EXECUTE_MODE.contentEquals(mode.toLowerCase())) {
            this.processor = new SingleModeProcessor();
            return;
        }

        if (LISTENER_MODE.contentEquals(mode.toLowerCase())) {
            this.processor = new ListenerModeProcessor();
            return;
        }

        throw new RuntimeException(INVALID_ARGUMENTS_MESSAGE);
    }

    private void loadPath(String path) {
        processor.loadPath(path);
    }

    public void start() {
        processor.execute();
    }

}
