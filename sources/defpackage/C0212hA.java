package defpackage;

import android.window.OnBackInvokedCallback;

/* renamed from: hA  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0212hA implements OnBackInvokedCallback {
    public final /* synthetic */ Runnable a;

    public /* synthetic */ C0212hA(Runnable runnable) {
        this.a = runnable;
    }

    public final void onBackInvoked() {
        this.a.run();
    }
}
