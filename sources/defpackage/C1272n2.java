package defpackage;

import com.google.zxing.Result;

/* renamed from: n2  reason: default package and case insensitive filesystem */
/* compiled from: BarcodeResult */
public final class C1272n2 {
    public final C0466Bx a;

    /* renamed from: a  reason: collision with other field name */
    public final Result f5599a;

    public C1272n2(Result result, C0466Bx bx) {
        this.f5599a = result;
        this.a = bx;
    }

    public final String toString() {
        return this.f5599a.getText();
    }
}
