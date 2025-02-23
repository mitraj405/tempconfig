package cris.prs.webservices.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public final class EwalletProfileDTO implements Serializable {
    private static final long serialVersionUID = 1;
    private Long aadhaarCardNumber;
    private Boolean aadharStatusFlag;
    private Integer amount;
    private ArrayList<C1187j2> bankDetailDTO;
    private String cardHolderName;
    private Integer closingBalance;
    private String conversationId;
    private Integer depositAmount;
    private Integer depositConfirmAmount;
    private Long depositDtlId;
    private Integer depositType;
    private String errorMessage = "";
    private Integer ewalletRegAadhaarMand;
    private Integer ewalletRegOption;
    private C1215kb ewalletRegPaymentDTO;
    private Integer ewalletRegistrationFee;
    private C1133ge gstDetailsDTO;
    private Integer gstEnableFlag;
    private String gstNumberRegEx;
    private boolean otpFlag;
    private boolean otpInputDisplayFlag;
    private String panDob;
    private String pancardNumber;
    private Boolean pancardNumberDisplayFlag;
    private String pancardNumberView;
    private Boolean pancardStatusFlag;
    private String pancardStatusString;
    private String pancardStatusSubString;
    private Boolean pancardVerificationStatus;
    private Short paymentOption;
    private Long paymentTxnId;
    private Integer rdsFlagForPancardNumber;
    private String reDirectPage;
    private Short rechargeStatus;
    private String referenceNumberRegistration;
    private Integer registrationAmount;
    private Boolean renewalFlag;
    private String serverId;
    private Boolean status;
    private Date timeStamp;
    private String transactionStatus;
    private String txnPassword;
    private String txnPasswordConfirm;
    private Long userId;
    private Long userIdForPancardNumber;
    private Long userIdForSession;
    private String userName;

    public EwalletProfileDTO() {
        Boolean bool = Boolean.FALSE;
        this.aadharStatusFlag = bool;
        this.ewalletRegOption = 1;
        this.pancardStatusFlag = bool;
        this.pancardNumberDisplayFlag = Boolean.TRUE;
    }

    public Long getAadhaarCardNumber() {
        return this.aadhaarCardNumber;
    }

    public Boolean getAadharStatusFlag() {
        return this.aadharStatusFlag;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public ArrayList<C1187j2> getBankDetailDTO() {
        return this.bankDetailDTO;
    }

    public String getCardHolderName() {
        return this.cardHolderName;
    }

    public Integer getClosingBalance() {
        return this.closingBalance;
    }

    public String getConversationId() {
        return this.conversationId;
    }

    public Integer getDepositAmount() {
        return this.depositAmount;
    }

    public Integer getDepositConfirmAmount() {
        return this.depositConfirmAmount;
    }

    public Long getDepositDtlId() {
        return this.depositDtlId;
    }

    public Integer getDepositType() {
        return this.depositType;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public Integer getEwalletRegAadhaarMand() {
        return this.ewalletRegAadhaarMand;
    }

    public Integer getEwalletRegOption() {
        return this.ewalletRegOption;
    }

    public C1215kb getEwalletRegPaymentDTO() {
        return this.ewalletRegPaymentDTO;
    }

    public Integer getEwalletRegistrationFee() {
        return this.ewalletRegistrationFee;
    }

    public C1133ge getGstDetailsDTO() {
        return this.gstDetailsDTO;
    }

    public Integer getGstEnableFlag() {
        return this.gstEnableFlag;
    }

    public String getGstNumberRegEx() {
        return this.gstNumberRegEx;
    }

    public String getPanDob() {
        return this.panDob;
    }

    public String getPancardNumber() {
        return this.pancardNumber;
    }

    public Boolean getPancardNumberDisplayFlag() {
        return this.pancardNumberDisplayFlag;
    }

    public String getPancardNumberView() {
        return this.pancardNumberView;
    }

    public Boolean getPancardStatusFlag() {
        return this.pancardStatusFlag;
    }

    public String getPancardStatusString() {
        return this.pancardStatusString;
    }

    public String getPancardStatusSubString() {
        return this.pancardStatusSubString;
    }

    public Boolean getPancardVerificationStatus() {
        return this.pancardVerificationStatus;
    }

    public Short getPaymentOption() {
        return this.paymentOption;
    }

    public Long getPaymentTxnId() {
        return this.paymentTxnId;
    }

    public Integer getRdsFlagForPancardNumber() {
        return this.rdsFlagForPancardNumber;
    }

    public String getReDirectPage() {
        return this.reDirectPage;
    }

    public Short getRechargeStatus() {
        return this.rechargeStatus;
    }

    public String getReferenceNumberRegistration() {
        return this.referenceNumberRegistration;
    }

    public Integer getRegistrationAmount() {
        return this.registrationAmount;
    }

    public Boolean getRenewalFlag() {
        return this.renewalFlag;
    }

    public String getServerId() {
        return this.serverId;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public Date getTimeStamp() {
        return this.timeStamp;
    }

    public String getTransactionStatus() {
        return this.transactionStatus;
    }

    public String getTxnPassword() {
        return this.txnPassword;
    }

    public String getTxnPasswordConfirm() {
        return this.txnPasswordConfirm;
    }

    public Long getUserId() {
        return this.userId;
    }

    public Long getUserIdForPancardNumber() {
        return this.userIdForPancardNumber;
    }

    public Long getUserIdForSession() {
        return this.userIdForSession;
    }

    public String getUserName() {
        return this.userName;
    }

    public boolean isOtpFlag() {
        return this.otpFlag;
    }

    public boolean isOtpInputDisplayFlag() {
        return this.otpInputDisplayFlag;
    }

    public void setAadhaarCardNumber(Long l) {
        this.aadhaarCardNumber = l;
    }

    public void setAadharStatusFlag(Boolean bool) {
        this.aadharStatusFlag = bool;
    }

    public void setAmount(Integer num) {
        this.amount = num;
    }

    public void setBankDetailDTO(ArrayList<C1187j2> arrayList) {
        this.bankDetailDTO = arrayList;
    }

    public void setCardHolderName(String str) {
        this.cardHolderName = str;
    }

    public void setClosingBalance(Integer num) {
        this.closingBalance = num;
    }

    public void setConversationId(String str) {
        this.conversationId = str;
    }

    public void setDepositAmount(Integer num) {
        this.depositAmount = num;
    }

    public void setDepositConfirmAmount(Integer num) {
        this.depositConfirmAmount = num;
    }

    public void setDepositDtlId(Long l) {
        this.depositDtlId = l;
    }

    public void setDepositType(Integer num) {
        this.depositType = num;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setEwalletRegAadhaarMand(Integer num) {
        this.ewalletRegAadhaarMand = num;
    }

    public void setEwalletRegOption(Integer num) {
        this.ewalletRegOption = num;
    }

    public void setEwalletRegPaymentDTO(C1215kb kbVar) {
        this.ewalletRegPaymentDTO = kbVar;
    }

    public void setEwalletRegistrationFee(Integer num) {
        this.ewalletRegistrationFee = num;
    }

    public void setGstDetailsDTO(C1133ge geVar) {
        this.gstDetailsDTO = geVar;
    }

    public void setGstEnableFlag(Integer num) {
        this.gstEnableFlag = num;
    }

    public void setGstNumberRegEx(String str) {
        this.gstNumberRegEx = str;
    }

    public void setOtpFlag(boolean z) {
        this.otpFlag = z;
    }

    public void setOtpInputDisplayFlag(boolean z) {
        this.otpInputDisplayFlag = z;
    }

    public void setPanDob(String str) {
        this.panDob = str;
    }

    public void setPancardNumber(String str) {
        this.pancardNumber = str;
    }

    public void setPancardNumberDisplayFlag(Boolean bool) {
        this.pancardNumberDisplayFlag = bool;
    }

    public void setPancardNumberView(String str) {
        this.pancardNumberView = str;
    }

    public void setPancardStatusFlag(Boolean bool) {
        this.pancardStatusFlag = bool;
    }

    public void setPancardStatusString(String str) {
        this.pancardStatusString = str;
    }

    public void setPancardStatusSubString(String str) {
        this.pancardStatusSubString = str;
    }

    public void setPancardVerificationStatus(Boolean bool) {
        this.pancardVerificationStatus = bool;
    }

    public void setPaymentOption(Short sh) {
        this.paymentOption = sh;
    }

    public void setPaymentTxnId(Long l) {
        this.paymentTxnId = l;
    }

    public void setRdsFlagForPancardNumber(Integer num) {
        this.rdsFlagForPancardNumber = num;
    }

    public void setReDirectPage(String str) {
        this.reDirectPage = str;
    }

    public void setRechargeStatus(Short sh) {
        this.rechargeStatus = sh;
    }

    public void setReferenceNumberRegistration(String str) {
        this.referenceNumberRegistration = str;
    }

    public void setRegistrationAmount(Integer num) {
        this.registrationAmount = num;
    }

    public void setRenewalFlag(Boolean bool) {
        this.renewalFlag = bool;
    }

    public void setServerId(String str) {
        this.serverId = str;
    }

    public void setStatus(Boolean bool) {
        this.status = bool;
    }

    public void setTimeStamp(Date date) {
        this.timeStamp = date;
    }

    public void setTransactionStatus(String str) {
        this.transactionStatus = str;
    }

    public void setTxnPassword(String str) {
        this.txnPassword = str;
    }

    public void setTxnPasswordConfirm(String str) {
        this.txnPasswordConfirm = str;
    }

    public void setUserId(Long l) {
        this.userId = l;
    }

    public void setUserIdForPancardNumber(Long l) {
        this.userIdForPancardNumber = l;
    }

    public void setUserIdForSession(Long l) {
        this.userIdForSession = l;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("EwalletProfileDTO [pancardNumber=");
        sb.append(this.pancardNumber);
        sb.append(", cardHolderName=");
        sb.append(this.cardHolderName);
        sb.append(", pancardStatusString=");
        sb.append(this.pancardStatusString);
        sb.append(", pancardStatusSubString=");
        sb.append(this.pancardStatusSubString);
        sb.append(", pancardVerificationStatus=");
        sb.append(this.pancardVerificationStatus);
        sb.append(", conversationId=");
        sb.append(this.conversationId);
        sb.append(", registrationAmount=");
        sb.append(this.registrationAmount);
        sb.append(", txnPassword=");
        sb.append(this.txnPassword);
        sb.append(", txnPasswordConfirm=");
        sb.append(this.txnPasswordConfirm);
        sb.append(", userId=");
        sb.append(this.userId);
        sb.append(", userName=");
        sb.append(this.userName);
        sb.append(", pancardNumberView=");
        sb.append(this.pancardNumberView);
        sb.append(", closingBalance=");
        sb.append(this.closingBalance);
        sb.append(", depositAmount=");
        sb.append(this.depositAmount);
        sb.append(", depositConfirmAmount=");
        sb.append(this.depositConfirmAmount);
        sb.append(", errorMessage=");
        sb.append(this.errorMessage);
        sb.append(", depositDtlId=");
        sb.append(this.depositDtlId);
        sb.append(", amount=");
        sb.append(this.amount);
        sb.append(", rechargeStatus=");
        sb.append(this.rechargeStatus);
        sb.append(", paymentOption=");
        sb.append(this.paymentOption);
        sb.append(", paymentTxnId=");
        sb.append(this.paymentTxnId);
        sb.append(", transactionStatus=");
        sb.append(this.transactionStatus);
        sb.append(", depositType=");
        sb.append(this.depositType);
        sb.append(", renewalFlag=");
        sb.append(this.renewalFlag);
        sb.append(", referenceNumberRegistration=");
        sb.append(this.referenceNumberRegistration);
        sb.append(", rdsFlagForPancardNumber=");
        sb.append(this.rdsFlagForPancardNumber);
        sb.append(", userIdForPancardNumber=");
        sb.append(this.userIdForPancardNumber);
        sb.append(", userIdForSession=");
        sb.append(this.userIdForSession);
        sb.append(", ewalletRegistrationFee=");
        sb.append(this.ewalletRegistrationFee);
        sb.append(", aadharStatusFlag=");
        sb.append(this.aadharStatusFlag);
        sb.append(", ewalletRegOption=");
        sb.append(this.ewalletRegOption);
        sb.append(", pancardStatusFlag=");
        sb.append(this.pancardStatusFlag);
        sb.append(", aadhaarCardNumber=");
        sb.append(this.aadhaarCardNumber);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(", ewalletRegAadhaarMand=");
        sb.append(this.ewalletRegAadhaarMand);
        sb.append(", pancardNumberDisplayFlag=");
        sb.append(this.pancardNumberDisplayFlag);
        sb.append(", gstDetailsDTO=");
        sb.append(this.gstDetailsDTO);
        sb.append(", bankDetailDTO=");
        sb.append(this.bankDetailDTO);
        sb.append(", otpInputDisplayFlag=");
        sb.append(this.otpInputDisplayFlag);
        sb.append(", otpFlag=");
        return xx.G(sb, this.otpFlag, "]");
    }
}
