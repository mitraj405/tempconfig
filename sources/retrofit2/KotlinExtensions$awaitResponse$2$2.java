package retrofit2;

import kotlinx.coroutines.CancellableContinuation;

/* compiled from: KotlinExtensions.kt */
public final class KotlinExtensions$awaitResponse$2$2 implements Callback<T> {
    final /* synthetic */ CancellableContinuation $continuation;

    public KotlinExtensions$awaitResponse$2$2(CancellableContinuation cancellableContinuation) {
        this.$continuation = cancellableContinuation;
    }

    public void onFailure(Call<T> call, Throwable th) {
        C1177ig.g(call, "call");
        C1177ig.g(th, "t");
        this.$continuation.resumeWith(r1.n(th));
    }

    public void onResponse(Call<T> call, Response<T> response) {
        C1177ig.g(call, "call");
        C1177ig.g(response, "response");
        this.$continuation.resumeWith(response);
    }
}
