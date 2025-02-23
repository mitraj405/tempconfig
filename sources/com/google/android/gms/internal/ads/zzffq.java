package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzffq implements zzgcf {
    final /* synthetic */ zzcej zza;
    final /* synthetic */ zzcni zzb;
    final /* synthetic */ zzfll zzc;
    final /* synthetic */ zzedh zzd;

    public zzffq(zzcej zzcej, zzcni zzcni, zzfll zzfll, zzedh zzedh) {
        this.zza = zzcej;
        this.zzb = zzcni;
        this.zzc = zzfll;
        this.zzd = zzedh;
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        String str = (String) obj;
        if (!this.zza.zzD().zzai) {
            if (!((Boolean) zzba.zzc().zza(zzbbw.zzjg)).booleanValue() || this.zzb == null || !zzcni.zzj(str)) {
                this.zzc.zzc(str, (zzfkf) null);
            } else {
                this.zzb.zzi(str, this.zzc, zzay.zze());
            }
        } else {
            long currentTimeMillis = zzu.zzB().currentTimeMillis();
            String str2 = this.zza.zzR().zzb;
            int i = 2;
            if (!zzu.zzo().zzA(this.zza.getContext())) {
                if ((!((Boolean) zzba.zzc().zza(zzbbw.zzfD)).booleanValue() || !this.zza.zzD().zzS) && this.zza.zzD().zzad == null) {
                    i = 1;
                }
            }
            this.zzd.zzd(new zzedj(currentTimeMillis, str2, str, i));
        }
    }

    public final void zza(Throwable th) {
    }
}
