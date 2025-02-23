package defpackage;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: Wp  reason: default package */
/* compiled from: PostBookingResponseDTO */
public final class Wp implements Serializable {
    private static final long serialVersionUID = 1;
    private List<C1187j2> bankDetailDTO;
    private boolean directBooking;
    private String error;
    private C1087eb ewalletDTO;
    private List<Do> fareBreakup;
    private String fromStation;
    private String message;
    private Date timeStamp;
    private String toStation;
    private double totalPayableAmount;

    public List<C1187j2> getBankDetailDTO() {
        return this.bankDetailDTO;
    }

    public String getError() {
        return this.error;
    }

    public C1087eb getEwalletDTO() {
        return this.ewalletDTO;
    }

    public List<Do> getFareBreakup() {
        return this.fareBreakup;
    }

    public String getFromStation() {
        return this.fromStation;
    }

    public String getMessage() {
        return this.message;
    }

    public Date getTimeStamp() {
        return this.timeStamp;
    }

    public String getToStation() {
        return this.toStation;
    }

    public double getTotalPayableAmount() {
        return this.totalPayableAmount;
    }

    public boolean isDirectBooking() {
        return this.directBooking;
    }

    public void setBankDetailDTO(List<C1187j2> list) {
        this.bankDetailDTO = list;
    }

    public void setDirectBooking(boolean z) {
        this.directBooking = z;
    }

    public void setError(String str) {
        this.error = str;
    }

    public void setEwalletDTO(C1087eb ebVar) {
        this.ewalletDTO = ebVar;
    }

    public void setFareBreakup(List<Do> list) {
        this.fareBreakup = list;
    }

    public void setFromStation(String str) {
        this.fromStation = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setTimeStamp(Date date) {
        this.timeStamp = date;
    }

    public void setToStation(String str) {
        this.toStation = str;
    }

    public void setTotalPayableAmount(double d) {
        this.totalPayableAmount = d;
    }

    public String toString() {
        return "PostBookingResponseDTO [fareBreakup=" + this.fareBreakup + ", error=" + this.error + ", message=" + this.message + ", directBooking=" + this.directBooking + ", fromStation=" + this.fromStation + ", toStation=" + this.toStation + ", totalPayableAmount=" + this.totalPayableAmount + ", bankDetailDTO=" + this.bankDetailDTO + ", ewalletDTO=" + this.ewalletDTO + ", timeStamp=" + this.timeStamp + "]";
    }
}
