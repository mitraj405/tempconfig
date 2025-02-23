package defpackage;

import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Callable;

/* renamed from: D3  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class D3 implements AsyncCallable {
    public final /* synthetic */ ListeningExecutorService a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Callable f111a;

    public /* synthetic */ D3(ListeningExecutorService listeningExecutorService, Callable callable) {
        this.a = listeningExecutorService;
        this.f111a = callable;
    }

    public final ListenableFuture call() {
        return this.a.submit(this.f111a);
    }
}
