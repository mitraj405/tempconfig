package defpackage;

import java.util.LinkedHashSet;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

@C1128g8(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {402, 410}, m = "transformAndWrite")
/* renamed from: fx  reason: default package and case insensitive filesystem */
/* compiled from: SingleProcessDataStore.kt */
public final class C0197fx extends C1148h7 {
    public Ww a;

    /* renamed from: a  reason: collision with other field name */
    public Object f2958a;
    public final /* synthetic */ Ww<Object> b;

    /* renamed from: b  reason: collision with other field name */
    public Object f2959b;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public /* synthetic */ Object f2960c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0197fx(Ww<Object> ww, Continuation<? super C0197fx> continuation) {
        super(continuation);
        this.b = ww;
    }

    public final Object invokeSuspend(Object obj) {
        this.f2960c = obj;
        this.c |= Integer.MIN_VALUE;
        LinkedHashSet linkedHashSet = Ww.f638a;
        return this.b.j(this, (CoroutineContext) null, (Function2) null);
    }
}
