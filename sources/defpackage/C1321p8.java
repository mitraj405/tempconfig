package defpackage;

import kotlinx.coroutines.e;

/* renamed from: p8  reason: default package and case insensitive filesystem */
/* compiled from: DefaultExecutor.kt */
public final class C1321p8 {
    public static final C0481D8 a;

    static {
        String str;
        boolean z;
        C0481D8 d8;
        int i = C1121fz.a;
        try {
            str = System.getProperty("kotlinx.coroutines.main.delay");
        } catch (SecurityException unused) {
            str = null;
        }
        if (str != null) {
            z = Boolean.parseBoolean(str);
        } else {
            z = false;
        }
        if (!z) {
            d8 = e.a;
        } else {
            C1474x8 x8Var = C1213k9.f5544a;
            C0682Sj sj = C0724Vj.a;
            sj.r();
            if (!(sj instanceof C0481D8)) {
                d8 = e.a;
            } else {
                d8 = (C0481D8) sj;
            }
        }
        a = d8;
    }
}
