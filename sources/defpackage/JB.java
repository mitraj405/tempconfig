package defpackage;

import cris.prs.webservices.dto.InformationMessageDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: JB  reason: default package */
/* compiled from: UserRegistrationRequestDTO */
public final class JB extends Zl {
    private static final long serialVersionUID = 1;
    private String aadhaarCard;
    private Boolean aadhaarReverifyFlag;
    private Integer aadhaarVerifyFlag;
    private String address;
    private String appCodeSuperApp;
    private int appModeSuperApp;
    private String area;
    private ArrayList<C1187j2> bankDetailDTO;
    private String captcha;
    private String city;
    private String cnfPassWord;
    private String copyAddressResToOff;
    private Short countryId;
    private String countryName;
    private int deactivationReason;
    private String dob;
    private Boolean dobChangeFlag;
    private Boolean eWalletAadhaarRegisterFlag;
    private Boolean eWalletExpireFlag;
    private String email;
    private Boolean emailCanChange;
    private Date emailChangeDate;
    private Boolean emailVerified;
    private int emailVerifyFlag;
    private int email_verify_flag;
    private int enable;
    private String error;
    private ArrayList<String> errorList;
    private int ersTktDownloadFlag;
    private int ersTktSendEmailFlag;
    private String ewalletValidDocListToken;
    private Boolean fevJourney;
    private String firstName;
    private String gender;
    private Boolean genderChangeFlag;
    private int groupId;
    private Integer gstInputFlag;
    private Integer idVerificationType;
    private ArrayList<InformationMessageDTO> informationMessage;
    private Integer isdCode;
    private boolean kycAddressDisplayStat;
    private Date kycDate;
    private String kycDocToken;
    private String kycEditCheck;
    private int kycMode;
    private int kycStatus;
    private String kycValidDocListToken;
    private String landlineNumber;
    private String lastName;
    private Long lastTxnId;
    private String lastTxnStatus;
    private Date lastTxnTimeStamp;
    private String martialStatus;
    private Integer masterList;
    private String middleName;
    private int mob_verify_flag;
    private String mobile;
    private C1408tl mobileAppConfigDTO;
    private Boolean mobileCanChange;
    private Date mobileChangeDate;
    private Boolean mobileRegistration;
    private Boolean mobileVerified;
    private ArrayList<JB> mpDetailList;
    private Yl mpUserDetailsDTO;
    private Boolean nameChangeFlag;
    private Boolean nameUpdateFlag;
    private Short nationalityId;
    private String nationalityName;
    private String newsletter = "Y";
    private Long nget_unique_user_id;
    private String occupation;
    private String off_Address;
    private String off_City;
    private String off_Colony;
    private Short off_CountryId;
    private String off_LandlineNumber;
    private String off_Mobile;
    private String off_PinCode;
    private String off_PostOffice;
    private String off_State;
    private String off_Street;
    private String off_area;
    private String off_countryName;
    private String off_otherCity;
    private String off_otherCountry;
    private String off_otherState;
    private String oldSbicardInfo = null;
    private String otherCity;
    private String otherCountry;
    private String otherState;
    private Integer otpLogin;
    private String panCard;
    private String passWord;
    private Boolean passwordChangeMandatory;
    private String phase;
    private String pinCode;
    private String postOffice;
    private String prefLanguage;
    private String promomail = "Y";
    private C1413ts[] ratingOptions;
    private Integer rdsFlag;
    private Boolean recentTransactionsFlag;
    private C0488Ds recentTransactionsList;
    private Short registrationSource;
    private Integer renewFlag;
    private ArrayList<Short> rolles;
    private String sbicardInfo = "N";
    private String securityAns;
    private String securityQuestion;
    private String serverId;
    private Boolean showLastTxn;
    private ArrayList<C1187j2> softBankList;
    private ArrayList<JB> spouseDetailList;
    private String state;
    private String street;
    private Date timeStamp;
    private Double totalAmount;
    private String uidNumber;
    private ArrayList<C0471CB> userConfigurablesDTOs;
    private Short userEnableState;
    private Long userId;
    private String userIdHash;
    private String userName;
    private Boolean userPaymentFlag;
    private String verificationIdNumber = "";
    private Boolean verified;

    public JB() {
        Boolean bool = Boolean.FALSE;
        this.verified = bool;
        this.emailVerified = bool;
        this.mobileVerified = bool;
        this.kycAddressDisplayStat = false;
        this.recentTransactionsFlag = bool;
        this.passwordChangeMandatory = bool;
        this.aadhaarReverifyFlag = bool;
        this.dobChangeFlag = bool;
        this.genderChangeFlag = bool;
        this.nameChangeFlag = bool;
        this.nameUpdateFlag = bool;
    }

    public String getAadhaarCard() {
        return this.aadhaarCard;
    }

    public Boolean getAadhaarReverifyFlag() {
        return this.aadhaarReverifyFlag;
    }

    public Integer getAadhaarVerifyFlag() {
        return this.aadhaarVerifyFlag;
    }

    public String getAddress() {
        return this.address;
    }

    public String getAppCodeSuperApp() {
        return this.appCodeSuperApp;
    }

    public int getAppModeSuperApp() {
        return this.appModeSuperApp;
    }

    public String getArea() {
        return this.area;
    }

    public ArrayList<C1187j2> getBankDetailDTO() {
        return this.bankDetailDTO;
    }

    public String getCaptcha() {
        return this.captcha;
    }

    public String getCity() {
        return this.city;
    }

    public String getCnfPassWord() {
        return this.cnfPassWord;
    }

    public String getCopyAddressResToOff() {
        return this.copyAddressResToOff;
    }

    public Short getCountryId() {
        return this.countryId;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public int getDeactivationReason() {
        return this.deactivationReason;
    }

    public String getDob() {
        return this.dob;
    }

    public Boolean getDobChangeFlag() {
        return this.dobChangeFlag;
    }

    public String getEmail() {
        return this.email;
    }

    public Boolean getEmailCanChange() {
        return this.emailCanChange;
    }

    public Date getEmailChangeDate() {
        return this.emailChangeDate;
    }

    public Boolean getEmailVerified() {
        return this.emailVerified;
    }

    public int getEmailVerifyFlag() {
        return this.emailVerifyFlag;
    }

    public int getEmail_verify_flag() {
        return this.email_verify_flag;
    }

    public int getEnable() {
        return this.enable;
    }

    public String getError() {
        return this.error;
    }

    public ArrayList<String> getErrorList() {
        return this.errorList;
    }

    public int getErsTktDownloadFlag() {
        return this.ersTktDownloadFlag;
    }

    public int getErsTktSendEmailFlag() {
        return this.ersTktSendEmailFlag;
    }

    public String getEwalletValidDocListToken() {
        return this.ewalletValidDocListToken;
    }

    public Boolean getFevJourney() {
        return this.fevJourney;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getGender() {
        return this.gender;
    }

    public Boolean getGenderChangeFlag() {
        return this.genderChangeFlag;
    }

    public int getGroupId() {
        return this.groupId;
    }

    public Integer getGstInputFlag() {
        return this.gstInputFlag;
    }

    public Integer getIdVerificationType() {
        return this.idVerificationType;
    }

    public ArrayList<InformationMessageDTO> getInformationMessage() {
        return this.informationMessage;
    }

    public Integer getIsdCode() {
        return this.isdCode;
    }

    public Date getKycDate() {
        return this.kycDate;
    }

    public String getKycDocToken() {
        return this.kycDocToken;
    }

    public String getKycEditCheck() {
        return this.kycEditCheck;
    }

    public int getKycMode() {
        return this.kycMode;
    }

    public int getKycStatus() {
        return this.kycStatus;
    }

    public String getKycValidDocListToken() {
        return this.kycValidDocListToken;
    }

    public String getLandlineNumber() {
        return this.landlineNumber;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Long getLastTxnId() {
        return this.lastTxnId;
    }

    public String getLastTxnStatus() {
        return this.lastTxnStatus;
    }

    public Date getLastTxnTimeStamp() {
        return this.lastTxnTimeStamp;
    }

    public String getMartialStatus() {
        return this.martialStatus;
    }

    public Integer getMasterList() {
        return this.masterList;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public int getMob_verify_flag() {
        return this.mob_verify_flag;
    }

    public String getMobile() {
        return this.mobile;
    }

    public C1408tl getMobileAppConfigDTO() {
        return this.mobileAppConfigDTO;
    }

    public Boolean getMobileCanChange() {
        return this.mobileCanChange;
    }

    public Date getMobileChangeDate() {
        return this.mobileChangeDate;
    }

    public Boolean getMobileRegistration() {
        return this.mobileRegistration;
    }

    public Boolean getMobileVerified() {
        return this.mobileVerified;
    }

    public ArrayList<JB> getMpDetailList() {
        return this.mpDetailList;
    }

    public Yl getMpUserDetailsDTO() {
        return this.mpUserDetailsDTO;
    }

    public Boolean getNameChangeFlag() {
        return this.nameChangeFlag;
    }

    public Boolean getNameUpdateFlag() {
        return this.nameUpdateFlag;
    }

    public Short getNationalityId() {
        return this.nationalityId;
    }

    public String getNationalityName() {
        return this.nationalityName;
    }

    public String getNewsletter() {
        return this.newsletter;
    }

    public Long getNget_unique_user_id() {
        return this.nget_unique_user_id;
    }

    public String getOccupation() {
        return this.occupation;
    }

    public String getOff_Address() {
        return this.off_Address;
    }

    public String getOff_City() {
        return this.off_City;
    }

    public String getOff_Colony() {
        return this.off_Colony;
    }

    public Short getOff_CountryId() {
        return this.off_CountryId;
    }

    public String getOff_LandlineNumber() {
        return this.off_LandlineNumber;
    }

    public String getOff_Mobile() {
        return this.off_Mobile;
    }

    public String getOff_PinCode() {
        return this.off_PinCode;
    }

    public String getOff_PostOffice() {
        return this.off_PostOffice;
    }

    public String getOff_State() {
        return this.off_State;
    }

    public String getOff_Street() {
        return this.off_Street;
    }

    public String getOff_area() {
        return this.off_area;
    }

    public String getOff_countryName() {
        return this.off_countryName;
    }

    public String getOff_otherCity() {
        return this.off_otherCity;
    }

    public String getOff_otherCountry() {
        return this.off_otherCountry;
    }

    public String getOff_otherState() {
        return this.off_otherState;
    }

    public String getOldSbicardInfo() {
        return this.oldSbicardInfo;
    }

    public String getOtherCity() {
        return this.otherCity;
    }

    public String getOtherCountry() {
        return this.otherCountry;
    }

    public String getOtherState() {
        return this.otherState;
    }

    public Integer getOtpLogin() {
        return this.otpLogin;
    }

    public String getPanCard() {
        return this.panCard;
    }

    public String getPassWord() {
        return this.passWord;
    }

    public Boolean getPasswordChangeMandatory() {
        return this.passwordChangeMandatory;
    }

    public String getPhase() {
        return this.phase;
    }

    public String getPinCode() {
        return this.pinCode;
    }

    public String getPostOffice() {
        return this.postOffice;
    }

    public String getPrefLanguage() {
        return this.prefLanguage;
    }

    public String getPromomail() {
        return this.promomail;
    }

    public C1413ts[] getRatingOptions() {
        return this.ratingOptions;
    }

    public Integer getRdsFlag() {
        return this.rdsFlag;
    }

    public Boolean getRecentTransactionsFlag() {
        return this.recentTransactionsFlag;
    }

    public C0488Ds getRecentTransactionsList() {
        return this.recentTransactionsList;
    }

    public Short getRegistrationSource() {
        return this.registrationSource;
    }

    public Integer getRenewFlag() {
        return this.renewFlag;
    }

    public ArrayList<Short> getRolles() {
        return this.rolles;
    }

    public String getSbicardInfo() {
        return this.sbicardInfo;
    }

    public String getSecurityAns() {
        return this.securityAns;
    }

    public String getSecurityQuestion() {
        return this.securityQuestion;
    }

    public String getServerId() {
        return this.serverId;
    }

    public Boolean getShowLastTxn() {
        return this.showLastTxn;
    }

    public ArrayList<C1187j2> getSoftBankList() {
        return this.softBankList;
    }

    public ArrayList<JB> getSpouseDetailList() {
        return this.spouseDetailList;
    }

    public String getState() {
        return this.state;
    }

    public String getStreet() {
        return this.street;
    }

    public Date getTimeStamp() {
        return this.timeStamp;
    }

    public Double getTotalAmount() {
        return this.totalAmount;
    }

    public String getUidNumber() {
        return this.uidNumber;
    }

    public ArrayList<C0471CB> getUserConfigurablesDTOs() {
        return this.userConfigurablesDTOs;
    }

    public Short getUserEnableState() {
        return this.userEnableState;
    }

    public Long getUserId() {
        return this.userId;
    }

    public String getUserIdHash() {
        return this.userIdHash;
    }

    public String getUserName() {
        return this.userName;
    }

    public Boolean getUserPaymentFlag() {
        return this.userPaymentFlag;
    }

    public String getVerificationIdNumber() {
        return this.verificationIdNumber;
    }

    public Boolean getVerified() {
        return this.verified;
    }

    public Boolean geteWalletAadhaarRegisterFlag() {
        return this.eWalletAadhaarRegisterFlag;
    }

    public Boolean geteWalletExpireFlag() {
        return this.eWalletExpireFlag;
    }

    public boolean isKycAddressDisplayStat() {
        return this.kycAddressDisplayStat;
    }

    public Boolean isMobileRegistration() {
        return this.mobileRegistration;
    }

    public void setAadhaarCard(String str) {
        this.aadhaarCard = str;
    }

    public void setAadhaarReverifyFlag(Boolean bool) {
        this.aadhaarReverifyFlag = bool;
    }

    public void setAadhaarVerifyFlag(Integer num) {
        this.aadhaarVerifyFlag = num;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setAppCodeSuperApp(String str) {
        this.appCodeSuperApp = str;
    }

    public void setAppModeSuperApp(int i) {
        this.appModeSuperApp = i;
    }

    public void setArea(String str) {
        this.area = str;
    }

    public void setBankDetailDTO(ArrayList<C1187j2> arrayList) {
        this.bankDetailDTO = arrayList;
    }

    public void setCaptcha(String str) {
        this.captcha = str;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setCnfPassWord(String str) {
        this.cnfPassWord = str;
    }

    public void setCopyAddressResToOff(String str) {
        this.copyAddressResToOff = str;
    }

    public void setCountryId(Short sh) {
        this.countryId = sh;
    }

    public void setCountryName(String str) {
        this.countryName = str;
    }

    public void setDeactivationReason(int i) {
        this.deactivationReason = i;
    }

    public void setDob(String str) {
        this.dob = str;
    }

    public void setDobChangeFlag(Boolean bool) {
        this.dobChangeFlag = bool;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setEmailCanChange(Boolean bool) {
        this.emailCanChange = bool;
    }

    public void setEmailChangeDate(Date date) {
        this.emailChangeDate = date;
    }

    public void setEmailVerified(Boolean bool) {
        this.emailVerified = bool;
    }

    public void setEmailVerifyFlag(int i) {
        this.emailVerifyFlag = i;
    }

    public void setEmail_verify_flag(int i) {
        this.email_verify_flag = i;
    }

    public void setEnable(int i) {
        this.enable = i;
    }

    public void setError(String str) {
        this.error = str;
    }

    public void setErrorList(ArrayList<String> arrayList) {
        this.errorList = arrayList;
    }

    public void setErsTktDownloadFlag(int i) {
        this.ersTktDownloadFlag = i;
    }

    public void setErsTktSendEmailFlag(int i) {
        this.ersTktSendEmailFlag = i;
    }

    public void setEwalletValidDocListToken(String str) {
        this.ewalletValidDocListToken = str;
    }

    public void setFevJourney(Boolean bool) {
        this.fevJourney = bool;
    }

    public void setFirstName(String str) {
        this.firstName = str;
    }

    public void setGender(String str) {
        this.gender = str;
    }

    public void setGenderChangeFlag(Boolean bool) {
        this.genderChangeFlag = bool;
    }

    public void setGroupId(int i) {
        this.groupId = i;
    }

    public void setGstInputFlag(Integer num) {
        this.gstInputFlag = num;
    }

    public void setIdVerificationType(Integer num) {
        this.idVerificationType = num;
    }

    public void setInformationMessage(ArrayList<InformationMessageDTO> arrayList) {
        this.informationMessage = arrayList;
    }

    public void setIsdCode(Integer num) {
        this.isdCode = num;
    }

    public void setKycAddressDisplayStat(boolean z) {
        this.kycAddressDisplayStat = z;
    }

    public void setKycDate(Date date) {
        this.kycDate = date;
    }

    public void setKycDocToken(String str) {
        this.kycDocToken = str;
    }

    public void setKycEditCheck(String str) {
        this.kycEditCheck = str;
    }

    public void setKycMode(int i) {
        this.kycMode = i;
    }

    public void setKycStatus(int i) {
        this.kycStatus = i;
    }

    public void setKycValidDocListToken(String str) {
        this.kycValidDocListToken = str;
    }

    public void setLandlineNumber(String str) {
        this.landlineNumber = str;
    }

    public void setLastName(String str) {
        this.lastName = str;
    }

    public void setLastTxnId(Long l) {
        this.lastTxnId = l;
    }

    public void setLastTxnStatus(String str) {
        this.lastTxnStatus = str;
    }

    public void setLastTxnTimeStamp(Date date) {
        this.lastTxnTimeStamp = date;
    }

    public void setMartialStatus(String str) {
        this.martialStatus = str;
    }

    public void setMasterList(Integer num) {
        this.masterList = num;
    }

    public void setMiddleName(String str) {
        this.middleName = str;
    }

    public void setMob_verify_flag(int i) {
        this.mob_verify_flag = i;
    }

    public void setMobile(String str) {
        this.mobile = str;
    }

    public void setMobileAppConfigDTO(C1408tl tlVar) {
        this.mobileAppConfigDTO = tlVar;
    }

    public void setMobileCanChange(Boolean bool) {
        this.mobileCanChange = bool;
    }

    public void setMobileChangeDate(Date date) {
        this.mobileChangeDate = date;
    }

    public void setMobileRegistration(Boolean bool) {
        this.mobileRegistration = bool;
    }

    public void setMobileVerified(Boolean bool) {
        this.mobileVerified = bool;
    }

    public void setMpDetailList(ArrayList<JB> arrayList) {
        this.mpDetailList = arrayList;
    }

    public void setMpUserDetailsDTO(Yl yl) {
        this.mpUserDetailsDTO = yl;
    }

    public void setNameChangeFlag(Boolean bool) {
        this.nameChangeFlag = bool;
    }

    public void setNameUpdateFlag(Boolean bool) {
        this.nameUpdateFlag = bool;
    }

    public void setNationalityId(Short sh) {
        this.nationalityId = sh;
    }

    public void setNationalityName(String str) {
        this.nationalityName = str;
    }

    public void setNewsletter(String str) {
        this.newsletter = str;
    }

    public void setNget_unique_user_id(Long l) {
        this.nget_unique_user_id = l;
    }

    public void setOccupation(String str) {
        this.occupation = str;
    }

    public void setOff_Address(String str) {
        this.off_Address = str;
    }

    public void setOff_City(String str) {
        this.off_City = str;
    }

    public void setOff_Colony(String str) {
        this.off_Colony = str;
    }

    public void setOff_CountryId(Short sh) {
        this.off_CountryId = sh;
    }

    public void setOff_LandlineNumber(String str) {
        this.off_LandlineNumber = str;
    }

    public void setOff_Mobile(String str) {
        this.off_Mobile = str;
    }

    public void setOff_PinCode(String str) {
        this.off_PinCode = str;
    }

    public void setOff_PostOffice(String str) {
        this.off_PostOffice = str;
    }

    public void setOff_State(String str) {
        this.off_State = str;
    }

    public void setOff_Street(String str) {
        this.off_Street = str;
    }

    public void setOff_area(String str) {
        this.off_area = str;
    }

    public void setOff_countryName(String str) {
        this.off_countryName = str;
    }

    public void setOff_otherCity(String str) {
        this.off_otherCity = str;
    }

    public void setOff_otherCountry(String str) {
        this.off_otherCountry = str;
    }

    public void setOff_otherState(String str) {
        this.off_otherState = str;
    }

    public void setOldSbicardInfo(String str) {
        this.oldSbicardInfo = str;
    }

    public void setOtherCity(String str) {
        this.otherCity = str;
    }

    public void setOtherCountry(String str) {
        this.otherCountry = str;
    }

    public void setOtherState(String str) {
        this.otherState = str;
    }

    public void setOtpLogin(Integer num) {
        this.otpLogin = num;
    }

    public void setPanCard(String str) {
        this.panCard = str;
    }

    public void setPassWord(String str) {
        this.passWord = str;
    }

    public void setPasswordChangeMandatory(Boolean bool) {
        this.passwordChangeMandatory = bool;
    }

    public void setPhase(String str) {
        this.phase = str;
    }

    public void setPinCode(String str) {
        this.pinCode = str;
    }

    public void setPostOffice(String str) {
        this.postOffice = str;
    }

    public void setPrefLanguage(String str) {
        this.prefLanguage = str;
    }

    public void setPromomail(String str) {
        this.promomail = str;
    }

    public void setRatingOptions(C1413ts[] tsVarArr) {
        this.ratingOptions = tsVarArr;
    }

    public void setRdsFlag(Integer num) {
        this.rdsFlag = num;
    }

    public void setRecentTransactionsFlag(Boolean bool) {
        this.recentTransactionsFlag = bool;
    }

    public void setRecentTransactionsList(C0488Ds ds) {
        this.recentTransactionsList = ds;
    }

    public void setRegistrationSource(Short sh) {
        this.registrationSource = sh;
    }

    public void setRenewFlag(Integer num) {
        this.renewFlag = num;
    }

    public void setRolles(ArrayList<Short> arrayList) {
        this.rolles = arrayList;
    }

    public void setSbicardInfo(String str) {
        this.sbicardInfo = str;
    }

    public void setSecurityAns(String str) {
        this.securityAns = str;
    }

    public void setSecurityQuestion(String str) {
        this.securityQuestion = str;
    }

    public void setServerId(String str) {
        this.serverId = str;
    }

    public void setShowLastTxn(Boolean bool) {
        this.showLastTxn = bool;
    }

    public void setSoftBankList(ArrayList<C1187j2> arrayList) {
        this.softBankList = arrayList;
    }

    public void setSpouseDetailList(ArrayList<JB> arrayList) {
        this.spouseDetailList = arrayList;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setStreet(String str) {
        this.street = str;
    }

    public void setTimeStamp(Date date) {
        this.timeStamp = date;
    }

    public void setTotalAmount(Double d) {
        this.totalAmount = d;
    }

    public void setUidNumber(String str) {
        this.uidNumber = str;
    }

    public void setUserConfigurablesDTOs(ArrayList<C0471CB> arrayList) {
        this.userConfigurablesDTOs = arrayList;
    }

    public void setUserEnableState(Short sh) {
        this.userEnableState = sh;
    }

    public void setUserId(Long l) {
        this.userId = l;
    }

    public void setUserIdHash(String str) {
        this.userIdHash = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void setUserPaymentFlag(Boolean bool) {
        this.userPaymentFlag = bool;
    }

    public void setVerificationIdNumber(String str) {
        this.verificationIdNumber = str;
    }

    public void setVerified(Boolean bool) {
        this.verified = bool;
    }

    public void seteWalletAadhaarRegisterFlag(Boolean bool) {
        this.eWalletAadhaarRegisterFlag = bool;
    }

    public void seteWalletExpireFlag(Boolean bool) {
        this.eWalletExpireFlag = bool;
    }

    public String useCustomeData() {
        StringBuilder sb = new StringBuilder("UserRegistrationRequestDTO [emailVerifyFlag=");
        sb.append(this.emailVerifyFlag);
        sb.append(", phase=");
        sb.append(this.phase);
        sb.append(", nget_unique_user_id=");
        sb.append(this.nget_unique_user_id);
        sb.append(", userName=");
        sb.append(this.userName);
        sb.append(", userId=");
        sb.append(this.userId);
        sb.append(", passWord=");
        sb.append(this.passWord);
        sb.append(", cnfPassWord=");
        sb.append(this.cnfPassWord);
        sb.append(", securityQuestion=");
        sb.append(this.securityQuestion);
        sb.append(", securityAns=");
        sb.append(this.securityAns);
        sb.append(", firstName=");
        sb.append(this.firstName);
        sb.append(", middleName=");
        sb.append(this.middleName);
        sb.append(", lastName=");
        sb.append(this.lastName);
        sb.append(", gender=");
        sb.append(this.gender);
        sb.append(", martialStatus=");
        sb.append(this.martialStatus);
        sb.append(", dob=");
        sb.append(this.dob);
        sb.append(", email=");
        sb.append(this.email);
        sb.append(", occupation=");
        sb.append(this.occupation);
        sb.append(", address=");
        sb.append(this.address);
        sb.append(", street=");
        sb.append(this.street);
        sb.append(", countryId=");
        sb.append(this.countryId);
        sb.append(", otherCountry=");
        sb.append(this.otherCountry);
        sb.append(", otherCity=");
        sb.append(this.otherCity);
        sb.append(", otherState=");
        sb.append(this.otherState);
        sb.append(", pinCode=");
        sb.append(this.pinCode);
        sb.append(", state=");
        sb.append(this.state);
        sb.append(", city=");
        sb.append(this.city);
        sb.append(", area=");
        sb.append(this.area);
        sb.append(", postOffice=");
        sb.append(this.postOffice);
        sb.append(", mobile=");
        sb.append(this.mobile);
        sb.append(", isdCode=");
        sb.append(this.isdCode);
        sb.append(", landlineNumber=");
        sb.append(this.landlineNumber);
        sb.append(", copyAddressResToOff=");
        sb.append(this.copyAddressResToOff);
        sb.append(", off_Address=");
        sb.append(this.off_Address);
        sb.append(", off_area=");
        sb.append(this.off_area);
        sb.append(", off_Street=");
        sb.append(this.off_Street);
        sb.append(", off_Colony=");
        sb.append(this.off_Colony);
        sb.append(", off_CountryId=");
        sb.append(this.off_CountryId);
        sb.append(", off_PinCode=");
        sb.append(this.off_PinCode);
        sb.append(", off_State=");
        sb.append(this.off_State);
        sb.append(", off_City=");
        sb.append(this.off_City);
        sb.append(", off_PostOffice=");
        sb.append(this.off_PostOffice);
        sb.append(", off_Mobile=");
        sb.append(this.off_Mobile);
        sb.append(", off_LandlineNumber=");
        sb.append(this.off_LandlineNumber);
        sb.append(", off_otherCountry=");
        sb.append(this.off_otherCountry);
        sb.append(", off_otherCity=");
        sb.append(this.off_otherCity);
        sb.append(", off_otherState=");
        sb.append(this.off_otherState);
        sb.append(", aadhaarCard=");
        sb.append(this.aadhaarCard);
        sb.append(", panCard=");
        sb.append(this.panCard);
        sb.append(", nationalityId=");
        sb.append(this.nationalityId);
        sb.append(", prefLanguage=");
        sb.append(this.prefLanguage);
        sb.append(", verificationIdNumber=");
        sb.append(this.verificationIdNumber);
        sb.append(", idVerificationType=");
        sb.append(this.idVerificationType);
        sb.append(", uidNumber=");
        sb.append(this.uidNumber);
        sb.append(", sbicardInfo=");
        sb.append(this.sbicardInfo);
        sb.append(", promomail=");
        sb.append(this.promomail);
        sb.append(", newsletter=");
        sb.append(this.newsletter);
        sb.append(", error=");
        sb.append(this.error);
        sb.append(", mobileRegistration=");
        sb.append(this.mobileRegistration);
        sb.append(", countryName=");
        sb.append(this.countryName);
        sb.append(", off_countryName=");
        sb.append(this.off_countryName);
        sb.append(", nationalityName=");
        sb.append(this.nationalityName);
        sb.append(", oldSbicardInfo=");
        sb.append(this.oldSbicardInfo);
        sb.append(", verified=");
        sb.append(this.verified);
        sb.append(", emailVerified=");
        sb.append(this.emailVerified);
        sb.append(", mobileVerified=");
        sb.append(this.mobileVerified);
        sb.append(", userEnableState=");
        sb.append(this.userEnableState);
        sb.append(", registrationSource=");
        sb.append(this.registrationSource);
        sb.append(", mobileChangeDate=");
        sb.append(this.mobileChangeDate);
        sb.append(", mobileCanChange=");
        sb.append(this.mobileCanChange);
        sb.append(", emailChangeDate=");
        sb.append(this.emailChangeDate);
        sb.append(", emailCanChange=");
        sb.append(this.emailCanChange);
        sb.append(", mobileAppConfigDTO=");
        sb.append(this.mobileAppConfigDTO);
        sb.append(", informationMessage=");
        sb.append(this.informationMessage);
        sb.append(", userConfigurablesDTOs=");
        sb.append(this.userConfigurablesDTOs);
        sb.append(", mpUserDetailsDTO=");
        sb.append(this.mpUserDetailsDTO);
        sb.append(", lastTxnId=");
        sb.append(this.lastTxnId);
        sb.append(", lastTxnStatus=");
        sb.append(this.lastTxnStatus);
        sb.append(", lastTxnTimeStamp=");
        sb.append(this.lastTxnTimeStamp);
        sb.append(", showLastTxn=");
        sb.append(this.showLastTxn);
        sb.append(", rdsFlag=");
        sb.append(this.rdsFlag);
        sb.append(", aadhaarVerifyFlag=");
        sb.append(this.aadhaarVerifyFlag);
        sb.append(", eWalletExpireFlag=");
        sb.append(this.eWalletExpireFlag);
        sb.append(", eWalletAadhaarRegisterFlag=");
        sb.append(this.eWalletAadhaarRegisterFlag);
        sb.append(", renewFlag=");
        sb.append(this.renewFlag);
        sb.append(", otpLogin=");
        sb.append(this.otpLogin);
        sb.append(", rolles=");
        sb.append(this.rolles);
        sb.append(", userPaymentFlag=");
        sb.append(this.userPaymentFlag);
        sb.append(", bankDetailDTO=");
        sb.append(this.bankDetailDTO);
        sb.append(", gstInputFlag=");
        sb.append(this.gstInputFlag);
        sb.append(", totalAmount=");
        sb.append(this.totalAmount);
        sb.append(", captcha=");
        sb.append(this.captcha);
        sb.append(", serverId=");
        sb.append(this.serverId);
        sb.append(", timeStamp=");
        sb.append(this.timeStamp);
        sb.append(", errorList=");
        sb.append(this.errorList);
        sb.append(", mpDetailList=");
        sb.append(this.mpDetailList);
        sb.append(", spouseDetailList=");
        sb.append(this.spouseDetailList);
        sb.append(", kycAddressDisplayStat=");
        sb.append(this.kycAddressDisplayStat);
        sb.append(", nlpCaptchaVarsDTO=");
        sb.append(this.deactivationReason);
        sb.append(", enable=");
        sb.append(this.enable);
        sb.append(", recentTransactionsList=");
        sb.append(this.recentTransactionsList);
        sb.append(", recentTransactionsFlag=");
        sb.append(this.recentTransactionsFlag);
        sb.append(", passwordChangeMandatory=");
        sb.append(this.passwordChangeMandatory);
        sb.append(", aadhaarReverifyFlag=");
        sb.append(this.aadhaarReverifyFlag);
        sb.append(", softBankList=");
        sb.append(this.softBankList);
        sb.append(", kycStatus=");
        sb.append(this.kycStatus);
        sb.append(", kycDate=");
        sb.append(this.kycDate);
        sb.append(", kycDocToken=");
        sb.append(this.kycDocToken);
        sb.append(", userIdHash=");
        sb.append(this.userIdHash);
        sb.append(", ewalletValidDocListToken=");
        sb.append(this.ewalletValidDocListToken);
        sb.append(", kycValidDocListToken=");
        sb.append(this.kycValidDocListToken);
        sb.append(", ersTktSendEmailFlag=");
        sb.append(this.ersTktSendEmailFlag);
        sb.append(", ersTktDownloadFlag=");
        sb.append(this.ersTktDownloadFlag);
        sb.append(", dobChangeFlag=");
        sb.append(this.dobChangeFlag);
        sb.append(", genderChangeFlag=");
        sb.append(this.genderChangeFlag);
        sb.append(", nameChangeFlag=");
        sb.append(this.nameChangeFlag);
        sb.append(", nameUpdateFlag=");
        sb.append(this.nameUpdateFlag);
        sb.append(", masterList=");
        sb.append(this.masterList);
        sb.append(", fevJourney=");
        sb.append(this.fevJourney);
        sb.append(", kycMode=");
        sb.append(this.kycMode);
        sb.append(", ratingOptions=");
        sb.append(Arrays.toString(this.ratingOptions));
        sb.append(", groupId=");
        sb.append(this.groupId);
        sb.append(", appCodeSuperApp=");
        sb.append(this.appCodeSuperApp);
        sb.append(", appModeSuperApp=");
        return lf.k(sb, this.appModeSuperApp, "]");
    }
}
