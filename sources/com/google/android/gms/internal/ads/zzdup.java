package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdup implements zzddr {
    private final Bundle zza = new Bundle();

    public final synchronized void zzb(String str, String str2) {
        this.zza.putInt(str, 3);
    }

    public final synchronized void zzc(String str) {
        this.zza.putInt(str, 1);
    }

    public final synchronized void zzd(String str) {
        this.zza.putInt(str, 2);
    }

    public final synchronized Bundle zzg() {
        return new Bundle(this.zza);
    }

    public final void zze() {
    }

    public final void zzf() {
    }

    public final void zza(String str) {
    }
}
