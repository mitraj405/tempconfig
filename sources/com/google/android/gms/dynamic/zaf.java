package com.google.android.gms.dynamic;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
final class zaf implements zah {
    final /* synthetic */ DeferredLifecycleHelper zaa;

    public zaf(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.zaa = deferredLifecycleHelper;
    }

    public final int zaa() {
        return 4;
    }

    public final void zab(LifecycleDelegate lifecycleDelegate) {
        this.zaa.zaa.onStart();
    }
}
