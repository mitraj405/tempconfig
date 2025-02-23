package defpackage;

import android.view.View;
import android.view.WindowInsets;
import in.juspay.hypersdk.core.JuspayServices;

/* renamed from: dh  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C1071dh implements View.OnApplyWindowInsetsListener {
    public final /* synthetic */ JuspayServices a;

    public /* synthetic */ C1071dh(JuspayServices juspayServices) {
        this.a = juspayServices;
    }

    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        return this.a.lambda$process$3(view, windowInsets);
    }
}
