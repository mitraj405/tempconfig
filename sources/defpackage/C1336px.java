package defpackage;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: px  reason: default package and case insensitive filesystem */
/* compiled from: SoftAnnualSummaryDTO */
public final class C1336px implements Serializable {
    private static final long serialVersionUID = 1;
    private Date annualExpiryDate;
    private Float annualFeesAmountPaid;
    private String annualFeesPaid;
    private Date annualFeesPaidDate;
    private Long annualPointsExpired;
    private Integer blockStartYear;
    private Long loyaltyNumber;
    private Long newPartnerPointsRedeemed;
    private Long newPurchasedPointsRedeemed;
    private Long newTotalPointsRedeemedInCurrentYear;
    private Long newTravelPointsRedeemed;
    private Long partnerPointsAccrued;
    private Long partnerPointsRedeemed;
    private Long purchasedPoints;
    private Long purchasedPointsRedeemed;
    private Long totalPointsRedeemedInCurrentYear;
    private Long travelPointsAccrued;
    private Long travelPointsRedeemed;
    private Date yearEndDate;
    private Date yearStartDate;

    public Date getAnnualExpiryDate() {
        return this.annualExpiryDate;
    }

    public Float getAnnualFeesAmountPaid() {
        return this.annualFeesAmountPaid;
    }

    public String getAnnualFeesPaid() {
        return this.annualFeesPaid;
    }

    public Date getAnnualFeesPaidDate() {
        return this.annualFeesPaidDate;
    }

    public Long getAnnualPointsExpired() {
        return this.annualPointsExpired;
    }

    public Integer getBlockStartYear() {
        return this.blockStartYear;
    }

    public Long getLoyaltyNumber() {
        return this.loyaltyNumber;
    }

    public Long getNewPartnerPointsRedeemed() {
        return this.newPartnerPointsRedeemed;
    }

    public Long getNewPurchasedPointsRedeemed() {
        return this.newPurchasedPointsRedeemed;
    }

    public Long getNewTotalPointsRedeemedInCurrentYear() {
        return this.newTotalPointsRedeemedInCurrentYear;
    }

    public Long getNewTravelPointsRedeemed() {
        return this.newTravelPointsRedeemed;
    }

    public Long getPartnerPointsAccrued() {
        return this.partnerPointsAccrued;
    }

    public Long getPartnerPointsRedeemed() {
        return this.partnerPointsRedeemed;
    }

    public Long getPurchasedPoints() {
        return this.purchasedPoints;
    }

    public Long getPurchasedPointsRedeemed() {
        return this.purchasedPointsRedeemed;
    }

    public Long getTotalPointsRedeemedInCurrentYear() {
        return this.totalPointsRedeemedInCurrentYear;
    }

    public Long getTravelPointsAccrued() {
        return this.travelPointsAccrued;
    }

    public Long getTravelPointsRedeemed() {
        return this.travelPointsRedeemed;
    }

    public Date getYearEndDate() {
        return this.yearEndDate;
    }

    public Date getYearStartDate() {
        return this.yearStartDate;
    }

    public void setAnnualExpiryDate(Date date) {
        this.annualExpiryDate = date;
    }

    public void setAnnualFeesAmountPaid(Float f) {
        this.annualFeesAmountPaid = f;
    }

    public void setAnnualFeesPaid(String str) {
        this.annualFeesPaid = str;
    }

    public void setAnnualFeesPaidDate(Date date) {
        this.annualFeesPaidDate = date;
    }

    public void setAnnualPointsExpired(Long l) {
        this.annualPointsExpired = l;
    }

    public void setBlockStartYear(Integer num) {
        this.blockStartYear = num;
    }

    public void setLoyaltyNumber(Long l) {
        this.loyaltyNumber = l;
    }

    public void setNewPartnerPointsRedeemed(Long l) {
        this.newPartnerPointsRedeemed = l;
    }

    public void setNewPurchasedPointsRedeemed(Long l) {
        this.newPurchasedPointsRedeemed = l;
    }

    public void setNewTotalPointsRedeemedInCurrentYear(Long l) {
        this.newTotalPointsRedeemedInCurrentYear = l;
    }

    public void setNewTravelPointsRedeemed(Long l) {
        this.newTravelPointsRedeemed = l;
    }

    public void setPartnerPointsAccrued(Long l) {
        this.partnerPointsAccrued = l;
    }

    public void setPartnerPointsRedeemed(Long l) {
        this.partnerPointsRedeemed = l;
    }

    public void setPurchasedPoints(Long l) {
        this.purchasedPoints = l;
    }

    public void setPurchasedPointsRedeemed(Long l) {
        this.purchasedPointsRedeemed = l;
    }

    public void setTotalPointsRedeemedInCurrentYear(Long l) {
        this.totalPointsRedeemedInCurrentYear = l;
    }

    public void setTravelPointsAccrued(Long l) {
        this.travelPointsAccrued = l;
    }

    public void setTravelPointsRedeemed(Long l) {
        this.travelPointsRedeemed = l;
    }

    public void setYearEndDate(Date date) {
        this.yearEndDate = date;
    }

    public void setYearStartDate(Date date) {
        this.yearStartDate = date;
    }

    public String toString() {
        return "SoftAnnualSummaryDTO [loyaltyNumber=" + this.loyaltyNumber + ", blockStartYear=" + this.blockStartYear + ", yearStartDate=" + this.yearStartDate + ", yearEndDate=" + this.yearEndDate + ", travelPointsAccrued=" + this.travelPointsAccrued + ", travelPointsRedeemed=" + this.travelPointsRedeemed + ", partnerPointsAccrued=" + this.partnerPointsAccrued + ", partnerPointsRedeemed=" + this.partnerPointsRedeemed + ", purchasedPoints=" + this.purchasedPoints + ", purchasedPointsRedeemed=" + this.purchasedPointsRedeemed + ", totalPointsRedeemedInCurrentYear=" + this.totalPointsRedeemedInCurrentYear + ", annualExpiryDate=" + this.annualExpiryDate + ", annualPointsExpired=" + this.annualPointsExpired + ", annualFeesPaid=" + this.annualFeesPaid + ", annualFeesAmountPaid=" + this.annualFeesAmountPaid + ", annualFeesPaidDate=" + this.annualFeesPaidDate + ", newTravelPointsRedeemed=" + this.newTravelPointsRedeemed + ", newPartnerPointsRedeemed=" + this.newPartnerPointsRedeemed + ", newPurchasedPointsRedeemed=" + this.newPurchasedPointsRedeemed + ", newTotalPointsRedeemedInCurrentYear=" + this.newTotalPointsRedeemedInCurrentYear + "]";
    }
}
