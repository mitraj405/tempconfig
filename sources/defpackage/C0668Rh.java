package defpackage;

import cris.prs.webservices.dto.MealItemDetails;
import cris.prs.webservices.dto.PassengerDetailDTO;
import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: Rh  reason: default package and case insensitive filesystem */
/* compiled from: LapAvlRequestDTO */
public final class C0668Rh implements Serializable {
    private static final long serialVersionUID = 1;
    private ArrayList<MealItemDetails> addMealDetail = null;
    private boolean agentOtpBooking;
    private String coachId;
    private boolean concessionBooking;
    private String fromStation;
    private Boolean ignoreChoiceIfWl = Boolean.TRUE;
    private ArrayList<Df> infantList = null;
    private String jd;
    private String journeyClass;
    private String journeyDate;
    private ArrayList<PassengerDetailDTO> passengerList = null;
    private String quota;
    private Short reservationChoice;
    private String ssQuotaSplitCoach;
    private Short ticketChoiceLowerBerth;
    private Boolean ticketChoiceSameCoach = Boolean.FALSE;
    private String toStation;
    private String trainNo;
    private Byte trainOwner;
    private Boolean travelInsuranceOpted;

    public ArrayList<MealItemDetails> getAddMealDetail() {
        return this.addMealDetail;
    }

    public String getCoachId() {
        return this.coachId;
    }

    public String getFromStation() {
        return this.fromStation;
    }

    public Boolean getIgnoreChoiceIfWl() {
        return this.ignoreChoiceIfWl;
    }

    public ArrayList<Df> getInfantList() {
        return this.infantList;
    }

    public String getJd() {
        return this.jd;
    }

    public String getJourneyClass() {
        return this.journeyClass;
    }

    public String getJourneyDate() {
        return this.journeyDate;
    }

    public ArrayList<PassengerDetailDTO> getPassengerList() {
        return this.passengerList;
    }

    public String getQuota() {
        return this.quota;
    }

    public Short getReservationChoice() {
        return this.reservationChoice;
    }

    public String getSsQuotaSplitCoach() {
        return this.ssQuotaSplitCoach;
    }

    public Short getTicketChoiceLowerBerth() {
        return this.ticketChoiceLowerBerth;
    }

    public Boolean getTicketChoiceSameCoach() {
        return this.ticketChoiceSameCoach;
    }

    public String getToStation() {
        return this.toStation;
    }

    public String getTrainNo() {
        return this.trainNo;
    }

    public Byte getTrainOwner() {
        return this.trainOwner;
    }

    public Boolean getTravelInsuranceOpted() {
        return this.travelInsuranceOpted;
    }

    public boolean isAgentOtpBooking() {
        return this.agentOtpBooking;
    }

    public boolean isConcessionBooking() {
        return this.concessionBooking;
    }

    public void setAddMealDetail(ArrayList<MealItemDetails> arrayList) {
        this.addMealDetail = arrayList;
    }

    public void setAgentOtpBooking(boolean z) {
        this.agentOtpBooking = z;
    }

    public void setCoachId(String str) {
        this.coachId = str;
    }

    public void setConcessionBooking(boolean z) {
        this.concessionBooking = z;
    }

    public void setFromStation(String str) {
        this.fromStation = str;
    }

    public void setIgnoreChoiceIfWl(Boolean bool) {
        this.ignoreChoiceIfWl = bool;
    }

    public void setInfantList(ArrayList<Df> arrayList) {
        this.infantList = arrayList;
    }

    public void setJd(String str) {
        this.jd = str;
    }

    public void setJourneyClass(String str) {
        this.journeyClass = str;
    }

    public void setJourneyDate(String str) {
        this.journeyDate = str;
    }

    public void setPassengerList(ArrayList<PassengerDetailDTO> arrayList) {
        this.passengerList = arrayList;
    }

    public void setQuota(String str) {
        this.quota = str;
    }

    public void setReservationChoice(Short sh) {
        this.reservationChoice = sh;
    }

    public void setSsQuotaSplitCoach(String str) {
        this.ssQuotaSplitCoach = str;
    }

    public void setTicketChoiceLowerBerth(Short sh) {
        this.ticketChoiceLowerBerth = sh;
    }

    public void setTicketChoiceSameCoach(Boolean bool) {
        this.ticketChoiceSameCoach = bool;
    }

    public void setToStation(String str) {
        this.toStation = str;
    }

    public void setTrainNo(String str) {
        this.trainNo = str;
    }

    public void setTrainOwner(Byte b) {
        this.trainOwner = b;
    }

    public void setTravelInsuranceOpted(Boolean bool) {
        this.travelInsuranceOpted = bool;
    }
}
