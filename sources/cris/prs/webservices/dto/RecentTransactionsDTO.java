package cris.prs.webservices.dto;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public final class RecentTransactionsDTO implements Serializable {
    private static final long serialVersionUID = 1;
    private Double amountPaidbyUser;
    private Date arrivalDate;
    private Date boardingDate;
    private String bookingClass;
    private Date bookingDate;
    private String bookingStatus;
    private Long cancellationId;
    private String cancellationStatus;
    private String fromStation;
    private String paymentStatus;
    private String pnrNumber;
    private String refundStatus;
    private Long reservationId;
    private String reservationMode;
    private String rrHotelFlag;
    private Double ticketAmount;
    private String toStation;
    private String trainName;
    private String trainNumber;
    private Long transactionId;
    private String txnType;

    public Double getAmountPaidbyUser() {
        return this.amountPaidbyUser;
    }

    public Date getArrivalDate() {
        return this.arrivalDate;
    }

    public Date getBoardingDate() {
        return this.boardingDate;
    }

    public String getBookingClass() {
        return this.bookingClass;
    }

    public Date getBookingDate() {
        return this.bookingDate;
    }

    public String getBookingStatus() {
        return this.bookingStatus;
    }

    public Long getCancellationId() {
        return this.cancellationId;
    }

    public String getCancellationStatus() {
        return this.cancellationStatus;
    }

    public String getFromStation() {
        return this.fromStation;
    }

    public String getPaymentStatus() {
        return this.paymentStatus;
    }

    public String getPnrNumber() {
        return this.pnrNumber;
    }

    public String getRefundStatus() {
        return this.refundStatus;
    }

    public Long getReservationId() {
        return this.reservationId;
    }

    public String getReservationMode() {
        return this.reservationMode;
    }

    public String getRrHotelFlag() {
        return this.rrHotelFlag;
    }

    public Double getTicketAmount() {
        return this.ticketAmount;
    }

    public String getToStation() {
        return this.toStation;
    }

    public String getTrainName() {
        return this.trainName;
    }

    public String getTrainNumber() {
        return this.trainNumber;
    }

    public Long getTransactionId() {
        return this.transactionId;
    }

    public String getTxnType() {
        return this.txnType;
    }

    public void setAmountPaidbyUser(Double d) {
        this.amountPaidbyUser = d;
    }

    public void setArrivalDate(Date date) {
        this.arrivalDate = date;
    }

    public void setBoardingDate(Date date) {
        this.boardingDate = date;
    }

    public void setBookingClass(String str) {
        this.bookingClass = str;
    }

    public void setBookingDate(Date date) {
        this.bookingDate = date;
    }

    public void setBookingStatus(String str) {
        this.bookingStatus = str;
    }

    public void setCancellationId(Long l) {
        this.cancellationId = l;
    }

    public void setCancellationStatus(String str) {
        this.cancellationStatus = str;
    }

    public void setFromStation(String str) {
        this.fromStation = str;
    }

    public void setPaymentStatus(String str) {
        this.paymentStatus = str;
    }

    public void setPnrNumber(String str) {
        this.pnrNumber = str;
    }

    public void setRefundStatus(String str) {
        this.refundStatus = str;
    }

    public void setReservationId(Long l) {
        this.reservationId = l;
    }

    public void setReservationMode(String str) {
        this.reservationMode = str;
    }

    public void setRrHotelFlag(String str) {
        this.rrHotelFlag = str;
    }

    public void setTicketAmount(Double d) {
        this.ticketAmount = d;
    }

    public void setToStation(String str) {
        this.toStation = str;
    }

    public void setTrainName(String str) {
        this.trainName = str;
    }

    public void setTrainNumber(String str) {
        this.trainNumber = str;
    }

    public void setTransactionId(Long l) {
        this.transactionId = l;
    }

    public void setTxnType(String str) {
        this.txnType = str;
    }

    public String toString() {
        return "RecentTransactionsDTO [txnType=" + this.txnType + ", reservationId=" + this.reservationId + ", pnrNumber=" + this.pnrNumber + ", boardingDate=" + this.boardingDate + ", trainNumber=" + this.trainNumber + ", trainName=" + this.trainName + ", fromStation=" + this.fromStation + ", toStation=" + this.toStation + ", bookingStatus=" + this.bookingStatus + ", paymentStatus=" + this.paymentStatus + ", cancellationStatus=" + this.cancellationStatus + ", refundStatus=" + this.refundStatus + ", bookingDate=" + this.bookingDate + ", reservationMode=" + this.reservationMode + ", cancellationId=" + this.cancellationId + ", arrivalDate=" + this.arrivalDate + ", amountPaidbyUser=" + this.amountPaidbyUser + ", rrHotelFlag=" + this.rrHotelFlag + ", ticketAmount=" + this.ticketAmount + ", bookingClass=" + this.bookingClass + ", transactionId=" + this.transactionId + "]";
    }
}
