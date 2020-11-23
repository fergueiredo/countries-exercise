package com.fergueiredo.countryloader.processors;

import com.fergueiredo.countryloader.CSVReader;
import com.fergueiredo.countryloader.Country;
import com.fergueiredo.countryloader.db.CountryRepository;
import java.io.File;
import java.util.*;

public class SingleModeProcessor implements LoadProcessor {
    public static final String INVALID_FILE_MESSAGE = "Invalid file.";

    private File file;

    private List<Country> countries;

    @Override
    public void execute() {
        CSVReader reader = new CSVReader();
        countries = reader.loadCountries(file);

        CountryRepository countryRepository = new CountryRepository();

        for (Country country : countries) {
            countryRepository.insert(country);
        }

    }

    @Override
    public void loadPath(String path) {
        file = new File(path);
        if (!file.exists() || file.isDirectory()) {
            throw new RuntimeException(INVALID_FILE_MESSAGE);
        }

        if (!(new CSVReader()).validateFile(file)) throw new RuntimeException(CSVReader.INVALID_CSV_FILE_MESSAGE);
    }
}
