package defpackage;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: nf  reason: default package and case insensitive filesystem */
/* compiled from: ITicketDetailsDTO */
public final class C1281nf implements Serializable {
    private static final long serialVersionUID = 5320963601284424206L;
    private String address;
    private Short addressFlag;
    private String city;
    private String colony;
    private String country;
    private Integer phoneExt;
    private Long phoneNumber;
    private Integer pinCode;
    private String postOffice;
    private String stateName;
    private String street;
    private boolean validRegdAddress;

    public String getAddress() {
        return this.address;
    }

    public Short getAddressFlag() {
        return this.addressFlag;
    }

    public String getCity() {
        return this.city;
    }

    public String getColony() {
        return this.colony;
    }

    public String getCountry() {
        return this.country;
    }

    public Integer getPhoneExt() {
        return this.phoneExt;
    }

    public Long getPhoneNumber() {
        return this.phoneNumber;
    }

    public Integer getPinCode() {
        return this.pinCode;
    }

    public String getPostOffice() {
        return this.postOffice;
    }

    public String getStateName() {
        return this.stateName;
    }

    public String getStreet() {
        return this.street;
    }

    public boolean isValidRegdAddress() {
        return this.validRegdAddress;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setAddressFlag(Short sh) {
        this.addressFlag = sh;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setColony(String str) {
        this.colony = str;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setPhoneExt(Integer num) {
        this.phoneExt = num;
    }

    public void setPhoneNumber(Long l) {
        this.phoneNumber = l;
    }

    public void setPinCode(Integer num) {
        this.pinCode = num;
    }

    public void setPostOffice(String str) {
        this.postOffice = str;
    }

    public void setStateName(String str) {
        this.stateName = str;
    }

    public void setStreet(String str) {
        this.street = str;
    }

    public void setValidRegdAddress(boolean z) {
        this.validRegdAddress = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ITicketDetailsDTO [addressFlag=");
        sb.append(this.addressFlag);
        sb.append(", address=");
        sb.append(this.address);
        sb.append(", street=");
        sb.append(this.street);
        sb.append(", colony=");
        sb.append(this.colony);
        sb.append(", city=");
        sb.append(this.city);
        sb.append(", stateName=");
        sb.append(this.stateName);
        sb.append(", country=");
        sb.append(this.country);
        sb.append(", pinCode=");
        sb.append(this.pinCode);
        sb.append(", phoneNumber=");
        sb.append(this.phoneNumber);
        sb.append(", phoneExt=");
        sb.append(this.phoneExt);
        sb.append(", validRegdAddress=");
        return xx.G(sb, this.validRegdAddress, "]");
    }
}
