package defpackage;

import cris.prs.webservices.dto.MealItemDetails;
import cris.prs.webservices.dto.PassengerDetailDTO;
import cris.prs.webservices.dto.a;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: Ga  reason: default package and case insensitive filesystem */
/* compiled from: EnquiryRequestDTO */
public final class C0515Ga extends a {
    public static final String AVLBLTY_ONLY = "1";
    public static final String FARE_AVLBLTY = "3";
    public static final String FARE_ONLY = "2";
    private static final long serialVersionUID = 1;
    private ArrayList<MealItemDetails> addMealDetail;
    private boolean addWPServiceCharge;
    private String agentDeviceId;
    private boolean agentOtpBooking;
    private boolean applyLimitCheck;
    private String atasOpted;
    private Boolean autoUpgradationSelected;
    private int bankId;
    private String boardingStation;
    private long bookNowPressTimeDiff;
    private long bookingInitTime;
    private String bookingOTP;
    private String captcha;
    private int captureAddress;
    private boolean choiceIgnored;
    private String clientTransactionId;
    private String clusterFlag = "N";
    private String clusterJourneyClass;
    private String coachId;
    private String cod = "false";
    private boolean concessionBooking;
    private C0587M6 connectedPnrDataDTO;
    private boolean connectingJourney;
    private boolean covid19;
    private String enquiryType = FARE_AVLBLTY;
    private String enrouteStation;
    private Boolean extraActivity;
    private String freeCanFeesFlag;
    private boolean ftBooking;
    private boolean generalPsgn;
    private boolean generalistChildConfirm;
    private Boolean gnToCkOpted;
    private C1133ge gstDetails;
    private long hrmsTxnId;
    private C1281nf iTicketDetailsDTO;
    private Boolean ignoreChoiceIfWl;
    private ArrayList<Df> infantList = null;
    private boolean loyaltyAccrualBookingFlag;
    private long loyaltyNo;
    private boolean loyaltyRedemptionBooking;
    private String mainJourneyPnr;
    private Long mainJourneyTktId;
    private Long mainJourneyTxnId;
    private String mobileNumber;
    private Boolean moreThanOneDay;
    private boolean mpBooking;
    private boolean mpPsgnPresent;
    private Short mpSecType;
    private boolean multiLapBooking;
    private String name;
    private long nget_transaction_id;
    private boolean nosbBooking;
    private String onwardFlag = "N";
    private boolean otpBooking;
    private ArrayList<PassengerDetailDTO> passengerList = null;
    private short paymentType;
    private Short reservationChoice;
    private String reservationMode = "WS_TA_B2C";
    private String reservationUptoStation;
    private boolean returnJourney;
    private boolean rlyPassBooking;
    private String ssQuotaSplitCoach;
    private Short ticketChoiceLowerBerth;
    private Boolean ticketChoiceSameCoach;
    private String ticketType;
    private C1281nf tktAddress;
    private Byte trainOwner;
    private Boolean travelInsuranceOpted;
    private String travelProtectFlag;
    private boolean twoPhaseAuthRequired;
    private String viaPointStation;
    private Short warrentType;
    private boolean zeroServiceCharge;

    public C0515Ga() {
        Boolean bool = Boolean.FALSE;
        this.autoUpgradationSelected = bool;
        this.gnToCkOpted = bool;
        this.ticketChoiceSameCoach = bool;
        this.ignoreChoiceIfWl = Boolean.TRUE;
        this.paymentType = 1;
        this.twoPhaseAuthRequired = false;
        this.addMealDetail = null;
        this.captureAddress = 0;
        this.loyaltyAccrualBookingFlag = false;
        this.generalPsgn = false;
        this.addWPServiceCharge = false;
    }

    public ArrayList<MealItemDetails> getAddMealDetail() {
        return this.addMealDetail;
    }

    public String getAgentDeviceId() {
        return this.agentDeviceId;
    }

    public String getAtasOpted() {
        return this.atasOpted;
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

    public String getCoachId() {
        return this.coachId;
    }

    public String getCod() {
        return this.cod;
    }

    public C0587M6 getConnectedPnrDataDTO() {
        return this.connectedPnrDataDTO;
    }

    public String getEnquiryType() {
        return this.enquiryType;
    }

    public String getEnrouteStation() {
        return this.enrouteStation;
    }

    public Boolean getExtraActivity() {
        return this.extraActivity;
    }

    public String getFreeCanFeesFlag() {
        return this.freeCanFeesFlag;
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

    public ArrayList<Df> getInfantList() {
        return this.infantList;
    }

    public long getLoyaltyNo() {
        return this.loyaltyNo;
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

    public ArrayList<PassengerDetailDTO> getPassengerList() {
        return this.passengerList;
    }

    public short getPaymentType() {
        return this.paymentType;
    }

    public Short getReservationChoice() {
        return this.reservationChoice;
    }

    public String getReservationMode() {
        return this.reservationMode;
    }

    public String getReservationUptoStation() {
        return this.reservationUptoStation;
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

    public String getTicketType() {
        return this.ticketType;
    }

    public C1281nf getTktAddress() {
        return this.tktAddress;
    }

    public Byte getTrainOwner() {
        return this.trainOwner;
    }

    public Boolean getTravelInsuranceOpted() {
        return this.travelInsuranceOpted;
    }

    public String getTravelProtectFlag() {
        return this.travelProtectFlag;
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

    public boolean isAddWPServiceCharge() {
        return this.addWPServiceCharge;
    }

    public boolean isAgentOtpBooking() {
        return this.agentOtpBooking;
    }

    public boolean isApplyLimitCheck() {
        return this.applyLimitCheck;
    }

    public Boolean isAutoUpgradationSelected() {
        return this.autoUpgradationSelected;
    }

    public boolean isChoiceIgnored() {
        return this.choiceIgnored;
    }

    public boolean isConcessionBooking() {
        return this.concessionBooking;
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

    public boolean isGeneralPsgn() {
        return this.generalPsgn;
    }

    public boolean isGeneralistChildConfirm() {
        return this.generalistChildConfirm;
    }

    public Boolean isIgnoreChoiceIfWl() {
        return this.ignoreChoiceIfWl;
    }

    public boolean isLoyaltyAccrualBookingFlag() {
        return this.loyaltyAccrualBookingFlag;
    }

    public boolean isLoyaltyRedemptionBooking() {
        return this.loyaltyRedemptionBooking;
    }

    public Boolean isMoreThanOneDay() {
        return this.moreThanOneDay;
    }

    public boolean isMpBooking() {
        return this.mpBooking;
    }

    public boolean isMpPsgnPresent() {
        return this.mpPsgnPresent;
    }

    public boolean isMultiLapBooking() {
        return this.multiLapBooking;
    }

    public boolean isNosbBooking() {
        return this.nosbBooking;
    }

    public boolean isOtpBooking() {
        return this.otpBooking;
    }

    public boolean isReturnJourney() {
        return this.returnJourney;
    }

    public boolean isRlyPassBooking() {
        return this.rlyPassBooking;
    }

    public boolean isTwoPhaseAuthRequired() {
        return this.twoPhaseAuthRequired;
    }

    public boolean isZeroServiceCharge() {
        return this.zeroServiceCharge;
    }

    public void setAddMealDetail(ArrayList<MealItemDetails> arrayList) {
        this.addMealDetail = arrayList;
    }

    public void setAddWPServiceCharge(boolean z) {
        this.addWPServiceCharge = z;
    }

    public void setAgentDeviceId(String str) {
        this.agentDeviceId = str;
    }

    public void setAgentOtpBooking(boolean z) {
        this.agentOtpBooking = z;
    }

    public void setApplyLimitCheck(boolean z) {
        this.applyLimitCheck = z;
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

    public void setChoiceIgnored(boolean z) {
        this.choiceIgnored = z;
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

    public void setCoachId(String str) {
        this.coachId = str;
    }

    public void setCod(String str) {
        this.cod = str;
    }

    public void setConcessionBooking(boolean z) {
        this.concessionBooking = z;
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

    public void setEnquiryType(String str) {
        this.enquiryType = str;
    }

    public void setEnrouteStation(String str) {
        this.enrouteStation = str;
    }

    public void setExtraActivity(Boolean bool) {
        this.extraActivity = bool;
    }

    public void setFreeCanFeesFlag(String str) {
        this.freeCanFeesFlag = str;
    }

    public void setFtBooking(boolean z) {
        this.ftBooking = z;
    }

    public void setGeneralPsgn(boolean z) {
        this.generalPsgn = z;
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

    public void setIgnoreChoiceIfWl(Boolean bool) {
        this.ignoreChoiceIfWl = bool;
    }

    public void setInfantList(ArrayList<Df> arrayList) {
        this.infantList = arrayList;
    }

    public void setLoyaltyAccrualBookingFlag(boolean z) {
        this.loyaltyAccrualBookingFlag = z;
    }

    public void setLoyaltyNo(long j) {
        this.loyaltyNo = j;
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

    public void setMpPsgnPresent(boolean z) {
        this.mpPsgnPresent = z;
    }

    public void setMpSecType(Short sh) {
        this.mpSecType = sh;
    }

    public void setMultiLapBooking(boolean z) {
        this.multiLapBooking = z;
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

    public void setPassengerList(ArrayList<PassengerDetailDTO> arrayList) {
        this.passengerList = arrayList;
    }

    public void setPaymentType(short s) {
        this.paymentType = s;
    }

    public void setReservationChoice(Short sh) {
        this.reservationChoice = sh;
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

    public void setRlyPassBooking(boolean z) {
        this.rlyPassBooking = z;
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

    public void setTicketType(String str) {
        this.ticketType = str;
    }

    public void setTktAddress(C1281nf nfVar) {
        this.tktAddress = nfVar;
    }

    public void setTrainOwner(Byte b) {
        this.trainOwner = b;
    }

    public void setTravelInsuranceOpted(Boolean bool) {
        this.travelInsuranceOpted = bool;
    }

    public void setTravelProtectFlag(String str) {
        this.travelProtectFlag = str;
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

    public void setZeroServiceCharge(boolean z) {
        this.zeroServiceCharge = z;
    }

    public void setiTicketDetailsDTO(C1281nf nfVar) {
        this.iTicketDetailsDTO = nfVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("EnquiryRequestDTO [moreThanOneDay=");
        sb.append(this.moreThanOneDay);
        sb.append(", passengerList=");
        sb.append(this.passengerList);
        sb.append(", infantList=");
        sb.append(this.infantList);
        sb.append(", enquiryType=");
        sb.append(this.enquiryType);
        sb.append(", clientTransactionId=");
        sb.append(this.clientTransactionId);
        sb.append(", boardingStation=");
        sb.append(this.boardingStation);
        sb.append(", reservationUptoStation=");
        sb.append(this.reservationUptoStation);
        sb.append(", mobileNumber=");
        sb.append(this.mobileNumber);
        sb.append(", ticketType=");
        sb.append(this.ticketType);
        sb.append(", enrouteStation=");
        sb.append(this.enrouteStation);
        sb.append(", viaPointStation=");
        sb.append(this.viaPointStation);
        sb.append(", mainJourneyTxnId=");
        sb.append(this.mainJourneyTxnId);
        sb.append(", mainJourneyTktId=");
        sb.append(this.mainJourneyTktId);
        sb.append(", clusterJourneyClass=");
        sb.append(this.clusterJourneyClass);
        sb.append(", clusterFlag=");
        sb.append(this.clusterFlag);
        sb.append(", onwardFlag=");
        sb.append(this.onwardFlag);
        sb.append(", mainJourneyPnr=");
        sb.append(this.mainJourneyPnr);
        sb.append(", cod=");
        sb.append(this.cod);
        sb.append(", reservationMode=");
        sb.append(this.reservationMode);
        sb.append(", agentDeviceId=");
        sb.append(this.agentDeviceId);
        sb.append(", atasOpted=");
        sb.append(this.atasOpted);
        sb.append(", ssQuotaSplitCoach=");
        sb.append(this.ssQuotaSplitCoach);
        sb.append(", captcha=");
        sb.append(this.captcha);
        sb.append(", concessionBooking=");
        sb.append(this.concessionBooking);
        sb.append(", generalistChildConfirm=");
        sb.append(this.generalistChildConfirm);
        sb.append(", ftBooking=");
        sb.append(this.ftBooking);
        sb.append(", loyaltyRedemptionBooking=");
        sb.append(this.loyaltyRedemptionBooking);
        sb.append(", bookingOTP=");
        sb.append(this.bookingOTP);
        sb.append(", otpBooking=");
        sb.append(this.otpBooking);
        sb.append(", mpBooking=");
        sb.append(this.mpBooking);
        sb.append(", mpSecType=");
        sb.append(this.mpSecType);
        sb.append(", nosbBooking=");
        sb.append(this.nosbBooking);
        sb.append(", warrentType=");
        sb.append(this.warrentType);
        sb.append(", trainOwner=");
        sb.append(this.trainOwner);
        sb.append(", autoUpgradationSelected=");
        sb.append(this.autoUpgradationSelected);
        sb.append(", gnToCkOpted=");
        sb.append(this.gnToCkOpted);
        sb.append(", ticketChoiceLowerBerth=");
        sb.append(this.ticketChoiceLowerBerth);
        sb.append(", ticketChoiceSameCoach=");
        sb.append(this.ticketChoiceSameCoach);
        sb.append(", coachId=");
        sb.append(this.coachId);
        sb.append(", reservationChoice=");
        sb.append(this.reservationChoice);
        sb.append(", ignoreChoiceIfWl=");
        sb.append(this.ignoreChoiceIfWl);
        sb.append(", travelInsuranceOpted=");
        sb.append(this.travelInsuranceOpted);
        sb.append(", gstDetails=");
        sb.append(this.gstDetails);
        sb.append(", iTicketDetailsDTO=");
        sb.append(this.iTicketDetailsDTO);
        sb.append(", bookingInitTime=");
        sb.append(this.bookingInitTime);
        sb.append(", bookNowPressTimeDiff=");
        sb.append(this.bookNowPressTimeDiff);
        sb.append(", returnJourney=");
        sb.append(this.returnJourney);
        sb.append(", connectingJourney=");
        sb.append(this.connectingJourney);
        sb.append(", connectedPnrDataDTO=");
        sb.append(this.connectedPnrDataDTO);
        sb.append(", paymentType=");
        sb.append(this.paymentType);
        sb.append(", twoPhaseAuthRequired=");
        sb.append(this.twoPhaseAuthRequired);
        sb.append(", addMealDetail=");
        sb.append(this.addMealDetail);
        sb.append(", captureAddress=");
        sb.append(this.captureAddress);
        sb.append(", tktAddress=");
        sb.append(this.tktAddress);
        sb.append(", covid19=");
        sb.append(this.covid19);
        sb.append(", nget_transaction_id=");
        sb.append(this.nget_transaction_id);
        sb.append(", hrmsTxnId=");
        sb.append(this.hrmsTxnId);
        sb.append(", rlyPassBooking=");
        sb.append(this.rlyPassBooking);
        sb.append(", multiLapBooking=");
        sb.append(this.multiLapBooking);
        sb.append(", agentOtpBooking=");
        sb.append(this.agentOtpBooking);
        sb.append(", extraActivity=");
        sb.append(this.extraActivity);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", freeCanFeesFlag=");
        sb.append(this.freeCanFeesFlag);
        sb.append(", travelProtectFlag=");
        sb.append(this.travelProtectFlag);
        sb.append(", mpPsgnPresent=");
        sb.append(this.mpPsgnPresent);
        sb.append(", applyLimitCheck=");
        sb.append(this.applyLimitCheck);
        sb.append(", loyaltyNo=");
        sb.append(this.loyaltyNo);
        sb.append(", zeroServiceCharge=");
        sb.append(this.zeroServiceCharge);
        sb.append(", bankId=");
        sb.append(this.bankId);
        sb.append(", choiceIgnored=");
        sb.append(this.choiceIgnored);
        sb.append(", loyaltyAccrualBookingFlag=");
        sb.append(this.loyaltyAccrualBookingFlag);
        sb.append(", generalPsgn=");
        sb.append(this.generalPsgn);
        sb.append(", addWPServiceCharge=");
        return xx.G(sb, this.addWPServiceCharge, "]");
    }
}
