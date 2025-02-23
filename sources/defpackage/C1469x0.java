package defpackage;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: x0  reason: default package and case insensitive filesystem */
/* compiled from: AlternateAvlInputDTO */
public final class C1469x0 implements Serializable {
    private static final long serialVersionUID = 1;
    private Short availabilityStatus;
    private List<String> avlClasses;
    private boolean concessionPassengers = false;
    private Boolean currentBooking;
    private String destStn;
    private boolean flexiFlag;
    private String flexiJrnyDate;
    private boolean ftBooking = false;
    private Boolean handicapFlag;
    private Date jd;
    private boolean jpFlag = false;
    private String jrnyClass;
    private String jrnyDate;
    private boolean loyaltyBooking = false;
    private Boolean loyaltyRedemptionBooking;
    private String quotaCode;
    private String reasonType = "";
    private boolean returnTicket = false;
    private String srcStn;
    private String ticketType;
    private String trainNo;

    public Short getAvailabilityStatus() {
        return this.availabilityStatus;
    }

    public List<String> getAvlClasses() {
        return this.avlClasses;
    }

    public Boolean getCurrentBooking() {
        return this.currentBooking;
    }

    public String getDestStn() {
        return this.destStn;
    }

    public String getFlexiJrnyDate() {
        return this.flexiJrnyDate;
    }

    public Boolean getHandicapFlag() {
        return this.handicapFlag;
    }

    public Date getJd() {
        return this.jd;
    }

    public String getJrnyClass() {
        return this.jrnyClass;
    }

    public String getJrnyDate() {
        return this.jrnyDate;
    }

    public Boolean getLoyaltyRedemptionBooking() {
        return this.loyaltyRedemptionBooking;
    }

    public String getQuotaCode() {
        return this.quotaCode;
    }

    public String getReasonType() {
        return this.reasonType;
    }

    public String getSrcStn() {
        return this.srcStn;
    }

    public String getTicketType() {
        return this.ticketType;
    }

    public String getTrainNo() {
        return this.trainNo;
    }

    public boolean isConcessionPassengers() {
        return this.concessionPassengers;
    }

    public boolean isFlexiFlag() {
        return this.flexiFlag;
    }

    public boolean isFtBooking() {
        return this.ftBooking;
    }

    public boolean isJpFlag() {
        return this.jpFlag;
    }

    public boolean isLoyaltyBooking() {
        return this.loyaltyBooking;
    }

    public boolean isReturnTicket() {
        return this.returnTicket;
    }

    public void setAvailabilityStatus(Short sh) {
        this.availabilityStatus = sh;
    }

    public void setAvlClasses(List<String> list) {
        this.avlClasses = list;
    }

    public void setConcessionPassengers(boolean z) {
        this.concessionPassengers = z;
    }

    public void setCurrentBooking(Boolean bool) {
        this.currentBooking = bool;
    }

    public void setDestStn(String str) {
        this.destStn = str;
    }

    public void setFlexiFlag(boolean z) {
        this.flexiFlag = z;
    }

    public void setFlexiJrnyDate(String str) {
        this.flexiJrnyDate = str;
    }

    public void setFtBooking(boolean z) {
        this.ftBooking = z;
    }

    public void setHandicapFlag(Boolean bool) {
        this.handicapFlag = bool;
    }

    public void setJd(Date date) {
        this.jd = date;
    }

    public void setJpFlag(boolean z) {
        this.jpFlag = z;
    }

    public void setJrnyClass(String str) {
        this.jrnyClass = str;
    }

    public void setJrnyDate(String str) {
        this.jrnyDate = str;
    }

    public void setLoyaltyBooking(boolean z) {
        this.loyaltyBooking = z;
    }

    public void setLoyaltyRedemptionBooking(Boolean bool) {
        this.loyaltyRedemptionBooking = bool;
    }

    public void setQuotaCode(String str) {
        this.quotaCode = str;
    }

    public void setReasonType(String str) {
        this.reasonType = str;
    }

    public void setReturnTicket(boolean z) {
        this.returnTicket = z;
    }

    public void setSrcStn(String str) {
        this.srcStn = str;
    }

    public void setTicketType(String str) {
        this.ticketType = str;
    }

    public void setTrainNo(String str) {
        this.trainNo = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AlternateAvlInputDTO [trainNo=");
        sb.append(this.trainNo);
        sb.append(", srcStn=");
        sb.append(this.srcStn);
        sb.append(", destStn=");
        sb.append(this.destStn);
        sb.append(", jrnyDate=");
        sb.append(this.jrnyDate);
        sb.append(", jrnyClass=");
        sb.append(this.jrnyClass);
        sb.append(", quotaCode=");
        sb.append(this.quotaCode);
        sb.append(", flexiFlag=");
        sb.append(this.flexiFlag);
        sb.append(", flexiJrnyDate=");
        sb.append(this.flexiJrnyDate);
        sb.append(", ticketType=");
        sb.append(this.ticketType);
        sb.append(", handicapFlag=");
        sb.append(this.handicapFlag);
        sb.append(", availabilityStatus=");
        sb.append(this.availabilityStatus);
        sb.append(", returnTicket=");
        sb.append(this.returnTicket);
        sb.append(", concessionPassengers=");
        sb.append(this.concessionPassengers);
        sb.append(", currentBooking=");
        sb.append(this.currentBooking);
        sb.append(", loyaltyRedemptionBooking=");
        sb.append(this.loyaltyRedemptionBooking);
        sb.append(", reasonType=");
        sb.append(this.reasonType);
        sb.append(", jpFlag=");
        sb.append(this.jpFlag);
        sb.append(", ftBooking=");
        sb.append(this.ftBooking);
        sb.append(", loyaltyBooking=");
        return xx.G(sb, this.loyaltyBooking, "]");
    }
}
