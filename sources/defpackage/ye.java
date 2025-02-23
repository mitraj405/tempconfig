package defpackage;

import android.graphics.Path;

/* renamed from: ye  reason: default package */
/* compiled from: GradientFill */
public final class ye implements Z6 {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final G0 f3432a;

    /* renamed from: a  reason: collision with other field name */
    public final I0 f3433a;

    /* renamed from: a  reason: collision with other field name */
    public final J0 f3434a;

    /* renamed from: a  reason: collision with other field name */
    public final Path.FillType f3435a;

    /* renamed from: a  reason: collision with other field name */
    public final String f3436a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f3437a;
    public final G0 b;

    public ye(String str, int i, Path.FillType fillType, I0 i0, J0 j0, G0 g0, G0 g02, boolean z) {
        this.a = i;
        this.f3435a = fillType;
        this.f3433a = i0;
        this.f3434a = j0;
        this.f3432a = g0;
        this.b = g02;
        this.f3436a = str;
        this.f3437a = z;
    }

    public final V6 a(Ej ej, C0359v2 v2Var) {
        return new ze(ej, v2Var, this);
    }
}
