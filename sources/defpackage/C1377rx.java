package defpackage;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: rx  reason: default package and case insensitive filesystem */
/* compiled from: SoftIRCTCTxnDetailsDTO */
public final class C1377rx implements Serializable {
    private static final long serialVersionUID = 1;
    private Long TxnId;
    private Date approvalDate;
    private String cardType;
    private String fromStation;
    private String journeyClass;
    private Date journeyDate;
    private Long loyaltyNumber;
    private String ngetTxnType;
    private String partnerName;
    private String pnrNumber;
    private Date pointAddDate;
    private Long points;
    private String toStation;
    private String trainNumber;
    private Date txnDate;
    private String txnDescription;
    private Double txnFare;
    private Long txnSrlNO;
    private String txnStatus;
    private String txnType;

    public Date getApprovalDate() {
        return this.approvalDate;
    }

    public String getCardType() {
        return this.cardType;
    }

    public String getFromStation() {
        return this.fromStation;
    }

    public String getJourneyClass() {
        return this.journeyClass;
    }

    public Date getJourneyDate() {
        return this.journeyDate;
    }

    public Long getLoyaltyNumber() {
        return this.loyaltyNumber;
    }

    public String getNgetTxnType() {
        return this.ngetTxnType;
    }

    public String getPartnerName() {
        return this.partnerName;
    }

    public String getPnrNumber() {
        return this.pnrNumber;
    }

    public Date getPointAddDate() {
        return this.pointAddDate;
    }

    public Long getPoints() {
        return this.points;
    }

    public String getToStation() {
        return this.toStation;
    }

    public String getTrainNumber() {
        return this.trainNumber;
    }

    public Date getTxnDate() {
        return this.txnDate;
    }

    public String getTxnDescription() {
        return this.txnDescription;
    }

    public Double getTxnFare() {
        return this.txnFare;
    }

    public Long getTxnId() {
        return this.TxnId;
    }

    public Long getTxnSrlNO() {
        return this.txnSrlNO;
    }

    public String getTxnStatus() {
        return this.txnStatus;
    }

    public String getTxnType() {
        return this.txnType;
    }

    public void setApprovalDate(Date date) {
        this.approvalDate = date;
    }

    public void setCardType(String str) {
        this.cardType = str;
    }

    public void setFromStation(String str) {
        this.fromStation = str;
    }

    public void setJourneyClass(String str) {
        this.journeyClass = str;
    }

    public void setJourneyDate(Date date) {
        this.journeyDate = date;
    }

    public void setLoyaltyNumber(Long l) {
        this.loyaltyNumber = l;
    }

    public void setNgetTxnType(String str) {
        this.ngetTxnType = str;
    }

    public void setPartnerName(String str) {
        this.partnerName = str;
    }

    public void setPnrNumber(String str) {
        this.pnrNumber = str;
    }

    public void setPointAddDate(Date date) {
        this.pointAddDate = date;
    }

    public void setPoints(Long l) {
        this.points = l;
    }

    public void setToStation(String str) {
        this.toStation = str;
    }

    public void setTrainNumber(String str) {
        this.trainNumber = str;
    }

    public void setTxnDate(Date date) {
        this.txnDate = date;
    }

    public void setTxnDescription(String str) {
        this.txnDescription = str;
    }

    public void setTxnFare(Double d) {
        this.txnFare = d;
    }

    public void setTxnId(Long l) {
        this.TxnId = l;
    }

    public void setTxnSrlNO(Long l) {
        this.txnSrlNO = l;
    }

    public void setTxnStatus(String str) {
        this.txnStatus = str;
    }

    public void setTxnType(String str) {
        this.txnType = str;
    }

    public String toString() {
        return "SoftIRCTCTxnDetailsDTO [txnSrlNO=" + this.txnSrlNO + ", loyaltyNumber=" + this.loyaltyNumber + ", TxnId=" + this.TxnId + ", ngetTxnType=" + this.ngetTxnType + ", txnType=" + this.txnType + ", txnStatus=" + this.txnStatus + ", points=" + this.points + ", txnDate=" + this.txnDate + ", pnrNumber=" + this.pnrNumber + ", txnFare=" + this.txnFare + ", trainNumber=" + this.trainNumber + ", fromStation=" + this.fromStation + ", toStation=" + this.toStation + ", journeyDate=" + this.journeyDate + ", journeyClass=" + this.journeyClass + ", cardType=" + this.cardType + ", partnerName=" + this.partnerName + ", approvalDate=" + this.approvalDate + ", txnDescription=" + this.txnDescription + ", pointAddDate=" + this.pointAddDate + "]";
    }
}
