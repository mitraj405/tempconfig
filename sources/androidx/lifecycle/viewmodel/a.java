package androidx.lifecycle.viewmodel;

import androidx.lifecycle.viewmodel.CreationExtras;

/* compiled from: CreationExtras.kt */
public final class a extends CreationExtras {
    public a() {
        this(CreationExtras.a.a);
    }

    public a(CreationExtras creationExtras) {
        C1177ig.f(creationExtras, "initialExtras");
        this.a.putAll(creationExtras.a);
    }
}
