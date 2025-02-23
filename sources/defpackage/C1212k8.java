package defpackage;

import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;

/* renamed from: k8  reason: default package and case insensitive filesystem */
/* compiled from: DecoderResultPointCallback */
public final class C1212k8 implements ResultPointCallback {
    public C1172i8 a;

    public final void foundPossibleResultPoint(ResultPoint resultPoint) {
        C1172i8 i8Var = this.a;
        if (i8Var != null) {
            i8Var.foundPossibleResultPoint(resultPoint);
        }
    }
}
