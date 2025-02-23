package defpackage;

import android.content.Context;
import com.airbnb.lottie.LottieAnimationView;
import java.util.concurrent.Callable;

/* renamed from: aj  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0122aj implements Callable {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ LottieAnimationView f799a;

    public /* synthetic */ C0122aj(LottieAnimationView lottieAnimationView, int i) {
        this.f799a = lottieAnimationView;
        this.a = i;
    }

    public final Object call() {
        LottieAnimationView lottieAnimationView = this.f799a;
        boolean z = lottieAnimationView.f2771c;
        int i = this.a;
        if (!z) {
            return C0281nj.e(lottieAnimationView.getContext(), i, (String) null);
        }
        Context context = lottieAnimationView.getContext();
        return C0281nj.e(context, i, C0281nj.h(context, i));
    }
}
