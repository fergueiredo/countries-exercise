package com.fergueiredo.countryloader.processors;

import com.fergueiredo.countryloader.CSVReader;
import com.fergueiredo.countryloader.db.CountryRepository;
import com.fergueiredo.countryloader.db.FileRepository;

import java.io.File;
import java.io.FileFilter;

public class ListenerModeProcessor implements LoadProcessor {

    public static final String INVALID_DIRECTORY_MESSAGE = "Invalid directory.";

    private int delay;
    private File directory;

    public ListenerModeProcessor() {
        delay = Integer.parseInt(System.getProperty("delay", "10")) * 1000;
    }


    @Override
    public void execute() {
        System.out.println("Starting on listener mode.");
        while (true) {
            System.out.println("----------------------------------------");
            System.out.println("Monitoring: " + directory.hashCode());
            checkForCSVFiles();
            
            System.out.println("----------------------------------------");
            delay();
        }
    }

    private void checkForCSVFiles() {
        FileFilter filter = file -> (new CSVReader()).validateFile(file);

        for (File file : directory.listFiles(filter)) {
            load(file);
        }
    }

    private void load(File file) {
        FileRepository fileRepository = new FileRepository();

        if (fileRepository.fileAlreadyExists(file)) {
            System.out.println("File already loaded. Skipping " + file.getName());
            return;
        }
        SingleModeProcessor processor = new SingleModeProcessor();
        processor.loadPath(file.getPath());

        processor.execute();

        fileRepository.insert(file);
    }

    private void delay() {
        try{
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadPath(String path) {
        directory = new File(path);
        if (!directory.exists() || !directory.isDirectory()) {
            throw new RuntimeException(INVALID_DIRECTORY_MESSAGE);
        }
    }
}
