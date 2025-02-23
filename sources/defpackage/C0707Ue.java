package defpackage;

import cris.prs.webservices.dto.BookingResponseDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: Ue  reason: default package and case insensitive filesystem */
/* compiled from: HistoryEnquiryDTO */
public final class C0707Ue implements Serializable {
    private static final long serialVersionUID = 1;
    private ArrayList<BookingResponseDTO> bookingResponseList = new ArrayList<>();
    private boolean eligibleForCancel = false;
    private String errorMsg;
    private String qrCodeTextMultiLap;
    private String serverId;
    private boolean showLastTxn = false;
    private ArrayList<C0502Ez> tdrReasonList = null;
    private Date timeStamp;

    public ArrayList<BookingResponseDTO> getBookingResponseList() {
        return this.bookingResponseList;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public String getQrCodeTextMultiLap() {
        return this.qrCodeTextMultiLap;
    }

    public String getServerId() {
        return this.serverId;
    }

    public ArrayList<C0502Ez> getTdrReasonList() {
        return this.tdrReasonList;
    }

    public Date getTimeStamp() {
        return this.timeStamp;
    }

    public boolean isEligibleForCancel() {
        return this.eligibleForCancel;
    }

    public boolean isShowLastTxn() {
        return this.showLastTxn;
    }

    public void setBookingResponseList(ArrayList<BookingResponseDTO> arrayList) {
        this.bookingResponseList = arrayList;
    }

    public void setEligibleForCancel(boolean z) {
        this.eligibleForCancel = z;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setQrCodeTextMultiLap(String str) {
        this.qrCodeTextMultiLap = str;
    }

    public void setServerId(String str) {
        this.serverId = str;
    }

    public void setShowLastTxn(boolean z) {
        this.showLastTxn = z;
    }

    public void setTdrReasonList(ArrayList<C0502Ez> arrayList) {
        this.tdrReasonList = arrayList;
    }

    public void setTimeStamp(Date date) {
        this.timeStamp = date;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("HistoryEnquiryDTO [errorMsg=");
        sb.append(this.errorMsg);
        sb.append(", bookingResponseList=");
        sb.append(this.bookingResponseList);
        sb.append(", tdrReasonList=");
        sb.append(this.tdrReasonList);
        sb.append(", serverId=");
        sb.append(this.serverId);
        sb.append(", timeStamp=");
        sb.append(this.timeStamp);
        sb.append(", eligibleForCancel=");
        sb.append(this.eligibleForCancel);
        sb.append(", showLastTxn=");
        return xx.G(sb, this.showLastTxn, "]");
    }
}
