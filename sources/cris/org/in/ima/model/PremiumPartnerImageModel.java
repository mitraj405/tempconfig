package cris.org.in.ima.model;

import java.io.Serializable;

public final class PremiumPartnerImageModel implements Serializable {
    public final boolean a = false;
    public final String c;
    public final String d;
    public final String e;
    public final String f;

    public PremiumPartnerImageModel(String str, String str2, String str3) {
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = null;
        this.a = false;
    }

    public final String toString() {
        return "PremiumPartnerImageModel{imageName='" + this.c + "', premiumiImage='" + this.d + "', redirectUrl='" + this.e + "', imagePkgName='" + this.f + "', imageflag=" + this.a + '}';
    }
}
