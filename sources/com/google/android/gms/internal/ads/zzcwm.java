package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcwm implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;

    public zzcwm(zzcwl zzcwl, zzhfu zzhfu, zzhfu zzhfu2, zzhfu zzhfu3, zzhfu zzhfu4) {
        this.zza = zzhfu;
        this.zzb = zzhfu2;
        this.zzc = zzhfu3;
    }

    public final /* synthetic */ Object zzb() {
        String str;
        Context context = (Context) this.zza.zzb();
        VersionInfoParcel zza2 = ((zzchc) this.zzb).zza();
        zzfel zza3 = ((zzcsl) this.zzc).zza();
        zzbxh zzbxh = new zzbxh();
        zzbxi zzbxi = zza3.zzA;
        if (zzbxi == null) {
            return null;
        }
        zzfeq zzfeq = zza3.zzs;
        if (zzfeq == null) {
            str = null;
        } else {
            str = zzfeq.zzb;
        }
        return new zzbxg(context, zza2, zzbxi, str, zzbxh);
    }
}
