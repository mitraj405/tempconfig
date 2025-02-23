package defpackage;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@C1128g8(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", l = {183}, m = "first")
/* renamed from: Pc  reason: default package and case insensitive filesystem */
/* compiled from: Reduce.kt */
public final class C0636Pc<T> extends C1148h7 {
    public C0571Ks a;

    /* renamed from: a  reason: collision with other field name */
    public C0622Oc f3752a;

    /* renamed from: a  reason: collision with other field name */
    public /* synthetic */ Object f3753a;
    public int c;

    public C0636Pc(Continuation<? super C0636Pc> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.f3753a = obj;
        this.c |= Integer.MIN_VALUE;
        return r1.r((Flow) null, this);
    }
}
