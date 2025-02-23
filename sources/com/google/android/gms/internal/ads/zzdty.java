package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzdty extends zzbwm {
    final /* synthetic */ zzdua zza;

    public zzdty(zzdua zzdua) {
        this.zza = zzdua;
    }

    public final void zze(int i) throws RemoteException {
        zzdua zzdua = this.zza;
        zzdua.zzb.zzm(zzdua.zza, i);
    }

    public final void zzf(zze zze) throws RemoteException {
        zzdua zzdua = this.zza;
        zzdua.zzb.zzm(zzdua.zza, zze.zza);
    }

    public final void zzg() throws RemoteException {
        zzdua zzdua = this.zza;
        zzdua.zzb.zzp(zzdua.zza);
    }
}
