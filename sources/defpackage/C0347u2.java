package defpackage;

import defpackage.C0335t2;

/* renamed from: u2  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0347u2 implements C0335t2.a {
    public final /* synthetic */ C0359v2 a;

    public /* synthetic */ C0347u2(C0359v2 v2Var) {
        this.a = v2Var;
    }

    public final void f() {
        boolean z;
        C0359v2 v2Var = this.a;
        if (v2Var.f3342a.l() == 1.0f) {
            z = true;
        } else {
            z = false;
        }
        if (z != v2Var.f3354a) {
            v2Var.f3354a = z;
            v2Var.f3341a.invalidateSelf();
        }
    }
}
