package defpackage;

import java.io.Serializable;
import java.util.ArrayList;

/* renamed from: CB  reason: default package and case insensitive filesystem */
/* compiled from: UserConfigurablesDTO */
public final class C0471CB implements Serializable {
    private static final long serialVersionUID = 1;
    private ArrayList<String> accrualClassList;
    private Short age;
    private String gender;
    private Boolean loyaltyAccrualBookingAllowed;
    private Boolean loyaltyNumberLinkFlag;
    private Boolean loyaltyRedemptionBookingAllowed;
    private String name;
    private C1311ox softAccountSummaryDTO;
    private Long softMemberId;
    private Boolean softUser;

    public ArrayList<String> getAccrualClassList() {
        return this.accrualClassList;
    }

    public Short getAge() {
        return this.age;
    }

    public String getGender() {
        return this.gender;
    }

    public Boolean getLoyaltyAccrualBookingAllowed() {
        return this.loyaltyAccrualBookingAllowed;
    }

    public Boolean getLoyaltyNumberLinkFlag() {
        return this.loyaltyNumberLinkFlag;
    }

    public Boolean getLoyaltyRedemptionBookingAllowed() {
        return this.loyaltyRedemptionBookingAllowed;
    }

    public String getName() {
        return this.name;
    }

    public C1311ox getSoftAccountSummaryDTO() {
        return this.softAccountSummaryDTO;
    }

    public Long getSoftMemberId() {
        return this.softMemberId;
    }

    public Boolean getSoftUser() {
        return this.softUser;
    }

    public void setAccrualClassList(ArrayList<String> arrayList) {
        this.accrualClassList = arrayList;
    }

    public void setAge(Short sh) {
        this.age = sh;
    }

    public void setGender(String str) {
        this.gender = str;
    }

    public void setLoyaltyAccrualBookingAllowed(Boolean bool) {
        this.loyaltyAccrualBookingAllowed = bool;
    }

    public void setLoyaltyNumberLinkFlag(Boolean bool) {
        this.loyaltyNumberLinkFlag = bool;
    }

    public void setLoyaltyRedemptionBookingAllowed(Boolean bool) {
        this.loyaltyRedemptionBookingAllowed = bool;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSoftAccountSummaryDTO(C1311ox oxVar) {
        this.softAccountSummaryDTO = oxVar;
    }

    public void setSoftMemberId(Long l) {
        this.softMemberId = l;
    }

    public void setSoftUser(Boolean bool) {
        this.softUser = bool;
    }

    public String toString() {
        return "UserConfigurablesDTO [softUser=" + this.softUser + ", loyaltyAccrualBookingAllowed=" + this.loyaltyAccrualBookingAllowed + ", loyaltyRedemptionBookingAllowed=" + this.loyaltyRedemptionBookingAllowed + ", loyaltyNumberLinkFlag=" + this.loyaltyNumberLinkFlag + ", name=" + this.name + ", age=" + this.age + ", gender=" + this.gender + ", softMemberId=" + this.softMemberId + ", accrualClassList=" + this.accrualClassList + ", softAccountSummaryDTO=" + this.softAccountSummaryDTO + "]";
    }
}
