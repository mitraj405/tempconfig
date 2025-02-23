package defpackage;

import defpackage.a8;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import kotlin.coroutines.Continuation;

@C1128g8(c = "androidx.datastore.core.DataMigrationInitializer$Companion", f = "DataMigrationInitializer.kt", l = {42, 57}, m = "runMigrations")
/* renamed from: Y7  reason: default package */
/* compiled from: DataMigrationInitializer.kt */
public final class Y7<T> extends C1148h7 {
    public final /* synthetic */ a8.a a;

    /* renamed from: a  reason: collision with other field name */
    public Serializable f709a;

    /* renamed from: a  reason: collision with other field name */
    public /* synthetic */ Object f710a;

    /* renamed from: a  reason: collision with other field name */
    public Iterator f711a;
    public int c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Y7(a8.a aVar, Continuation<? super Y7> continuation) {
        super(continuation);
        this.a = aVar;
    }

    public final Object invokeSuspend(Object obj) {
        this.f710a = obj;
        this.c |= Integer.MIN_VALUE;
        return a8.a.a(this.a, (List) null, (Tf) null, this);
    }
}
