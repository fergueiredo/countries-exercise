package com.fergueiredo.model;

public class Country {
    private String code;
    private String englishName;
    private String frenchName;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Code: ")
                .append(code)
                .append("\t")
                .append("English Name: ")
                .append(englishName)
                .append("\t")
                .append("French Name: ")
                .append(frenchName);

        return sb.toString();
    }
}
