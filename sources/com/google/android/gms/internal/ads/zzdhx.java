package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzdhx implements zzbix {
    private final WeakReference zza;

    public /* synthetic */ zzdhx(zzdhy zzdhy, zzdhw zzdhw) {
        this.zza = new WeakReference(zzdhy);
    }

    public final void zza(Object obj, Map map) {
        zzdhy zzdhy = (zzdhy) this.zza.get();
        if (zzdhy != null) {
            zzdhy.zzg.zza();
        }
    }
}
