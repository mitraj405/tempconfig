package defpackage;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: kb  reason: default package and case insensitive filesystem */
/* compiled from: EwalletRegPaymentDTO */
public final class C1215kb implements Serializable {
    private static final long serialVersionUID = 1;
    private double closingBalanceDeactivate;
    private boolean flag;
    private C1133ge gstDetailsDTO;
    private String idCardNumber;
    private String pancardNumber;
    private C1225kp paymentDetailDTO;
    private String status;
    private String txnPassword;
    private String txnPasswordConfirm;
    private JB userDetail;
    private String userName;

    public double getClosingBalanceDeactivate() {
        return this.closingBalanceDeactivate;
    }

    public C1133ge getGstDetailsDTO() {
        return this.gstDetailsDTO;
    }

    public String getIdCardNumber() {
        return this.idCardNumber;
    }

    public String getPancardNumber() {
        return this.pancardNumber;
    }

    public C1225kp getPaymentDetailDTO() {
        return this.paymentDetailDTO;
    }

    public String getStatus() {
        return this.status;
    }

    public String getTxnPassword() {
        return this.txnPassword;
    }

    public String getTxnPasswordConfirm() {
        return this.txnPasswordConfirm;
    }

    public JB getUserDetail() {
        return this.userDetail;
    }

    public String getUserName() {
        return this.userName;
    }

    public boolean isFlag() {
        return this.flag;
    }

    public void setClosingBalanceDeactivate(double d) {
        this.closingBalanceDeactivate = d;
    }

    public void setFlag(boolean z) {
        this.flag = z;
    }

    public void setGstDetailsDTO(C1133ge geVar) {
        this.gstDetailsDTO = geVar;
    }

    public void setIdCardNumber(String str) {
        this.idCardNumber = str;
    }

    public void setPancardNumber(String str) {
        this.pancardNumber = str;
    }

    public void setPaymentDetailDTO(C1225kp kpVar) {
        this.paymentDetailDTO = kpVar;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setTxnPassword(String str) {
        this.txnPassword = str;
    }

    public void setTxnPasswordConfirm(String str) {
        this.txnPasswordConfirm = str;
    }

    public void setUserDetail(JB jb) {
        this.userDetail = jb;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("EwalletRegPaymentDTO [txnPassword=");
        sb.append(this.txnPassword);
        sb.append(", txnPasswordConfirm=");
        sb.append(this.txnPasswordConfirm);
        sb.append(", gstDetailsDTO=");
        sb.append(this.gstDetailsDTO);
        sb.append(", paymentDetailDTO=");
        sb.append(this.paymentDetailDTO);
        sb.append(", userDetail=");
        sb.append(this.userDetail);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(", userName=");
        sb.append(this.userName);
        sb.append(", idCardNumber=");
        sb.append(this.idCardNumber);
        sb.append(", pancardNumber=");
        sb.append(this.pancardNumber);
        sb.append(", closingBalanceDeactivate=");
        sb.append(this.closingBalanceDeactivate);
        sb.append(", flag=");
        return xx.G(sb, this.flag, "]");
    }
}
