package defpackage;

import kotlinx.coroutines.CoroutineDispatcher;

/* renamed from: Sj  reason: default package and case insensitive filesystem */
/* compiled from: MainCoroutineDispatcher.kt */
public abstract class C0682Sj extends CoroutineDispatcher {
    public abstract C0682Sj r();

    public String toString() {
        String str;
        C0682Sj sj;
        C1474x8 x8Var = C1213k9.f5544a;
        C0682Sj sj2 = C0724Vj.a;
        if (this == sj2) {
            str = "Dispatchers.Main";
        } else {
            try {
                sj = sj2.r();
            } catch (UnsupportedOperationException unused) {
                sj = null;
            }
            if (this == sj) {
                str = "Dispatchers.Main.immediate";
            } else {
                str = null;
            }
        }
        if (str != null) {
            return str;
        }
        return getClass().getSimpleName() + '@' + C1149h8.a(this);
    }
}
