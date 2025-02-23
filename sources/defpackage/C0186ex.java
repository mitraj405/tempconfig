package defpackage;

import defpackage.Ww;
import kotlin.coroutines.Continuation;

@C1128g8(c = "androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1", f = "SingleProcessDataStore.kt", l = {503, 337, 339}, m = "updateData")
/* renamed from: ex  reason: default package and case insensitive filesystem */
/* compiled from: SingleProcessDataStore.kt */
public final class C0186ex extends C1148h7 {
    public C0571Ks a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Ww.d f2915a;

    /* renamed from: a  reason: collision with other field name */
    public Ww f2916a;

    /* renamed from: a  reason: collision with other field name */
    public Object f2917a;
    public Object b;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public Object f2918c;
    public /* synthetic */ Object d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0186ex(Ww.d dVar, Continuation<? super C0186ex> continuation) {
        super(continuation);
        this.f2915a = dVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.c |= Integer.MIN_VALUE;
        return this.f2915a.a((Z7) null, this);
    }
}
