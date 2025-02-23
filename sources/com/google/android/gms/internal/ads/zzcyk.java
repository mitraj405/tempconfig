package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcyk extends zzdch implements zzbhn {
    private final Bundle zzb = new Bundle();

    public zzcyk(Set set) {
        super(set);
    }

    public final synchronized void zza(String str, Bundle bundle) {
        this.zzb.putAll(bundle);
        zzq(new zzcyj());
    }

    public final synchronized Bundle zzb() {
        return new Bundle(this.zzb);
    }
}
