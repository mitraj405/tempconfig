package cris.prs.webservices.dto;

import java.io.Serializable;

public final class CountryDTO implements Serializable {
    private static final long serialVersionUID = 1;
    private String country;
    private String countryCode;
    private Integer countryId;

    public String getCountry() {
        return this.country;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public Integer getCountryId() {
        return this.countryId;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public void setCountryId(Integer num) {
        this.countryId = num;
    }

    public String toString() {
        return "CountryDTO [country=" + this.country + ", countryCode=" + this.countryCode + ", countryId=" + this.countryId + "]";
    }
}
