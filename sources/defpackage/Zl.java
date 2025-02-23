package defpackage;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: Zl  reason: default package */
/* compiled from: MpUserRegistrationDTO */
public class Zl implements Serializable {
    private static final long serialVersionUID = 1;
    private Short cardStatus;
    private Boolean existenceFlag;
    private Short funcType;
    private Short mpAadhaarStatus;
    private String mpBookingName;
    private Boolean mpCardExpFlag;
    private String mpDisabilityFlag;
    private String mpFileExistFlag;
    private String mpGender;
    private String mpICardExpiryDate;
    private String mpICardIssueDate;
    private String mpICardNumber;
    private String mpICardUpdateStatus;
    private Short mpMaritalStatus;
    private String mpName;
    private Date mpOldICardIssueDate;
    private Integer mpOldICardNumber;
    private Integer mpOldStatus = 0;
    private String mpPhoto;
    private String mpPhotoName;
    private Short mpSecretariatType;
    private Integer mpSpouseFlag;
    private Short mpStatus;
    private Short mpType;
    private Short oldMpSecretariatType;
    private Short oldMpType;
    private String spouseAadhaarNumber;
    private Short spouseAadhaarStatus;
    private String spouseBookingName;
    private String spouseDateOfBirth;
    private String spouseEMailId;
    private Boolean spouseExistenceFlag;
    private String spouseGender;
    private String spouseICardExpiryDate;
    private String spouseICardIssueDate;
    private String spouseICardNumber;
    private String spouseICardUpdateStatus;
    private String spouseMobileNumber;
    private String spouseName;
    private String spouseNearestCity;
    private Integer spouseOldStatus = 0;
    private Short spouseStatus;
    private String status;
    private Boolean updatePhoto;

    public Zl() {
        Boolean bool = Boolean.FALSE;
        this.existenceFlag = bool;
        this.mpCardExpFlag = bool;
        this.funcType = 0;
        this.mpSpouseFlag = 0;
        this.spouseExistenceFlag = bool;
        this.mpFileExistFlag = "false";
        this.updatePhoto = bool;
        this.cardStatus = 1;
    }

    public Short getCardStatus() {
        return this.cardStatus;
    }

    public short getFuncType() {
        return this.funcType.shortValue();
    }

    public Short getMpAadhaarStatus() {
        return this.mpAadhaarStatus;
    }

    public String getMpBookingName() {
        return this.mpBookingName;
    }

    public String getMpDisabilityFlag() {
        return this.mpDisabilityFlag;
    }

    public String getMpFileExistFlag() {
        return this.mpFileExistFlag;
    }

    public String getMpGender() {
        return this.mpGender;
    }

    public String getMpICardExpiryDate() {
        return this.mpICardExpiryDate;
    }

    public String getMpICardIssueDate() {
        return this.mpICardIssueDate;
    }

    public String getMpICardNumber() {
        return this.mpICardNumber;
    }

    public String getMpICardUpdateStatus() {
        return this.mpICardUpdateStatus;
    }

    public Short getMpMaritalStatus() {
        return this.mpMaritalStatus;
    }

    public String getMpName() {
        return this.mpName;
    }

    public Date getMpOldICardIssueDate() {
        return this.mpOldICardIssueDate;
    }

    public Integer getMpOldICardNumber() {
        return this.mpOldICardNumber;
    }

    public int getMpOldStatus() {
        return this.mpOldStatus.intValue();
    }

    public String getMpPhoto() {
        return this.mpPhoto;
    }

    public String getMpPhotoName() {
        return this.mpPhotoName;
    }

    public Short getMpSecretariatType() {
        return this.mpSecretariatType;
    }

    public int getMpSpouseFlag() {
        return this.mpSpouseFlag.intValue();
    }

    public Short getMpStatus() {
        return this.mpStatus;
    }

    public Short getMpType() {
        return this.mpType;
    }

    public Short getOldMpSecretariatType() {
        return this.oldMpSecretariatType;
    }

    public Short getOldMpType() {
        return this.oldMpType;
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

    public String getSpouseDateOfBirth() {
        return this.spouseDateOfBirth;
    }

    public String getSpouseEMailId() {
        return this.spouseEMailId;
    }

    public String getSpouseGender() {
        return this.spouseGender;
    }

    public String getSpouseICardExpiryDate() {
        return this.spouseICardExpiryDate;
    }

    public String getSpouseICardIssueDate() {
        return this.spouseICardIssueDate;
    }

    public String getSpouseICardNumber() {
        return this.spouseICardNumber;
    }

    public String getSpouseICardUpdateStatus() {
        return this.spouseICardUpdateStatus;
    }

    public String getSpouseMobileNumber() {
        return this.spouseMobileNumber;
    }

    public String getSpouseName() {
        return this.spouseName;
    }

    public String getSpouseNearestCity() {
        return this.spouseNearestCity;
    }

    public int getSpouseOldStatus() {
        return this.spouseOldStatus.intValue();
    }

    public Short getSpouseStatus() {
        return this.spouseStatus;
    }

    public String getStatus() {
        return this.status;
    }

    public boolean isExistenceFlag() {
        return this.existenceFlag.booleanValue();
    }

    public boolean isMpCardExpFlag() {
        return this.mpCardExpFlag.booleanValue();
    }

    public boolean isSpouseExistenceFlag() {
        return this.spouseExistenceFlag.booleanValue();
    }

    public boolean isUpdatePhoto() {
        return this.updatePhoto.booleanValue();
    }

    public String mpUserData() {
        return "MpUserRegistrationDTO [mpSecretariatType=" + this.mpSecretariatType + ", mpICardNumber=" + this.mpICardNumber + ", mpOldICardNumber=" + this.mpOldICardNumber + ", mpICardIssueDate=" + this.mpICardIssueDate + ", mpOldICardIssueDate=" + this.mpOldICardIssueDate + ", mpICardExpiryDate=" + this.mpICardExpiryDate + ", mpBookingName=" + this.mpBookingName + ", mpDisabilityFlag=" + this.mpDisabilityFlag + ", mpType=" + this.mpType + ", mpStatus=" + this.mpStatus + ", mpAadhaarStatus=" + this.mpAadhaarStatus + ", mpName=" + this.mpName + ", mpMaritalStatus=" + this.mpMaritalStatus + ", mpGender=" + this.mpGender + ", mpICardUpdateStatus=" + this.mpICardUpdateStatus + ", spouseICardNumber=" + this.spouseICardNumber + ", spouseICardIssueDate=" + this.spouseICardIssueDate + ", spouseICardExpiryDate=" + this.spouseICardExpiryDate + ", spouseBookingName=" + this.spouseBookingName + ", spouseName=" + this.spouseName + ", spouseGender=" + this.spouseGender + ", spouseDateOfBirth=" + this.spouseDateOfBirth + ", spouseMobileNumber=" + this.spouseMobileNumber + ", spouseAadhaarNumber=" + this.spouseAadhaarNumber + ", spouseNearestCity=" + this.spouseNearestCity + ", spouseEMailId=" + this.spouseEMailId + ", spouseStatus=" + this.spouseStatus + ", spouseAadhaarStatus=" + this.spouseAadhaarStatus + ", status=" + this.status + ", spouseICardUpdateStatus=" + this.spouseICardUpdateStatus + ", existenceFlag=" + this.existenceFlag + ", mpOldStatus=" + this.mpOldStatus + ", spouseOldStatus=" + this.spouseOldStatus + ", mpCardExpFlag=" + this.mpCardExpFlag + ", funcType=" + this.funcType + ", oldMpSecretariatType=" + this.oldMpSecretariatType + ", oldMpType=" + this.oldMpType + ", cardStatus=" + this.cardStatus + "]";
    }

    public void setCardStatus(Short sh) {
        this.cardStatus = sh;
    }

    public void setExistenceFlag(boolean z) {
        this.existenceFlag = Boolean.valueOf(z);
    }

    public void setFuncType(short s) {
        this.funcType = Short.valueOf(s);
    }

    public void setMpAadhaarStatus(Short sh) {
        this.mpAadhaarStatus = sh;
    }

    public void setMpBookingName(String str) {
        this.mpBookingName = str;
    }

    public void setMpCardExpFlag(boolean z) {
        this.mpCardExpFlag = Boolean.valueOf(z);
    }

    public void setMpDisabilityFlag(String str) {
        this.mpDisabilityFlag = str;
    }

    public void setMpFileExistFlag(String str) {
        this.mpFileExistFlag = str;
    }

    public void setMpGender(String str) {
        this.mpGender = str;
    }

    public void setMpICardExpiryDate(String str) {
        this.mpICardExpiryDate = str;
    }

    public void setMpICardIssueDate(String str) {
        this.mpICardIssueDate = str;
    }

    public void setMpICardNumber(String str) {
        this.mpICardNumber = str;
    }

    public void setMpICardUpdateStatus(String str) {
        this.mpICardUpdateStatus = str;
    }

    public void setMpMaritalStatus(Short sh) {
        this.mpMaritalStatus = sh;
    }

    public void setMpName(String str) {
        this.mpName = str;
    }

    public void setMpOldICardIssueDate(Date date) {
        this.mpOldICardIssueDate = date;
    }

    public void setMpOldICardNumber(Integer num) {
        this.mpOldICardNumber = num;
    }

    public void setMpOldStatus(int i) {
        this.mpOldStatus = Integer.valueOf(i);
    }

    public void setMpPhoto(String str) {
        this.mpPhoto = str;
    }

    public void setMpPhotoName(String str) {
        this.mpPhotoName = str;
    }

    public void setMpSecretariatType(Short sh) {
        this.mpSecretariatType = sh;
    }

    public void setMpSpouseFlag(int i) {
        this.mpSpouseFlag = Integer.valueOf(i);
    }

    public void setMpStatus(Short sh) {
        this.mpStatus = sh;
    }

    public void setMpType(Short sh) {
        this.mpType = sh;
    }

    public void setOldMpSecretariatType(Short sh) {
        this.oldMpSecretariatType = sh;
    }

    public void setOldMpType(Short sh) {
        this.oldMpType = sh;
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

    public void setSpouseDateOfBirth(String str) {
        this.spouseDateOfBirth = str;
    }

    public void setSpouseEMailId(String str) {
        this.spouseEMailId = str;
    }

    public void setSpouseExistenceFlag(boolean z) {
        this.spouseExistenceFlag = Boolean.valueOf(z);
    }

    public void setSpouseGender(String str) {
        this.spouseGender = str;
    }

    public void setSpouseICardExpiryDate(String str) {
        this.spouseICardExpiryDate = str;
    }

    public void setSpouseICardIssueDate(String str) {
        this.spouseICardIssueDate = str;
    }

    public void setSpouseICardNumber(String str) {
        this.spouseICardNumber = str;
    }

    public void setSpouseICardUpdateStatus(String str) {
        this.spouseICardUpdateStatus = str;
    }

    public void setSpouseMobileNumber(String str) {
        this.spouseMobileNumber = str;
    }

    public void setSpouseName(String str) {
        this.spouseName = str;
    }

    public void setSpouseNearestCity(String str) {
        this.spouseNearestCity = str;
    }

    public void setSpouseOldStatus(int i) {
        this.spouseOldStatus = Integer.valueOf(i);
    }

    public void setSpouseStatus(Short sh) {
        this.spouseStatus = sh;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setUpdatePhoto(boolean z) {
        this.updatePhoto = Boolean.valueOf(z);
    }
}
