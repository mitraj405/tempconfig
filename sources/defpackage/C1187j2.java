package defpackage;

import java.io.Serializable;

/* renamed from: j2  reason: default package and case insensitive filesystem */
/* compiled from: BankDetailDTO */
public final class C1187j2 implements Serializable {
    private static final long serialVersionUID = 1;
    private String bankDisplayName;
    private int bankId;
    private String bankName;
    private int cardInputFlag;
    private String currentBalance;
    private String disableReason;
    private int displaySection;
    private int displaySequence;
    private boolean enableFlag;
    private short groupId;
    private int juspayEnableFlag;
    private String juspayEnabledMode;
    private String message;
    private String mobileType;
    private String offerMsg;
    private String offerUrl;
    private int paymentMode;
    private String paymentModeName;
    private String superAppEnabledMode;
    private int travelAgentFlag;
    private boolean txnPasswordMandatory;

    public String getBankDisplayName() {
        return this.bankDisplayName;
    }

    public int getBankId() {
        return this.bankId;
    }

    public String getBankName() {
        return this.bankName;
    }

    public int getCardInputFlag() {
        return this.cardInputFlag;
    }

    public String getCurrentBalance() {
        return this.currentBalance;
    }

    public String getDisableReason() {
        return this.disableReason;
    }

    public int getDisplaySection() {
        return this.displaySection;
    }

    public int getDisplaySequence() {
        return this.displaySequence;
    }

    public short getGroupId() {
        return this.groupId;
    }

    public int getJuspayEnableFlag() {
        return this.juspayEnableFlag;
    }

    public String getJuspayEnabledMode() {
        return this.juspayEnabledMode;
    }

    public String getMessage() {
        return this.message;
    }

    public String getMobileType() {
        return this.mobileType;
    }

    public String getOfferMsg() {
        return this.offerMsg;
    }

    public String getOfferUrl() {
        return this.offerUrl;
    }

    public int getPaymentMode() {
        return this.paymentMode;
    }

    public String getPaymentModeName() {
        return this.paymentModeName;
    }

    public String getSuperAppEnabledMode() {
        return this.superAppEnabledMode;
    }

    public int getTravelAgentFlag() {
        return this.travelAgentFlag;
    }

    public boolean isEnableFlag() {
        return this.enableFlag;
    }

    public boolean isTxnPasswordMandatory() {
        return this.txnPasswordMandatory;
    }

    public void setBankDisplayName(String str) {
        this.bankDisplayName = str;
    }

    public void setBankId(int i) {
        this.bankId = i;
    }

    public void setBankName(String str) {
        this.bankName = str;
    }

    public void setCardInputFlag(int i) {
        this.cardInputFlag = i;
    }

    public void setCurrentBalance(String str) {
        this.currentBalance = str;
    }

    public void setDisableReason(String str) {
        this.disableReason = str;
    }

    public void setDisplaySection(int i) {
        this.displaySection = i;
    }

    public void setDisplaySequence(int i) {
        this.displaySequence = i;
    }

    public void setEnableFlag(boolean z) {
        this.enableFlag = z;
    }

    public void setGroupId(short s) {
        this.groupId = s;
    }

    public void setJuspayEnableFlag(int i) {
        this.juspayEnableFlag = i;
    }

    public void setJuspayEnabledMode(String str) {
        this.juspayEnabledMode = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setMobileType(String str) {
        this.mobileType = str;
    }

    public void setOfferMsg(String str) {
        this.offerMsg = str;
    }

    public void setOfferUrl(String str) {
        this.offerUrl = str;
    }

    public void setPaymentMode(int i) {
        this.paymentMode = i;
    }

    public void setPaymentModeName(String str) {
        this.paymentModeName = str;
    }

    public void setSuperAppEnabledMode(String str) {
        this.superAppEnabledMode = str;
    }

    public void setTravelAgentFlag(int i) {
        this.travelAgentFlag = i;
    }

    public void setTxnPasswordMandatory(boolean z) {
        this.txnPasswordMandatory = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("BankDetailDTO [bankId=");
        sb.append(this.bankId);
        sb.append(", bankName=");
        sb.append(this.bankName);
        sb.append(", paymentMode=");
        sb.append(this.paymentMode);
        sb.append(", message=");
        sb.append(this.message);
        sb.append(", enableFlag=");
        sb.append(this.enableFlag);
        sb.append(", offerMsg=");
        sb.append(this.offerMsg);
        sb.append(", offerUrl=");
        sb.append(this.offerUrl);
        sb.append(", disableReason=");
        sb.append(this.disableReason);
        sb.append(", currentBalance=");
        sb.append(this.currentBalance);
        sb.append(", displaySection=");
        sb.append(this.displaySection);
        sb.append(", cardInputFlag=");
        sb.append(this.cardInputFlag);
        sb.append(", paymentModeName=");
        sb.append(this.paymentModeName);
        sb.append(", travelAgentFlag=");
        sb.append(this.travelAgentFlag);
        sb.append(", txnPasswordMandatory=");
        sb.append(this.txnPasswordMandatory);
        sb.append(", groupId=");
        sb.append(this.groupId);
        sb.append(", displaySequence=");
        sb.append(this.displaySequence);
        sb.append(", mobileType=");
        sb.append(this.mobileType);
        sb.append(", juspayEnableFlag=");
        sb.append(this.juspayEnableFlag);
        sb.append(", juspayEnabledMode=");
        sb.append(this.juspayEnabledMode);
        sb.append(", bankDisplayName=");
        sb.append(this.bankDisplayName);
        sb.append(", superAppEnabledMode=");
        return C0709Uj.j(sb, this.superAppEnabledMode, "]");
    }
}
