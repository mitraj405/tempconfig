package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzehs extends zzbqe {
    final /* synthetic */ zzeht zza;
    private final zzeew zzb;

    public /* synthetic */ zzehs(zzeht zzeht, zzeew zzeew, zzehr zzehr) {
        this.zza = zzeht;
        this.zzb = zzeew;
    }

    public final void zze(String str) throws RemoteException {
        ((zzegp) this.zzb.zzc).zzi(0, str);
    }

    public final void zzf(zze zze) throws RemoteException {
        ((zzegp) this.zzb.zzc).zzh(zze);
    }

    public final void zzg(zzbpb zzbpb) throws RemoteException {
        this.zza.zzc = zzbpb;
        ((zzegp) this.zzb.zzc).zzo();
    }
}
