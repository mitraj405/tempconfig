package defpackage;

import cris.prs.webservices.dto.InformationMessageDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: b3  reason: default package and case insensitive filesystem */
/* compiled from: BookingConfig */
public final class C0794b3 implements Serializable {
    private static final long serialVersionUID = 1;
    private Boolean acuralBooking;
    private ArrayList<String> applicableBerthTypes;
    private boolean atasEnable;
    private boolean bedRollFlagEnabled;
    private Boolean beyondArpBooking;
    private List<String> bonafideCountryList;
    private Integer captureAddress;
    private boolean childBerthMandatory;
    private ArrayList<String> concessionalPassengerType;
    private boolean foodChoiceEnabled;
    private List<String> foodDetails;
    private boolean forgoConcession;
    private boolean gatimaanTrain;
    private boolean gstDetailInputFlag;
    private String gstinPattern;
    private boolean idRequired;
    private List<InformationMessageDTO> informationMessageDTO;
    private boolean lowerBerthApplicable;
    private short maxARPDays;
    private short maxChildAge;
    private short maxIdCardLength;
    private short maxInfants;
    private Integer maxMasterListPsgn;
    private short maxNameLength;
    private short maxPassengerAge;
    private short maxPassengers;
    private short maxPassportLength;
    private short maxRetentionDays;
    private short minIdCardLength;
    private short minNameLength;
    private short minPassengerAge;
    private short minPassportLength;
    private boolean newTimeTable;
    private C1262mo paymentOption;
    private boolean pmfInputEnable;
    private boolean pmfInputMandatory;
    private Integer pmfInputMaxLength;
    private Boolean redemptionBooking;
    private boolean seniorCitizenApplicable;
    private boolean specialTatkal;
    private short srctnwAge;
    private short srctzTAge;
    private short srctznAge;
    private boolean suvidhaTrain;
    private String trainNo;
    private String trainsiteId;
    private boolean travelInsuranceEnabled;
    private String travelInsuranceFareMsg;
    private Boolean travelProtectRedemption;
    private boolean twoSSReleaseFlag;
    private short uidMandatoryFlag;
    private short uidVerificationMasterListFlag;
    private short uidVerificationPsgnInputFlag;
    private String[] validIdCardTypes;

    public Boolean getAcuralBooking() {
        return this.acuralBooking;
    }

    public ArrayList<String> getApplicableBerthTypes() {
        return this.applicableBerthTypes;
    }

    public List<String> getBonafideCountryList() {
        return this.bonafideCountryList;
    }

    public Integer getCaptureAddress() {
        return this.captureAddress;
    }

    public ArrayList<String> getConcessionalPassengerType() {
        return this.concessionalPassengerType;
    }

    public List<String> getFoodDetails() {
        return this.foodDetails;
    }

    public String getGstinPattern() {
        return this.gstinPattern;
    }

    public List<InformationMessageDTO> getInformationMessageDTO() {
        return this.informationMessageDTO;
    }

    public short getMaxARPDays() {
        return this.maxARPDays;
    }

    public short getMaxChildAge() {
        return this.maxChildAge;
    }

    public short getMaxIdCardLength() {
        return this.maxIdCardLength;
    }

    public short getMaxInfants() {
        return this.maxInfants;
    }

    public Integer getMaxMasterListPsgn() {
        return this.maxMasterListPsgn;
    }

    public short getMaxNameLength() {
        return this.maxNameLength;
    }

    public short getMaxPassengerAge() {
        return this.maxPassengerAge;
    }

    public short getMaxPassengers() {
        return this.maxPassengers;
    }

    public short getMaxPassportLength() {
        return this.maxPassportLength;
    }

    public short getMaxRetentionDays() {
        return this.maxRetentionDays;
    }

    public short getMinIdCardLength() {
        return this.minIdCardLength;
    }

    public short getMinNameLength() {
        return this.minNameLength;
    }

    public short getMinPassengerAge() {
        return this.minPassengerAge;
    }

    public short getMinPassportLength() {
        return this.minPassportLength;
    }

    public C1262mo getPaymentOption() {
        return this.paymentOption;
    }

    public Integer getPmfInputMaxLength() {
        return this.pmfInputMaxLength;
    }

    public Boolean getRedemptionBooking() {
        return this.redemptionBooking;
    }

    public short getSrctnwAge() {
        return this.srctnwAge;
    }

    public short getSrctzTAge() {
        return this.srctzTAge;
    }

    public short getSrctznAge() {
        return this.srctznAge;
    }

    public String getTrainNo() {
        return this.trainNo;
    }

    public String getTrainsiteId() {
        return this.trainsiteId;
    }

    public String getTravelInsuranceFareMsg() {
        return this.travelInsuranceFareMsg;
    }

    public Boolean getTravelProtectRedemption() {
        return this.travelProtectRedemption;
    }

    public short getUidMandatoryFlag() {
        return this.uidMandatoryFlag;
    }

    public short getUidVerificationMasterListFlag() {
        return this.uidVerificationMasterListFlag;
    }

    public short getUidVerificationPsgnInputFlag() {
        return this.uidVerificationPsgnInputFlag;
    }

    public String[] getValidIdCardTypes() {
        return this.validIdCardTypes;
    }

    public boolean isAtasEnable() {
        return this.atasEnable;
    }

    public boolean isBedRollFlagEnabled() {
        return this.bedRollFlagEnabled;
    }

    public Boolean isBeyondArpBooking() {
        return this.beyondArpBooking;
    }

    public boolean isChildBerthMandatory() {
        return this.childBerthMandatory;
    }

    public boolean isFoodChoiceEnabled() {
        return this.foodChoiceEnabled;
    }

    public boolean isForgoConcession() {
        return this.forgoConcession;
    }

    public boolean isGatimaanTrain() {
        return this.gatimaanTrain;
    }

    public boolean isGstDetailInputFlag() {
        return this.gstDetailInputFlag;
    }

    public boolean isIdRequired() {
        return this.idRequired;
    }

    public boolean isLowerBerthApplicable() {
        return this.lowerBerthApplicable;
    }

    public boolean isNewTimeTable() {
        return this.newTimeTable;
    }

    public boolean isPmfInputEnable() {
        return this.pmfInputEnable;
    }

    public boolean isPmfInputMandatory() {
        return this.pmfInputMandatory;
    }

    public boolean isSeniorCitizenApplicable() {
        return this.seniorCitizenApplicable;
    }

    public boolean isSpecialTatkal() {
        return this.specialTatkal;
    }

    public boolean isSuvidhaTrain() {
        return this.suvidhaTrain;
    }

    public boolean isTravelInsuranceEnabled() {
        return this.travelInsuranceEnabled;
    }

    public boolean isTwoSSReleaseFlag() {
        return this.twoSSReleaseFlag;
    }

    public void setAcuralBooking(Boolean bool) {
        this.acuralBooking = bool;
    }

    public void setApplicableBerthTypes(ArrayList<String> arrayList) {
        this.applicableBerthTypes = arrayList;
    }

    public void setAtasEnable(boolean z) {
        this.atasEnable = z;
    }

    public void setBedRollFlagEnabled(boolean z) {
        this.bedRollFlagEnabled = z;
    }

    public void setBeyondArpBooking(Boolean bool) {
        this.beyondArpBooking = bool;
    }

    public void setBonafideCountryList(List<String> list) {
        this.bonafideCountryList = list;
    }

    public void setCaptureAddress(Integer num) {
        this.captureAddress = num;
    }

    public void setChildBerthMandatory(boolean z) {
        this.childBerthMandatory = z;
    }

    public void setConcessionalPassengerType(ArrayList<String> arrayList) {
        this.concessionalPassengerType = arrayList;
    }

    public void setFoodChoiceEnabled(boolean z) {
        this.foodChoiceEnabled = z;
    }

    public void setFoodDetails(List<String> list) {
        this.foodDetails = list;
    }

    public void setForgoConcession(boolean z) {
        this.forgoConcession = z;
    }

    public void setGatimaanTrain(boolean z) {
        this.gatimaanTrain = z;
    }

    public void setGstDetailInputFlag(boolean z) {
        this.gstDetailInputFlag = z;
    }

    public void setGstinPattern(String str) {
        this.gstinPattern = str;
    }

    public void setIdRequired(boolean z) {
        this.idRequired = z;
    }

    public void setInformationMessageDTO(List<InformationMessageDTO> list) {
        this.informationMessageDTO = list;
    }

    public void setLowerBerthApplicable(boolean z) {
        this.lowerBerthApplicable = z;
    }

    public void setMaxARPDays(short s) {
        this.maxARPDays = s;
    }

    public void setMaxChildAge(short s) {
        this.maxChildAge = s;
    }

    public void setMaxIdCardLength(short s) {
        this.maxIdCardLength = s;
    }

    public void setMaxInfants(short s) {
        this.maxInfants = s;
    }

    public void setMaxMasterListPsgn(Integer num) {
        this.maxMasterListPsgn = num;
    }

    public void setMaxNameLength(short s) {
        this.maxNameLength = s;
    }

    public void setMaxPassengerAge(short s) {
        this.maxPassengerAge = s;
    }

    public void setMaxPassengers(short s) {
        this.maxPassengers = s;
    }

    public void setMaxPassportLength(short s) {
        this.maxPassportLength = s;
    }

    public void setMaxRetentionDays(short s) {
        this.maxRetentionDays = s;
    }

    public void setMinIdCardLength(short s) {
        this.minIdCardLength = s;
    }

    public void setMinNameLength(short s) {
        this.minNameLength = s;
    }

    public void setMinPassengerAge(short s) {
        this.minPassengerAge = s;
    }

    public void setMinPassportLength(short s) {
        this.minPassportLength = s;
    }

    public void setNewTimeTable(boolean z) {
        this.newTimeTable = z;
    }

    public void setPaymentOption(C1262mo moVar) {
        this.paymentOption = moVar;
    }

    public void setPmfInputEnable(boolean z) {
        this.pmfInputEnable = z;
    }

    public void setPmfInputMandatory(boolean z) {
        this.pmfInputMandatory = z;
    }

    public void setPmfInputMaxLength(Integer num) {
        this.pmfInputMaxLength = num;
    }

    public void setRedemptionBooking(Boolean bool) {
        this.redemptionBooking = bool;
    }

    public void setSeniorCitizenApplicable(boolean z) {
        this.seniorCitizenApplicable = z;
    }

    public void setSpecialTatkal(boolean z) {
        this.specialTatkal = z;
    }

    public void setSrctnwAge(short s) {
        this.srctnwAge = s;
    }

    public void setSrctzTAge(short s) {
        this.srctzTAge = s;
    }

    public void setSrctznAge(short s) {
        this.srctznAge = s;
    }

    public void setSuvidhaTrain(boolean z) {
        this.suvidhaTrain = z;
    }

    public void setTrainNo(String str) {
        this.trainNo = str;
    }

    public void setTrainsiteId(String str) {
        this.trainsiteId = str;
    }

    public void setTravelInsuranceEnabled(boolean z) {
        this.travelInsuranceEnabled = z;
    }

    public void setTravelInsuranceFareMsg(String str) {
        this.travelInsuranceFareMsg = str;
    }

    public void setTravelProtectRedemption(Boolean bool) {
        this.travelProtectRedemption = bool;
    }

    public void setTwoSSReleaseFlag(boolean z) {
        this.twoSSReleaseFlag = z;
    }

    public void setUidMandatoryFlag(short s) {
        this.uidMandatoryFlag = s;
    }

    public void setUidVerificationMasterListFlag(short s) {
        this.uidVerificationMasterListFlag = s;
    }

    public void setUidVerificationPsgnInputFlag(short s) {
        this.uidVerificationPsgnInputFlag = s;
    }

    public void setValidIdCardTypes(String[] strArr) {
        this.validIdCardTypes = strArr;
    }

    public String toString() {
        return "BookingConfig [seniorCitizenApplicable=" + this.seniorCitizenApplicable + ", foodChoiceEnabled=" + this.foodChoiceEnabled + ", idRequired=" + this.idRequired + ", bedRollFlagEnabled=" + this.bedRollFlagEnabled + ", maxMasterListPsgn=" + this.maxMasterListPsgn + ", maxPassengers=" + this.maxPassengers + ", maxInfants=" + this.maxInfants + ", minNameLength=" + this.minNameLength + ", maxNameLength=" + this.maxNameLength + ", srctznAge=" + this.srctznAge + ", srctnwAge=" + this.srctnwAge + ", maxARPDays=" + this.maxARPDays + ", maxRetentionDays=" + this.maxRetentionDays + ", minPassengerAge=" + this.minPassengerAge + ", maxPassengerAge=" + this.maxPassengerAge + ", maxChildAge=" + this.maxChildAge + ", minIdCardLength=" + this.minIdCardLength + ", maxIdCardLength=" + this.maxIdCardLength + ", minPassportLength=" + this.minPassportLength + ", maxPassportLength=" + this.maxPassportLength + ", srctzTAge=" + this.srctzTAge + ", lowerBerthApplicable=" + this.lowerBerthApplicable + ", newTimeTable=" + this.newTimeTable + ", childBerthMandatory=" + this.childBerthMandatory + ", validIdCardTypes=" + Arrays.toString(this.validIdCardTypes) + ", applicableBerthTypes=" + this.applicableBerthTypes + ", suvidhaTrain=" + this.suvidhaTrain + ", specialTatkal=" + this.specialTatkal + ", atasEnable=" + this.atasEnable + ", gatimaanTrain=" + this.gatimaanTrain + ", foodDetails=" + this.foodDetails + ", travelInsuranceEnabled=" + this.travelInsuranceEnabled + ", travelInsuranceFareMsg=" + this.travelInsuranceFareMsg + ", uidVerificationPsgnInputFlag=" + this.uidVerificationPsgnInputFlag + ", uidVerificationMasterListFlag=" + this.uidVerificationMasterListFlag + ", uidMandatoryFlag=" + this.uidMandatoryFlag + ", gstDetailInputFlag=" + this.gstDetailInputFlag + ", gstinPattern=" + this.gstinPattern + ", forgoConcession=" + this.forgoConcession + ", concessionalPassengerType=" + this.concessionalPassengerType + ", twoSSReleaseFlag=" + this.twoSSReleaseFlag + ", beyondArpBooking=" + this.beyondArpBooking + ", acuralBooking=" + this.acuralBooking + ", redemptionBooking=" + this.redemptionBooking + ", trainsiteId=" + this.trainsiteId + ", bonafideCountryList=" + this.bonafideCountryList + ", pmfInputEnable=" + this.pmfInputEnable + ", pmfInputMandatory=" + this.pmfInputMandatory + ", pmfInputMaxLength=" + this.pmfInputMaxLength + ", paymentOption=" + this.paymentOption + ", captureAddress=" + this.captureAddress + ", trainNo=" + this.trainNo + ", travelProtectRedemption=" + this.travelProtectRedemption + "]";
    }
}
