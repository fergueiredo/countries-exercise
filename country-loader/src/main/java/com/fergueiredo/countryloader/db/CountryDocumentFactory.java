package com.fergueiredo.countryloader.db;

import com.fergueiredo.countryloader.Country;
import org.bson.Document;

public class CountryDocumentFactory {
    public Document create(Country country) {
        Document countryDocument = new Document();
        countryDocument.append("code", country.getCode());
        countryDocument.append("englishName", country.getEnglishName());
        countryDocument.append("frenchName", country.getFrenchName());

        return countryDocument;
    }
}
