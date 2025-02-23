package defpackage;

import androidx.lifecycle.MutableLiveData;
import androidx.work.impl.utils.futures.SettableFuture;
import defpackage.C0218ho;

/* renamed from: io  reason: default package */
/* compiled from: OperationImpl */
public final class io implements C0218ho {
    public final MutableLiveData<C0218ho.a> a = new MutableLiveData<>();

    /* renamed from: a  reason: collision with other field name */
    public final SettableFuture<C0218ho.a.c> f3019a = new SettableFuture<>();

    public io() {
        a(C0218ho.a);
    }

    public final void a(C0218ho.a aVar) {
        this.a.j(aVar);
        boolean z = aVar instanceof C0218ho.a.c;
        SettableFuture<C0218ho.a.c> settableFuture = this.f3019a;
        if (z) {
            settableFuture.h((C0218ho.a.c) aVar);
        } else if (aVar instanceof C0218ho.a.C0031a) {
            settableFuture.i(((C0218ho.a.C0031a) aVar).a);
        }
    }
}
