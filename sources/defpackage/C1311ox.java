package defpackage;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: ox  reason: default package and case insensitive filesystem */
/* compiled from: SoftAccountSummaryDTO */
public final class C1311ox implements Serializable {
    private static final long serialVersionUID = 1;
    private Date accountCreationDate;
    private Date accountExpirationDate;
    private String bankName;
    private String cardType;
    private String error;
    private Date expiryDate;
    private long expirypoints;
    private Long loyaltyNumber;
    private String serverId;
    private String softAccountStatus;
    private String softUserName;
    private Date timeStamp;
    private Long totalPartnerPoints;
    private Long totalPointsAvailable;
    private Long totalPointsAvailableToRedeem;
    private Long totalPointsRedeemed;
    private Long totalPurchasePoints;
    private Long totalTravelPoints;

    public Date getAccountCreationDate() {
        return this.accountCreationDate;
    }

    public Date getAccountExpirationDate() {
        return this.accountExpirationDate;
    }

    public String getBankName() {
        return this.bankName;
    }

    public String getCardType() {
        return this.cardType;
    }

    public String getError() {
        return this.error;
    }

    public Date getExpiryDate() {
        return this.expiryDate;
    }

    public long getExpirypoints() {
        return this.expirypoints;
    }

    public Long getLoyaltyNumber() {
        return this.loyaltyNumber;
    }

    public String getServerId() {
        return this.serverId;
    }

    public String getSoftAccountStatus() {
        return this.softAccountStatus;
    }

    public String getSoftUserName() {
        return this.softUserName;
    }

    public Date getTimeStamp() {
        return this.timeStamp;
    }

    public Long getTotalPartnerPoints() {
        return this.totalPartnerPoints;
    }

    public Long getTotalPointsAvailable() {
        return this.totalPointsAvailable;
    }

    public Long getTotalPointsAvailableToRedeem() {
        return this.totalPointsAvailableToRedeem;
    }

    public Long getTotalPointsRedeemed() {
        return this.totalPointsRedeemed;
    }

    public Long getTotalPurchasePoints() {
        return this.totalPurchasePoints;
    }

    public Long getTotalTravelPoints() {
        return this.totalTravelPoints;
    }

    public void setAccountCreationDate(Date date) {
        this.accountCreationDate = date;
    }

    public void setAccountExpirationDate(Date date) {
        this.accountExpirationDate = date;
    }

    public void setBankName(String str) {
        this.bankName = str;
    }

    public void setCardType(String str) {
        this.cardType = str;
    }

    public void setError(String str) {
        this.error = str;
    }

    public void setExpiryDate(Date date) {
        this.expiryDate = date;
    }

    public void setExpirypoints(long j) {
        this.expirypoints = j;
    }

    public void setLoyaltyNumber(Long l) {
        this.loyaltyNumber = l;
    }

    public void setServerId(String str) {
        this.serverId = str;
    }

    public void setSoftAccountStatus(String str) {
        this.softAccountStatus = str;
    }

    public void setSoftUserName(String str) {
        this.softUserName = str;
    }

    public void setTimeStamp(Date date) {
        this.timeStamp = date;
    }

    public void setTotalPartnerPoints(Long l) {
        this.totalPartnerPoints = l;
    }

    public void setTotalPointsAvailable(Long l) {
        this.totalPointsAvailable = l;
    }

    public void setTotalPointsAvailableToRedeem(Long l) {
        this.totalPointsAvailableToRedeem = l;
    }

    public void setTotalPointsRedeemed(Long l) {
        this.totalPointsRedeemed = l;
    }

    public void setTotalPurchasePoints(Long l) {
        this.totalPurchasePoints = l;
    }

    public void setTotalTravelPoints(Long l) {
        this.totalTravelPoints = l;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SoftAccountSummaryDTO [softUserName=");
        sb.append(this.softUserName);
        sb.append(", loyaltyNumber=");
        sb.append(this.loyaltyNumber);
        sb.append(", totalPointsAvailable=");
        sb.append(this.totalPointsAvailable);
        sb.append(", totalPointsAvailableToRedeem=");
        sb.append(this.totalPointsAvailableToRedeem);
        sb.append(", totalTravelPoints=");
        sb.append(this.totalTravelPoints);
        sb.append(", totalPartnerPoints=");
        sb.append(this.totalPartnerPoints);
        sb.append(", totalPurchasePoints=");
        sb.append(this.totalPurchasePoints);
        sb.append(", totalPointsRedeemed=");
        sb.append(this.totalPointsRedeemed);
        sb.append(", accountCreationDate=");
        sb.append(this.accountCreationDate);
        sb.append(", accountExpirationDate=");
        sb.append(this.accountExpirationDate);
        sb.append(", softAccountStatus=");
        sb.append(this.softAccountStatus);
        sb.append(", error=");
        sb.append(this.error);
        sb.append(", serverId=");
        sb.append(this.serverId);
        sb.append(", timeStamp=");
        sb.append(this.timeStamp);
        sb.append(", expirypoints=");
        sb.append(this.expirypoints);
        sb.append(", expiryDate=");
        sb.append(this.expiryDate);
        sb.append(", cardType=");
        sb.append(this.cardType);
        sb.append(", bankName=");
        return C0709Uj.j(sb, this.bankName, "]");
    }
}
