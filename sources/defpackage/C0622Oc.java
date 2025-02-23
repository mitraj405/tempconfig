package defpackage;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: Oc  reason: default package and case insensitive filesystem */
/* compiled from: Limit.kt */
public final class C0622Oc implements FlowCollector<Object> {
    public final /* synthetic */ C0571Ks a;

    public C0622Oc(C0571Ks ks) {
        this.a = ks;
    }

    public final Object emit(Object obj, Continuation<? super Unit> continuation) {
        this.a.a = obj;
        throw new C1185j(this);
    }
}
