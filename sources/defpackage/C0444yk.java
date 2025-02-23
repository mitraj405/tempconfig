package defpackage;

import android.window.OnBackInvokedCallback;
import com.google.android.material.motion.MaterialBackHandler;

/* renamed from: yk  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0444yk implements OnBackInvokedCallback {
    public final /* synthetic */ MaterialBackHandler a;

    public /* synthetic */ C0444yk(MaterialBackHandler materialBackHandler) {
        this.a = materialBackHandler;
    }

    public final void onBackInvoked() {
        this.a.handleBackInvoked();
    }
}
