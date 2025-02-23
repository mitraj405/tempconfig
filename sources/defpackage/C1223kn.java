package defpackage;

import java.io.Serializable;
import java.util.Date;

/* renamed from: kn  reason: default package and case insensitive filesystem */
/* compiled from: OAuth2Token */
public final class C1223kn implements Serializable {
    private String access_token;
    private Date created = new Date();
    private String errorMessage;
    private String error_description;
    private long expires_in;
    private String message;
    private String refresh_token;
    private String token_type;

    public String getAccess_token() {
        return this.access_token;
    }

    public Date getCreated() {
        return this.created;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getError_description() {
        return this.error_description;
    }

    public long getExpires_in() {
        return this.expires_in;
    }

    public String getMessage() {
        return this.message;
    }

    public String getRefresh_token() {
        return this.refresh_token;
    }

    public String getToken_type() {
        return this.token_type;
    }

    public void setAccess_token(String str) {
        this.access_token = str;
    }

    public void setCreated(Date date) {
        this.created = date;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setError_description(String str) {
        this.error_description = str;
    }

    public void setExpires_in(long j) {
        this.expires_in = j;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setRefresh_token(String str) {
        this.refresh_token = str;
    }

    public void setToken_type(String str) {
        this.token_type = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("OAuth2Token{access_token='");
        sb.append(this.access_token);
        sb.append("', token_type='");
        sb.append(this.token_type);
        sb.append("', refresh_token='");
        sb.append(this.refresh_token);
        sb.append("', expires_in=");
        sb.append(this.expires_in);
        sb.append(", created=");
        sb.append(this.created);
        sb.append(", errorMessage='");
        sb.append(this.errorMessage);
        sb.append("', error_description='");
        sb.append(this.error_description);
        sb.append("', message='");
        return C0709Uj.j(sb, this.message, "'}");
    }
}
