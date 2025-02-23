package defpackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: nx  reason: default package and case insensitive filesystem */
/* compiled from: SoftAccountDetailsDTO */
public final class C1291nx implements Serializable {
    private static final long serialVersionUID = 1;
    private C1336px accountStatus;
    private String error;
    private Integer expirypoints;
    private C0655Qj loyaltyTxnDetails;
    private String serverId;
    private ArrayList<C1336px> softAnnualSummaries;
    private Date timeStamp;
    private Integer totalPartnerPoints;
    private Integer totalPointsAvailable;
    private Integer totalPointsAvailableToRedeem;
    private Integer totalPointsRedeemed;
    private Integer totalTravelPoints;

    public C1336px getAccountStatus() {
        return this.accountStatus;
    }

    public String getError() {
        return this.error;
    }

    public Integer getExpirypoints() {
        return this.expirypoints;
    }

    public C0655Qj getLoyaltyTxnDetails() {
        return this.loyaltyTxnDetails;
    }

    public String getServerId() {
        return this.serverId;
    }

    public ArrayList<C1336px> getSoftAnnualSummaries() {
        return this.softAnnualSummaries;
    }

    public Date getTimeStamp() {
        return this.timeStamp;
    }

    public Integer getTotalPartnerPoints() {
        return this.totalPartnerPoints;
    }

    public Integer getTotalPointsAvailable() {
        return this.totalPointsAvailable;
    }

    public Integer getTotalPointsAvailableToRedeem() {
        return this.totalPointsAvailableToRedeem;
    }

    public Integer getTotalPointsRedeemed() {
        return this.totalPointsRedeemed;
    }

    public Integer getTotalTravelPoints() {
        return this.totalTravelPoints;
    }

    public void setAccountStatus(C1336px pxVar) {
        this.accountStatus = pxVar;
    }

    public void setError(String str) {
        this.error = str;
    }

    public void setExpirypoints(Integer num) {
        this.expirypoints = num;
    }

    public void setLoyaltyTxnDetails(C0655Qj qj) {
        this.loyaltyTxnDetails = qj;
    }

    public void setServerId(String str) {
        this.serverId = str;
    }

    public void setSoftAnnualSummaries(ArrayList<C1336px> arrayList) {
        this.softAnnualSummaries = arrayList;
    }

    public void setTimeStamp(Date date) {
        this.timeStamp = date;
    }

    public void setTotalPartnerPoints(Integer num) {
        this.totalPartnerPoints = num;
    }

    public void setTotalPointsAvailable(Integer num) {
        this.totalPointsAvailable = num;
    }

    public void setTotalPointsAvailableToRedeem(Integer num) {
        this.totalPointsAvailableToRedeem = num;
    }

    public void setTotalPointsRedeemed(Integer num) {
        this.totalPointsRedeemed = num;
    }

    public void setTotalTravelPoints(Integer num) {
        this.totalTravelPoints = num;
    }

    public String toString() {
        return "SoftAccountDetailsDTO [softAnnualSummaries=" + this.softAnnualSummaries + ", loyaltyTxnDetails=" + this.loyaltyTxnDetails + ", accountStatus=" + this.accountStatus + ", error=" + this.error + ", serverId=" + this.serverId + ", timeStamp=" + this.timeStamp + ", totalPointsAvailableToRedeem=" + this.totalPointsAvailableToRedeem + ", expirypoints=" + this.expirypoints + ", totalPartnerPoints=" + this.totalPartnerPoints + ", totalPointsAvailable=" + this.totalPointsAvailable + ", totalPointsRedeemed=" + this.totalPointsRedeemed + ", totalTravelPoints=" + this.totalTravelPoints + "]";
    }
}
