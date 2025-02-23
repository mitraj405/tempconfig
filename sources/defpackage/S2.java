package defpackage;

import androidx.biometric.d;

/* renamed from: S2  reason: default package */
/* compiled from: BiometricFragment */
public final class S2 implements Runnable {
    public final /* synthetic */ d a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ CharSequence f504a;
    public final /* synthetic */ int c;

    public S2(d dVar, int i, CharSequence charSequence) {
        this.a = dVar;
        this.c = i;
        this.f504a = charSequence;
    }

    public final void run() {
        this.a.k(this.c, this.f504a);
    }
}
