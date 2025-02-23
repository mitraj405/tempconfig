package retrofit2;

import retrofit2.DefaultCallAdapterFactory;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ Throwable a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Callback f6944a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 f6945a;

    public /* synthetic */ b(DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 r1, Callback callback, Throwable th) {
        this.f6945a = r1;
        this.f6944a = callback;
        this.a = th;
    }

    public final void run() {
        this.f6945a.lambda$onFailure$1(this.f6944a, this.a);
    }
}
