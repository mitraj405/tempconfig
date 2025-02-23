package cris.prs.webservices.dto;

import java.io.Serializable;
import java.util.Date;

public final class PassengerDetailDTO implements Serializable {
    private static final long serialVersionUID = 1;
    private String berth_class_I;
    private String berth_class_II;
    private String bookingBerthCode;
    private short bookingBerthNo;
    private String bookingCoachId;
    private String bookingStatus;
    private String bookingStatusCode;
    private String bookingStatusDetails;
    private short bookingStatusIndex;
    private String cardIssueDate;
    private Boolean childBerthFlag;
    private Boolean childPassenger;
    private Boolean concessionOpted;
    private String currentBerthChoice;
    private String currentBerthCode;
    private short currentBerthNo;
    private String currentCoachId;
    private String currentStatus;
    private String currentStatusDetails;
    private short currentStatusIndex;
    private Date dateOfBirth;
    private boolean dropWaitlistFlag;
    private String error;
    private float fareChargedPercentage = 0.0f;
    private String foodChoice;
    private Boolean forGoConcessionOpted;
    private Long hrmsTxnId;
    private String insuranceIssued;
    private String issuingAuthority;
    private String issuingStation;
    private String issuingZone;
    private Short memberType;
    private Long mpID;
    private String passBookingCode;
    private String passType;
    private Long passUPN = 0L;
    private Short passengerAge;
    private String passengerBedrollChoice;
    private String passengerBerthChoice;
    private String passengerCabinCoupe;
    private String passengerCancellationDate;
    private String passengerCardNumber;
    private String passengerCardType;
    private String passengerConcession;
    private Integer passengerDynamicFare;
    private String passengerFoodChoice;
    private String passengerForceNumber;
    private String passengerGender;
    private String passengerGenderCode;
    private boolean passengerIcardFlag;
    private String passengerName;
    private String passengerNationality;
    private Integer passengerNetFare;
    private Short passengerSerialNumber;
    private Float paymentValue;
    private String policyNumber;
    private Short psgnAmountDeducted;
    private Short psgnAmountRefunded;
    protected String psgnConcCardExpiryDate;
    protected String psgnConcCardId;
    protected String psgnConcDOB;
    protected String psgnConcType;
    private short psgnwlType;
    private Short secretariatType;
    private Boolean softMemberFlag;
    private Long softMemberId;
    private String validationFlag = "N";
    private Integer verificationStatus;
    private String verificationStatusString;

    public String getBerth_class_I() {
        return this.berth_class_I;
    }

    public String getBerth_class_II() {
        return this.berth_class_II;
    }

    public String getBookingBerthCode() {
        return this.bookingBerthCode;
    }

    public short getBookingBerthNo() {
        return this.bookingBerthNo;
    }

    public String getBookingCoachId() {
        return this.bookingCoachId;
    }

    public String getBookingStatus() {
        return this.bookingStatus;
    }

    public String getBookingStatusCode() {
        return this.bookingStatusCode;
    }

    public String getBookingStatusDetails() {
        return this.bookingStatusDetails;
    }

    public short getBookingStatusIndex() {
        return this.bookingStatusIndex;
    }

    public String getCardIssueDate() {
        return this.cardIssueDate;
    }

    public Boolean getChildBerthFlag() {
        return this.childBerthFlag;
    }

    public Boolean getChildPassenger() {
        return this.childPassenger;
    }

    public Boolean getConcessionOpted() {
        return this.concessionOpted;
    }

    public String getCurrentBerthChoice() {
        return this.currentBerthChoice;
    }

    public String getCurrentBerthCode() {
        return this.currentBerthCode;
    }

    public short getCurrentBerthNo() {
        return this.currentBerthNo;
    }

    public String getCurrentCoachId() {
        return this.currentCoachId;
    }

    public String getCurrentStatus() {
        return this.currentStatus;
    }

    public String getCurrentStatusDetails() {
        return this.currentStatusDetails;
    }

    public short getCurrentStatusIndex() {
        return this.currentStatusIndex;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public String getError() {
        return this.error;
    }

    public float getFareChargedPercentage() {
        return this.fareChargedPercentage;
    }

    public String getFoodChoice() {
        return this.foodChoice;
    }

    public Boolean getForGoConcessionOpted() {
        return this.forGoConcessionOpted;
    }

    public Long getHrmsTxnId() {
        return this.hrmsTxnId;
    }

    public String getInsuranceIssued() {
        return this.insuranceIssued;
    }

    public String getIssuingAuthority() {
        return this.issuingAuthority;
    }

    public String getIssuingStation() {
        return this.issuingStation;
    }

    public String getIssuingZone() {
        return this.issuingZone;
    }

    public Short getMemberType() {
        return this.memberType;
    }

    public Long getMpID() {
        return this.mpID;
    }

    public String getPassBookingCode() {
        return this.passBookingCode;
    }

    public String getPassType() {
        return this.passType;
    }

    public Long getPassUPN() {
        return this.passUPN;
    }

    public Short getPassengerAge() {
        return this.passengerAge;
    }

    public String getPassengerBedrollChoice() {
        return this.passengerBedrollChoice;
    }

    public String getPassengerBerthChoice() {
        return this.passengerBerthChoice;
    }

    public String getPassengerCabinCoupe() {
        return this.passengerCabinCoupe;
    }

    public String getPassengerCancellationDate() {
        return this.passengerCancellationDate;
    }

    public String getPassengerCardNumber() {
        return this.passengerCardNumber;
    }

    public String getPassengerCardType() {
        return this.passengerCardType;
    }

    public String getPassengerConcession() {
        return this.passengerConcession;
    }

    public Integer getPassengerDynamicFare() {
        return this.passengerDynamicFare;
    }

    public String getPassengerFoodChoice() {
        return this.passengerFoodChoice;
    }

    public String getPassengerForceNumber() {
        return this.passengerForceNumber;
    }

    public String getPassengerGender() {
        return this.passengerGender;
    }

    public String getPassengerGenderCode() {
        return this.passengerGenderCode;
    }

    public String getPassengerName() {
        return this.passengerName;
    }

    public String getPassengerNationality() {
        return this.passengerNationality;
    }

    public Integer getPassengerNetFare() {
        return this.passengerNetFare;
    }

    public Short getPassengerSerialNumber() {
        return this.passengerSerialNumber;
    }

    public Float getPaymentValue() {
        return this.paymentValue;
    }

    public String getPolicyNumber() {
        return this.policyNumber;
    }

    public Short getPsgnAmountDeducted() {
        return this.psgnAmountDeducted;
    }

    public Short getPsgnAmountRefunded() {
        return this.psgnAmountRefunded;
    }

    public String getPsgnConcCardExpiryDate() {
        return this.psgnConcCardExpiryDate;
    }

    public String getPsgnConcCardId() {
        return this.psgnConcCardId;
    }

    public String getPsgnConcDOB() {
        return this.psgnConcDOB;
    }

    public String getPsgnConcType() {
        return this.psgnConcType;
    }

    public short getPsgnwlType() {
        return this.psgnwlType;
    }

    public Short getSecretariatType() {
        return this.secretariatType;
    }

    public Boolean getSoftMemberFlag() {
        return this.softMemberFlag;
    }

    public Long getSoftMemberId() {
        return this.softMemberId;
    }

    public String getValidationFlag() {
        return this.validationFlag;
    }

    public Integer getVerificationStatus() {
        return this.verificationStatus;
    }

    public String getVerificationStatusString() {
        return this.verificationStatusString;
    }

    public boolean isDropWaitlistFlag() {
        return this.dropWaitlistFlag;
    }

    public boolean isPassengerIcardFlag() {
        return this.passengerIcardFlag;
    }

    public void setBerth_class_I(String str) {
        this.berth_class_I = str;
    }

    public void setBerth_class_II(String str) {
        this.berth_class_II = str;
    }

    public void setBookingBerthCode(String str) {
        this.bookingBerthCode = str;
    }

    public void setBookingBerthNo(short s) {
        this.bookingBerthNo = s;
    }

    public void setBookingCoachId(String str) {
        this.bookingCoachId = str;
    }

    public void setBookingStatus(String str) {
        this.bookingStatus = str;
    }

    public void setBookingStatusCode(String str) {
        this.bookingStatusCode = str;
    }

    public void setBookingStatusDetails(String str) {
        this.bookingStatusDetails = str;
    }

    public void setBookingStatusIndex(short s) {
        this.bookingStatusIndex = s;
    }

    public void setCardIssueDate(String str) {
        this.cardIssueDate = str;
    }

    public void setChildBerthFlag(Boolean bool) {
        this.childBerthFlag = bool;
    }

    public void setChildPassenger(Boolean bool) {
        this.childPassenger = bool;
    }

    public void setConcessionOpted(Boolean bool) {
        this.concessionOpted = bool;
    }

    public void setCurrentBerthChoice(String str) {
        this.currentBerthChoice = str;
    }

    public void setCurrentBerthCode(String str) {
        this.currentBerthCode = str;
    }

    public void setCurrentBerthNo(short s) {
        this.currentBerthNo = s;
    }

    public void setCurrentCoachId(String str) {
        this.currentCoachId = str;
    }

    public void setCurrentStatus(String str) {
        this.currentStatus = str;
    }

    public void setCurrentStatusDetails(String str) {
        this.currentStatusDetails = str;
    }

    public void setCurrentStatusIndex(short s) {
        this.currentStatusIndex = s;
    }

    public void setDateOfBirth(Date date) {
        this.dateOfBirth = date;
    }

    public void setDropWaitlistFlag(boolean z) {
        this.dropWaitlistFlag = z;
    }

    public void setError(String str) {
        this.error = str;
    }

    public void setFareChargedPercentage(float f) {
        this.fareChargedPercentage = f;
    }

    public void setFoodChoice(String str) {
        this.foodChoice = str;
    }

    public void setForGoConcessionOpted(Boolean bool) {
        this.forGoConcessionOpted = bool;
    }

    public void setHrmsTxnId(Long l) {
        this.hrmsTxnId = l;
    }

    public void setInsuranceIssued(String str) {
        this.insuranceIssued = str;
    }

    public void setIssuingAuthority(String str) {
        this.issuingAuthority = str;
    }

    public void setIssuingStation(String str) {
        this.issuingStation = str;
    }

    public void setIssuingZone(String str) {
        this.issuingZone = str;
    }

    public void setMemberType(Short sh) {
        this.memberType = sh;
    }

    public void setMpID(Long l) {
        this.mpID = l;
    }

    public void setPassBookingCode(String str) {
        this.passBookingCode = str;
    }

    public void setPassType(String str) {
        this.passType = str;
    }

    public void setPassUPN(Long l) {
        this.passUPN = l;
    }

    public void setPassengerAge(Short sh) {
        this.passengerAge = sh;
    }

    public void setPassengerBedrollChoice(String str) {
        this.passengerBedrollChoice = str;
    }

    public void setPassengerBerthChoice(String str) {
        this.passengerBerthChoice = str;
    }

    public void setPassengerCabinCoupe(String str) {
        this.passengerCabinCoupe = str;
    }

    public void setPassengerCancellationDate(String str) {
        this.passengerCancellationDate = str;
    }

    public void setPassengerCardNumber(String str) {
        this.passengerCardNumber = str;
    }

    public void setPassengerCardType(String str) {
        this.passengerCardType = str;
    }

    public void setPassengerConcession(String str) {
        this.passengerConcession = str;
    }

    public void setPassengerDynamicFare(Integer num) {
        this.passengerDynamicFare = num;
    }

    public void setPassengerFoodChoice(String str) {
        this.passengerFoodChoice = str;
    }

    public void setPassengerForceNumber(String str) {
        this.passengerForceNumber = str;
    }

    public void setPassengerGender(String str) {
        this.passengerGender = str;
    }

    public void setPassengerGenderCode(String str) {
        this.passengerGenderCode = str;
    }

    public void setPassengerIcardFlag(boolean z) {
        this.passengerIcardFlag = z;
    }

    public void setPassengerName(String str) {
        this.passengerName = str;
    }

    public void setPassengerNationality(String str) {
        this.passengerNationality = str;
    }

    public void setPassengerNetFare(Integer num) {
        this.passengerNetFare = num;
    }

    public void setPassengerSerialNumber(Short sh) {
        this.passengerSerialNumber = sh;
    }

    public void setPaymentValue(Float f) {
        this.paymentValue = f;
    }

    public void setPolicyNumber(String str) {
        this.policyNumber = str;
    }

    public void setPsgnAmountDeducted(Short sh) {
        this.psgnAmountDeducted = sh;
    }

    public void setPsgnAmountRefunded(Short sh) {
        this.psgnAmountRefunded = sh;
    }

    public void setPsgnConcCardExpiryDate(String str) {
        this.psgnConcCardExpiryDate = str;
    }

    public void setPsgnConcCardId(String str) {
        this.psgnConcCardId = str;
    }

    public void setPsgnConcDOB(String str) {
        this.psgnConcDOB = str;
    }

    public void setPsgnConcType(String str) {
        this.psgnConcType = str;
    }

    public void setPsgnwlType(short s) {
        this.psgnwlType = s;
    }

    public void setSecretariatType(Short sh) {
        this.secretariatType = sh;
    }

    public void setSoftMemberFlag(Boolean bool) {
        this.softMemberFlag = bool;
    }

    public void setSoftMemberId(Long l) {
        this.softMemberId = l;
    }

    public void setValidationFlag(String str) {
        this.validationFlag = str;
    }

    public void setVerificationStatus(Integer num) {
        this.verificationStatus = num;
    }

    public void setVerificationStatusString(String str) {
        this.verificationStatusString = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PassengerDetailDTO [passengerSerialNumber=");
        sb.append(this.passengerSerialNumber);
        sb.append(", passengerName=");
        sb.append(this.passengerName);
        sb.append(", passengerAge=");
        sb.append(this.passengerAge);
        sb.append(", passengerGender=");
        sb.append(this.passengerGender);
        sb.append(", passengerGenderCode=");
        sb.append(this.passengerGenderCode);
        sb.append(", passengerBerthChoice=");
        sb.append(this.passengerBerthChoice);
        sb.append(", passengerFoodChoice=");
        sb.append(this.passengerFoodChoice);
        sb.append(", passengerBedrollChoice=");
        sb.append(this.passengerBedrollChoice);
        sb.append(", passengerConcession=");
        sb.append(this.passengerConcession);
        sb.append(", passengerDynamicFare=");
        sb.append(this.passengerDynamicFare);
        sb.append(", psgnAmountDeducted=");
        sb.append(this.psgnAmountDeducted);
        sb.append(", psgnAmountRefunded=");
        sb.append(this.psgnAmountRefunded);
        sb.append(", concessionOpted=");
        sb.append(this.concessionOpted);
        sb.append(", forGoConcessionOpted=");
        sb.append(this.forGoConcessionOpted);
        sb.append(", passengerIcardFlag=");
        sb.append(this.passengerIcardFlag);
        sb.append(", passengerCardType=");
        sb.append(this.passengerCardType);
        sb.append(", passengerCardNumber=");
        sb.append(this.passengerCardNumber);
        sb.append(", childBerthFlag=");
        sb.append(this.childBerthFlag);
        sb.append(", passengerNationality=");
        sb.append(this.passengerNationality);
        sb.append(", childPassenger=");
        sb.append(this.childPassenger);
        sb.append(", softMemberFlag=");
        sb.append(this.softMemberFlag);
        sb.append(", softMemberId=");
        sb.append(this.softMemberId);
        sb.append(", psgnConcType=");
        sb.append(this.psgnConcType);
        sb.append(", psgnConcCardId=");
        sb.append(this.psgnConcCardId);
        sb.append(", psgnConcDOB=");
        sb.append(this.psgnConcDOB);
        sb.append(", psgnConcCardExpiryDate=");
        sb.append(this.psgnConcCardExpiryDate);
        sb.append(", mpID=");
        sb.append(this.mpID);
        sb.append(", secretariatType=");
        sb.append(this.secretariatType);
        sb.append(", memberType=");
        sb.append(this.memberType);
        sb.append(", cardIssueDate=");
        sb.append(this.cardIssueDate);
        sb.append(", dateOfBirth=");
        sb.append(this.dateOfBirth);
        sb.append(", error=");
        sb.append(this.error);
        sb.append(", passengerForceNumber=");
        sb.append(this.passengerForceNumber);
        sb.append(", verificationStatus=");
        sb.append(this.verificationStatus);
        sb.append(", verificationStatusString=");
        sb.append(this.verificationStatusString);
        sb.append(", passUPN=");
        sb.append(this.passUPN);
        sb.append(", passBookingCode=");
        sb.append(this.passBookingCode);
        sb.append(", fareChargedPercentage=");
        sb.append(this.fareChargedPercentage);
        sb.append(", berth_class_I=");
        sb.append(this.berth_class_I);
        sb.append(", berth_class_II=");
        sb.append(this.berth_class_II);
        sb.append(", passType=");
        sb.append(this.passType);
        sb.append(", issuingZone=");
        sb.append(this.issuingZone);
        sb.append(", issuingAuthority=");
        sb.append(this.issuingAuthority);
        sb.append(", issuingStation=");
        sb.append(this.issuingStation);
        sb.append(", hrmsTxnId=");
        sb.append(this.hrmsTxnId);
        sb.append(", validationFlag=");
        sb.append(this.validationFlag);
        sb.append(", paymentValue=");
        sb.append(this.paymentValue);
        sb.append(", bookingStatusIndex=");
        sb.append(this.bookingStatusIndex);
        sb.append(", bookingStatus=");
        sb.append(this.bookingStatus);
        sb.append(", bookingCoachId=");
        sb.append(this.bookingCoachId);
        sb.append(", bookingBerthNo=");
        sb.append(this.bookingBerthNo);
        sb.append(", bookingBerthCode=");
        sb.append(this.bookingBerthCode);
        sb.append(", bookingStatusDetails=");
        sb.append(this.bookingStatusDetails);
        sb.append(", currentStatusIndex=");
        sb.append(this.currentStatusIndex);
        sb.append(", currentStatus=");
        sb.append(this.currentStatus);
        sb.append(", currentCoachId=");
        sb.append(this.currentCoachId);
        sb.append(", currentBerthNo=");
        sb.append(this.currentBerthNo);
        sb.append(", currentBerthCode=");
        sb.append(this.currentBerthCode);
        sb.append(", passengerNetFare=");
        sb.append(this.passengerNetFare);
        sb.append(", foodChoice=");
        sb.append(this.foodChoice);
        sb.append(", currentBerthChoice=");
        sb.append(this.currentBerthChoice);
        sb.append(", currentStatusDetails=");
        sb.append(this.currentStatusDetails);
        sb.append(", insuranceIssued=");
        sb.append(this.insuranceIssued);
        sb.append(", policyNumber=");
        sb.append(this.policyNumber);
        sb.append(", passengerCancellationDate=");
        sb.append(this.passengerCancellationDate);
        sb.append(", psgnwlType=");
        sb.append(this.psgnwlType);
        sb.append(", dropWaitlistFlag=");
        sb.append(this.dropWaitlistFlag);
        sb.append(", bookingStatusCode=");
        sb.append(this.bookingStatusCode);
        sb.append(", passengerCabinCoupe=");
        return C0709Uj.j(sb, this.passengerCabinCoupe, "]");
    }
}
