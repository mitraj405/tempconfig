package defpackage;

import android.content.Context;
import com.airbnb.lottie.LottieAnimationView;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* renamed from: dj  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0170dj implements Callable {
    public final /* synthetic */ LottieAnimationView a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f2873a;

    public /* synthetic */ C0170dj(LottieAnimationView lottieAnimationView, String str) {
        this.a = lottieAnimationView;
        this.f2873a = str;
    }

    public final Object call() {
        LottieAnimationView lottieAnimationView = this.a;
        boolean z = lottieAnimationView.f2771c;
        String str = this.f2873a;
        if (!z) {
            return C0281nj.b(lottieAnimationView.getContext(), str, (String) null);
        }
        Context context = lottieAnimationView.getContext();
        HashMap hashMap = C0281nj.a;
        return C0281nj.b(context, str, "asset_" + str);
    }
}
