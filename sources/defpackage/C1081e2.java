package defpackage;

import cris.prs.webservices.dto.a;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: e2  reason: default package and case insensitive filesystem */
/* compiled from: AvlRequestDTO */
public final class C1081e2 extends a {
    private static final long serialVersionUID = 1;
    private String agentDeviceId;
    private ArrayList<C1469x0> alternateAvlInputDTO;
    private String atasOpted;
    private Boolean autoUpgradationSelected;
    private int bankId;
    private String boardingStation;
    private long bookNowPressTimeDiff;
    private int bookingChoice;
    private int bookingConfirmChoice;
    private long bookingInitTime;
    private String bookingOTP;
    private String captcha;
    private int captureAddress;
    private String clientTransactionId;
    private String clusterFlag = "N";
    private String clusterJourneyClass;
    private String cod = "false";
    private C0587M6 connectedPnrDataDTO;
    private boolean connectingJourney;
    private boolean covid19;
    private String enrouteStation;
    private boolean ftBooking;
    private boolean generalistChildConfirm;
    private Boolean gnToCkOpted;
    private C1133ge gstDetails;
    private long hrmsTxnId;
    private C1281nf iTicketDetailsDTO;
    private boolean journalistBooking;
    private ArrayList<C0668Rh> lapAvlRequestDTO;
    private boolean loyaltyAccuralBooking;
    private String loyaltyBankId;
    private String loyaltyNumber;
    private boolean loyaltyRedemptionBooking;
    private String mainJourneyPnr;
    private Long mainJourneyTktId;
    private Long mainJourneyTxnId;
    private String mobileNumber;
    private Boolean moreThanOneDay;
    private boolean mpBooking;
    private Short mpSecType;
    private String name;
    private long nget_transaction_id;
    private boolean nosbBooking;
    private String onwardFlag = "N";
    private boolean otpBooking;
    private boolean passBooking;
    private short paymentType;
    private String reservationMode = "WS_TA_B2C";
    private String reservationUptoStation;
    private boolean returnJourney;
    private String ticketType;
    private C1281nf tktAddress;
    private boolean twoPhaseAuthRequired;
    private String viaPointStation;
    private Short warrentType;

    public C1081e2() {
        Boolean bool = Boolean.FALSE;
        this.autoUpgradationSelected = bool;
        this.gnToCkOpted = bool;
        this.paymentType = 1;
        this.twoPhaseAuthRequired = false;
        this.captureAddress = 0;
        this.loyaltyAccuralBooking = false;
    }

    public String getAgentDeviceId() {
        return this.agentDeviceId;
    }

    public ArrayList<C1469x0> getAlternateAvlInputDTO() {
        return this.alternateAvlInputDTO;
    }

    public String getAtasOpted() {
        return this.atasOpted;
    }

    public Boolean getAutoUpgradationSelected() {
        return this.autoUpgradationSelected;
    }

    public int getBankId() {
        return this.bankId;
    }

    public String getBoardingStation() {
        return this.boardingStation;
    }

    public long getBookNowPressTimeDiff() {
        return this.bookNowPressTimeDiff;
    }

    public int getBookingChoice() {
        return this.bookingChoice;
    }

    public int getBookingConfirmChoice() {
        return this.bookingConfirmChoice;
    }

    public long getBookingInitTime() {
        return this.bookingInitTime;
    }

    public String getBookingOTP() {
        return this.bookingOTP;
    }

    public String getCaptcha() {
        return this.captcha;
    }

    public int getCaptureAddress() {
        return this.captureAddress;
    }

    public String getClientTransactionId() {
        return this.clientTransactionId;
    }

    public String getClusterFlag() {
        return this.clusterFlag;
    }

    public String getClusterJourneyClass() {
        return this.clusterJourneyClass;
    }

    public String getCod() {
        return this.cod;
    }

    public C0587M6 getConnectedPnrDataDTO() {
        return this.connectedPnrDataDTO;
    }

    public String getEnrouteStation() {
        return this.enrouteStation;
    }

    public Boolean getGnToCkOpted() {
        return this.gnToCkOpted;
    }

    public C1133ge getGstDetails() {
        return this.gstDetails;
    }

    public long getHrmsTxnId() {
        return this.hrmsTxnId;
    }

    public ArrayList<C0668Rh> getLapAvlRequestDTO() {
        return this.lapAvlRequestDTO;
    }

    public String getLoyaltyBankId() {
        return this.loyaltyBankId;
    }

    public String getLoyaltyNumber() {
        return this.loyaltyNumber;
    }

    public String getMainJourneyPnr() {
        return this.mainJourneyPnr;
    }

    public Long getMainJourneyTktId() {
        return this.mainJourneyTktId;
    }

    public Long getMainJourneyTxnId() {
        return this.mainJourneyTxnId;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public Boolean getMoreThanOneDay() {
        return this.moreThanOneDay;
    }

    public Short getMpSecType() {
        return this.mpSecType;
    }

    public String getName() {
        return this.name;
    }

    public long getNget_transaction_id() {
        return this.nget_transaction_id;
    }

    public String getOnwardFlag() {
        return this.onwardFlag;
    }

    public short getPaymentType() {
        return this.paymentType;
    }

    public String getReservationMode() {
        return this.reservationMode;
    }

    public String getReservationUptoStation() {
        return this.reservationUptoStation;
    }

    public String getTicketType() {
        return this.ticketType;
    }

    public C1281nf getTktAddress() {
        return this.tktAddress;
    }

    public String getViaPointStation() {
        return this.viaPointStation;
    }

    public Short getWarrentType() {
        return this.warrentType;
    }

    public C1281nf getiTicketDetailsDTO() {
        return this.iTicketDetailsDTO;
    }

    public boolean isConnectingJourney() {
        return this.connectingJourney;
    }

    public boolean isCovid19() {
        return this.covid19;
    }

    public boolean isFtBooking() {
        return this.ftBooking;
    }

    public boolean isGeneralistChildConfirm() {
        return this.generalistChildConfirm;
    }

    public boolean isJournalistBooking() {
        return this.journalistBooking;
    }

    public boolean isLoyaltyAccuralBooking() {
        return this.loyaltyAccuralBooking;
    }

    public boolean isLoyaltyRedemptionBooking() {
        return this.loyaltyRedemptionBooking;
    }

    public boolean isMpBooking() {
        return this.mpBooking;
    }

    public boolean isNosbBooking() {
        return this.nosbBooking;
    }

    public boolean isOtpBooking() {
        return this.otpBooking;
    }

    public boolean isPassBooking() {
        return this.passBooking;
    }

    public boolean isReturnJourney() {
        return this.returnJourney;
    }

    public boolean isTwoPhaseAuthRequired() {
        return this.twoPhaseAuthRequired;
    }

    public void setAgentDeviceId(String str) {
        this.agentDeviceId = str;
    }

    public void setAlternateAvlInputDTO(ArrayList<C1469x0> arrayList) {
        this.alternateAvlInputDTO = arrayList;
    }

    public void setAtasOpted(String str) {
        this.atasOpted = str;
    }

    public void setAutoUpgradationSelected(Boolean bool) {
        this.autoUpgradationSelected = bool;
    }

    public void setBankId(int i) {
        this.bankId = i;
    }

    public void setBoardingStation(String str) {
        this.boardingStation = str;
    }

    public void setBookNowPressTimeDiff(long j) {
        this.bookNowPressTimeDiff = j;
    }

    public void setBookingChoice(int i) {
        this.bookingChoice = i;
    }

    public void setBookingConfirmChoice(int i) {
        this.bookingConfirmChoice = i;
    }

    public void setBookingInitTime(long j) {
        this.bookingInitTime = j;
    }

    public void setBookingOTP(String str) {
        this.bookingOTP = str;
    }

    public void setCaptcha(String str) {
        this.captcha = str;
    }

    public void setCaptureAddress(int i) {
        this.captureAddress = i;
    }

    public void setClientTransactionId(String str) {
        this.clientTransactionId = str;
    }

    public void setClusterFlag(String str) {
        this.clusterFlag = str;
    }

    public void setClusterJourneyClass(String str) {
        this.clusterJourneyClass = str;
    }

    public void setCod(String str) {
        this.cod = str;
    }

    public void setConnectedPnrDataDTO(C0587M6 m6) {
        this.connectedPnrDataDTO = m6;
    }

    public void setConnectingJourney(boolean z) {
        this.connectingJourney = z;
    }

    public void setCovid19(boolean z) {
        this.covid19 = z;
    }

    public void setEnrouteStation(String str) {
        this.enrouteStation = str;
    }

    public void setFtBooking(boolean z) {
        this.ftBooking = z;
    }

    public void setGeneralistChildConfirm(boolean z) {
        this.generalistChildConfirm = z;
    }

    public void setGnToCkOpted(Boolean bool) {
        this.gnToCkOpted = bool;
    }

    public void setGstDetails(C1133ge geVar) {
        this.gstDetails = geVar;
    }

    public void setHrmsTxnId(long j) {
        this.hrmsTxnId = j;
    }

    public void setJournalistBooking(boolean z) {
        this.journalistBooking = z;
    }

    public void setLapAvlRequestDTO(ArrayList<C0668Rh> arrayList) {
        this.lapAvlRequestDTO = arrayList;
    }

    public void setLoyaltyAccuralBooking(boolean z) {
        this.loyaltyAccuralBooking = z;
    }

    public void setLoyaltyBankId(String str) {
        this.loyaltyBankId = str;
    }

    public void setLoyaltyNumber(String str) {
        this.loyaltyNumber = str;
    }

    public void setLoyaltyRedemptionBooking(boolean z) {
        this.loyaltyRedemptionBooking = z;
    }

    public void setMainJourneyPnr(String str) {
        this.mainJourneyPnr = str;
    }

    public void setMainJourneyTktId(Long l) {
        this.mainJourneyTktId = l;
    }

    public void setMainJourneyTxnId(Long l) {
        this.mainJourneyTxnId = l;
    }

    public void setMobileNumber(String str) {
        this.mobileNumber = str;
    }

    public void setMoreThanOneDay(Boolean bool) {
        this.moreThanOneDay = bool;
    }

    public void setMpBooking(boolean z) {
        this.mpBooking = z;
    }

    public void setMpSecType(Short sh) {
        this.mpSecType = sh;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNget_transaction_id(long j) {
        this.nget_transaction_id = j;
    }

    public void setNosbBooking(boolean z) {
        this.nosbBooking = z;
    }

    public void setOnwardFlag(String str) {
        this.onwardFlag = str;
    }

    public void setOtpBooking(boolean z) {
        this.otpBooking = z;
    }

    public void setPassBooking(boolean z) {
        this.passBooking = z;
    }

    public void setPaymentType(short s) {
        this.paymentType = s;
    }

    public void setReservationMode(String str) {
        this.reservationMode = str;
    }

    public void setReservationUptoStation(String str) {
        this.reservationUptoStation = str;
    }

    public void setReturnJourney(boolean z) {
        this.returnJourney = z;
    }

    public void setTicketType(String str) {
        this.ticketType = str;
    }

    public void setTktAddress(C1281nf nfVar) {
        this.tktAddress = nfVar;
    }

    public void setTwoPhaseAuthRequired(boolean z) {
        this.twoPhaseAuthRequired = z;
    }

    public void setViaPointStation(String str) {
        this.viaPointStation = str;
    }

    public void setWarrentType(Short sh) {
        this.warrentType = sh;
    }

    public void setiTicketDetailsDTO(C1281nf nfVar) {
        this.iTicketDetailsDTO = nfVar;
    }
}
