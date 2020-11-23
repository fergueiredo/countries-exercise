package com.fergueiredo.countryloader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVReader {

    private static final String EXTENSION = ".csv";
    public static final String INVALID_CSV_FILE_MESSAGE = "Invalid CSV file.";

    public boolean validateExtension(String name) {
        return EXTENSION.contentEquals(name.substring(name.length() - 4));
    }
    public boolean validateFile(File file) {
        return validateExtension(file.getName()) && file.exists() && !file.isDirectory();
    }

    public List<Country> loadCountries(File file) {
        validateFile(file);

        List<Country> countries = new ArrayList<>();
        try {
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                Country country = new Country(line);

                countries.add(country);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return countries;
    }
}
