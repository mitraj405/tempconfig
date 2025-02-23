package cris.prs.webservices.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public final class BookingResponseDTO extends C0693Tb {
    private static final long serialVersionUID = 1;
    private boolean addOnOpted;
    private C0792b0 addOnOptedDetail;
    private String arrivalTime;
    private String ataspnrNumber;
    private String autoUpgradeChoice;
    private Boolean avlForVikalp;
    private String bankName;
    private String bankNameDis;
    private String bankPaymentMode;
    private String bankRefundRefNo;
    private String bankRefundtransactionId;
    private String boardingStnName;
    private String bookedQuota;
    private Date bookingDate;
    private String bookingErrorMessage;
    private String bookingFuelCharge;
    private String bookingResvCharge;
    private String bookingSuperFastCharge;
    private String bookingTatkalCharge;
    private ArrayList<Short> buttons;
    private Boolean canSpouseFlag = Boolean.FALSE;
    private Double cancellationCharge;
    private String cancellationDate;
    private ArrayList<C1510z4> cancellationDetails;
    private String cancellationId;
    private String cancellationStatus;
    private String childPnrNumber;
    private String childReservationId;
    private String clientTransactionId;
    private int complaintFlag;
    private String connectingPnrNumber;
    private String curFuelCharge;
    private String curResvCharge;
    private String curSuperFastCharge;
    private String curTatkalCharge;
    private String currentPrsAmt;
    private String departureTime;
    private Date destArrvDate;
    private String destStn;
    private String dispatchDate;
    private String dmrcBankName;
    private double dmrcCancellationCharge;
    private long dmrcCancellationId;
    private double dmrcRefundAmount;
    private Date dmrcRefundDate;
    private String dmrcRefundStatus;
    private String dmrcRefundStatusDes;
    private int dmrcRefundStatusId;
    private List<String> dutiesMessage;
    private List<String> dutiesMessageLap1;
    private List<String> dutiesMessageLap2;
    private boolean eligibleForMetro;
    private List<String> ersDisplayMessage;
    private List<String> ersDisplayMessageLap1;
    private List<String> ersDisplayMessageLap2;
    private Boolean ersGovMsg;
    private String failureReason;
    private String fromStn;
    private String fromStnName;
    private String gnToCkOpt;
    private C1110fe gstCharge;
    private C1133ge gstDetailsDTO;
    private Boolean gstFlag;
    private String ignoreChoiceIf;
    private ArrayList<Df> infantDetails;
    private String[] informationMessage;
    private Double insuranceCharge;
    private String insuranceCompany;
    private String insuranceCompanyUrl;
    private String insuranceOpted;
    private C1281nf itTicketDetailsDTO;
    private String journeyClass;
    private Integer journeyLap = 0;
    private String journeyQuota;
    private int lapNumber;
    private String lapNumberEtTkt;
    private Boolean linkedPnr;
    private boolean mahakalFlag;
    private String mainPnrNumber;
    private String mainReservationId;
    private long mealCancellationId;
    private boolean mealChoiceEnable;
    private String mealRefundStatus;
    private C0597Mk mealTransaction;
    private String metroFromStation;
    private C1303ol metroServiceDetail;
    private boolean metroServiceOpted;
    private String metroToStation;
    private String mlAgentUserId;
    private Date mlBoardingDate;
    private Date mlDestArrivalDate;
    private String mlJourneyFrom;
    private String mlJourneyTime;
    private String mlJourneyTo;
    private int mlJourneyType;
    private Integer mlNumberOfTicket;
    private int mlReservationStatus;
    private long mlTimeDiff = 0;
    private Double mlTotalAmount;
    private Date mlTransactionDate;
    private int mlTransactionStatus;
    private long mlUserId;
    private Integer monthBkgTicket;
    private boolean multiLapFlag = false;
    private String noOfBkdChild;
    private String noOfBkdPsgn;
    private String noOfCanChild;
    private String noOfCanPsgn;
    private Short numberOfAdults;
    private Short numberOfChilds;
    private Short numberOfpassenger;
    private String paymentStatus;
    private Integer pnrLinkStatus;
    private String pnrNumber;
    private Boolean pocFlag;
    private String policyIssueDate;
    private String policyStatus;
    private String postBankRefundTxnId;
    private String postMealBankName;
    private String postMealBankRefundTxnId;
    private double postMealCancellationCharge;
    private int postMealComplaintFlag;
    private boolean postMealOpt;
    private double postMealRefundAmount;
    private Date postMealRefundDate;
    private String postMealRefundId;
    private String postMealRefundStatusDes;
    private int postMealRefundStatusId;
    private String postRefundId;
    private String prefCoachId;
    private String prsBookingResponse;
    private ArrayList<PassengerDetailDTO> psgnDtlList;
    private String qrCodeText;
    private Long reasonIndex;
    private String reasonType;
    private Double refundAmount;
    private Date refundDate;
    private String refundId;
    private String refundStatusDes;
    private String refundStatusEtTkt;
    private Integer refundStatusId;
    private String requestedClientTransactionId;
    private String reservationId;
    private String reservationStatus;
    private String reservationUpTo;
    private ArrayList<C0514GA> resvDetails;
    private String resvnUptoStn;
    private String resvnUptoStnName;
    private Boolean retryBooking;
    private String retryWithoutChoice;
    private String rrHbFlag;
    private String rsvnStatusLap1;
    private String rsvnStatusLap2;
    private boolean sai;
    private Boolean scheduleArrivalFlag;
    private Boolean scheduleDepartureFlag;
    private boolean sectorId;
    private String sectorName;
    private Double serviceChargeTotal;
    private Integer softFlag;
    private String taServiceCharge;
    private C0456Az tdrDetailsDTO = null;
    private String tdrFilingDate;
    private Double ticketAmount;
    private String ticketChoiceBerth;
    private String ticketChoiceCoach;
    private String ticketStatus;
    private String ticketType;
    private long timeDiff = 0;
    private Short timeTableFlag;
    private String tktBookedFrom;
    private String tktLegendMessage;
    private Double totalCollectibleAmount;
    private double totalRefundAmount;
    private String tourismUrl;
    private String trainChartStatus;
    private String trainNumber;
    private Date trainStartDate;
    private Double transactionAmt;
    private Date transactionDate;
    private String transactionId;
    private String transactionStatusEtTkt;
    private boolean travelProtectOpted;
    private float travelnsuranceRefundAmount;
    private JB userDetail;
    private ArrayList<c> vikalpDTO;
    private c vikalpPsgnDTO;
    private String vikalpStatus;

    public C0792b0 getAddOnOptedDetail() {
        return this.addOnOptedDetail;
    }

    public String getArrivalTime() {
        return this.arrivalTime;
    }

    public String getAtaspnrNumber() {
        return this.ataspnrNumber;
    }

    public String getAutoUpgradeChoice() {
        return this.autoUpgradeChoice;
    }

    public Boolean getAvlForVikalp() {
        return this.avlForVikalp;
    }

    public String getBankName() {
        return this.bankName;
    }

    public String getBankNameDis() {
        return this.bankNameDis;
    }

    public String getBankPaymentMode() {
        return this.bankPaymentMode;
    }

    public String getBankRefundRefNo() {
        return this.bankRefundRefNo;
    }

    public String getBankRefundtransactionId() {
        return this.bankRefundtransactionId;
    }

    public String getBoardingStnName() {
        return this.boardingStnName;
    }

    public String getBookedQuota() {
        return this.bookedQuota;
    }

    public Date getBookingDate() {
        return this.bookingDate;
    }

    public String getBookingErrorMessage() {
        return this.bookingErrorMessage;
    }

    public String getBookingFuelCharge() {
        return this.bookingFuelCharge;
    }

    public String getBookingResvCharge() {
        return this.bookingResvCharge;
    }

    public String getBookingSuperFastCharge() {
        return this.bookingSuperFastCharge;
    }

    public String getBookingTatkalCharge() {
        return this.bookingTatkalCharge;
    }

    public ArrayList<Short> getButtons() {
        return this.buttons;
    }

    public Boolean getCanSpouseFlag() {
        return this.canSpouseFlag;
    }

    public Double getCancellationCharge() {
        return this.cancellationCharge;
    }

    public String getCancellationDate() {
        return this.cancellationDate;
    }

    public ArrayList<C1510z4> getCancellationDetails() {
        return this.cancellationDetails;
    }

    public String getCancellationId() {
        return this.cancellationId;
    }

    public String getCancellationStatus() {
        return this.cancellationStatus;
    }

    public String getChildPnrNumber() {
        return this.childPnrNumber;
    }

    public String getChildReservationId() {
        return this.childReservationId;
    }

    public String getClientTransactionId() {
        return this.clientTransactionId;
    }

    public int getComplaintFlag() {
        return this.complaintFlag;
    }

    public String getConnectingPnrNumber() {
        return this.connectingPnrNumber;
    }

    public String getCurFuelCharge() {
        return this.curFuelCharge;
    }

    public String getCurResvCharge() {
        return this.curResvCharge;
    }

    public String getCurSuperFastCharge() {
        return this.curSuperFastCharge;
    }

    public String getCurTatkalCharge() {
        return this.curTatkalCharge;
    }

    public String getCurrentPrsAmt() {
        return this.currentPrsAmt;
    }

    public String getDepartureTime() {
        return this.departureTime;
    }

    public Date getDestArrvDate() {
        return this.destArrvDate;
    }

    public String getDestStn() {
        return this.destStn;
    }

    public String getDispatchDate() {
        return this.dispatchDate;
    }

    public String getDmrcBankName() {
        return this.dmrcBankName;
    }

    public double getDmrcCancellationCharge() {
        return this.dmrcCancellationCharge;
    }

    public long getDmrcCancellationId() {
        return this.dmrcCancellationId;
    }

    public double getDmrcRefundAmount() {
        return this.dmrcRefundAmount;
    }

    public Date getDmrcRefundDate() {
        return this.dmrcRefundDate;
    }

    public String getDmrcRefundStatus() {
        return this.dmrcRefundStatus;
    }

    public String getDmrcRefundStatusDes() {
        return this.dmrcRefundStatusDes;
    }

    public int getDmrcRefundStatusId() {
        return this.dmrcRefundStatusId;
    }

    public List<String> getDutiesMessage() {
        return this.dutiesMessage;
    }

    public List<String> getDutiesMessageLap1() {
        return this.dutiesMessageLap1;
    }

    public List<String> getDutiesMessageLap2() {
        return this.dutiesMessageLap2;
    }

    public List<String> getErsDisplayMessage() {
        return this.ersDisplayMessage;
    }

    public List<String> getErsDisplayMessageLap1() {
        return this.ersDisplayMessageLap1;
    }

    public List<String> getErsDisplayMessageLap2() {
        return this.ersDisplayMessageLap2;
    }

    public Boolean getErsGovMsg() {
        return this.ersGovMsg;
    }

    public String getFailureReason() {
        return this.failureReason;
    }

    public String getFromStn() {
        return this.fromStn;
    }

    public String getFromStnName() {
        return this.fromStnName;
    }

    public String getGnToCkOpt() {
        return this.gnToCkOpt;
    }

    public C1110fe getGstCharge() {
        return this.gstCharge;
    }

    public C1133ge getGstDetailsDTO() {
        return this.gstDetailsDTO;
    }

    public Boolean getGstFlag() {
        return this.gstFlag;
    }

    public String getIgnoreChoiceIf() {
        return this.ignoreChoiceIf;
    }

    public ArrayList<Df> getInfantDetails() {
        return this.infantDetails;
    }

    public String[] getInformationMessage() {
        return this.informationMessage;
    }

    public Double getInsuranceCharge() {
        return this.insuranceCharge;
    }

    public String getInsuranceCompany() {
        return this.insuranceCompany;
    }

    public String getInsuranceCompanyUrl() {
        return this.insuranceCompanyUrl;
    }

    public String getInsuranceOpted() {
        return this.insuranceOpted;
    }

    public C1281nf getItTicketDetailsDTO() {
        return this.itTicketDetailsDTO;
    }

    public String getJourneyClass() {
        return this.journeyClass;
    }

    public Integer getJourneyLap() {
        return this.journeyLap;
    }

    public String getJourneyQuota() {
        return this.journeyQuota;
    }

    public int getLapNumber() {
        return this.lapNumber;
    }

    public String getLapNumberEtTkt() {
        return this.lapNumberEtTkt;
    }

    public Boolean getLinkedPnr() {
        return this.linkedPnr;
    }

    public String getMainPnrNumber() {
        return this.mainPnrNumber;
    }

    public String getMainReservationId() {
        return this.mainReservationId;
    }

    public long getMealCancellationId() {
        return this.mealCancellationId;
    }

    public String getMealRefundStatus() {
        return this.mealRefundStatus;
    }

    public C0597Mk getMealTransaction() {
        return this.mealTransaction;
    }

    public String getMetroFromStation() {
        return this.metroFromStation;
    }

    public C1303ol getMetroServiceDetail() {
        return this.metroServiceDetail;
    }

    public String getMetroToStation() {
        return this.metroToStation;
    }

    public String getMlAgentUserId() {
        return this.mlAgentUserId;
    }

    public Date getMlBoardingDate() {
        return this.mlBoardingDate;
    }

    public Date getMlDestArrivalDate() {
        return this.mlDestArrivalDate;
    }

    public String getMlJourneyFrom() {
        return this.mlJourneyFrom;
    }

    public String getMlJourneyTime() {
        return this.mlJourneyTime;
    }

    public String getMlJourneyTo() {
        return this.mlJourneyTo;
    }

    public int getMlJourneyType() {
        return this.mlJourneyType;
    }

    public Integer getMlNumberOfTicket() {
        return this.mlNumberOfTicket;
    }

    public int getMlReservationStatus() {
        return this.mlReservationStatus;
    }

    public long getMlTimeDiff() {
        return this.mlTimeDiff;
    }

    public Double getMlTotalAmount() {
        return this.mlTotalAmount;
    }

    public Date getMlTransactionDate() {
        return this.mlTransactionDate;
    }

    public int getMlTransactionStatus() {
        return this.mlTransactionStatus;
    }

    public long getMlUserId() {
        return this.mlUserId;
    }

    public Integer getMonthBkgTicket() {
        return this.monthBkgTicket;
    }

    public String getNoOfBkdChild() {
        return this.noOfBkdChild;
    }

    public String getNoOfBkdPsgn() {
        return this.noOfBkdPsgn;
    }

    public String getNoOfCanChild() {
        return this.noOfCanChild;
    }

    public String getNoOfCanPsgn() {
        return this.noOfCanPsgn;
    }

    public Short getNumberOfAdults() {
        return this.numberOfAdults;
    }

    public Short getNumberOfChilds() {
        return this.numberOfChilds;
    }

    public Short getNumberOfpassenger() {
        return this.numberOfpassenger;
    }

    public String getPaymentStatus() {
        return this.paymentStatus;
    }

    public Integer getPnrLinkStatus() {
        return this.pnrLinkStatus;
    }

    public String getPnrNumber() {
        return this.pnrNumber;
    }

    public Boolean getPocFlag() {
        return this.pocFlag;
    }

    public String getPolicyIssueDate() {
        return this.policyIssueDate;
    }

    public String getPolicyStatus() {
        return this.policyStatus;
    }

    public String getPostBankRefundTxnId() {
        return this.postBankRefundTxnId;
    }

    public String getPostMealBankName() {
        return this.postMealBankName;
    }

    public String getPostMealBankRefundTxnId() {
        return this.postMealBankRefundTxnId;
    }

    public double getPostMealCancellationCharge() {
        return this.postMealCancellationCharge;
    }

    public int getPostMealComplaintFlag() {
        return this.postMealComplaintFlag;
    }

    public double getPostMealRefundAmount() {
        return this.postMealRefundAmount;
    }

    public Date getPostMealRefundDate() {
        return this.postMealRefundDate;
    }

    public String getPostMealRefundId() {
        return this.postMealRefundId;
    }

    public String getPostMealRefundStatusDes() {
        return this.postMealRefundStatusDes;
    }

    public int getPostMealRefundStatusId() {
        return this.postMealRefundStatusId;
    }

    public String getPostRefundId() {
        return this.postRefundId;
    }

    public String getPrefCoachId() {
        return this.prefCoachId;
    }

    public String getPrsBookingResponse() {
        return this.prsBookingResponse;
    }

    public ArrayList<PassengerDetailDTO> getPsgnDtlList() {
        return this.psgnDtlList;
    }

    public String getQrCodeText() {
        return this.qrCodeText;
    }

    public Long getReasonIndex() {
        return this.reasonIndex;
    }

    public String getReasonType() {
        return this.reasonType;
    }

    public Double getRefundAmount() {
        return this.refundAmount;
    }

    public Date getRefundDate() {
        return this.refundDate;
    }

    public String getRefundId() {
        return this.refundId;
    }

    public String getRefundStatusDes() {
        return this.refundStatusDes;
    }

    public String getRefundStatusEtTkt() {
        return this.refundStatusEtTkt;
    }

    public Integer getRefundStatusId() {
        return this.refundStatusId;
    }

    public String getRequestedClientTransactionId() {
        return this.requestedClientTransactionId;
    }

    public String getReservationId() {
        return this.reservationId;
    }

    public String getReservationStatus() {
        return this.reservationStatus;
    }

    public String getReservationUpTo() {
        return this.reservationUpTo;
    }

    public ArrayList<C0514GA> getResvDetails() {
        return this.resvDetails;
    }

    public String getResvnUptoStn() {
        return this.resvnUptoStn;
    }

    public String getResvnUptoStnName() {
        return this.resvnUptoStnName;
    }

    public Boolean getRetryBooking() {
        return this.retryBooking;
    }

    public String getRetryWithoutChoice() {
        return this.retryWithoutChoice;
    }

    public String getRrHbFlag() {
        return this.rrHbFlag;
    }

    public String getRsvnStatusLap1() {
        return this.rsvnStatusLap1;
    }

    public String getRsvnStatusLap2() {
        return this.rsvnStatusLap2;
    }

    public Boolean getScheduleArrivalFlag() {
        return this.scheduleArrivalFlag;
    }

    public Boolean getScheduleDepartureFlag() {
        return this.scheduleDepartureFlag;
    }

    public boolean getSectorId() {
        return this.sectorId;
    }

    public String getSectorName() {
        return this.sectorName;
    }

    public Double getServiceChargeTotal() {
        return this.serviceChargeTotal;
    }

    public Integer getSoftFlag() {
        return this.softFlag;
    }

    public String getTaServiceCharge() {
        return this.taServiceCharge;
    }

    public C0456Az getTdrDetailsDTO() {
        return this.tdrDetailsDTO;
    }

    public String getTdrFilingDate() {
        return this.tdrFilingDate;
    }

    public Double getTicketAmount() {
        return this.ticketAmount;
    }

    public String getTicketChoiceBerth() {
        return this.ticketChoiceBerth;
    }

    public String getTicketChoiceCoach() {
        return this.ticketChoiceCoach;
    }

    public String getTicketStatus() {
        return this.ticketStatus;
    }

    public String getTicketType() {
        return this.ticketType;
    }

    public long getTimeDiff() {
        return this.timeDiff;
    }

    public Short getTimeTableFlag() {
        return this.timeTableFlag;
    }

    public String getTktBookedFrom() {
        return this.tktBookedFrom;
    }

    public String getTktLegendMessage() {
        return this.tktLegendMessage;
    }

    public Double getTotalCollectibleAmount() {
        return this.totalCollectibleAmount;
    }

    public double getTotalRefundAmount() {
        return this.totalRefundAmount;
    }

    public String getTourismUrl() {
        return this.tourismUrl;
    }

    public String getTrainChartStatus() {
        return this.trainChartStatus;
    }

    public String getTrainNumber() {
        return this.trainNumber;
    }

    public Date getTrainStartDate() {
        return this.trainStartDate;
    }

    public Double getTransactionAmt() {
        return this.transactionAmt;
    }

    public Date getTransactionDate() {
        return this.transactionDate;
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public String getTransactionStatusEtTkt() {
        return this.transactionStatusEtTkt;
    }

    public float getTravelnsuranceRefundAmount() {
        return this.travelnsuranceRefundAmount;
    }

    public JB getUserDetail() {
        return this.userDetail;
    }

    public ArrayList<c> getVikalpDTO() {
        return this.vikalpDTO;
    }

    public c getVikalpPsgnDTO() {
        return this.vikalpPsgnDTO;
    }

    public String getVikalpStatus() {
        return this.vikalpStatus;
    }

    public boolean isAddOnOpted() {
        return this.addOnOpted;
    }

    public boolean isEligibleForMetro() {
        return this.eligibleForMetro;
    }

    public boolean isMahakalFlag() {
        return this.mahakalFlag;
    }

    public boolean isMealChoiceEnable() {
        return this.mealChoiceEnable;
    }

    public boolean isMetroServiceOpted() {
        return this.metroServiceOpted;
    }

    public boolean isMultiLapFlag() {
        return this.multiLapFlag;
    }

    public boolean isPostMealOpt() {
        return this.postMealOpt;
    }

    public boolean isSai() {
        return this.sai;
    }

    public boolean isTravelProtectOpted() {
        return this.travelProtectOpted;
    }

    public void setAddOnOpted(boolean z) {
        this.addOnOpted = z;
    }

    public void setAddOnOptedDetail(C0792b0 b0Var) {
        this.addOnOptedDetail = b0Var;
    }

    public void setArrivalTime(String str) {
        this.arrivalTime = str;
    }

    public void setAtaspnrNumber(String str) {
        this.ataspnrNumber = str;
    }

    public void setAutoUpgradeChoice(String str) {
        this.autoUpgradeChoice = str;
    }

    public void setAvlForVikalp(Boolean bool) {
        this.avlForVikalp = bool;
    }

    public void setBankName(String str) {
        this.bankName = str;
    }

    public void setBankNameDis(String str) {
        this.bankNameDis = str;
    }

    public void setBankPaymentMode(String str) {
        this.bankPaymentMode = str;
    }

    public void setBankRefundRefNo(String str) {
        this.bankRefundRefNo = str;
    }

    public void setBankRefundtransactionId(String str) {
        this.bankRefundtransactionId = str;
    }

    public void setBoardingStnName(String str) {
        this.boardingStnName = str;
    }

    public void setBookedQuota(String str) {
        this.bookedQuota = str;
    }

    public void setBookingDate(Date date) {
        this.bookingDate = date;
    }

    public void setBookingErrorMessage(String str) {
        this.bookingErrorMessage = str;
    }

    public void setBookingFuelCharge(String str) {
        this.bookingFuelCharge = str;
    }

    public void setBookingResvCharge(String str) {
        this.bookingResvCharge = str;
    }

    public void setBookingSuperFastCharge(String str) {
        this.bookingSuperFastCharge = str;
    }

    public void setBookingTatkalCharge(String str) {
        this.bookingTatkalCharge = str;
    }

    public void setButtons(ArrayList<Short> arrayList) {
        this.buttons = arrayList;
    }

    public void setCanSpouseFlag(Boolean bool) {
        this.canSpouseFlag = bool;
    }

    public void setCancellationCharge(Double d) {
        this.cancellationCharge = d;
    }

    public void setCancellationDate(String str) {
        this.cancellationDate = str;
    }

    public void setCancellationDetails(ArrayList<C1510z4> arrayList) {
        this.cancellationDetails = arrayList;
    }

    public void setCancellationId(String str) {
        this.cancellationId = str;
    }

    public void setCancellationStatus(String str) {
        this.cancellationStatus = str;
    }

    public void setChildPnrNumber(String str) {
        this.childPnrNumber = str;
    }

    public void setChildReservationId(String str) {
        this.childReservationId = str;
    }

    public void setClientTransactionId(String str) {
        this.clientTransactionId = str;
    }

    public void setComplaintFlag(int i) {
        this.complaintFlag = i;
    }

    public void setConnectingPnrNumber(String str) {
        this.connectingPnrNumber = str;
    }

    public void setCurFuelCharge(String str) {
        this.curFuelCharge = str;
    }

    public void setCurResvCharge(String str) {
        this.curResvCharge = str;
    }

    public void setCurSuperFastCharge(String str) {
        this.curSuperFastCharge = str;
    }

    public void setCurTatkalCharge(String str) {
        this.curTatkalCharge = str;
    }

    public void setCurrentPrsAmt(String str) {
        this.currentPrsAmt = str;
    }

    public void setDepartureTime(String str) {
        this.departureTime = str;
    }

    public void setDestArrvDate(Date date) {
        this.destArrvDate = date;
    }

    public void setDestStn(String str) {
        this.destStn = str;
    }

    public void setDispatchDate(String str) {
        this.dispatchDate = str;
    }

    public void setDmrcBankName(String str) {
        this.dmrcBankName = str;
    }

    public void setDmrcCancellationCharge(double d) {
        this.dmrcCancellationCharge = d;
    }

    public void setDmrcCancellationId(long j) {
        this.dmrcCancellationId = j;
    }

    public void setDmrcRefundAmount(double d) {
        this.dmrcRefundAmount = d;
    }

    public void setDmrcRefundDate(Date date) {
        this.dmrcRefundDate = date;
    }

    public void setDmrcRefundStatus(String str) {
        this.dmrcRefundStatus = str;
    }

    public void setDmrcRefundStatusDes(String str) {
        this.dmrcRefundStatusDes = str;
    }

    public void setDmrcRefundStatusId(int i) {
        this.dmrcRefundStatusId = i;
    }

    public void setDutiesMessage(List<String> list) {
        this.dutiesMessage = list;
    }

    public void setDutiesMessageLap1(List<String> list) {
        this.dutiesMessageLap1 = list;
    }

    public void setDutiesMessageLap2(List<String> list) {
        this.dutiesMessageLap2 = list;
    }

    public void setEligibleForMetro(boolean z) {
        this.eligibleForMetro = z;
    }

    public void setErsDisplayMessage(List<String> list) {
        this.ersDisplayMessage = list;
    }

    public void setErsDisplayMessageLap1(List<String> list) {
        this.ersDisplayMessageLap1 = list;
    }

    public void setErsDisplayMessageLap2(List<String> list) {
        this.ersDisplayMessageLap2 = list;
    }

    public void setErsGovMsg(Boolean bool) {
        this.ersGovMsg = bool;
    }

    public void setFailureReason(String str) {
        this.failureReason = str;
    }

    public void setFromStn(String str) {
        this.fromStn = str;
    }

    public void setFromStnName(String str) {
        this.fromStnName = str;
    }

    public void setGnToCkOpt(String str) {
        this.gnToCkOpt = str;
    }

    public void setGstCharge(C1110fe feVar) {
        this.gstCharge = feVar;
    }

    public void setGstDetailsDTO(C1133ge geVar) {
        this.gstDetailsDTO = geVar;
    }

    public void setGstFlag(Boolean bool) {
        this.gstFlag = bool;
    }

    public void setIgnoreChoiceIf(String str) {
        this.ignoreChoiceIf = str;
    }

    public void setInfantDetails(ArrayList<Df> arrayList) {
        this.infantDetails = arrayList;
    }

    public void setInformationMessage(String[] strArr) {
        this.informationMessage = strArr;
    }

    public void setInsuranceCharge(Double d) {
        this.insuranceCharge = d;
    }

    public void setInsuranceCompany(String str) {
        this.insuranceCompany = str;
    }

    public void setInsuranceCompanyUrl(String str) {
        this.insuranceCompanyUrl = str;
    }

    public void setInsuranceOpted(String str) {
        this.insuranceOpted = str;
    }

    public void setItTicketDetailsDTO(C1281nf nfVar) {
        this.itTicketDetailsDTO = nfVar;
    }

    public void setJourneyClass(String str) {
        this.journeyClass = str;
    }

    public void setJourneyLap(Integer num) {
        this.journeyLap = num;
    }

    public void setJourneyQuota(String str) {
        this.journeyQuota = str;
    }

    public void setLapNumber(int i) {
        this.lapNumber = i;
    }

    public void setLapNumberEtTkt(String str) {
        this.lapNumberEtTkt = str;
    }

    public void setLinkedPnr(Boolean bool) {
        this.linkedPnr = bool;
    }

    public void setMahakalFlag(boolean z) {
        this.mahakalFlag = z;
    }

    public void setMainPnrNumber(String str) {
        this.mainPnrNumber = str;
    }

    public void setMainReservationId(String str) {
        this.mainReservationId = str;
    }

    public void setMealCancellationId(long j) {
        this.mealCancellationId = j;
    }

    public void setMealChoiceEnable(boolean z) {
        this.mealChoiceEnable = z;
    }

    public void setMealRefundStatus(String str) {
        this.mealRefundStatus = str;
    }

    public void setMealTransaction(C0597Mk mk) {
        this.mealTransaction = mk;
    }

    public void setMetroFromStation(String str) {
        this.metroFromStation = str;
    }

    public void setMetroServiceDetail(C1303ol olVar) {
        this.metroServiceDetail = olVar;
    }

    public void setMetroServiceOpted(boolean z) {
        this.metroServiceOpted = z;
    }

    public void setMetroToStation(String str) {
        this.metroToStation = str;
    }

    public void setMlAgentUserId(String str) {
        this.mlAgentUserId = str;
    }

    public void setMlBoardingDate(Date date) {
        this.mlBoardingDate = date;
    }

    public void setMlDestArrivalDate(Date date) {
        this.mlDestArrivalDate = date;
    }

    public void setMlJourneyFrom(String str) {
        this.mlJourneyFrom = str;
    }

    public void setMlJourneyTime(String str) {
        this.mlJourneyTime = str;
    }

    public void setMlJourneyTo(String str) {
        this.mlJourneyTo = str;
    }

    public void setMlJourneyType(int i) {
        this.mlJourneyType = i;
    }

    public void setMlNumberOfTicket(Integer num) {
        this.mlNumberOfTicket = num;
    }

    public void setMlReservationStatus(int i) {
        this.mlReservationStatus = i;
    }

    public void setMlTimeDiff(long j) {
        this.mlTimeDiff = j;
    }

    public void setMlTotalAmount(Double d) {
        this.mlTotalAmount = d;
    }

    public void setMlTransactionDate(Date date) {
        this.mlTransactionDate = date;
    }

    public void setMlTransactionStatus(int i) {
        this.mlTransactionStatus = i;
    }

    public void setMlUserId(long j) {
        this.mlUserId = j;
    }

    public void setMonthBkgTicket(Integer num) {
        this.monthBkgTicket = num;
    }

    public void setMultiLapFlag(boolean z) {
        this.multiLapFlag = z;
    }

    public void setNoOfBkdChild(String str) {
        this.noOfBkdChild = str;
    }

    public void setNoOfBkdPsgn(String str) {
        this.noOfBkdPsgn = str;
    }

    public void setNoOfCanChild(String str) {
        this.noOfCanChild = str;
    }

    public void setNoOfCanPsgn(String str) {
        this.noOfCanPsgn = str;
    }

    public void setNumberOfAdults(Short sh) {
        this.numberOfAdults = sh;
    }

    public void setNumberOfChilds(Short sh) {
        this.numberOfChilds = sh;
    }

    public void setNumberOfpassenger(Short sh) {
        this.numberOfpassenger = sh;
    }

    public void setPaymentStatus(String str) {
        this.paymentStatus = str;
    }

    public void setPnrLinkStatus(Integer num) {
        this.pnrLinkStatus = num;
    }

    public void setPnrNumber(String str) {
        this.pnrNumber = str;
    }

    public void setPocFlag(Boolean bool) {
        this.pocFlag = bool;
    }

    public void setPolicyIssueDate(String str) {
        this.policyIssueDate = str;
    }

    public void setPolicyStatus(String str) {
        this.policyStatus = str;
    }

    public void setPostBankRefundTxnId(String str) {
        this.postBankRefundTxnId = str;
    }

    public void setPostMealBankName(String str) {
        this.postMealBankName = str;
    }

    public void setPostMealBankRefundTxnId(String str) {
        this.postMealBankRefundTxnId = str;
    }

    public void setPostMealCancellationCharge(double d) {
        this.postMealCancellationCharge = d;
    }

    public void setPostMealComplaintFlag(int i) {
        this.postMealComplaintFlag = i;
    }

    public void setPostMealOpt(boolean z) {
        this.postMealOpt = z;
    }

    public void setPostMealRefundAmount(double d) {
        this.postMealRefundAmount = d;
    }

    public void setPostMealRefundDate(Date date) {
        this.postMealRefundDate = date;
    }

    public void setPostMealRefundId(String str) {
        this.postMealRefundId = str;
    }

    public void setPostMealRefundStatusDes(String str) {
        this.postMealRefundStatusDes = str;
    }

    public void setPostMealRefundStatusId(int i) {
        this.postMealRefundStatusId = i;
    }

    public void setPostRefundId(String str) {
        this.postRefundId = str;
    }

    public void setPrefCoachId(String str) {
        this.prefCoachId = str;
    }

    public void setPrsBookingResponse(String str) {
        this.prsBookingResponse = str;
    }

    public void setPsgnDtlList(ArrayList<PassengerDetailDTO> arrayList) {
        this.psgnDtlList = arrayList;
    }

    public void setQrCodeText(String str) {
        this.qrCodeText = str;
    }

    public void setReasonIndex(Long l) {
        this.reasonIndex = l;
    }

    public void setReasonType(String str) {
        this.reasonType = str;
    }

    public void setRefundAmount(Double d) {
        this.refundAmount = d;
    }

    public void setRefundDate(Date date) {
        this.refundDate = date;
    }

    public void setRefundId(String str) {
        this.refundId = str;
    }

    public void setRefundStatusDes(String str) {
        this.refundStatusDes = str;
    }

    public void setRefundStatusEtTkt(String str) {
        this.refundStatusEtTkt = str;
    }

    public void setRefundStatusId(Integer num) {
        this.refundStatusId = num;
    }

    public void setRequestedClientTransactionId(String str) {
        this.requestedClientTransactionId = str;
    }

    public void setReservationId(String str) {
        this.reservationId = str;
    }

    public void setReservationStatus(String str) {
        this.reservationStatus = str;
    }

    public void setReservationUpTo(String str) {
        this.reservationUpTo = str;
    }

    public void setResvDetails(ArrayList<C0514GA> arrayList) {
        this.resvDetails = arrayList;
    }

    public void setResvnUptoStn(String str) {
        this.resvnUptoStn = str;
    }

    public void setResvnUptoStnName(String str) {
        this.resvnUptoStnName = str;
    }

    public void setRetryBooking(Boolean bool) {
        this.retryBooking = bool;
    }

    public void setRetryWithoutChoice(String str) {
        this.retryWithoutChoice = str;
    }

    public void setRrHbFlag(String str) {
        this.rrHbFlag = str;
    }

    public void setRsvnStatusLap1(String str) {
        this.rsvnStatusLap1 = str;
    }

    public void setRsvnStatusLap2(String str) {
        this.rsvnStatusLap2 = str;
    }

    public void setSai(boolean z) {
        this.sai = z;
    }

    public void setScheduleArrivalFlag(Boolean bool) {
        this.scheduleArrivalFlag = bool;
    }

    public void setScheduleDepartureFlag(Boolean bool) {
        this.scheduleDepartureFlag = bool;
    }

    public void setSectorId(boolean z) {
        this.sectorId = z;
    }

    public void setSectorName(String str) {
        this.sectorName = str;
    }

    public void setServiceChargeTotal(Double d) {
        this.serviceChargeTotal = d;
    }

    public void setSoftFlag(Integer num) {
        this.softFlag = num;
    }

    public void setTaServiceCharge(String str) {
        this.taServiceCharge = str;
    }

    public void setTdrDetailsDTO(C0456Az az) {
        this.tdrDetailsDTO = az;
    }

    public void setTdrFilingDate(String str) {
        this.tdrFilingDate = str;
    }

    public void setTicketAmount(Double d) {
        this.ticketAmount = d;
    }

    public void setTicketChoiceBerth(String str) {
        this.ticketChoiceBerth = str;
    }

    public void setTicketChoiceCoach(String str) {
        this.ticketChoiceCoach = str;
    }

    public void setTicketStatus(String str) {
        this.ticketStatus = str;
    }

    public void setTicketType(String str) {
        this.ticketType = str;
    }

    public void setTimeDiff(long j) {
        this.timeDiff = j;
    }

    public void setTimeTableFlag(Short sh) {
        this.timeTableFlag = sh;
    }

    public void setTktBookedFrom(String str) {
        this.tktBookedFrom = str;
    }

    public void setTktLegendMessage(String str) {
        this.tktLegendMessage = str;
    }

    public void setTotalCollectibleAmount(Double d) {
        this.totalCollectibleAmount = d;
    }

    public void setTotalRefundAmount(double d) {
        this.totalRefundAmount = d;
    }

    public void setTourismUrl(String str) {
        this.tourismUrl = str;
    }

    public void setTrainChartStatus(String str) {
        this.trainChartStatus = str;
    }

    public void setTrainNumber(String str) {
        this.trainNumber = str;
    }

    public void setTrainStartDate(Date date) {
        this.trainStartDate = date;
    }

    public void setTransactionAmt(Double d) {
        this.transactionAmt = d;
    }

    public void setTransactionDate(Date date) {
        this.transactionDate = date;
    }

    public void setTransactionId(String str) {
        this.transactionId = str;
    }

    public void setTransactionStatusEtTkt(String str) {
        this.transactionStatusEtTkt = str;
    }

    public void setTravelProtectOpted(boolean z) {
        this.travelProtectOpted = z;
    }

    public void setTravelnsuranceRefundAmount(float f) {
        this.travelnsuranceRefundAmount = f;
    }

    public void setUserDetail(JB jb) {
        this.userDetail = jb;
    }

    public void setVikalpDTO(ArrayList<c> arrayList) {
        this.vikalpDTO = arrayList;
    }

    public void setVikalpPsgnDTO(c cVar) {
        this.vikalpPsgnDTO = cVar;
    }

    public void setVikalpStatus(String str) {
        this.vikalpStatus = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("BookingResponseDTO [transactionId=");
        sb.append(this.transactionId);
        sb.append(", reservationId=");
        sb.append(this.reservationId);
        sb.append(", lapNumber=");
        sb.append(this.lapNumber);
        sb.append(", tktBookedFrom=");
        sb.append(this.tktBookedFrom);
        sb.append(", requestedClientTransactionId=");
        sb.append(this.requestedClientTransactionId);
        sb.append(", numberOfpassenger=");
        sb.append(this.numberOfpassenger);
        sb.append(", timeTableFlag=");
        sb.append(this.timeTableFlag);
        sb.append(", pnrNumber=");
        sb.append(this.pnrNumber);
        sb.append(", departureTime=");
        sb.append(this.departureTime);
        sb.append(", arrivalTime=");
        sb.append(this.arrivalTime);
        sb.append(", reasonType=");
        sb.append(this.reasonType);
        sb.append(", reasonIndex=");
        sb.append(this.reasonIndex);
        sb.append(", informationMessage=");
        sb.append(Arrays.toString(this.informationMessage));
        sb.append(", destArrvDate=");
        sb.append(this.destArrvDate);
        sb.append(", bookingDate=");
        sb.append(this.bookingDate);
        sb.append(", numberOfChilds=");
        sb.append(this.numberOfChilds);
        sb.append(", numberOfAdults=");
        sb.append(this.numberOfAdults);
        sb.append(", trainNumber=");
        sb.append(this.trainNumber);
        sb.append(", fromStn=");
        sb.append(this.fromStn);
        sb.append(", destStn=");
        sb.append(this.destStn);
        sb.append(", resvnUptoStn=");
        sb.append(this.resvnUptoStn);
        sb.append(", fromStnName=");
        sb.append(this.fromStnName);
        sb.append(", boardingStnName=");
        sb.append(this.boardingStnName);
        sb.append(", resvnUptoStnName=");
        sb.append(this.resvnUptoStnName);
        sb.append(", journeyClass=");
        sb.append(this.journeyClass);
        sb.append(", journeyQuota=");
        sb.append(this.journeyQuota);
        sb.append(", insuranceCharge=");
        sb.append(this.insuranceCharge);
        sb.append(", totalCollectibleAmount=");
        sb.append(this.totalCollectibleAmount);
        sb.append(", cancellationCharge=");
        sb.append(this.cancellationCharge);
        sb.append(", psgnDtlList=");
        sb.append(this.psgnDtlList);
        sb.append(", retryBooking=");
        sb.append(this.retryBooking);
        sb.append(", clientTransactionId=");
        sb.append(this.clientTransactionId);
        sb.append(", bookingErrorMessage=");
        sb.append(this.bookingErrorMessage);
        sb.append(", scheduleDepartureFlag=");
        sb.append(this.scheduleDepartureFlag);
        sb.append(", scheduleArrivalFlag=");
        sb.append(this.scheduleArrivalFlag);
        sb.append(", cancellationDetails=");
        sb.append(this.cancellationDetails);
        sb.append(", resvDetails=");
        sb.append(this.resvDetails);
        sb.append(", infantDetails=");
        sb.append(this.infantDetails);
        sb.append(", noOfCanPsgn=");
        sb.append(this.noOfCanPsgn);
        sb.append(", noOfCanChild=");
        sb.append(this.noOfCanChild);
        sb.append(", transactionStatusEtTkt=");
        sb.append(this.transactionStatusEtTkt);
        sb.append(", trainChartStatus=");
        sb.append(this.trainChartStatus);
        sb.append(", currentPrsAmt=");
        sb.append(this.currentPrsAmt);
        sb.append(", taServiceCharge=");
        sb.append(this.taServiceCharge);
        sb.append(", serviceChargeTotal=");
        sb.append(this.serviceChargeTotal);
        sb.append(", prsBookingResponse=");
        sb.append(this.prsBookingResponse);
        sb.append(", trainStartDate=");
        sb.append(this.trainStartDate);
        sb.append(", tktLegendMessage=");
        sb.append(this.tktLegendMessage);
        sb.append(", bookingTatkalCharge=");
        sb.append(this.bookingTatkalCharge);
        sb.append(", bookingResvCharge=");
        sb.append(this.bookingResvCharge);
        sb.append(", bookingFuelCharge=");
        sb.append(this.bookingFuelCharge);
        sb.append(", bookingSuperFastCharge=");
        sb.append(this.bookingSuperFastCharge);
        sb.append(", curTatkalCharge=");
        sb.append(this.curTatkalCharge);
        sb.append(", curResvCharge=");
        sb.append(this.curResvCharge);
        sb.append(", curFuelCharge=");
        sb.append(this.curFuelCharge);
        sb.append(", curSuperFastCharge=");
        sb.append(this.curSuperFastCharge);
        sb.append(", refundStatusEtTkt=");
        sb.append(this.refundStatusEtTkt);
        sb.append(", refundDate=");
        sb.append(this.refundDate);
        sb.append(", ticketType=");
        sb.append(this.ticketType);
        sb.append(", retryWithoutChoice=");
        sb.append(this.retryWithoutChoice);
        sb.append(", failureReason=");
        sb.append(this.failureReason);
        sb.append(", paymentStatus=");
        sb.append(this.paymentStatus);
        sb.append(", transactionAmt=");
        sb.append(this.transactionAmt);
        sb.append(", transactionDate=");
        sb.append(this.transactionDate);
        sb.append(", cancellationId=");
        sb.append(this.cancellationId);
        sb.append(", ticketAmount=");
        sb.append(this.ticketAmount);
        sb.append(", refundAmount=");
        sb.append(this.refundAmount);
        sb.append(", cancellationStatus=");
        sb.append(this.cancellationStatus);
        sb.append(", reservationStatus=");
        sb.append(this.reservationStatus);
        sb.append(", cancellationDate=");
        sb.append(this.cancellationDate);
        sb.append(", tdrFilingDate=");
        sb.append(this.tdrFilingDate);
        sb.append(", lapNumberEtTkt=");
        sb.append(this.lapNumberEtTkt);
        sb.append(", prefCoachId=");
        sb.append(this.prefCoachId);
        sb.append(", ignoreChoiceIf=");
        sb.append(this.ignoreChoiceIf);
        sb.append(", autoUpgradeChoice=");
        sb.append(this.autoUpgradeChoice);
        sb.append(", gnToCkOpt=");
        sb.append(this.gnToCkOpt);
        sb.append(", ticketChoiceBerth=");
        sb.append(this.ticketChoiceBerth);
        sb.append(", ticketChoiceCoach=");
        sb.append(this.ticketChoiceCoach);
        sb.append(", dispatchDate=");
        sb.append(this.dispatchDate);
        sb.append(", bookedQuota=");
        sb.append(this.bookedQuota);
        sb.append(", reservationUpTo=");
        sb.append(this.reservationUpTo);
        sb.append(", noOfBkdChild=");
        sb.append(this.noOfBkdChild);
        sb.append(", noOfBkdPsgn=");
        sb.append(this.noOfBkdPsgn);
        sb.append(", policyIssueDate=");
        sb.append(this.policyIssueDate);
        sb.append(", insuranceCompany=");
        sb.append(this.insuranceCompany);
        sb.append(", insuranceCompanyUrl=");
        sb.append(this.insuranceCompanyUrl);
        sb.append(", insuranceOpted=");
        sb.append(this.insuranceOpted);
        sb.append(", policyStatus=");
        sb.append(this.policyStatus);
        sb.append(", ersGovMsg=");
        sb.append(this.ersGovMsg);
        sb.append(", avlForVikalp=");
        sb.append(this.avlForVikalp);
        sb.append(", vikalpStatus=");
        sb.append(this.vikalpStatus);
        sb.append(", ersDisplayMessage=");
        sb.append(this.ersDisplayMessage);
        sb.append(", dutiesMessage=");
        sb.append(this.dutiesMessage);
        sb.append(", bankName=");
        sb.append(this.bankName);
        sb.append(", gstCharge=");
        sb.append(this.gstCharge);
        sb.append(", gstDetailsDTO=");
        sb.append(this.gstDetailsDTO);
        sb.append(", gstFlag=");
        sb.append(this.gstFlag);
        sb.append(", itTicketDetailsDTO=");
        sb.append(this.itTicketDetailsDTO);
        sb.append(", ticketStatus=");
        sb.append(this.ticketStatus);
        sb.append(", softFlag=");
        sb.append(this.softFlag);
        sb.append(", tdrDetailsDTO=");
        sb.append(this.tdrDetailsDTO);
        sb.append(", vikalpDTO=");
        sb.append(this.vikalpDTO);
        sb.append(", ataspnrNumber=");
        sb.append(this.ataspnrNumber);
        sb.append(", userDetail=");
        sb.append(this.userDetail);
        sb.append(", mainReservationId=");
        sb.append(this.mainReservationId);
        sb.append(", mainPnrNumber=");
        sb.append(this.mainPnrNumber);
        sb.append(", childReservationId=");
        sb.append(this.childReservationId);
        sb.append(", childPnrNumber=");
        sb.append(this.childPnrNumber);
        sb.append(", linkedPnr=");
        sb.append(this.linkedPnr);
        sb.append(", buttons=");
        sb.append(this.buttons);
        sb.append(", refundId=");
        sb.append(this.refundId);
        sb.append(", bankRefundtransactionId=");
        sb.append(this.bankRefundtransactionId);
        sb.append(", monthBkgTicket=");
        sb.append(this.monthBkgTicket);
        sb.append(", sai=");
        sb.append(this.sai);
        sb.append(", pnrLinkStatus=");
        sb.append(this.pnrLinkStatus);
        sb.append(", journeyLap=");
        sb.append(this.journeyLap);
        sb.append(", connectingPnrNumber=");
        sb.append(this.connectingPnrNumber);
        sb.append(", sectorId=");
        sb.append(this.sectorId);
        sb.append(", sectorName=");
        sb.append(this.sectorName);
        sb.append(", pocFlag=");
        sb.append(this.pocFlag);
        sb.append(", canSpouseFlag=");
        sb.append(this.canSpouseFlag);
        sb.append(", mahakalFlag=");
        sb.append(this.mahakalFlag);
        sb.append(", tourismUrl=");
        sb.append(this.tourismUrl);
        sb.append(", rrHbFlag=");
        sb.append(this.rrHbFlag);
        sb.append(", mealTransaction=");
        sb.append(this.mealTransaction);
        sb.append(", mealChoiceEnable=");
        sb.append(this.mealChoiceEnable);
        sb.append(", refundStatusId=");
        sb.append(this.refundStatusId);
        sb.append(", refundStatusDes=");
        sb.append(this.refundStatusDes);
        sb.append(", bankRefundRefNo=");
        sb.append(this.bankRefundRefNo);
        sb.append(", complaintFlag=");
        sb.append(this.complaintFlag);
        sb.append(", qrCodeText=");
        sb.append(this.qrCodeText);
        sb.append(", bankNameDis=");
        sb.append(this.bankNameDis);
        sb.append(", bankPaymentMode=");
        sb.append(this.bankPaymentMode);
        sb.append(", travelnsuranceRefundAmount=");
        sb.append(this.travelnsuranceRefundAmount);
        sb.append(", totalRefundAmount=");
        sb.append(this.totalRefundAmount);
        sb.append(", addOnOpted=");
        sb.append(this.addOnOpted);
        sb.append(", addOnOptedDetail=");
        sb.append(this.addOnOptedDetail);
        sb.append(", metroServiceOpted=");
        sb.append(this.metroServiceOpted);
        sb.append(", metroServiceDetail=");
        sb.append(this.metroServiceDetail);
        sb.append(", eligibleForMetro=");
        sb.append(this.eligibleForMetro);
        sb.append(", multiLapFlag=");
        sb.append(this.multiLapFlag);
        sb.append(", mlJourneyFrom=");
        sb.append(this.mlJourneyFrom);
        sb.append(", mlJourneyTo=");
        sb.append(this.mlJourneyTo);
        sb.append(", mlJourneyTime=");
        sb.append(this.mlJourneyTime);
        sb.append(", mlTotalAmount=");
        sb.append(this.mlTotalAmount);
        sb.append(", mlNumberOfTicket=");
        sb.append(this.mlNumberOfTicket);
        sb.append(", mlUserId=");
        sb.append(this.mlUserId);
        sb.append(", mlAgentUserId=");
        sb.append(this.mlAgentUserId);
        sb.append(", mlTransactionDate=");
        sb.append(this.mlTransactionDate);
        sb.append(", mlReservationStatus=");
        sb.append(this.mlReservationStatus);
        sb.append(", mlTransactionStatus=");
        sb.append(this.mlTransactionStatus);
        sb.append(", mlJourneyType=");
        sb.append(this.mlJourneyType);
        sb.append(", mlBoardingDate=");
        sb.append(this.mlBoardingDate);
        sb.append(", mlDestArrivalDate=");
        sb.append(this.mlDestArrivalDate);
        sb.append(", timeDiff=");
        sb.append(this.timeDiff);
        sb.append(", mlTimeDiff=");
        sb.append(this.mlTimeDiff);
        sb.append(", rsvnStatusLap1=");
        sb.append(this.rsvnStatusLap1);
        sb.append(", rsvnStatusLap2=");
        sb.append(this.rsvnStatusLap2);
        sb.append(", ersDisplayMessageLap1=");
        sb.append(this.ersDisplayMessageLap1);
        sb.append(", ersDisplayMessageLap2=");
        sb.append(this.ersDisplayMessageLap2);
        sb.append(", dutiesMessageLap1=");
        sb.append(this.dutiesMessageLap1);
        sb.append(", dutiesMessageLap2=");
        sb.append(this.dutiesMessageLap2);
        sb.append(", travelProtectOpted=");
        sb.append(this.travelProtectOpted);
        sb.append(", metroFromStation=");
        sb.append(this.metroFromStation);
        sb.append(", metroToStation=");
        sb.append(this.metroToStation);
        sb.append(", mealRefundStatus=");
        sb.append(this.mealRefundStatus);
        sb.append(", postMealRefundDate=");
        sb.append(this.postMealRefundDate);
        sb.append(", postMealRefundStatusId=");
        sb.append(this.postMealRefundStatusId);
        sb.append(", postMealRefundStatusDes=");
        sb.append(this.postMealRefundStatusDes);
        sb.append(", postMealRefundAmount=");
        sb.append(this.postMealRefundAmount);
        sb.append(", postMealCancellationCharge=");
        sb.append(this.postMealCancellationCharge);
        sb.append(", postMealRefundId=");
        sb.append(this.postMealRefundId);
        sb.append(", postMealBankRefundTxnId=");
        sb.append(this.postMealBankRefundTxnId);
        sb.append(", postMealComplaintFlag=");
        sb.append(this.postMealComplaintFlag);
        sb.append(", postMealBankName=");
        sb.append(this.postMealBankName);
        sb.append(", postMealOpt=");
        sb.append(this.postMealOpt);
        sb.append(", mealCancellationId=");
        sb.append(this.mealCancellationId);
        sb.append(", dmrcRefundStatus=");
        sb.append(this.dmrcRefundStatus);
        sb.append(", dmrcRefundDate=");
        sb.append(this.dmrcRefundDate);
        sb.append(", dmrcRefundStatusId=");
        sb.append(this.dmrcRefundStatusId);
        sb.append(", dmrcRefundStatusDes=");
        sb.append(this.dmrcRefundStatusDes);
        sb.append(", dmrcRefundAmount=");
        sb.append(this.dmrcRefundAmount);
        sb.append(", dmrcCancellationCharge=");
        sb.append(this.dmrcCancellationCharge);
        sb.append(", postRefundId=");
        sb.append(this.postRefundId);
        sb.append(", postBankRefundTxnId=");
        sb.append(this.postBankRefundTxnId);
        sb.append(", dmrcBankName=");
        sb.append(this.dmrcBankName);
        sb.append(", dmrcCancellationId=");
        return lf.l(sb, this.dmrcCancellationId, "]");
    }
}
