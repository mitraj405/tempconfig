package cris.org.in.ima.model;

import java.io.Serializable;

public final class QuotaModel implements Serializable {
    public Boolean a;
    public final String c;

    public QuotaModel(String str) {
        Boolean bool = Boolean.FALSE;
        this.c = str;
        this.a = bool;
    }

    public final String toString() {
        return "QuotaModel{quota='" + this.c + "', selected=" + this.a + '}';
    }
}
