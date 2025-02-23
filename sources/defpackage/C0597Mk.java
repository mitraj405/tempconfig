package defpackage;

import cris.prs.webservices.dto.MealDetails;
import cris.prs.webservices.dto.MealItemDetails;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: Mk  reason: default package and case insensitive filesystem */
/* compiled from: MealTransactionDetails */
public final class C0597Mk implements Serializable {
    private static final long serialVersionUID = 1;
    private ArrayList<MealItemDetails> addMealDetail = null;
    private Date boardingDate;
    private int bookingMode;
    private int bookingSource = 0;
    private String coachSeatNo;
    private String errorMessage;
    private boolean mealBooked;
    private ArrayList<MealDetails> mealChoiceDetails = null;
    private String mobileNo;
    private String pnrNumber;
    private long reservationId;
    private long ticketId;
    private int tktCanStatus;
    private String trainNo;
    private Date trainStartDate;

    public ArrayList<MealItemDetails> getAddMealDetail() {
        return this.addMealDetail;
    }

    public Date getBoardingDate() {
        return this.boardingDate;
    }

    public int getBookingMode() {
        return this.bookingMode;
    }

    public int getBookingSource() {
        return this.bookingSource;
    }

    public String getCoachSeatNo() {
        return this.coachSeatNo;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public ArrayList<MealDetails> getMealChoiceDetails() {
        return this.mealChoiceDetails;
    }

    public String getMobileNo() {
        return this.mobileNo;
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

    public int getTktCanStatus() {
        return this.tktCanStatus;
    }

    public String getTrainNo() {
        return this.trainNo;
    }

    public Date getTrainStartDate() {
        return this.trainStartDate;
    }

    public boolean isMealBooked() {
        return this.mealBooked;
    }

    public void setAddMealDetail(ArrayList<MealItemDetails> arrayList) {
        this.addMealDetail = arrayList;
    }

    public void setBoardingDate(Date date) {
        this.boardingDate = date;
    }

    public void setBookingMode(int i) {
        this.bookingMode = i;
    }

    public void setBookingSource(int i) {
        this.bookingSource = i;
    }

    public void setCoachSeatNo(String str) {
        this.coachSeatNo = str;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setMealBooked(boolean z) {
        this.mealBooked = z;
    }

    public void setMealChoiceDetails(ArrayList<MealDetails> arrayList) {
        this.mealChoiceDetails = arrayList;
    }

    public void setMobileNo(String str) {
        this.mobileNo = str;
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

    public void setTktCanStatus(int i) {
        this.tktCanStatus = i;
    }

    public void setTrainNo(String str) {
        this.trainNo = str;
    }

    public void setTrainStartDate(Date date) {
        this.trainStartDate = date;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MealTransactionDetails [ticketId=");
        sb.append(this.ticketId);
        sb.append(", reservationId=");
        sb.append(this.reservationId);
        sb.append(", pnrNumber=");
        sb.append(this.pnrNumber);
        sb.append(", boardingDate=");
        sb.append(this.boardingDate);
        sb.append(", mobileNo=");
        sb.append(this.mobileNo);
        sb.append(", coachSeatNo=");
        sb.append(this.coachSeatNo);
        sb.append(", trainStartDate=");
        sb.append(this.trainStartDate);
        sb.append(", trainNo=");
        sb.append(this.trainNo);
        sb.append(", addMealDetail=");
        sb.append(this.addMealDetail);
        sb.append(", mealChoiceDetails=");
        sb.append(this.mealChoiceDetails);
        sb.append(", mealBooked=");
        sb.append(this.mealBooked);
        sb.append(", tktCanStatus=");
        sb.append(this.tktCanStatus);
        sb.append(", errorMessage=");
        sb.append(this.errorMessage);
        sb.append(", bookingMode=");
        sb.append(this.bookingMode);
        sb.append(", bookingSource=");
        return lf.k(sb, this.bookingSource, "]");
    }
}
