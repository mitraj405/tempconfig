package defpackage;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Collections;

/* renamed from: tw  reason: default package */
/* compiled from: ShapeLayer */
public final class tw extends C0359v2 {
    public final Y6 a;

    /* renamed from: a  reason: collision with other field name */
    public final l6 f3306a;

    public tw(Ej ej, Sh sh, l6 l6Var) {
        super(ej, sh);
        this.f3306a = l6Var;
        Y6 y6 = new Y6(ej, this, new qw(sh.f528a, "__container", false));
        this.a = y6;
        y6.d(Collections.emptyList(), Collections.emptyList());
    }

    public final void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        this.a.a(rectF, this.f3359c, z);
    }

    public final void l(Canvas canvas, Matrix matrix, int i) {
        this.a.c(canvas, matrix, i);
    }

    public final nh m() {
        nh nhVar = this.f3345a.f529a;
        if (nhVar != null) {
            return nhVar;
        }
        return this.f3306a.f3345a.f529a;
    }

    public final B9 n() {
        B9 b9 = this.f3345a.f521a;
        if (b9 != null) {
            return b9;
        }
        return this.f3306a.f3345a.f521a;
    }

    public final void r(uh uhVar, int i, ArrayList arrayList, uh uhVar2) {
        this.a.i(uhVar, i, arrayList, uhVar2);
    }
}
