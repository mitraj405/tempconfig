package in.juspay.hypersdk.core;

import android.view.View;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class f implements View.OnClickListener {
    public final /* synthetic */ AndroidInterface a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String[] f5496a;
    public final /* synthetic */ String c;

    public /* synthetic */ f(AndroidInterface androidInterface, String[] strArr, String str) {
        this.a = androidInterface;
        this.f5496a = strArr;
        this.c = str;
    }

    public final void onClick(View view) {
        this.a.lambda$generateUIElement$14(this.f5496a, this.c, view);
    }
}
