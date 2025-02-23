package defpackage;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: LB  reason: default package and case insensitive filesystem */
/* compiled from: UserSignupDTO */
public final class C0574LB implements Serializable {
    private static final long serialVersionUID = 1;
    private String captcha;
    private String cnfpassword;
    private Integer country_id;
    private String email;
    private Integer isd_code;
    private String mailverifyid;
    private Long mobile_number;
    private String mobileverifyid;
    private String name;
    private String password;
    private Integer requesterId;
    private C0538IB userProfiles;
    private String userRequestId;
    private String user_loginid;
    private Integer userinputstatus;
    private Integer userstage;

    public String getCaptcha() {
        return this.captcha;
    }

    public String getCnfpassword() {
        return this.cnfpassword;
    }

    public Integer getCountry_id() {
        return this.country_id;
    }

    public String getEmail() {
        return this.email;
    }

    public Integer getIsd_code() {
        return this.isd_code;
    }

    public String getMailverifyid() {
        return this.mailverifyid;
    }

    public Long getMobile_number() {
        return this.mobile_number;
    }

    public String getMobileverifyid() {
        return this.mobileverifyid;
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public Integer getRequesterId() {
        return this.requesterId;
    }

    public C0538IB getUserProfiles() {
        return this.userProfiles;
    }

    public String getUserRequestId() {
        return this.userRequestId;
    }

    public String getUser_loginid() {
        return this.user_loginid;
    }

    public Integer getUserinputstatus() {
        return this.userinputstatus;
    }

    public Integer getUserstage() {
        return this.userstage;
    }

    public void setCaptcha(String str) {
        this.captcha = str;
    }

    public void setCnfpassword(String str) {
        this.cnfpassword = str;
    }

    public void setCountry_id(Integer num) {
        this.country_id = num;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setIsd_code(Integer num) {
        this.isd_code = num;
    }

    public void setMailverifyid(String str) {
        this.mailverifyid = str;
    }

    public void setMobile_number(Long l) {
        this.mobile_number = l;
    }

    public void setMobileverifyid(String str) {
        this.mobileverifyid = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setRequesterId(Integer num) {
        this.requesterId = num;
    }

    public void setUserProfiles(C0538IB ib) {
        this.userProfiles = ib;
    }

    public void setUserRequestId(String str) {
        this.userRequestId = str;
    }

    public void setUser_loginid(String str) {
        this.user_loginid = str;
    }

    public void setUserinputstatus(Integer num) {
        this.userinputstatus = num;
    }

    public void setUserstage(Integer num) {
        this.userstage = num;
    }

    public String toString() {
        return "UserSignupDTO [user_loginid=" + this.user_loginid + ", password=" + this.password + ", cnfpassword=" + this.cnfpassword + ", email=" + this.email + ", mobile_number=" + this.mobile_number + ", isd_code=" + this.isd_code + ", name=" + this.name + ", country_id=" + this.country_id + ", mailverifyid=" + this.mailverifyid + ", mobileverifyid=" + this.mobileverifyid + ", userstage=" + this.userstage + ", userinputstatus=" + this.userinputstatus + ", captcha=" + this.captcha + ", requesterId=" + this.requesterId + ", userRequestId=" + this.userRequestId + ", userProfiles=" + this.userProfiles + "]";
    }
}
