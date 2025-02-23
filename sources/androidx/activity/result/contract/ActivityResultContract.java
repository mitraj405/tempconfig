package androidx.activity.result.contract;

import android.content.Intent;
import androidx.activity.ComponentActivity;
import in.juspay.hyper.constants.LogCategory;

/* compiled from: ActivityResultContract.kt */
public abstract class ActivityResultContract<I, O> {

    /* compiled from: ActivityResultContract.kt */
    public static final class a<T> {
        public final T a;

        public a(T t) {
            this.a = t;
        }
    }

    public abstract Intent a(ComponentActivity componentActivity, Object obj);

    public a b(ComponentActivity componentActivity, Object obj) {
        C1177ig.f(componentActivity, LogCategory.CONTEXT);
        return null;
    }

    public abstract O c(int i, Intent intent);
}
