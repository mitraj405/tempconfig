package cris.prs.webservices.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public final class PnrEnquiryResponseDTO implements Serializable {
    private static final long serialVersionUID = 1;
    private short arrivalTimeDestination;
    private String berthFlag;
    private String boardingPoint;
    private String bookingDate;
    private Integer bookingFare;
    private Short cateringFare;
    private Short chartFlag;
    private String chartStatus;
    private String connectingPnrFlag;
    private Date dateOfArrivalDestination;
    private Date dateOfJourney;
    private Short delay;
    private short departureTime;
    private String destinationStation;
    private Short distance;
    private String errorMessage;
    private List<String> foodDetails;
    private String[] informationMessage;
    private String journeyClass;
    private String linkPnr;
    private Short linkPnrFlag;
    private String mobileNo;
    private Short numberOfpassenger;
    private ArrayList<PassengerDetailDTO> passengerList;
    private String pnrNumber;
    private String quota;
    private String reasonType;
    private String reservationUpto;
    private String serverId;
    private String sourceStation;
    private short specialFlag;
    private String status;
    private Integer ticketFare;
    private String ticketType;
    private Date timeStamp;
    private short timeTableChangeFlag;
    private String trainCancelStatus;
    private String trainName;
    private String trainNumber;
    private String trainSiteId;
    private Date trainStartDate;
    private String vikalpMessage;
    private String vikalpStatus;

    public short getArrivalTimeDestination() {
        return this.arrivalTimeDestination;
    }

    public String getBerthFlag() {
        return this.berthFlag;
    }

    public String getBoardingPoint() {
        return this.boardingPoint;
    }

    public String getBookingDate() {
        return this.bookingDate;
    }

    public Integer getBookingFare() {
        return this.bookingFare;
    }

    public Short getCateringFare() {
        return this.cateringFare;
    }

    public Short getChartFlag() {
        return this.chartFlag;
    }

    public String getChartStatus() {
        return this.chartStatus;
    }

    public String getConnectingPnrFlag() {
        return this.connectingPnrFlag;
    }

    public Date getDateOfArrivalDestination() {
        return this.dateOfArrivalDestination;
    }

    public Date getDateOfJourney() {
        return this.dateOfJourney;
    }

    public Short getDelay() {
        return this.delay;
    }

    public short getDepartureTime() {
        return this.departureTime;
    }

    public String getDestinationStation() {
        return this.destinationStation;
    }

    public Short getDistance() {
        return this.distance;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public List<String> getFoodDetails() {
        return this.foodDetails;
    }

    public String[] getInformationMessage() {
        return this.informationMessage;
    }

    public String getJourneyClass() {
        return this.journeyClass;
    }

    public String getLinkPnr() {
        return this.linkPnr;
    }

    public Short getLinkPnrFlag() {
        return this.linkPnrFlag;
    }

    public String getMobileNo() {
        return this.mobileNo;
    }

    public Short getNumberOfpassenger() {
        return this.numberOfpassenger;
    }

    public ArrayList<PassengerDetailDTO> getPassengerList() {
        return this.passengerList;
    }

    public String getPnrNumber() {
        return this.pnrNumber;
    }

    public String getQuota() {
        return this.quota;
    }

    public String getReasonType() {
        return this.reasonType;
    }

    public String getReservationUpto() {
        return this.reservationUpto;
    }

    public String getServerId() {
        return this.serverId;
    }

    public String getSourceStation() {
        return this.sourceStation;
    }

    public short getSpecialFlag() {
        return this.specialFlag;
    }

    public String getStatus() {
        return this.status;
    }

    public Integer getTicketFare() {
        return this.ticketFare;
    }

    public String getTicketType() {
        return this.ticketType;
    }

    public Date getTimeStamp() {
        return this.timeStamp;
    }

    public short getTimeTableChangeFlag() {
        return this.timeTableChangeFlag;
    }

    public String getTrainCancelStatus() {
        return this.trainCancelStatus;
    }

    public String getTrainName() {
        return this.trainName;
    }

    public String getTrainNumber() {
        return this.trainNumber;
    }

    public String getTrainSiteId() {
        return this.trainSiteId;
    }

    public Date getTrainStartDate() {
        return this.trainStartDate;
    }

    public String getVikalpMessage() {
        return this.vikalpMessage;
    }

    public String getVikalpStatus() {
        return this.vikalpStatus;
    }

    public void setArrivalTimeDestination(short s) {
        this.arrivalTimeDestination = s;
    }

    public void setBerthFlag(String str) {
        this.berthFlag = str;
    }

    public void setBoardingPoint(String str) {
        this.boardingPoint = str;
    }

    public void setBookingDate(String str) {
        this.bookingDate = str;
    }

    public void setBookingFare(Integer num) {
        this.bookingFare = num;
    }

    public void setCateringFare(Short sh) {
        this.cateringFare = sh;
    }

    public void setChartFlag(Short sh) {
        this.chartFlag = sh;
    }

    public void setChartStatus(String str) {
        this.chartStatus = str;
    }

    public void setConnectingPnrFlag(String str) {
        this.connectingPnrFlag = str;
    }

    public void setDateOfArrivalDestination(Date date) {
        this.dateOfArrivalDestination = date;
    }

    public void setDateOfJourney(Date date) {
        this.dateOfJourney = date;
    }

    public void setDelay(Short sh) {
        this.delay = sh;
    }

    public void setDepartureTime(short s) {
        this.departureTime = s;
    }

    public void setDestinationStation(String str) {
        this.destinationStation = str;
    }

    public void setDistance(Short sh) {
        this.distance = sh;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setFoodDetails(List<String> list) {
        this.foodDetails = list;
    }

    public void setInformationMessage(String[] strArr) {
        this.informationMessage = strArr;
    }

    public void setJourneyClass(String str) {
        this.journeyClass = str;
    }

    public void setLinkPnr(String str) {
        this.linkPnr = str;
    }

    public void setLinkPnrFlag(Short sh) {
        this.linkPnrFlag = sh;
    }

    public void setMobileNo(String str) {
        this.mobileNo = str;
    }

    public void setNumberOfpassenger(Short sh) {
        this.numberOfpassenger = sh;
    }

    public void setPassengerList(ArrayList<PassengerDetailDTO> arrayList) {
        this.passengerList = arrayList;
    }

    public void setPnrNumber(String str) {
        this.pnrNumber = str;
    }

    public void setQuota(String str) {
        this.quota = str;
    }

    public void setReasonType(String str) {
        this.reasonType = str;
    }

    public void setReservationUpto(String str) {
        this.reservationUpto = str;
    }

    public void setServerId(String str) {
        this.serverId = str;
    }

    public void setSourceStation(String str) {
        this.sourceStation = str;
    }

    public void setSpecialFlag(short s) {
        this.specialFlag = s;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setTicketFare(Integer num) {
        this.ticketFare = num;
    }

    public void setTicketType(String str) {
        this.ticketType = str;
    }

    public void setTimeStamp(Date date) {
        this.timeStamp = date;
    }

    public void setTimeTableChangeFlag(short s) {
        this.timeTableChangeFlag = s;
    }

    public void setTrainCancelStatus(String str) {
        this.trainCancelStatus = str;
    }

    public void setTrainName(String str) {
        this.trainName = str;
    }

    public void setTrainNumber(String str) {
        this.trainNumber = str;
    }

    public void setTrainSiteId(String str) {
        this.trainSiteId = str;
    }

    public void setTrainStartDate(Date date) {
        this.trainStartDate = date;
    }

    public void setVikalpMessage(String str) {
        this.vikalpMessage = str;
    }

    public void setVikalpStatus(String str) {
        this.vikalpStatus = str;
    }
}
