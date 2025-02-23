package defpackage;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: IB  reason: default package and case insensitive filesystem */
/* compiled from: UserProfileDetailsData */
public final class C0538IB implements Serializable {
    private static final long serialVersionUID = 1;
    private String address1;
    private String address2;
    private String city;
    private String cnfpassword;
    private Integer country_id;
    private Date date_of_birth;
    private String email;
    private int email_flag;
    private int enable;
    private String gender;
    private Integer isd_code;
    private String itaf_flag;
    private int kyc_status;
    private String marital_status;
    private String maskedMobileNo;
    private int mobile_flag;
    private Long mobile_number;
    private String name;
    private int no_of_loyalty_acc;
    private String password;
    private Integer pin_code;
    private String postoffice;
    private int rds_flag;
    private int registration_flag;
    private Integer requesterId;
    private String state_name;
    private Date timeStamp;
    private C0527HB userProfileAddonServices;
    private String userRequestId;
    private Date user_kyc_date;
    private String user_loginid;
    private int verified;

    public String getAddress1() {
        return this.address1;
    }

    public String getAddress2() {
        return this.address2;
    }

    public String getCity() {
        return this.city;
    }

    public String getCnfpassword() {
        return this.cnfpassword;
    }

    public Integer getCountry_id() {
        return this.country_id;
    }

    public Date getDate_of_birth() {
        return this.date_of_birth;
    }

    public String getEmail() {
        return this.email;
    }

    public int getEmail_flag() {
        return this.email_flag;
    }

    public int getEnable() {
        return this.enable;
    }

    public String getGender() {
        return this.gender;
    }

    public Integer getIsd_code() {
        return this.isd_code;
    }

    public String getItaf_flag() {
        return this.itaf_flag;
    }

    public int getKyc_status() {
        return this.kyc_status;
    }

    public String getMarital_status() {
        return this.marital_status;
    }

    public String getMaskedMobileNo() {
        return this.maskedMobileNo;
    }

    public int getMobile_flag() {
        return this.mobile_flag;
    }

    public Long getMobile_number() {
        return this.mobile_number;
    }

    public String getName() {
        return this.name;
    }

    public int getNo_of_loyalty_acc() {
        return this.no_of_loyalty_acc;
    }

    public String getPassword() {
        return this.password;
    }

    public Integer getPin_code() {
        return this.pin_code;
    }

    public String getPostoffice() {
        return this.postoffice;
    }

    public int getRds_flag() {
        return this.rds_flag;
    }

    public int getRegistration_flag() {
        return this.registration_flag;
    }

    public Integer getRequesterId() {
        return this.requesterId;
    }

    public String getState_name() {
        return this.state_name;
    }

    public Date getTimeStamp() {
        return this.timeStamp;
    }

    public C0527HB getUserProfileAddonServices() {
        return this.userProfileAddonServices;
    }

    public String getUserRequestId() {
        return this.userRequestId;
    }

    public Date getUser_kyc_date() {
        return this.user_kyc_date;
    }

    public String getUser_loginid() {
        return this.user_loginid;
    }

    public int getVerified() {
        return this.verified;
    }

    public void setAddress1(String str) {
        this.address1 = str;
    }

    public void setAddress2(String str) {
        this.address2 = str;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setCnfpassword(String str) {
        this.cnfpassword = str;
    }

    public void setCountry_id(Integer num) {
        this.country_id = num;
    }

    public void setDate_of_birth(Date date) {
        this.date_of_birth = date;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setEmail_flag(int i) {
        this.email_flag = i;
    }

    public void setEnable(int i) {
        this.enable = i;
    }

    public void setGender(String str) {
        this.gender = str;
    }

    public void setIsd_code(Integer num) {
        this.isd_code = num;
    }

    public void setItaf_flag(String str) {
        this.itaf_flag = str;
    }

    public void setKyc_status(int i) {
        this.kyc_status = i;
    }

    public void setMarital_status(String str) {
        this.marital_status = str;
    }

    public void setMaskedMobileNo(String str) {
        this.maskedMobileNo = str;
    }

    public void setMobile_flag(int i) {
        this.mobile_flag = i;
    }

    public void setMobile_number(Long l) {
        this.mobile_number = l;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNo_of_loyalty_acc(int i) {
        this.no_of_loyalty_acc = i;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setPin_code(Integer num) {
        this.pin_code = num;
    }

    public void setPostoffice(String str) {
        this.postoffice = str;
    }

    public void setRds_flag(int i) {
        this.rds_flag = i;
    }

    public void setRegistration_flag(int i) {
        this.registration_flag = i;
    }

    public void setRequesterId(Integer num) {
        this.requesterId = num;
    }

    public void setState_name(String str) {
        this.state_name = str;
    }

    public void setTimeStamp(Date date) {
        this.timeStamp = date;
    }

    public void setUserProfileAddonServices(C0527HB hb) {
        this.userProfileAddonServices = hb;
    }

    public void setUserRequestId(String str) {
        this.userRequestId = str;
    }

    public void setUser_kyc_date(Date date) {
        this.user_kyc_date = date;
    }

    public void setUser_loginid(String str) {
        this.user_loginid = str;
    }

    public void setVerified(int i) {
        this.verified = i;
    }

    public String toString() {
        return "UserProfileDetailsData [user_loginid=" + this.user_loginid + ", password=" + this.password + ", cnfpassword=" + this.cnfpassword + ", email=" + this.email + ", mobile_number=" + this.mobile_number + ", isd_code=" + this.isd_code + ", name=" + this.name + ", country_id=" + this.country_id + ", gender=" + this.gender + ", marital_status=" + this.marital_status + ", date_of_birth=" + this.date_of_birth + ", address1=" + this.address1 + ", address2=" + this.address2 + ", city=" + this.city + ", state_name=" + this.state_name + ", postoffice=" + this.postoffice + ", pin_code=" + this.pin_code + ", verified=" + this.verified + ", enable=" + this.enable + ", mobile_flag=" + this.mobile_flag + ", email_flag=" + this.email_flag + ", registration_flag=" + this.registration_flag + ", rds_flag=" + this.rds_flag + ", no_of_loyalty_acc=" + this.no_of_loyalty_acc + ", user_kyc_date=" + this.user_kyc_date + ", kyc_status=" + this.kyc_status + ", itaf_flag=" + this.itaf_flag + ", requesterId=" + this.requesterId + ", userRequestId=" + this.userRequestId + ", maskedMobileNo=" + this.maskedMobileNo + ", timeStamp=" + this.timeStamp + ", userProfileAddonServices=" + this.userProfileAddonServices + "]";
    }
}
