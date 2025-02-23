package defpackage;

import java.io.Serializable;
import java.util.ArrayList;

/* renamed from: tx  reason: default package and case insensitive filesystem */
/* compiled from: SoftPointsPurchaseView */
public final class C1416tx implements Serializable {
    private static final long serialVersionUID = -4247141408073910570L;
    private String area;
    private String city;
    private ArrayList<String> cityList;
    private Boolean errorExists;
    private String errorMessage;
    private String errorMessagePincode;
    private String flat;
    private Integer gstEnableFlag;
    private String gstIn;
    private String gstPatternRegExp;
    private Float irctcCgstCharge;
    private Float irctcEwalletCgstCharge;
    private Float irctcEwalletIgstCharge;
    private Float irctcEwalletSgstCharge;
    private Float irctcEwalletUgstCharge;
    private Float irctcIgstCharge;
    private Float irctcSgstCharge;
    private Float irctcUgstCharge;
    private Long loyaltyNumber;
    private Long loyaltyTxnDtlsSrlNo;
    private String nameOnGst;
    private String pin;
    private Long pointsToPurchase;
    private Double purchaseAmount;
    private String state;
    private String stateId;
    private String street;
    private Double totalAmount;
    private Double totalEwalletGst;
    private Double totalEwalletIrctcGst;
    private Double totalGst;
    private Double totalIrctcGst;
    private Long txnIdGstDetails;

    public String getArea() {
        return this.area;
    }

    public String getCity() {
        return this.city;
    }

    public ArrayList<String> getCityList() {
        return this.cityList;
    }

    public Boolean getErrorExists() {
        return this.errorExists;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getErrorMessagePincode() {
        return this.errorMessagePincode;
    }

    public String getFlat() {
        return this.flat;
    }

    public Integer getGstEnableFlag() {
        return this.gstEnableFlag;
    }

    public String getGstIn() {
        return this.gstIn;
    }

    public String getGstPatternRegExp() {
        return this.gstPatternRegExp;
    }

    public Float getIrctcCgstCharge() {
        return this.irctcCgstCharge;
    }

    public Float getIrctcEwalletCgstCharge() {
        return this.irctcEwalletCgstCharge;
    }

    public Float getIrctcEwalletIgstCharge() {
        return this.irctcEwalletIgstCharge;
    }

    public Float getIrctcEwalletSgstCharge() {
        return this.irctcEwalletSgstCharge;
    }

    public Float getIrctcEwalletUgstCharge() {
        return this.irctcEwalletUgstCharge;
    }

    public Float getIrctcIgstCharge() {
        return this.irctcIgstCharge;
    }

    public Float getIrctcSgstCharge() {
        return this.irctcSgstCharge;
    }

    public Float getIrctcUgstCharge() {
        return this.irctcUgstCharge;
    }

    public Long getLoyaltyNumber() {
        return this.loyaltyNumber;
    }

    public Long getLoyaltyTxnDtlsSrlNo() {
        return this.loyaltyTxnDtlsSrlNo;
    }

    public String getNameOnGst() {
        return this.nameOnGst;
    }

    public String getPin() {
        return this.pin;
    }

    public Long getPointsToPurchase() {
        return this.pointsToPurchase;
    }

    public Double getPurchaseAmount() {
        return this.purchaseAmount;
    }

    public String getState() {
        return this.state;
    }

    public String getStateId() {
        return this.stateId;
    }

    public String getStreet() {
        return this.street;
    }

    public Double getTotalAmount() {
        return this.totalAmount;
    }

    public Double getTotalEwalletGst() {
        return this.totalEwalletGst;
    }

    public Double getTotalEwalletIrctcGst() {
        return this.totalEwalletIrctcGst;
    }

    public Double getTotalGst() {
        return this.totalGst;
    }

    public Double getTotalIrctcGst() {
        return this.totalIrctcGst;
    }

    public Long getTxnIdGstDetails() {
        return this.txnIdGstDetails;
    }

    public void setArea(String str) {
        this.area = str;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setCityList(ArrayList<String> arrayList) {
        this.cityList = arrayList;
    }

    public void setErrorExists(Boolean bool) {
        this.errorExists = bool;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setErrorMessagePincode(String str) {
        this.errorMessagePincode = str;
    }

    public void setFlat(String str) {
        this.flat = str;
    }

    public void setGstEnableFlag(Integer num) {
        this.gstEnableFlag = num;
    }

    public void setGstIn(String str) {
        this.gstIn = str;
    }

    public void setGstPatternRegExp(String str) {
        this.gstPatternRegExp = str;
    }

    public void setIrctcCgstCharge(Float f) {
        this.irctcCgstCharge = f;
    }

    public void setIrctcEwalletCgstCharge(Float f) {
        this.irctcEwalletCgstCharge = f;
    }

    public void setIrctcEwalletIgstCharge(Float f) {
        this.irctcEwalletIgstCharge = f;
    }

    public void setIrctcEwalletSgstCharge(Float f) {
        this.irctcEwalletSgstCharge = f;
    }

    public void setIrctcEwalletUgstCharge(Float f) {
        this.irctcEwalletUgstCharge = f;
    }

    public void setIrctcIgstCharge(Float f) {
        this.irctcIgstCharge = f;
    }

    public void setIrctcSgstCharge(Float f) {
        this.irctcSgstCharge = f;
    }

    public void setIrctcUgstCharge(Float f) {
        this.irctcUgstCharge = f;
    }

    public void setLoyaltyNumber(Long l) {
        this.loyaltyNumber = l;
    }

    public void setLoyaltyTxnDtlsSrlNo(Long l) {
        this.loyaltyTxnDtlsSrlNo = l;
    }

    public void setNameOnGst(String str) {
        this.nameOnGst = str;
    }

    public void setPin(String str) {
        this.pin = str;
    }

    public void setPointsToPurchase(Long l) {
        this.pointsToPurchase = l;
    }

    public void setPurchaseAmount(Double d) {
        this.purchaseAmount = d;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setStateId(String str) {
        this.stateId = str;
    }

    public void setStreet(String str) {
        this.street = str;
    }

    public void setTotalAmount(Double d) {
        this.totalAmount = d;
    }

    public void setTotalEwalletGst(Double d) {
        this.totalEwalletGst = d;
    }

    public void setTotalEwalletIrctcGst(Double d) {
        this.totalEwalletIrctcGst = d;
    }

    public void setTotalGst(Double d) {
        this.totalGst = d;
    }

    public void setTotalIrctcGst(Double d) {
        this.totalIrctcGst = d;
    }

    public void setTxnIdGstDetails(Long l) {
        this.txnIdGstDetails = l;
    }

    public String toString() {
        return "SoftPointsPurchaseView [errorExists=" + this.errorExists + ", errorMessage=" + this.errorMessage + ", pointsToPurchase=" + this.pointsToPurchase + ", purchaseAmount=" + this.purchaseAmount + ", loyaltyNumber=" + this.loyaltyNumber + ", loyaltyTxnDtlsSrlNo=" + this.loyaltyTxnDtlsSrlNo + ", gstEnableFlag=" + this.gstEnableFlag + ", gstIn=" + this.gstIn + ", nameOnGst=" + this.nameOnGst + ", flat=" + this.flat + ", street=" + this.street + ", area=" + this.area + ", pin=" + this.pin + ", state=" + this.state + ", city=" + this.city + ", cityList=" + this.cityList + ", stateId=" + this.stateId + ", errorMessagePincode=" + this.errorMessagePincode + ", irctcCgstCharge=" + this.irctcCgstCharge + ", irctcSgstCharge=" + this.irctcSgstCharge + ", irctcIgstCharge=" + this.irctcIgstCharge + ", irctcUgstCharge=" + this.irctcUgstCharge + ", totalIrctcGst=" + this.totalIrctcGst + ", totalAmount=" + this.totalAmount + ", totalGst=" + this.totalGst + ", txnIdGstDetails=" + this.txnIdGstDetails + ", gstPatternRegExp=" + this.gstPatternRegExp + ", irctcEwalletCgstCharge=" + this.irctcEwalletCgstCharge + ", irctcEwalletSgstCharge=" + this.irctcEwalletSgstCharge + ", irctcEwalletIgstCharge=" + this.irctcEwalletIgstCharge + ", irctcEwalletUgstCharge=" + this.irctcEwalletUgstCharge + ", totalEwalletIrctcGst=" + this.totalEwalletIrctcGst + ", totalEwalletGst=" + this.totalEwalletGst + "]";
    }
}
