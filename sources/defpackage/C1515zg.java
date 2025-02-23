package defpackage;

import android.renderscript.RenderScript;
import android.view.View;
import in.juspay.hypersdk.core.JBridge;

/* renamed from: zg  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C1515zg implements Runnable {
    public final /* synthetic */ RenderScript a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ View f7103a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ JBridge f7104a;
    public final /* synthetic */ View b;
    public final /* synthetic */ int c;

    public /* synthetic */ C1515zg(JBridge jBridge, RenderScript renderScript, int i, View view, View view2) {
        this.f7104a = jBridge;
        this.a = renderScript;
        this.c = i;
        this.f7103a = view;
        this.b = view2;
    }

    public final void run() {
        this.f7104a.lambda$blurBackground$8(this.a, this.c, this.f7103a, this.b);
    }
}
