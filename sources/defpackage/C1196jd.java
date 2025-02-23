package defpackage;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: jd  reason: default package and case insensitive filesystem */
/* compiled from: ForgetTransactionPasswordDTO */
public final class C1196jd implements Serializable {
    private static final long serialVersionUID = 5231886762000866975L;
    private String aadhaarId = null;
    private String emailId = null;
    private String loginPassword = null;
    private String panNumber = null;
    private String userName = null;

    public String getAadhaarId() {
        return this.aadhaarId;
    }

    public String getEmailId() {
        return this.emailId;
    }

    public String getLoginPassword() {
        return this.loginPassword;
    }

    public String getPanNumber() {
        return this.panNumber;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setAadhaarId(String str) {
        this.aadhaarId = str;
    }

    public void setEmailId(String str) {
        this.emailId = str;
    }

    public void setLoginPassword(String str) {
        this.loginPassword = str;
    }

    public void setPanNumber(String str) {
        this.panNumber = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ForgetTransactionPasswordDTO [panNumber=");
        sb.append(this.panNumber);
        sb.append(", userName=");
        sb.append(this.userName);
        sb.append(", aadhaarId=");
        sb.append(this.aadhaarId);
        sb.append(", emailId=");
        return C0709Uj.j(sb, this.emailId, "]");
    }
}
