package defpackage;

import cris.prs.webservices.dto.PassengerDetailDTO;
import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: M6  reason: default package and case insensitive filesystem */
/* compiled from: ConnectedPnrDataDTO */
public final class C0587M6 implements Serializable {
    private static final long serialVersionUID = 1;
    private int lapNo;
    private String mobileNo;
    private boolean otpSuccess;
    private ArrayList<PassengerDetailDTO> passengerList;
    private String pnrNumber;
    private long reservationId;
    private long ticketId;
    private String ticketType;
    private long userId;

    public int getLapNo() {
        return this.lapNo;
    }

    public String getMobileNo() {
        return this.mobileNo;
    }

    public ArrayList<PassengerDetailDTO> getPassengerList() {
        return this.passengerList;
    }

    public String getPnrNumber() {
        return this.pnrNumber;
    }

    public long getReservationId() {
        return this.reservationId;
    }

    public long getTicketId() {
        return this.ticketId;
    }

    public String getTicketType() {
        return this.ticketType;
    }

    public long getUserId() {
        return this.userId;
    }

    public boolean isOtpSuccess() {
        return this.otpSuccess;
    }

    public void setLapNo(int i) {
        this.lapNo = i;
    }

    public void setMobileNo(String str) {
        this.mobileNo = str;
    }

    public void setOtpSuccess(boolean z) {
        this.otpSuccess = z;
    }

    public void setPassengerList(ArrayList<PassengerDetailDTO> arrayList) {
        this.passengerList = arrayList;
    }

    public void setPnrNumber(String str) {
        this.pnrNumber = str;
    }

    public void setReservationId(long j) {
        this.reservationId = j;
    }

    public void setTicketId(long j) {
        this.ticketId = j;
    }

    public void setTicketType(String str) {
        this.ticketType = str;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ConnectedPnrDataDTO [pnrNumber=");
        sb.append(this.pnrNumber);
        sb.append(", passengerList=");
        sb.append(this.passengerList);
        sb.append(", reservationId=");
        sb.append(this.reservationId);
        sb.append(", ticketId=");
        sb.append(this.ticketId);
        sb.append(", lapNo=");
        sb.append(this.lapNo);
        sb.append(", userId=");
        return lf.l(sb, this.userId, "]");
    }
}
