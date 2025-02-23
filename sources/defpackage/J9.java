package defpackage;

import cris.org.in.ima.IrctcImaApplication;

/* renamed from: J9  reason: default package */
/* compiled from: EAppConstant */
public enum J9 {
    ;
    

    /* renamed from: a  reason: collision with other field name */
    public final char f3664a;
    public final int c;

    /* renamed from: c  reason: collision with other field name */
    public final String f3665c;
    public final String d;

    /* access modifiers changed from: public */
    J9(int i, char c2, String str, String str2) {
        this.c = i;
        this.f3664a = c2;
        this.f3665c = str;
        this.d = str2;
    }

    public static J9 i(char c2) {
        for (J9 j9 : values()) {
            if (j9.f3664a == c2) {
                return j9;
            }
        }
        return null;
    }

    public static J9 j(String str) {
        for (J9 j9 : values()) {
            if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
                if (j9.d.equalsIgnoreCase(str)) {
                    return j9;
                }
            } else if (j9.f3665c.equalsIgnoreCase(str)) {
                return j9;
            }
        }
        return null;
    }

    public final char a() {
        return this.f3664a;
    }

    public final String f() {
        if (IrctcImaApplication.e.equalsIgnoreCase("hi")) {
            return this.d;
        }
        return this.f3665c;
    }
}
