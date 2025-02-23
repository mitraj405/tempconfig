package defpackage;

import java.io.Serializable;

/* renamed from: mn  reason: default package and case insensitive filesystem */
/* compiled from: OAuthRequestDTO */
public final class C1261mn implements Serializable {
    private String grant_type;
    private String password;
    private String username;

    public String getGrant_type() {
        return this.grant_type;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setGrant_type(String str) {
        this.grant_type = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("OAuthRequestDTO{grant_type='");
        sb.append(this.grant_type);
        sb.append("', username='");
        sb.append(this.username);
        sb.append("', password='");
        return C0709Uj.j(sb, this.password, "'}");
    }
}
