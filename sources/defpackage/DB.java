package defpackage;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: DB  reason: default package */
/* compiled from: UserDTO */
public final class DB implements Serializable {
    private static final long serialVersionUID = 1;
    private String captcha;
    private String dob;
    private String email;
    private Boolean errorFlag;
    private String errorMessage;
    private String txnId;
    private ArrayList<String> userEmailIdsList;

    public String getCaptcha() {
        return this.captcha;
    }

    public String getDob() {
        return this.dob;
    }

    public String getEmail() {
        return this.email;
    }

    public Boolean getErrorFlag() {
        return this.errorFlag;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getTxnId() {
        return this.txnId;
    }

    public ArrayList<String> getUserEmailIdsList() {
        return this.userEmailIdsList;
    }

    public void setCaptcha(String str) {
        this.captcha = str;
    }

    public void setDob(String str) {
        this.dob = str;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setErrorFlag(Boolean bool) {
        this.errorFlag = bool;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setTxnId(String str) {
        this.txnId = str;
    }

    public void setUserEmailIdsList(ArrayList<String> arrayList) {
        this.userEmailIdsList = arrayList;
    }
}
