package defpackage;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

@C1128g8(c = "kotlinx.coroutines.flow.FlowKt__ChannelsKt", f = "Channels.kt", l = {36, 37}, m = "emitAllImpl$FlowKt__ChannelsKt")
/* renamed from: Jc  reason: default package and case insensitive filesystem */
/* compiled from: Channels.kt */
public final class C0552Jc<T> extends C1148h7 {
    public C0475Cs a;

    /* renamed from: a  reason: collision with other field name */
    public C0689T4 f3666a;

    /* renamed from: a  reason: collision with other field name */
    public /* synthetic */ Object f3667a;

    /* renamed from: a  reason: collision with other field name */
    public FlowCollector f3668a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f3669a;
    public int c;

    public C0552Jc(Continuation<? super C0552Jc> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.f3667a = obj;
        this.c |= Integer.MIN_VALUE;
        return C1354qp.F((FlowCollector) null, (C1501yq) null, false, this);
    }
}
