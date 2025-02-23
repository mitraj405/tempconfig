package com.google.android.gms.internal.ads;

import android.app.Activity;
import com.google.android.gms.ads.internal.overlay.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzecw extends zzedt {
    private Activity zza;
    private zzm zzb;
    private String zzc;
    private String zzd;

    public final zzedt zza(Activity activity) {
        if (activity != null) {
            this.zza = activity;
            return this;
        }
        throw new NullPointerException("Null activity");
    }

    public final zzedt zzb(zzm zzm) {
        this.zzb = zzm;
        return this;
    }

    public final zzedt zzc(String str) {
        this.zzc = str;
        return this;
    }

    public final zzedt zzd(String str) {
        this.zzd = str;
        return this;
    }

    public final zzedu zze() {
        Activity activity = this.zza;
        if (activity != null) {
            return new zzecy(activity, this.zzb, this.zzc, this.zzd, (zzecx) null);
        }
        throw new IllegalStateException("Missing required properties: activity");
    }
}
