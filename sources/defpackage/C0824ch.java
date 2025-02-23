package defpackage;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: ch  reason: default package and case insensitive filesystem */
/* compiled from: JuspayLoadDTO */
public final class C0824ch implements Serializable {
    private static final long serialVersionUID = 1;
    private String clientId;
    private String environment;
    private String merchantKeyID;
    private String merchant_id;
    private String orderDetails;
    private String serviceUrl;
    private String signature;
    private String udf6;
    private String upiOpted;

    public String getClientId() {
        return this.clientId;
    }

    public String getEnvironment() {
        return this.environment;
    }

    public String getMerchantKeyID() {
        return this.merchantKeyID;
    }

    public String getMerchant_id() {
        return this.merchant_id;
    }

    public String getOrderDetails() {
        return this.orderDetails;
    }

    public String getServiceUrl() {
        return this.serviceUrl;
    }

    public String getSignature() {
        return this.signature;
    }

    public String getUdf6() {
        return this.udf6;
    }

    public String getUpiOpted() {
        return this.upiOpted;
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public void setEnvironment(String str) {
        this.environment = str;
    }

    public void setMerchantKeyID(String str) {
        this.merchantKeyID = str;
    }

    public void setMerchant_id(String str) {
        this.merchant_id = str;
    }

    public void setOrderDetails(String str) {
        this.orderDetails = str;
    }

    public void setServiceUrl(String str) {
        this.serviceUrl = str;
    }

    public void setSignature(String str) {
        this.signature = str;
    }

    public void setUdf6(String str) {
        this.udf6 = str;
    }

    public void setUpiOpted(String str) {
        this.upiOpted = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("JuspayLoadDTO [serviceUrl=");
        sb.append(this.serviceUrl);
        sb.append(", orderDetails=");
        sb.append(this.orderDetails);
        sb.append(", signature=");
        sb.append(this.signature);
        sb.append(", merchant_id=");
        sb.append(this.merchant_id);
        sb.append(", clientId=");
        sb.append(this.clientId);
        sb.append(", merchantKeyID=");
        sb.append(this.merchantKeyID);
        sb.append(", upiOpted=");
        sb.append(this.upiOpted);
        sb.append(", environment=");
        sb.append(this.environment);
        sb.append(", udf6=");
        return C0709Uj.j(sb, this.udf6, "]");
    }
}
