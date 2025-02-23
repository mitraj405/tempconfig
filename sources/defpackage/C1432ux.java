package defpackage;

import java.util.ArrayList;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: ux  reason: default package and case insensitive filesystem */
/* compiled from: SoftPurchaseView */
public final class C1432ux {
    private double amountCalcFactor = 1.5d;
    private ArrayList<C1187j2> bankDetailDTO;
    private Integer bankId;
    private String errorMessage;
    private C1087eb ewalletDTO;
    private ArrayList<Do> paramList;
    private C1225kp paymentDetailDTO;
    private String serverId;
    private C1416tx softPointsPurchaseView;
    private Date timeStamp;
    private JB userDetail;

    public double getAmountCalcFactor() {
        return this.amountCalcFactor;
    }

    public ArrayList<C1187j2> getBankDetailDTO() {
        return this.bankDetailDTO;
    }

    public Integer getBankId() {
        return this.bankId;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public C1087eb getEwalletDTO() {
        return this.ewalletDTO;
    }

    public ArrayList<Do> getParamList() {
        return this.paramList;
    }

    public C1225kp getPaymentDetailDTO() {
        return this.paymentDetailDTO;
    }

    public String getServerId() {
        return this.serverId;
    }

    public C1416tx getSoftPointsPurchaseView() {
        return this.softPointsPurchaseView;
    }

    public Date getTimeStamp() {
        return this.timeStamp;
    }

    public JB getUserDetail() {
        return this.userDetail;
    }

    public void setAmountCalcFactor(double d) {
        this.amountCalcFactor = d;
    }

    public void setBankDetailDTO(ArrayList<C1187j2> arrayList) {
        this.bankDetailDTO = arrayList;
    }

    public void setBankId(Integer num) {
        this.bankId = num;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setEwalletDTO(C1087eb ebVar) {
        this.ewalletDTO = ebVar;
    }

    public void setParamList(ArrayList<Do> arrayList) {
        this.paramList = arrayList;
    }

    public void setPaymentDetailDTO(C1225kp kpVar) {
        this.paymentDetailDTO = kpVar;
    }

    public void setServerId(String str) {
        this.serverId = str;
    }

    public void setSoftPointsPurchaseView(C1416tx txVar) {
        this.softPointsPurchaseView = txVar;
    }

    public void setTimeStamp(Date date) {
        this.timeStamp = date;
    }

    public void setUserDetail(JB jb) {
        this.userDetail = jb;
    }

    public String toString() {
        return "SoftPurchaseView [softPointsPurchaseView=" + this.softPointsPurchaseView + ", bankId=" + this.bankId + ", bankDetailDTO=" + this.bankDetailDTO + ", ewalletDTO=" + this.ewalletDTO + ", paramList=" + this.paramList + ", userDetail=" + this.userDetail + ", paymentDetailDTO=" + this.paymentDetailDTO + ", errorMessage=" + this.errorMessage + ", serverId=" + this.serverId + ", timeStamp=" + this.timeStamp + ", amountCalcFactor=" + this.amountCalcFactor + "]";
    }
}
