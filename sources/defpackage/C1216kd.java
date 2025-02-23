package defpackage;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: kd  reason: default package and case insensitive filesystem */
/* compiled from: ForgotPasswordReqDTO */
public final class C1216kd implements Serializable {
    private static final long serialVersionUID = 1;
    private String captcha;
    private String dob;
    private Xo passwordDTO;
    private String seqType;
    private String txnId;
    private String userId;

    public String getCaptcha() {
        return this.captcha;
    }

    public String getDob() {
        return this.dob;
    }

    public Xo getPasswordDTO() {
        return this.passwordDTO;
    }

    public String getSeqType() {
        return this.seqType;
    }

    public String getTxnId() {
        return this.txnId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setCaptcha(String str) {
        this.captcha = str;
    }

    public void setDob(String str) {
        this.dob = str;
    }

    public void setPasswordDTO(Xo xo) {
        this.passwordDTO = xo;
    }

    public void setSeqType(String str) {
        this.seqType = str;
    }

    public void setTxnId(String str) {
        this.txnId = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }
}
