package defpackage;

import java.util.ArrayList;
import java.util.Arrays;

/* renamed from: U1  reason: default package and case insensitive filesystem */
/* compiled from: AtasSpecialTrainOutputDTO */
public final class C0701U1 extends C0750Xx {
    private String boardingPoint;
    private String destinationStationName;
    private String[] informationMessage;
    private String journeyClass;
    private String journeyDate;
    private ArrayList<Object> passengerList;
    private String pnrNumber;
    private String quotaName;
    private long reasonIndex;
    private String reasonType;
    private String reservationUpto;
    private String sourceStationName;
    private String startDate;
    private String trainNumber;

    public String getBoardingPoint() {
        return this.boardingPoint;
    }

    public String getDestinationStationName() {
        return this.destinationStationName;
    }

    public String[] getInformationMessage() {
        return this.informationMessage;
    }

    public String getJourneyClass() {
        return this.journeyClass;
    }

    public ArrayList<Object> getPassengerList() {
        return this.passengerList;
    }

    public String getPnrNumber() {
        return this.pnrNumber;
    }

    public String getQuotaName() {
        return this.quotaName;
    }

    public long getReasonIndex() {
        return this.reasonIndex;
    }

    public String getReasonType() {
        return this.reasonType;
    }

    public String getReservationUpto() {
        return this.reservationUpto;
    }

    public String getSourceStationName() {
        return this.sourceStationName;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public String getTrainNumber() {
        return this.trainNumber;
    }

    public void setBoardingPoint(String str) {
        this.boardingPoint = str;
    }

    public void setDestinationStationName(String str) {
        this.destinationStationName = str;
    }

    public void setInformationMessage(String[] strArr) {
        this.informationMessage = strArr;
    }

    public void setJourneyClass(String str) {
        this.journeyClass = str;
    }

    public void setJourneyDate(String str) {
        this.journeyDate = str;
    }

    public void setPassengerList(ArrayList<Object> arrayList) {
        this.passengerList = arrayList;
    }

    public void setPnrNumber(String str) {
        this.pnrNumber = str;
    }

    public void setQuotaName(String str) {
        this.quotaName = str;
    }

    public void setReasonIndex(long j) {
        this.reasonIndex = j;
    }

    public void setReasonType(String str) {
        this.reasonType = str;
    }

    public void setReservationUpto(String str) {
        this.reservationUpto = str;
    }

    public void setSourceStationName(String str) {
        this.sourceStationName = str;
    }

    public void setStartDate(String str) {
        this.startDate = str;
    }

    public void setTrainNumber(String str) {
        this.trainNumber = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AtasSpecialTrainOutputDTO [trainNumber=");
        sb.append(this.trainNumber);
        sb.append(", journeyDate=");
        sb.append(this.journeyDate);
        sb.append(", sourceStationName=");
        sb.append(this.sourceStationName);
        sb.append(", destinationStationName=");
        sb.append(this.destinationStationName);
        sb.append(", quotaName=");
        sb.append(this.quotaName);
        sb.append(", reservationUpto=");
        sb.append(this.reservationUpto);
        sb.append(", boardingPoint=");
        sb.append(this.boardingPoint);
        sb.append(", journeyClass=");
        sb.append(this.journeyClass);
        sb.append(", startDate=");
        sb.append(this.startDate);
        sb.append(", pnrNumber=");
        sb.append(this.pnrNumber);
        sb.append(", passengerList=");
        sb.append(this.passengerList);
        sb.append(", reasonType=");
        sb.append(this.reasonType);
        sb.append(", reasonIndex=");
        sb.append(this.reasonIndex);
        sb.append(", informationMessage=");
        return C0709Uj.j(sb, Arrays.toString(this.informationMessage), "]");
    }
}
