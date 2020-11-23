package com.fergueiredo.countryloader;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Country {
    private String code;
    private String englishName;
    private String frenchName;

    public Country(String data) {
        String[] countryData = split(data);

        code = countryData[0];
        englishName = countryData[1];
        frenchName = countryData[2];
    }

    private String[] split(String data) {
        String[] infos = data.split(",");

        if (infos.length == 3) return infos;

        return getInfoWithQuotes(infos);

    }

    private String[] getInfoWithQuotes(String[] infos) {
        String partial = "";
        int index = -1;
        List<String> returnInfo = new ArrayList<>();

        for (int i = 0; i < infos.length; i++) {
            if (infos[i].startsWith("\"")) {
                partial = infos[i].substring(1);
                index = i;
            } else if (infos[i].endsWith("\"")) {
                partial = partial.join(",", partial, infos[i].substring(0, infos[i].length() - 1));
                index = -1;
                returnInfo.add(partial);
            } else if (index != -1) {
                partial = partial.join(",", partial, infos[i]);
            } else {
                returnInfo.add(infos[i]);
            }
        }

        return returnInfo.toArray(new String[returnInfo.size()]);
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
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
        StringBuffer strb = new StringBuffer();
        strb.append(code)
            .append(" - ")
            .append(englishName)
            .append(" - ")
            .append(frenchName);

        return strb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(code, country.code) &&
                Objects.equals(englishName, country.englishName) &&
                Objects.equals(frenchName, country.frenchName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, englishName, frenchName);
    }
}
