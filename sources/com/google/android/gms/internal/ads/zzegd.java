package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzegd extends zzbpy {
    final /* synthetic */ zzege zza;
    private final zzeew zzb;

    public /* synthetic */ zzegd(zzege zzege, zzeew zzeew, zzegc zzegc) {
        this.zza = zzege;
        this.zzb = zzeew;
    }

    public final void zze(String str) throws RemoteException {
        ((zzegp) this.zzb.zzc).zzi(0, str);
    }

    public final void zzf(zze zze) throws RemoteException {
        ((zzegp) this.zzb.zzc).zzh(zze);
    }

    public final void zzg(IObjectWrapper iObjectWrapper) throws RemoteException {
        this.zza.zzc = (View) ObjectWrapper.unwrap(iObjectWrapper);
        ((zzegp) this.zzb.zzc).zzo();
    }

    public final void zzh(zzbov zzbov) throws RemoteException {
        this.zza.zzd = zzbov;
        ((zzegp) this.zzb.zzc).zzo();
    }
}
