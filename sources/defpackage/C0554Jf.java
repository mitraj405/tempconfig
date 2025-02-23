package defpackage;

import android.view.View;
import in.juspay.hypersdk.core.InflateView;

/* renamed from: Jf  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0554Jf implements View.OnLongClickListener {
    public final /* synthetic */ InflateView a;
    public final /* synthetic */ String c;

    public /* synthetic */ C0554Jf(InflateView inflateView, String str) {
        this.a = inflateView;
        this.c = str;
    }

    public final boolean onLongClick(View view) {
        return this.a.lambda$parseKeys$2(this.c, view);
    }
}
