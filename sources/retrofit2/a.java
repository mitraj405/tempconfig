package retrofit2;

import retrofit2.DefaultCallAdapterFactory;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ Callback a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 f6942a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Response f6943a;

    public /* synthetic */ a(DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 r1, Callback callback, Response response) {
        this.f6942a = r1;
        this.a = callback;
        this.f6943a = response;
    }

    public final void run() {
        this.f6942a.lambda$onResponse$0(this.a, this.f6943a);
    }
}
