package defpackage;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: ol  reason: default package and case insensitive filesystem */
/* compiled from: MetroServiceDetailsDTO */
public final class C1303ol implements Serializable {
    private static final long serialVersionUID = 1;
    private String addOnOptedBankName;
    private Date addonCancelDate;
    private String currentCancelStatusString;
    private Integer dmrcBookingMode;
    private String dmrcCarbonMessage;
    private Integer dmrcCarbonValue;
    private Short dmrcServiceCharge;
    private String dmrcServiceId;
    private String linkedPnrNumber;
    private Integer metroCancelCharge;
    private Integer metroCancelPsgnFare;
    private Integer metroCancelStatus;
    private Long metroCancellationId;
    private String metroFromStation;
    private Integer metroFromStationColorCode;
    private Integer metroFromStationIndex;
    private Float metroGstCharge;
    private Date metroJourneyDate;
    private List<C1283nl> metroPassengerList;
    private Integer metroRefundAmount;
    private Date metroServiceOptedDate;
    private Integer metroTicketFare;
    private String metroToStation;
    private Integer metroToStationColorCode;
    private Integer metroToStationIndex;
    private Short numberOfCancelPsgn;
    private Short numberOfPassengerOpted;
    private String reservationId;
    private Integer serviceStatus;
    private Integer serviceType;
    private Double totalAmount;
    private Integer transactionStatus;

    public String getAddOnOptedBankName() {
        return this.addOnOptedBankName;
    }

    public Date getAddonCancelDate() {
        return this.addonCancelDate;
    }

    public String getCurrentCancelStatusString() {
        return this.currentCancelStatusString;
    }

    public Integer getDmrcBookingMode() {
        return this.dmrcBookingMode;
    }

    public String getDmrcCarbonMessage() {
        return this.dmrcCarbonMessage;
    }

    public Integer getDmrcCarbonValue() {
        return this.dmrcCarbonValue;
    }

    public Short getDmrcServiceCharge() {
        return this.dmrcServiceCharge;
    }

    public String getDmrcServiceId() {
        return this.dmrcServiceId;
    }

    public String getLinkedPnrNumber() {
        return this.linkedPnrNumber;
    }

    public Integer getMetroCancelCharge() {
        return this.metroCancelCharge;
    }

    public Integer getMetroCancelPsgnFare() {
        return this.metroCancelPsgnFare;
    }

    public Integer getMetroCancelStatus() {
        return this.metroCancelStatus;
    }

    public Long getMetroCancellationId() {
        return this.metroCancellationId;
    }

    public String getMetroFromStation() {
        return this.metroFromStation;
    }

    public Integer getMetroFromStationColorCode() {
        return this.metroFromStationColorCode;
    }

    public Integer getMetroFromStationIndex() {
        return this.metroFromStationIndex;
    }

    public Float getMetroGstCharge() {
        return this.metroGstCharge;
    }

    public Date getMetroJourneyDate() {
        return this.metroJourneyDate;
    }

    public List<C1283nl> getMetroPassengerList() {
        return this.metroPassengerList;
    }

    public Integer getMetroRefundAmount() {
        return this.metroRefundAmount;
    }

    public Date getMetroServiceOptedDate() {
        return this.metroServiceOptedDate;
    }

    public Integer getMetroTicketFare() {
        return this.metroTicketFare;
    }

    public String getMetroToStation() {
        return this.metroToStation;
    }

    public Integer getMetroToStationColorCode() {
        return this.metroToStationColorCode;
    }

    public Integer getMetroToStationIndex() {
        return this.metroToStationIndex;
    }

    public Short getNumberOfCancelPsgn() {
        return this.numberOfCancelPsgn;
    }

    public Short getNumberOfPassengerOpted() {
        return this.numberOfPassengerOpted;
    }

    public String getReservationId() {
        return this.reservationId;
    }

    public Integer getServiceStatus() {
        return this.serviceStatus;
    }

    public Integer getServiceType() {
        return this.serviceType;
    }

    public Double getTotalAmount() {
        return this.totalAmount;
    }

    public Integer getTransactionStatus() {
        return this.transactionStatus;
    }

    public void setAddOnOptedBankName(String str) {
        this.addOnOptedBankName = str;
    }

    public void setAddonCancelDate(Date date) {
        this.addonCancelDate = date;
    }

    public void setCurrentCancelStatusString(String str) {
        this.currentCancelStatusString = str;
    }

    public void setDmrcBookingMode(Integer num) {
        this.dmrcBookingMode = num;
    }

    public void setDmrcCarbonMessage(String str) {
        this.dmrcCarbonMessage = str;
    }

    public void setDmrcCarbonValue(Integer num) {
        this.dmrcCarbonValue = num;
    }

    public void setDmrcServiceCharge(Short sh) {
        this.dmrcServiceCharge = sh;
    }

    public void setDmrcServiceId(String str) {
        this.dmrcServiceId = str;
    }

    public void setLinkedPnrNumber(String str) {
        this.linkedPnrNumber = str;
    }

    public void setMetroCancelCharge(Integer num) {
        this.metroCancelCharge = num;
    }

    public void setMetroCancelPsgnFare(Integer num) {
        this.metroCancelPsgnFare = num;
    }

    public void setMetroCancelStatus(Integer num) {
        this.metroCancelStatus = num;
    }

    public void setMetroCancellationId(Long l) {
        this.metroCancellationId = l;
    }

    public void setMetroFromStation(String str) {
        this.metroFromStation = str;
    }

    public void setMetroFromStationColorCode(Integer num) {
        this.metroFromStationColorCode = num;
    }

    public void setMetroFromStationIndex(Integer num) {
        this.metroFromStationIndex = num;
    }

    public void setMetroGstCharge(Float f) {
        this.metroGstCharge = f;
    }

    public void setMetroJourneyDate(Date date) {
        this.metroJourneyDate = date;
    }

    public void setMetroPassengerList(List<C1283nl> list) {
        this.metroPassengerList = list;
    }

    public void setMetroRefundAmount(Integer num) {
        this.metroRefundAmount = num;
    }

    public void setMetroServiceOptedDate(Date date) {
        this.metroServiceOptedDate = date;
    }

    public void setMetroTicketFare(Integer num) {
        this.metroTicketFare = num;
    }

    public void setMetroToStation(String str) {
        this.metroToStation = str;
    }

    public void setMetroToStationColorCode(Integer num) {
        this.metroToStationColorCode = num;
    }

    public void setMetroToStationIndex(Integer num) {
        this.metroToStationIndex = num;
    }

    public void setNumberOfCancelPsgn(Short sh) {
        this.numberOfCancelPsgn = sh;
    }

    public void setNumberOfPassengerOpted(Short sh) {
        this.numberOfPassengerOpted = sh;
    }

    public void setReservationId(String str) {
        this.reservationId = str;
    }

    public void setServiceStatus(Integer num) {
        this.serviceStatus = num;
    }

    public void setServiceType(Integer num) {
        this.serviceType = num;
    }

    public void setTotalAmount(Double d) {
        this.totalAmount = d;
    }

    public void setTransactionStatus(Integer num) {
        this.transactionStatus = num;
    }

    public String toString() {
        return "MetroServiceDetailsDTO [dmrcServiceId=" + this.dmrcServiceId + ", metroCancelStatus=" + this.metroCancelStatus + ", currentCancelStatusString=" + this.currentCancelStatusString + ", metroCancellationId=" + this.metroCancellationId + ", metroRefundAmount=" + this.metroRefundAmount + ", addOnOptedBankName=" + this.addOnOptedBankName + ", metroCancelCharge=" + this.metroCancelCharge + ", addonCancelDate=" + this.addonCancelDate + ", metroCancelPsgnFare=" + this.metroCancelPsgnFare + ", metroTicketFare=" + this.metroTicketFare + ", metroJourneyDate=" + this.metroJourneyDate + ", metroFromStationIndex=" + this.metroFromStationIndex + ", metroToStationIndex=" + this.metroToStationIndex + ", metroFromStation=" + this.metroFromStation + ", metroToStation=" + this.metroToStation + ", metroFromStationColorCode=" + this.metroFromStationColorCode + ", metroToStationColorCode=" + this.metroToStationColorCode + ", numberOfPassengerOpted=" + this.numberOfPassengerOpted + ", numberOfCancelPsgn=" + this.numberOfCancelPsgn + ", totalAmount=" + this.totalAmount + ", metroServiceOptedDate=" + this.metroServiceOptedDate + ", dmrcServiceCharge=" + this.dmrcServiceCharge + ", dmrcCarbonValue=" + this.dmrcCarbonValue + ", dmrcCarbonMessage=" + this.dmrcCarbonMessage + ", dmrcBookingMode=" + this.dmrcBookingMode + ", metroGstCharge=" + this.metroGstCharge + ", metroPassengerList=" + this.metroPassengerList + "]";
    }
}
