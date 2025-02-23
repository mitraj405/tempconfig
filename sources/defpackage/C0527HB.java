package defpackage;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: HB  reason: default package and case insensitive filesystem */
/* compiled from: UserProfileAddonService */
public final class C0527HB implements Serializable {
    private static final long serialVersionUID = 1;
    private String aadhaar_verification_date;
    private boolean addresseditallowed;
    private Date dob_change_date;
    private boolean dobeditallowed;
    private Date email_change_date;
    private int email_flag;
    private boolean emaileditallowed;
    private int enable;
    private Date gender_change_date;
    private boolean gendereditallowed;
    private boolean incompleteProfile;
    private String itaf_flag;
    private int kyc_status;
    private int mobile_flag;
    private boolean mobileeditallowed;
    private Date moblieno_change_date;
    private Date name_change_date;
    private boolean nameeditallowed;
    private int no_of_loyalty_acc;
    private Date password_change_date;
    private boolean passwordeditallowed;
    private Date profile_update_time;
    private int rds_flag;
    private int registration_flag;
    private Date user_kyc_date;
    private int verified;

    public String getAadhaar_verification_date() {
        return this.aadhaar_verification_date;
    }

    public Date getDob_change_date() {
        return this.dob_change_date;
    }

    public Date getEmail_change_date() {
        return this.email_change_date;
    }

    public int getEmail_flag() {
        return this.email_flag;
    }

    public int getEnable() {
        return this.enable;
    }

    public Date getGender_change_date() {
        return this.gender_change_date;
    }

    public String getItaf_flag() {
        return this.itaf_flag;
    }

    public int getKyc_status() {
        return this.kyc_status;
    }

    public int getMobile_flag() {
        return this.mobile_flag;
    }

    public Date getMoblieno_change_date() {
        return this.moblieno_change_date;
    }

    public Date getName_change_date() {
        return this.name_change_date;
    }

    public int getNo_of_loyalty_acc() {
        return this.no_of_loyalty_acc;
    }

    public Date getPassword_change_date() {
        return this.password_change_date;
    }

    public Date getProfile_update_time() {
        return this.profile_update_time;
    }

    public int getRds_flag() {
        return this.rds_flag;
    }

    public int getRegistration_flag() {
        return this.registration_flag;
    }

    public Date getUser_kyc_date() {
        return this.user_kyc_date;
    }

    public int getVerified() {
        return this.verified;
    }

    public boolean isAddresseditallowed() {
        return this.addresseditallowed;
    }

    public boolean isDobeditallowed() {
        return this.dobeditallowed;
    }

    public boolean isEmaileditallowed() {
        return this.emaileditallowed;
    }

    public boolean isGendereditallowed() {
        return this.gendereditallowed;
    }

    public boolean isIncompleteProfile() {
        return this.incompleteProfile;
    }

    public boolean isMobileeditallowed() {
        return this.mobileeditallowed;
    }

    public boolean isNameeditallowed() {
        return this.nameeditallowed;
    }

    public boolean isPasswordeditallowed() {
        return this.passwordeditallowed;
    }

    public void setAadhaar_verification_date(String str) {
        this.aadhaar_verification_date = str;
    }

    public void setAddresseditallowed(boolean z) {
        this.addresseditallowed = z;
    }

    public void setDob_change_date(Date date) {
        this.dob_change_date = date;
    }

    public void setDobeditallowed(boolean z) {
        this.dobeditallowed = z;
    }

    public void setEmail_change_date(Date date) {
        this.email_change_date = date;
    }

    public void setEmail_flag(int i) {
        this.email_flag = i;
    }

    public void setEmaileditallowed(boolean z) {
        this.emaileditallowed = z;
    }

    public void setEnable(int i) {
        this.enable = i;
    }

    public void setGender_change_date(Date date) {
        this.gender_change_date = date;
    }

    public void setGendereditallowed(boolean z) {
        this.gendereditallowed = z;
    }

    public void setIncompleteProfile(boolean z) {
        this.incompleteProfile = z;
    }

    public void setItaf_flag(String str) {
        this.itaf_flag = str;
    }

    public void setKyc_status(int i) {
        this.kyc_status = i;
    }

    public void setMobile_flag(int i) {
        this.mobile_flag = i;
    }

    public void setMobileeditallowed(boolean z) {
        this.mobileeditallowed = z;
    }

    public void setMoblieno_change_date(Date date) {
        this.moblieno_change_date = date;
    }

    public void setName_change_date(Date date) {
        this.name_change_date = date;
    }

    public void setNameeditallowed(boolean z) {
        this.nameeditallowed = z;
    }

    public void setNo_of_loyalty_acc(int i) {
        this.no_of_loyalty_acc = i;
    }

    public void setPassword_change_date(Date date) {
        this.password_change_date = date;
    }

    public void setPasswordeditallowed(boolean z) {
        this.passwordeditallowed = z;
    }

    public void setProfile_update_time(Date date) {
        this.profile_update_time = date;
    }

    public void setRds_flag(int i) {
        this.rds_flag = i;
    }

    public void setRegistration_flag(int i) {
        this.registration_flag = i;
    }

    public void setUser_kyc_date(Date date) {
        this.user_kyc_date = date;
    }

    public void setVerified(int i) {
        this.verified = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UserProfileAddonService [verified=");
        sb.append(this.verified);
        sb.append(", enable=");
        sb.append(this.enable);
        sb.append(", mobile_flag=");
        sb.append(this.mobile_flag);
        sb.append(", email_flag=");
        sb.append(this.email_flag);
        sb.append(", registration_flag=");
        sb.append(this.registration_flag);
        sb.append(", rds_flag=");
        sb.append(this.rds_flag);
        sb.append(", no_of_loyalty_acc=");
        sb.append(this.no_of_loyalty_acc);
        sb.append(", user_kyc_date=");
        sb.append(this.user_kyc_date);
        sb.append(", kyc_status=");
        sb.append(this.kyc_status);
        sb.append(", itaf_flag=");
        sb.append(this.itaf_flag);
        sb.append(", aadhaar_verification_date=");
        sb.append(this.aadhaar_verification_date);
        sb.append(", email_change_date=");
        sb.append(this.email_change_date);
        sb.append(", password_change_date=");
        sb.append(this.password_change_date);
        sb.append(", dob_change_date=");
        sb.append(this.dob_change_date);
        sb.append(", gender_change_date=");
        sb.append(this.gender_change_date);
        sb.append(", name_change_date=");
        sb.append(this.name_change_date);
        sb.append(", moblieno_change_date=");
        sb.append(this.moblieno_change_date);
        sb.append(", profile_update_time=");
        sb.append(this.profile_update_time);
        sb.append(", emaileditallowed=");
        sb.append(this.emaileditallowed);
        sb.append(", mobileeditallowed=");
        sb.append(this.mobileeditallowed);
        sb.append(", passwordeditallowed=");
        sb.append(this.passwordeditallowed);
        sb.append(", dobeditallowed=");
        sb.append(this.dobeditallowed);
        sb.append(", gendereditallowed=");
        sb.append(this.gendereditallowed);
        sb.append(", nameeditallowed=");
        sb.append(this.nameeditallowed);
        sb.append(", incompleteProfile=");
        sb.append(this.incompleteProfile);
        sb.append(", addresseditallowed=");
        return xx.G(sb, this.addresseditallowed, "]");
    }
}
