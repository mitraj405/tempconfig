package com.google.android.gms.dynamic;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
final class zag implements zah {
    final /* synthetic */ DeferredLifecycleHelper zaa;

    public zag(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.zaa = deferredLifecycleHelper;
    }

    public final int zaa() {
        return 5;
    }

    public final void zab(LifecycleDelegate lifecycleDelegate) {
        this.zaa.zaa.onResume();
    }
}
