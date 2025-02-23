package defpackage;

import android.view.KeyEvent;
import android.view.View;
import in.juspay.hypersdk.core.InflateView;

/* renamed from: If  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class If implements View.OnKeyListener {
    public final /* synthetic */ InflateView a;
    public final /* synthetic */ String c;

    public /* synthetic */ If(InflateView inflateView, String str) {
        this.a = inflateView;
        this.c = str;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        return this.a.lambda$parseKeys$1(this.c, view, i, keyEvent);
    }
}
