package com.fergueiredo.countryloader.db;

import com.fergueiredo.countryloader.Country;
import org.bson.Document;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountryDocumentFactoryTest {
    @Test
    public void shouldCreateABsonDocumentFromCountry() {
        String expected = "{ \"code\" : \"BR\", \"englishName\" : \"Brazil\", \"frenchName\" : \"Bresil\" }";
        String brazilCsv = "BR,Brazil,Bresil";
        Country brazil = new Country(brazilCsv);

        CountryDocumentFactory countryDocumentFactory = new CountryDocumentFactory();
        Document brazilDocument = countryDocumentFactory.create(brazil);

        Assertions.assertEquals(expected, brazilDocument.toJson());
    }

    @Test
    public void shouldCreateABsonDocumentFromCountryWithQuotes() {
        String expected = "{ \"code\" : \"CD\", \"englishName\" : \"Congo, Democratic Republic of\", \"frenchName\" : \"Congo, République démocratique du\" }";
        String brazilCsv = "CD,\"Congo, Democratic Republic of\",\"Congo, République démocratique du\"";
        Country brazil = new Country(brazilCsv);

        CountryDocumentFactory countryDocumentFactory = new CountryDocumentFactory();
        Document brazilDocument = countryDocumentFactory.create(brazil);

        Assertions.assertEquals(expected, brazilDocument.toJson());
    }
}
