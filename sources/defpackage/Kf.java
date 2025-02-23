package defpackage;

import android.view.View;
import in.juspay.hypersdk.core.InflateView;

/* renamed from: Kf  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class Kf implements View.OnClickListener {
    public final /* synthetic */ InflateView a;
    public final /* synthetic */ String c;

    public /* synthetic */ Kf(InflateView inflateView, String str) {
        this.a = inflateView;
        this.c = str;
    }

    public final void onClick(View view) {
        this.a.lambda$parseKeys$3(this.c, view);
    }
}
