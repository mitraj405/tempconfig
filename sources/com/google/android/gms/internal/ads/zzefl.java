package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzefl extends zzbpv {
    private final zzeew zza;

    public /* synthetic */ zzefl(zzeew zzeew, zzefk zzefk) {
        this.zza = zzeew;
    }

    public final void zze(String str) throws RemoteException {
        ((zzegp) this.zza.zzc).zzi(0, str);
    }

    public final void zzf(zze zze) throws RemoteException {
        ((zzegp) this.zza.zzc).zzh(zze);
    }

    public final void zzg() throws RemoteException {
        ((zzegp) this.zza.zzc).zzo();
    }
}
