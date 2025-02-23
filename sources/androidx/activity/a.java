package androidx.activity;

import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContract;

/* compiled from: ComponentActivity */
public final class a implements Runnable {
    public final /* synthetic */ ComponentActivity.a a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ActivityResultContract.a f822a;
    public final /* synthetic */ int c;

    public a(ComponentActivity.a aVar, int i, ActivityResultContract.a aVar2) {
        this.a = aVar;
        this.c = i;
        this.f822a = aVar2;
    }

    public final void run() {
        ActivityResultCallback<O> activityResultCallback;
        T t = this.f822a.a;
        ComponentActivity.a aVar = this.a;
        String str = (String) aVar.f825a.get(Integer.valueOf(this.c));
        if (str != null) {
            ActivityResultRegistry.a aVar2 = (ActivityResultRegistry.a) aVar.d.get(str);
            if (aVar2 == null || (activityResultCallback = aVar2.a) == null) {
                aVar.a.remove(str);
                aVar.e.put(str, t);
            } else if (aVar.f824a.remove(str)) {
                activityResultCallback.a(t);
            }
        }
    }
}
