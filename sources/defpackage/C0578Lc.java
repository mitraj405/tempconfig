package defpackage;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@C1128g8(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt", f = "Errors.kt", l = {156}, m = "catchImpl")
/* renamed from: Lc  reason: default package and case insensitive filesystem */
/* compiled from: Errors.kt */
public final class C0578Lc<T> extends C1148h7 {
    public C0571Ks a;

    /* renamed from: a  reason: collision with other field name */
    public /* synthetic */ Object f3695a;
    public int c;

    public C0578Lc(Continuation<? super C0578Lc> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.f3695a = obj;
        this.c |= Integer.MIN_VALUE;
        return r1.j(this, (Flow) null, (FlowCollector) null);
    }
}
