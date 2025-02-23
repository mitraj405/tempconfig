package defpackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: Az  reason: default package and case insensitive filesystem */
/* compiled from: TdrDetailsDTO */
public final class C0456Az implements Serializable {
    private static final long serialVersionUID = 1;
    private Date cancellationDate;
    private Double eftAmount;
    private String eftNumber;
    private ArrayList<String> moreRepudiateReason;
    private Date refundDate;
    private Date registrationDate;
    private Date repudiateDate;
    private String repudiateReason;
    private String tdrFilingDate;
    private String tdrReason;
    private String tdrRefNo;
    private String tdrRegistrationFailedReason;
    private String tdrStatus;
    private String tdrZone;

    public Date getCancellationDate() {
        return this.cancellationDate;
    }

    public Double getEftAmount() {
        return this.eftAmount;
    }

    public String getEftNumber() {
        return this.eftNumber;
    }

    public ArrayList<String> getMoreRepudiateReason() {
        return this.moreRepudiateReason;
    }

    public Date getRefundDate() {
        return this.refundDate;
    }

    public Date getRegistrationDate() {
        return this.registrationDate;
    }

    public Date getRepudiateDate() {
        return this.repudiateDate;
    }

    public String getRepudiateReason() {
        return this.repudiateReason;
    }

    public String getTdrFilingDate() {
        return this.tdrFilingDate;
    }

    public String getTdrReason() {
        return this.tdrReason;
    }

    public String getTdrRefNo() {
        return this.tdrRefNo;
    }

    public String getTdrRegistrationFailedReason() {
        return this.tdrRegistrationFailedReason;
    }

    public String getTdrStatus() {
        return this.tdrStatus;
    }

    public String getTdrZone() {
        return this.tdrZone;
    }

    public void setCancellationDate(Date date) {
        this.cancellationDate = date;
    }

    public void setEftAmount(Double d) {
        this.eftAmount = d;
    }

    public void setEftNumber(String str) {
        this.eftNumber = str;
    }

    public void setMoreRepudiateReason(ArrayList<String> arrayList) {
        this.moreRepudiateReason = arrayList;
    }

    public void setRefundDate(Date date) {
        this.refundDate = date;
    }

    public void setRegistrationDate(Date date) {
        this.registrationDate = date;
    }

    public void setRepudiateDate(Date date) {
        this.repudiateDate = date;
    }

    public void setRepudiateReason(String str) {
        this.repudiateReason = str;
    }

    public void setTdrFilingDate(String str) {
        this.tdrFilingDate = str;
    }

    public void setTdrReason(String str) {
        this.tdrReason = str;
    }

    public void setTdrRefNo(String str) {
        this.tdrRefNo = str;
    }

    public void setTdrRegistrationFailedReason(String str) {
        this.tdrRegistrationFailedReason = str;
    }

    public void setTdrStatus(String str) {
        this.tdrStatus = str;
    }

    public void setTdrZone(String str) {
        this.tdrZone = str;
    }

    public String toString() {
        return "TdrDetailsDTO [eftAmount=" + this.eftAmount + ", eftNumber=" + this.eftNumber + ", tdrStatus=" + this.tdrStatus + ", tdrFilingDate=" + this.tdrFilingDate + ", tdrReason=" + this.tdrReason + ", tdrRefNo=" + this.tdrRefNo + ", registrationDate=" + this.registrationDate + ", cancellationDate=" + this.cancellationDate + ", tdrZone=" + this.tdrZone + ", tdrRegistrationFailedReason=" + this.tdrRegistrationFailedReason + ", refundDate=" + this.refundDate + ", repudiateReason=" + this.repudiateReason + ", moreRepudiateReason=" + this.moreRepudiateReason + "]";
    }
}
