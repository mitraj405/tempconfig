package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcwa {
    private final Context zza;
    private final zzffg zzb;
    private final Bundle zzc;
    private final zzfey zzd;
    private final zzcvs zze;
    private final zzeey zzf;

    public /* synthetic */ zzcwa(zzcvy zzcvy, zzcvz zzcvz) {
        this.zza = zzcvy.zza;
        this.zzb = zzcvy.zzb;
        this.zzc = zzcvy.zzc;
        this.zzd = zzcvy.zzd;
        this.zze = zzcvy.zze;
        this.zzf = zzcvy.zzf;
    }

    public final Context zza(Context context) {
        return this.zza;
    }

    public final Bundle zzb() {
        return this.zzc;
    }

    public final zzcvs zzc() {
        return this.zze;
    }

    public final zzcvy zzd() {
        zzcvy zzcvy = new zzcvy();
        zzcvy.zze(this.zza);
        zzcvy.zzi(this.zzb);
        zzcvy.zzf(this.zzc);
        zzcvy.zzg(this.zze);
        zzcvy.zzd(this.zzf);
        return zzcvy;
    }

    public final zzeey zze(String str) {
        zzeey zzeey = this.zzf;
        if (zzeey != null) {
            return zzeey;
        }
        return new zzeey(str);
    }

    public final zzfey zzf() {
        return this.zzd;
    }

    public final zzffg zzg() {
        return this.zzb;
    }
}
