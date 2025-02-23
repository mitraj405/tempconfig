package defpackage;

import kotlin.coroutines.Continuation;

@C1128g8(c = "kotlinx.coroutines.flow.SubscribedFlowCollector", f = "Share.kt", l = {419, 423}, m = "onSubscription")
/* renamed from: yy  reason: default package and case insensitive filesystem */
/* compiled from: Share.kt */
public final class C1505yy extends C1148h7 {
    public C0559Ju a;

    /* renamed from: a  reason: collision with other field name */
    public /* synthetic */ Object f7074a;

    /* renamed from: a  reason: collision with other field name */
    public C1523zy f7075a;
    public final /* synthetic */ C1523zy<Object> b;
    public int c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1505yy(C1523zy<Object> zyVar, Continuation<? super C1505yy> continuation) {
        super(continuation);
        this.b = zyVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f7074a = obj;
        this.c |= Integer.MIN_VALUE;
        return this.b.b(this);
    }
}
