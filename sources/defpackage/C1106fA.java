package defpackage;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: fA  reason: default package and case insensitive filesystem */
/* compiled from: TokenUDTO */
public final class C1106fA implements Serializable {
    private static final long serialVersionUID = 1;
    private String access_token;
    private Long expires_in;
    private String message;
    private String refresh_token;
    private String scope;
    private String token_type;

    public String getAccess_token() {
        return this.access_token;
    }

    public Long getExpires_in() {
        return this.expires_in;
    }

    public String getMessage() {
        return this.message;
    }

    public String getRefresh_token() {
        return this.refresh_token;
    }

    public String getScope() {
        return this.scope;
    }

    public String getToken_type() {
        return this.token_type;
    }

    public void setAccess_token(String str) {
        this.access_token = str;
    }

    public void setExpires_in(Long l) {
        this.expires_in = l;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setRefresh_token(String str) {
        this.refresh_token = str;
    }

    public void setScope(String str) {
        this.scope = str;
    }

    public void setToken_type(String str) {
        this.token_type = str;
    }
}
