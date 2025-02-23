package defpackage;

import com.google.firebase.analytics.FirebaseAnalytics;

/* renamed from: N1  reason: default package and case insensitive filesystem */
/* compiled from: _Arrays.kt */
public class C0601N1 extends r1 {
    public static final void W(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        C1177ig.f(objArr, "<this>");
        C1177ig.f(objArr2, FirebaseAnalytics.Param.DESTINATION);
        System.arraycopy(objArr, i2, objArr2, i, i3 - i2);
    }
}
