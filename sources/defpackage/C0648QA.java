package defpackage;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* renamed from: QA  reason: default package and case insensitive filesystem */
/* compiled from: TypeIntrinsics */
public final class C0648QA {
    public static void a(int i, Object obj) {
        int i2;
        if (obj != null) {
            boolean z = false;
            if (obj instanceof C0782ae) {
                if (obj instanceof C0801be) {
                    i2 = ((C0801be) obj).getArity();
                } else if (obj instanceof Function0) {
                    i2 = 0;
                } else if (obj instanceof Function1) {
                    i2 = 1;
                } else if (obj instanceof Function2) {
                    i2 = 2;
                } else if (obj instanceof C0694Td) {
                    i2 = 3;
                } else if (obj instanceof C0706Ud) {
                    i2 = 4;
                } else if (obj instanceof C0722Vd) {
                    i2 = 5;
                } else if (obj instanceof C0736Wd) {
                    i2 = 6;
                } else if (obj instanceof C0747Xd) {
                    i2 = 7;
                } else if (obj instanceof C0756Yd) {
                    i2 = 8;
                } else if (obj instanceof C0767Zd) {
                    i2 = 9;
                } else if (obj instanceof C0517Gd) {
                    i2 = 10;
                } else if (obj instanceof C0528Hd) {
                    i2 = 11;
                } else if (obj instanceof C0540Id) {
                    i2 = 12;
                } else if (obj instanceof C0553Jd) {
                    i2 = 13;
                } else if (obj instanceof C0566Kd) {
                    i2 = 14;
                } else if (obj instanceof C0579Ld) {
                    i2 = 15;
                } else if (obj instanceof C0592Md) {
                    i2 = 16;
                } else if (obj instanceof C0608Nd) {
                    i2 = 17;
                } else if (obj instanceof C0623Od) {
                    i2 = 18;
                } else if (obj instanceof C0637Pd) {
                    i2 = 19;
                } else if (obj instanceof C0651Qd) {
                    i2 = 20;
                } else if (obj instanceof C0666Rd) {
                    i2 = 21;
                } else if (obj instanceof C0681Sd) {
                    i2 = 22;
                } else {
                    i2 = -1;
                }
                if (i2 == i) {
                    z = true;
                }
            }
            if (!z) {
                ClassCastException classCastException = new ClassCastException(xx.D(obj.getClass().getName(), " cannot be cast to ", lf.h("kotlin.jvm.functions.Function", i)));
                C1177ig.i(C0648QA.class.getName(), classCastException);
                throw classCastException;
            }
        }
    }
}
