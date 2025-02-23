package defpackage;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: sx  reason: default package and case insensitive filesystem */
/* compiled from: SoftPaymentDTO */
public final class C1398sx implements Serializable {
    private static final long serialVersionUID = 1;
    private boolean activatedFlag;
    private long loyalityNumberSoft;
    private Long loyaltyBankId;
    private String loyaltyBankName;
    private boolean loyaltyNumLinkedFlag = false;
    private Long loyaltyPointBalance;
    private String message;
    private int minBalance;
    private int paymentMode;

    public long getLoyalityNumberSoft() {
        return this.loyalityNumberSoft;
    }

    public Long getLoyaltyBankId() {
        return this.loyaltyBankId;
    }

    public String getLoyaltyBankName() {
        return this.loyaltyBankName;
    }

    public Long getLoyaltyPointBalance() {
        return this.loyaltyPointBalance;
    }

    public String getMessage() {
        return this.message;
    }

    public int getMinBalance() {
        return this.minBalance;
    }

    public int getPaymentMode() {
        return this.paymentMode;
    }

    public boolean isActivatedFlag() {
        return this.activatedFlag;
    }

    public boolean isLoyaltyNumLinkedFlag() {
        return this.loyaltyNumLinkedFlag;
    }

    public void setActivatedFlag(boolean z) {
        this.activatedFlag = z;
    }

    public void setLoyalityNumberSoft(long j) {
        this.loyalityNumberSoft = j;
    }

    public void setLoyaltyBankId(Long l) {
        this.loyaltyBankId = l;
    }

    public void setLoyaltyBankName(String str) {
        this.loyaltyBankName = str;
    }

    public void setLoyaltyNumLinkedFlag(boolean z) {
        this.loyaltyNumLinkedFlag = z;
    }

    public void setLoyaltyPointBalance(Long l) {
        this.loyaltyPointBalance = l;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setMinBalance(int i) {
        this.minBalance = i;
    }

    public void setPaymentMode(int i) {
        this.paymentMode = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SoftPaymentDTO [activatedFlag=");
        sb.append(this.activatedFlag);
        sb.append(", message=");
        sb.append(this.message);
        sb.append(", loyaltyPointBalance=");
        sb.append(this.loyaltyPointBalance);
        sb.append(", minBalance=");
        sb.append(this.minBalance);
        sb.append(", loyaltyBankName=");
        sb.append(this.loyaltyBankName);
        sb.append(", loyaltyBankId=");
        sb.append(this.loyaltyBankId);
        sb.append(", paymentMode=");
        sb.append(this.paymentMode);
        sb.append(", loyaltyNumLinkedFlag=");
        sb.append(this.loyaltyNumLinkedFlag);
        sb.append(", loyalityNumberSoft=");
        return lf.l(sb, this.loyalityNumberSoft, "]");
    }
}
