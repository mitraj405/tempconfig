package defpackage;

import android.view.View;
import in.juspay.hypersdk.core.InflateView;

/* renamed from: Mf  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0594Mf implements View.OnFocusChangeListener {
    public final /* synthetic */ InflateView a;
    public final /* synthetic */ String c;

    public /* synthetic */ C0594Mf(InflateView inflateView, String str) {
        this.a = inflateView;
        this.c = str;
    }

    public final void onFocusChange(View view, boolean z) {
        this.a.lambda$parseKeys$6(this.c, view, z);
    }
}
