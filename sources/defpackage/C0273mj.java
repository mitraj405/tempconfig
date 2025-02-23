package defpackage;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;

/* renamed from: mj  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0273mj implements Callable {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Context f3103a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f3104a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ WeakReference f3105a;

    public /* synthetic */ C0273mj(WeakReference weakReference, Context context, int i, String str) {
        this.f3105a = weakReference;
        this.f3103a = context;
        this.a = i;
        this.f3104a = str;
    }

    public final Object call() {
        Context context = (Context) this.f3105a.get();
        if (context == null) {
            context = this.f3103a;
        }
        return C0281nj.e(context, this.a, this.f3104a);
    }
}
