package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzest implements zzevo {
    private final Context zza;
    private final Intent zzb;

    public zzest(Context context, Intent intent) {
        this.zza = context;
        this.zzb = intent;
    }

    public final int zza() {
        return 60;
    }

    public final ListenableFuture zzb() {
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzlQ)).booleanValue()) {
            return zzgcj.zzh(new zzesu((Boolean) null));
        }
        boolean z = false;
        try {
            if (this.zzb.resolveActivity(this.zza.getPackageManager()) != null) {
                z = true;
            }
        } catch (Exception e) {
            zzu.zzo().zzw(e, "HsdpMigrationSignal.isHsdpMigrationSupported");
        }
        return zzgcj.zzh(new zzesu(Boolean.valueOf(z)));
    }
}
