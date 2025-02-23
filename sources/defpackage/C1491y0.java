package defpackage;

import com.google.zxing.client.android.AmbientLightManager;

/* renamed from: y0  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C1491y0 implements Runnable {
    public final /* synthetic */ AmbientLightManager a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f7067a;

    public /* synthetic */ C1491y0(AmbientLightManager ambientLightManager, boolean z) {
        this.a = ambientLightManager;
        this.f7067a = z;
    }

    public final void run() {
        this.a.lambda$setTorch$0(this.f7067a);
    }
}
