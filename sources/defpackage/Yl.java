package defpackage;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: Yl  reason: default package */
/* compiled from: MpUserDetailsDTO */
public final class Yl implements Serializable {
    private static final long serialVersionUID = 1;
    private String aadhaarStatus;
    private String bookingName;
    private Date cardExpiryDate;
    private String concType;
    private Date dateOfBirth;
    private String gender;
    private String idCardNumber;
    private String memberType;
    private String mpAadhaarNumber;
    private Short mpStatus;
    private String secretariatType;
    private String serverId;
    private String spouseAadhaarNumber;
    private Short spouseAadhaarStatus;
    private String spouseBookingName;
    private Date spouseCardExpiryDate;
    private String spouseCardNumber;
    private String spouseConcType;
    private Date spouseDateOfBirth;
    private String spouseGender;
    private Short spouseStatus;
    private Date timeStamp;

    public String getAadhaarStatus() {
        return this.aadhaarStatus;
    }

    public String getBookingName() {
        return this.bookingName;
    }

    public Date getCardExpiryDate() {
        return this.cardExpiryDate;
    }

    public String getConcType() {
        return this.concType;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public String getGender() {
        return this.gender;
    }

    public String getIdCardNumber() {
        return this.idCardNumber;
    }

    public String getMemberType() {
        return this.memberType;
    }

    public String getMpAadhaarNumber() {
        return this.mpAadhaarNumber;
    }

    public Short getMpStatus() {
        return this.mpStatus;
    }

    public String getSecretariatType() {
        return this.secretariatType;
    }

    public String getServerId() {
        return this.serverId;
    }

    public String getSpouseAadhaarNumber() {
        return this.spouseAadhaarNumber;
    }

    public Short getSpouseAadhaarStatus() {
        return this.spouseAadhaarStatus;
    }

    public String getSpouseBookingName() {
        return this.spouseBookingName;
    }

    public Date getSpouseCardExpiryDate() {
        return this.spouseCardExpiryDate;
    }

    public String getSpouseCardNumber() {
        return this.spouseCardNumber;
    }

    public String getSpouseConcType() {
        return this.spouseConcType;
    }

    public Date getSpouseDateOfBirth() {
        return this.spouseDateOfBirth;
    }

    public String getSpouseGender() {
        return this.spouseGender;
    }

    public Short getSpouseStatus() {
        return this.spouseStatus;
    }

    public Date getTimeStamp() {
        return this.timeStamp;
    }

    public void setAadhaarStatus(String str) {
        this.aadhaarStatus = str;
    }

    public void setBookingName(String str) {
        this.bookingName = str;
    }

    public void setCardExpiryDate(Date date) {
        this.cardExpiryDate = date;
    }

    public void setConcType(String str) {
        this.concType = str;
    }

    public void setDateOfBirth(Date date) {
        this.dateOfBirth = date;
    }

    public void setGender(String str) {
        this.gender = str;
    }

    public void setIdCardNumber(String str) {
        this.idCardNumber = str;
    }

    public void setMemberType(String str) {
        this.memberType = str;
    }

    public void setMpAadhaarNumber(String str) {
        this.mpAadhaarNumber = str;
    }

    public void setMpStatus(Short sh) {
        this.mpStatus = sh;
    }

    public void setSecretariatType(String str) {
        this.secretariatType = str;
    }

    public void setServerId(String str) {
        this.serverId = str;
    }

    public void setSpouseAadhaarNumber(String str) {
        this.spouseAadhaarNumber = str;
    }

    public void setSpouseAadhaarStatus(Short sh) {
        this.spouseAadhaarStatus = sh;
    }

    public void setSpouseBookingName(String str) {
        this.spouseBookingName = str;
    }

    public void setSpouseCardExpiryDate(Date date) {
        this.spouseCardExpiryDate = date;
    }

    public void setSpouseCardNumber(String str) {
        this.spouseCardNumber = str;
    }

    public void setSpouseConcType(String str) {
        this.spouseConcType = str;
    }

    public void setSpouseDateOfBirth(Date date) {
        this.spouseDateOfBirth = date;
    }

    public void setSpouseGender(String str) {
        this.spouseGender = str;
    }

    public void setSpouseStatus(Short sh) {
        this.spouseStatus = sh;
    }

    public void setTimeStamp(Date date) {
        this.timeStamp = date;
    }

    public String toString() {
        return "MpUserDetailsDTO [secretariatType=" + this.secretariatType + ", memberType=" + this.memberType + ", idCardNumber=" + this.idCardNumber + ", bookingName=" + this.bookingName + ", dateOfBirth=" + this.dateOfBirth + ", gender=" + this.gender + ", cardExpiryDate=" + this.cardExpiryDate + ", mpAadhaarNumber=" + this.mpAadhaarNumber + ", aadhaarStatus=" + this.aadhaarStatus + ", mpStatus=" + this.mpStatus + ", spouseBookingName=" + this.spouseBookingName + ", spouseCardNumber=" + this.spouseCardNumber + ", spouseCardExpiryDate=" + this.spouseCardExpiryDate + ", spouseAadhaarNumber=" + this.spouseAadhaarNumber + ", spouseAadhaarStatus=" + this.spouseAadhaarStatus + ", spouseStatus=" + this.spouseStatus + ", spouseGender=" + this.spouseGender + ", spouseDateOfBirth=" + this.spouseDateOfBirth + ", serverId=" + this.serverId + ", timeStamp=" + this.timeStamp + "]";
    }
}
