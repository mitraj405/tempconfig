package com.google.android.gms.common.api.internal;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
final class zav implements Runnable {
    final /* synthetic */ zaaa zaa;

    public zav(zaaa zaaa) {
        this.zaa = zaaa;
    }

    public final void run() {
        this.zaa.zam.lock();
        try {
            zaaa.zap(this.zaa);
        } finally {
            this.zaa.zam.unlock();
        }
    }
}
