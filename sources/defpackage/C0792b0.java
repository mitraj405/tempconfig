package defpackage;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: b0  reason: default package and case insensitive filesystem */
/* compiled from: AddOnOptedDTO */
public final class C0792b0 implements Serializable {
    private static final long serialVersionUID = 1;
    private String addOnOptedAmount;
    private String addOnOptedBankName;
    private String addonCancelStatus;
    private String addonOptedDate;
    private String addonRefundStatus;
    private String addonTransactionStatus;
    private String errorMessage;
    private Date serviceDate;
    private String serviceId;
    private String serviceStatus;

    public String getAddOnOptedAmount() {
        return this.addOnOptedAmount;
    }

    public String getAddOnOptedBankName() {
        return this.addOnOptedBankName;
    }

    public String getAddonCancelStatus() {
        return this.addonCancelStatus;
    }

    public String getAddonOptedDate() {
        return this.addonOptedDate;
    }

    public String getAddonRefundStatus() {
        return this.addonRefundStatus;
    }

    public String getAddonTransactionStatus() {
        return this.addonTransactionStatus;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public Date getServiceDate() {
        return this.serviceDate;
    }

    public String getServiceId() {
        return this.serviceId;
    }

    public String getServiceStatus() {
        return this.serviceStatus;
    }

    public void setAddOnOptedAmount(String str) {
        this.addOnOptedAmount = str;
    }

    public void setAddOnOptedBankName(String str) {
        this.addOnOptedBankName = str;
    }

    public void setAddonCancelStatus(String str) {
        this.addonCancelStatus = str;
    }

    public void setAddonOptedDate(String str) {
        this.addonOptedDate = str;
    }

    public void setAddonRefundStatus(String str) {
        this.addonRefundStatus = str;
    }

    public void setAddonTransactionStatus(String str) {
        this.addonTransactionStatus = str;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setServiceDate(Date date) {
        this.serviceDate = date;
    }

    public void setServiceId(String str) {
        this.serviceId = str;
    }

    public void setServiceStatus(String str) {
        this.serviceStatus = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AddOnOptedDTO [serviceId=");
        sb.append(this.serviceId);
        sb.append(", addOnOptedAmount=");
        sb.append(this.addOnOptedAmount);
        sb.append(", addOnOptedBankName=");
        sb.append(this.addOnOptedBankName);
        sb.append(", addonOptedDate=");
        sb.append(this.addonOptedDate);
        sb.append(", addonTransactionStatus=");
        sb.append(this.addonTransactionStatus);
        sb.append(", addonCancelStatus=");
        sb.append(this.addonCancelStatus);
        sb.append(", addonRefundStatus=");
        sb.append(this.addonRefundStatus);
        sb.append(", serviceDate=");
        sb.append(this.serviceDate);
        sb.append(", errorMessage=");
        return C0709Uj.j(sb, this.errorMessage, "]");
    }
}
