package defpackage;

import defpackage.Ww;
import kotlin.coroutines.Continuation;

@C1128g8(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {276, 281, 284}, m = "handleUpdate")
/* renamed from: dx  reason: default package and case insensitive filesystem */
/* compiled from: SingleProcessDataStore.kt */
public final class C0172dx extends C1148h7 {
    public N5 a;

    /* renamed from: a  reason: collision with other field name */
    public Ww f2874a;

    /* renamed from: a  reason: collision with other field name */
    public Object f2875a;
    public final /* synthetic */ Ww<Object> b;

    /* renamed from: b  reason: collision with other field name */
    public /* synthetic */ Object f2876b;
    public int c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0172dx(Ww<Object> ww, Continuation<? super C0172dx> continuation) {
        super(continuation);
        this.b = ww;
    }

    public final Object invokeSuspend(Object obj) {
        this.f2876b = obj;
        this.c |= Integer.MIN_VALUE;
        return Ww.c(this.b, (Ww.a.b) null, this);
    }
}
