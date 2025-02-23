package cris.prs.webservices.dto;

import java.io.Serializable;

/* compiled from: BaseDTO */
public class a implements Serializable {
    private static final long serialVersionUID = 1;
    protected String masterId;
    protected String wsUserLogin;
    protected String wsUserPassword;
    protected String wsUserTransactionPassword;

    public String getMasterId() {
        return this.masterId;
    }

    public String getWsUserLogin() {
        return this.wsUserLogin;
    }

    public String getWsUserPassword() {
        return this.wsUserPassword;
    }

    public String getWsUserTransactionPassword() {
        return this.wsUserTransactionPassword;
    }

    public void setMasterId(String str) {
        this.masterId = str;
    }

    public void setWsUserLogin(String str) {
        this.wsUserLogin = str;
    }

    public void setWsUserPassword(String str) {
        this.wsUserPassword = str;
    }

    public void setWsUserTransactionPassword(String str) {
        this.wsUserTransactionPassword = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("BaseDTO [masterId=");
        sb.append(this.masterId);
        sb.append(", wsUserLogin=");
        sb.append(this.wsUserLogin);
        sb.append(", wsUserPassword=");
        sb.append(this.wsUserPassword);
        sb.append(", wsUserTransactionPassword=");
        return C0709Uj.j(sb, this.wsUserTransactionPassword, "]");
    }
}
