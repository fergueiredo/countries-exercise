package com.fergueiredo.countryloader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountryTest {
    @Test
    void countryMustReceiveThreeParametersSeparatedByCommas() {
        String param = "PF,French Polynesia,Polynésie française";
        Country country = new Country(param);
        Assertions.assertEquals("PF - French Polynesia - Polynésie française", country.toString());
    }

    @Test
    void countryCouldReceiveParametersWithCommaBetweenQuotes() {
        String param = "CD,\"Congo, Democratic Republic of\",\"Congo, République démocratique du\"";
        Country country = new Country(param);
        Assertions.assertEquals("CD - Congo, Democratic Republic of - Congo, République démocratique du", country.toString());
    }
}
