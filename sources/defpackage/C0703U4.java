package defpackage;

import defpackage.N4;
import kotlin.jvm.functions.Function1;

/* renamed from: U4  reason: default package and case insensitive filesystem */
/* compiled from: Channel.kt */
public final class C0703U4 {
    public static C1296o3 a(int i, int i2, int i3) {
        C1296o3 o3Var;
        boolean z = false;
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if (i != -2) {
            if (i == -1) {
                if (i2 == 1) {
                    z = true;
                }
                if (z) {
                    return new K6(1, 2, (Function1) null);
                }
                throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
            } else if (i != 0) {
                if (i == Integer.MAX_VALUE) {
                    return new C1296o3(Integer.MAX_VALUE, (Function1) null);
                }
                if (i2 == 1) {
                    return new C1296o3(i, (Function1) null);
                }
                return new K6(i, i2, (Function1) null);
            } else if (i2 == 1) {
                o3Var = new C1296o3(0, (Function1) null);
            } else {
                o3Var = new K6(1, i2, (Function1) null);
            }
        } else if (i2 == 1) {
            N4.a.getClass();
            o3Var = new C1296o3(N4.a.a, (Function1) null);
        } else {
            o3Var = new K6(1, i2, (Function1) null);
        }
        return o3Var;
    }
}
