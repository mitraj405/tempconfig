package defpackage;

import androidx.concurrent.futures.AbstractResolvableFuture;
import com.google.common.util.concurrent.ListenableFuture;

/* renamed from: Bt  reason: default package */
/* compiled from: ResolvableFuture */
public final class Bt<V> extends AbstractResolvableFuture<V> {
    public final boolean set(V v) {
        return super.set(v);
    }

    public final boolean setException(Throwable th) {
        return super.setException(th);
    }

    public final boolean setFuture(ListenableFuture<? extends V> listenableFuture) {
        return super.setFuture(listenableFuture);
    }
}
