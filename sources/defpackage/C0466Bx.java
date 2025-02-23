package defpackage;

import android.graphics.Rect;

/* renamed from: Bx  reason: default package and case insensitive filesystem */
/* compiled from: SourceData */
public final class C0466Bx {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public Rect f3536a;

    /* renamed from: a  reason: collision with other field name */
    public final C1429us f3537a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f3538a;
    public final int b;

    public C0466Bx(byte[] bArr, int i, int i2, int i3, int i4) {
        this.f3537a = new C1429us(bArr, i, i2);
        this.b = i4;
        this.a = i3;
        if (i * i2 > bArr.length) {
            StringBuilder C = C1058d.C("Image data does not match the resolution. ", i, "x", i2, " > ");
            C.append(bArr.length);
            throw new IllegalArgumentException(C.toString());
        }
    }
}
