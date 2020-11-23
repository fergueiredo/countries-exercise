package com.fergueiredo.countriesapi.models;

import org.bson.Document;

public class Country {
    private String code;
    private String englishName;
    private String frenchName;

    public Country(String code, String englishName, String frenchName) {
        this.code = code;
        this.englishName = englishName;
        this.frenchName = frenchName;
    }

    public Country(Document result) {
        setCode((String) result.get("code"));
        setEnglishName((String) result.get("englishName"));
        setFrenchName((String) result.get("frenchName"));

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getFrenchName() {
        return frenchName;
    }

    public void setFrenchName(String frenchName) {
        this.frenchName = frenchName;
    }
}
