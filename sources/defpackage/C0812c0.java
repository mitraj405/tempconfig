package defpackage;

import cris.prs.webservices.dto.CountryDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: c0  reason: default package and case insensitive filesystem */
/* compiled from: AddressDTO */
public final class C0812c0 implements Serializable {
    private static final long serialVersionUID = 1;
    private String city;
    private ArrayList<String> cityList = null;
    private ArrayList<CountryDTO> countryList = null;
    private String error;
    private ArrayList<Object> isdCountryList = null;
    private ArrayList<Object> pinList = null;
    private ArrayList<String> postofficeList = null;
    private String serverId;
    private String state;
    private ArrayList<String> stateList = null;
    private Date timeStamp;

    public String getCity() {
        return this.city;
    }

    public ArrayList<String> getCityList() {
        return this.cityList;
    }

    public ArrayList<CountryDTO> getCountryList() {
        return this.countryList;
    }

    public String getError() {
        return this.error;
    }

    public ArrayList<Object> getIsdCountryList() {
        return this.isdCountryList;
    }

    public ArrayList<Object> getPinList() {
        return this.pinList;
    }

    public ArrayList<String> getPostofficeList() {
        return this.postofficeList;
    }

    public String getServerId() {
        return this.serverId;
    }

    public String getState() {
        return this.state;
    }

    public ArrayList<String> getStateList() {
        return this.stateList;
    }

    public Date getTimeStamp() {
        return this.timeStamp;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setCityList(ArrayList<String> arrayList) {
        this.cityList = arrayList;
    }

    public void setCountryList(ArrayList<CountryDTO> arrayList) {
        this.countryList = arrayList;
    }

    public void setError(String str) {
        this.error = str;
    }

    public void setIsdCountryList(ArrayList<Object> arrayList) {
        this.isdCountryList = arrayList;
    }

    public void setPinList(ArrayList<Object> arrayList) {
        this.pinList = arrayList;
    }

    public void setPostofficeList(ArrayList<String> arrayList) {
        this.postofficeList = arrayList;
    }

    public void setServerId(String str) {
        this.serverId = str;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setStateList(ArrayList<String> arrayList) {
        this.stateList = arrayList;
    }

    public void setTimeStamp(Date date) {
        this.timeStamp = date;
    }

    public String toString() {
        return "AddressDTO [state=" + this.state + ", city=" + this.city + ", stateList=" + this.stateList + ", cityList=" + this.cityList + ", postofficeList=" + this.postofficeList + ", countryList=" + this.countryList + ", isdCountryList=" + this.isdCountryList + ", pinList=" + this.pinList + ", error=" + this.error + ", serverId=" + this.serverId + ", timeStamp=" + this.timeStamp + "]";
    }
}
