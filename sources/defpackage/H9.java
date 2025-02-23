package defpackage;

import cris.org.in.ima.IrctcImaApplication;

/* renamed from: H9  reason: default package */
/* compiled from: EAppConstant */
public enum H9 {
    a("GN", "GENERAL", "सामान्य"),
    b("LD", "LADIES", "महिला"),
    c("TQ", "TATKAL", "तत्काल"),
    d("SS", "SENIOR CITIZEN", "वरिष्ठ नागरिक"),
    e("HP", "Person with disability", "दिव्यांग "),
    f("PQ", "POOLED QUOTA", "POOLED QUOTA"),
    g("PT", "PREMIUM TATKAL", "प्रीमियम तत्काल"),
    h("PH", "PARLIAMENT HOUSE", "PARLIAMENT HOUSE"),
    i("DP", "DUTY PASS", "ड्यूटी पास");
    

    /* renamed from: c  reason: collision with other field name */
    public final String f3610c;

    /* renamed from: d  reason: collision with other field name */
    public final String f3611d;

    /* renamed from: e  reason: collision with other field name */
    public final String f3612e;

    /* access modifiers changed from: public */
    H9(String str, String str2, String str3) {
        this.f3610c = str;
        this.f3611d = str2;
        this.f3612e = str3;
    }

    public static H9 f(String str) {
        for (H9 h9 : values()) {
            if (h9.f3610c.equalsIgnoreCase(str)) {
                return h9;
            }
        }
        return null;
    }

    public static H9 i(String str) {
        for (H9 h9 : values()) {
            if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
                if (h9.f3612e.equalsIgnoreCase(str)) {
                    return h9;
                }
            } else if (h9.f3611d.equalsIgnoreCase(str)) {
                return h9;
            }
        }
        return null;
    }

    public final String a() {
        if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
            return this.f3612e;
        }
        return this.f3611d;
    }
}
