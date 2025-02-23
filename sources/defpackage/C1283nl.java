package defpackage;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: nl  reason: default package and case insensitive filesystem */
/* compiled from: MetroPassengerDTO */
public final class C1283nl implements Serializable {
    private static final long serialVersionUID = 1;
    private String bankRefundTxnId;
    private Integer cancelStatus;
    private String cancelStatusString;
    private Double cancellationCharge;
    private Date cancellationDate;
    private Long cancellationId;
    private Integer metroFarePerPsgn;
    private Integer metroPassengerSerialNumber;
    private Long metroPsgnId;
    private String metroQrTicketBlock;
    private String metroQrTicketNo;
    private Long metroTransactionId;
    private Integer refundAmount;
    private Date refundDate;
    private String refundId;
    private String refundStatus;
    private String refundStatusDesc;
    private Integer refundStatusId;
    private Integer ticketAmount;

    public String getBankRefundTxnId() {
        return this.bankRefundTxnId;
    }

    public Integer getCancelStatus() {
        return this.cancelStatus;
    }

    public String getCancelStatusString() {
        return this.cancelStatusString;
    }

    public Double getCancellationCharge() {
        return this.cancellationCharge;
    }

    public Date getCancellationDate() {
        return this.cancellationDate;
    }

    public Long getCancellationId() {
        return this.cancellationId;
    }

    public Integer getMetroFarePerPsgn() {
        return this.metroFarePerPsgn;
    }

    public Integer getMetroPassengerSerialNumber() {
        return this.metroPassengerSerialNumber;
    }

    public Long getMetroPsgnId() {
        return this.metroPsgnId;
    }

    public String getMetroQrTicketBlock() {
        return this.metroQrTicketBlock;
    }

    public String getMetroQrTicketNo() {
        return this.metroQrTicketNo;
    }

    public Long getMetroTransactionId() {
        return this.metroTransactionId;
    }

    public Integer getRefundAmount() {
        return this.refundAmount;
    }

    public Date getRefundDate() {
        return this.refundDate;
    }

    public String getRefundId() {
        return this.refundId;
    }

    public String getRefundStatus() {
        return this.refundStatus;
    }

    public String getRefundStatusDesc() {
        return this.refundStatusDesc;
    }

    public Integer getRefundStatusId() {
        return this.refundStatusId;
    }

    public Integer getTicketAmount() {
        return this.ticketAmount;
    }

    public void setBankRefundTxnId(String str) {
        this.bankRefundTxnId = str;
    }

    public void setCancelStatus(Integer num) {
        this.cancelStatus = num;
    }

    public void setCancelStatusString(String str) {
        this.cancelStatusString = str;
    }

    public void setCancellationCharge(Double d) {
        this.cancellationCharge = d;
    }

    public void setCancellationDate(Date date) {
        this.cancellationDate = date;
    }

    public void setCancellationId(Long l) {
        this.cancellationId = l;
    }

    public void setMetroFarePerPsgn(Integer num) {
        this.metroFarePerPsgn = num;
    }

    public void setMetroPassengerSerialNumber(Integer num) {
        this.metroPassengerSerialNumber = num;
    }

    public void setMetroPsgnId(Long l) {
        this.metroPsgnId = l;
    }

    public void setMetroQrTicketBlock(String str) {
        this.metroQrTicketBlock = str;
    }

    public void setMetroQrTicketNo(String str) {
        this.metroQrTicketNo = str;
    }

    public void setMetroTransactionId(Long l) {
        this.metroTransactionId = l;
    }

    public void setRefundAmount(Integer num) {
        this.refundAmount = num;
    }

    public void setRefundDate(Date date) {
        this.refundDate = date;
    }

    public void setRefundId(String str) {
        this.refundId = str;
    }

    public void setRefundStatus(String str) {
        this.refundStatus = str;
    }

    public void setRefundStatusDesc(String str) {
        this.refundStatusDesc = str;
    }

    public void setRefundStatusId(Integer num) {
        this.refundStatusId = num;
    }

    public void setTicketAmount(Integer num) {
        this.ticketAmount = num;
    }

    public String toString() {
        return "MetroPassengerDTO [metroPsgnId=" + this.metroPsgnId + ", metroTransactionId=" + this.metroTransactionId + ", metroPassengerSerialNumber=" + this.metroPassengerSerialNumber + ", metroQrTicketNo=" + this.metroQrTicketNo + ", metroQrTicketBlock=" + this.metroQrTicketBlock + ", cancelStatus=" + this.cancelStatus + ", cancellationId=" + this.cancellationId + ", cancellationDate=" + this.cancellationDate + ", cancelStatusString=" + this.cancelStatusString + ", metroFarePerPsgn=" + this.metroFarePerPsgn + ", ticketAmount=" + this.ticketAmount + ", refundAmount=" + this.refundAmount + "]";
    }
}
