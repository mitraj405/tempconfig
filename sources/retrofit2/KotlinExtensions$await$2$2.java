package retrofit2;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.reflect.Method;
import kotlinx.coroutines.CancellableContinuation;

/* compiled from: KotlinExtensions.kt */
public final class KotlinExtensions$await$2$2 implements Callback<T> {
    final /* synthetic */ CancellableContinuation $continuation;

    public KotlinExtensions$await$2$2(CancellableContinuation cancellableContinuation) {
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
        if (response.isSuccessful()) {
            T body = response.body();
            if (body == null) {
                Object tag = call.request().tag(Invocation.class);
                if (tag != null) {
                    Method method = ((Invocation) tag).method();
                    StringBuilder sb = new StringBuilder("Response from ");
                    C1177ig.b(method, FirebaseAnalytics.Param.METHOD);
                    Class<?> declaringClass = method.getDeclaringClass();
                    C1177ig.b(declaringClass, "method.declaringClass");
                    sb.append(declaringClass.getName());
                    sb.append('.');
                    sb.append(method.getName());
                    sb.append(" was null but response body type was declared as non-null");
                    this.$continuation.resumeWith(r1.n(new Gh(sb.toString())));
                    return;
                }
                Gh gh = new Gh();
                C1177ig.i(C1177ig.class.getName(), gh);
                throw gh;
            }
            this.$continuation.resumeWith(body);
            return;
        }
        this.$continuation.resumeWith(r1.n(new HttpException(response)));
    }
}
