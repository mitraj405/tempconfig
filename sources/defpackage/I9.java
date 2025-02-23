package defpackage;

import com.google.zxing.client.result.ExpandedProductParsedResult;
import cris.org.in.ima.IrctcImaApplication;

/* renamed from: I9  reason: default package */
/* compiled from: EAppConstant */
public enum I9 {
    a(ExpandedProductParsedResult.POUND, "Lower", "निचला", ExpandedProductParsedResult.POUND),
    b("MB", "Middle", "मध्य", "MB"),
    c("UB", "Upper", "ऊपरी", "UB"),
    d("SL", "Side Lower", "साइड लोअर", "SL"),
    e("SU", "Side Upper", "साइड अपर", "SU"),
    f("WS", "Window Side", "खिड़की पक्ष", "WS"),
    g("AS", "Aisle", "Aisle", "AS"),
    h("CB", "Cabin", "केबिन", "CB"),
    i("CP", "Coupe", "कूप", "CP"),
    j("HB", "Hndcap_Berth", "Hndcap_Berth", "HB"),
    k("SM", "Side Middle", "साइड मिडल", "SM"),
    l("NC", "No Preference", "कोई वरीयता नहीं", "NC");
    

    /* renamed from: c  reason: collision with other field name */
    public final int f3657c;

    /* renamed from: c  reason: collision with other field name */
    public final String f3658c;

    /* renamed from: d  reason: collision with other field name */
    public final String f3659d;

    /* renamed from: e  reason: collision with other field name */
    public final String f3660e;

    /* access modifiers changed from: public */
    I9(String str, String str2, String str3, String str4) {
        this.f3657c = r2;
        this.f3659d = str2;
        this.f3660e = str3;
        this.f3658c = str4;
    }

    public static I9 i(String str) {
        for (I9 i9 : values()) {
            if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
                if (i9.f3660e.equalsIgnoreCase(str)) {
                    return i9;
                }
            } else if (i9.f3659d.equalsIgnoreCase(str)) {
                return i9;
            }
        }
        return null;
    }

    public static I9 j(String str) {
        for (I9 i9 : values()) {
            if (i9.f3658c.equals(str)) {
                return i9;
            }
        }
        return null;
    }

    public final String a() {
        if (IrctcImaApplication.e.equals("hi")) {
            return this.f3660e;
        }
        return this.f3659d;
    }

    public final String f() {
        return this.f3658c;
    }

    public final String toString() {
        return this.f3659d;
    }
}
