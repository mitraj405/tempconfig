package defpackage;

import androidx.datastore.core.CorruptionException;
import java.io.IOException;
import kotlin.jvm.functions.Function1;

/* renamed from: wt  reason: default package */
/* compiled from: ReplaceFileCorruptionHandler.kt */
public final class wt<T> implements C0387x7<T> {
    public final Function1<CorruptionException, T> a;

    public wt(Function1<? super CorruptionException, ? extends T> function1) {
        C1177ig.f(function1, "produceNewData");
        this.a = function1;
    }

    public final Object b(CorruptionException corruptionException) throws IOException {
        return this.a.invoke(corruptionException);
    }
}
