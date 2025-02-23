package defpackage;

import android.view.View;
import in.juspay.hyperlottie.LottieAnimation;

/* renamed from: Zi  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0769Zi implements Hj {
    public final /* synthetic */ Ej a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ View f3882a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f3883a;

    public /* synthetic */ C0769Zi(Ej ej, View view, boolean z) {
        this.a = ej;
        this.f3882a = view;
        this.f3883a = z;
    }

    public final void onResult(Object obj) {
        LottieAnimation.lambda$applyAnimation$0(this.a, this.f3882a, this.f3883a, (C0181ej) obj);
    }
}
