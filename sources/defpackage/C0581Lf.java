package defpackage;

import android.view.View;
import android.widget.AdapterView;
import in.juspay.hypersdk.core.InflateView;

/* renamed from: Lf  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0581Lf implements AdapterView.OnItemClickListener {
    public final /* synthetic */ InflateView a;
    public final /* synthetic */ String c;

    public /* synthetic */ C0581Lf(InflateView inflateView, String str) {
        this.a = inflateView;
        this.c = str;
    }

    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.a.lambda$parseKeys$5(this.c, adapterView, view, i, j);
    }
}
