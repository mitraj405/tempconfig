package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzbh;
import com.google.android.gms.ads.internal.client.zzbm;
import com.google.android.gms.ads.internal.client.zzl;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzelo extends zzbm {
    private final zzemv zza;

    public zzelo(Context context, zzcgj zzcgj, zzffe zzffe, zzdjm zzdjm, zzbh zzbh) {
        zzemx zzemx = new zzemx(zzdjm, zzcgj.zzj());
        zzemx.zze(zzbh);
        this.zza = new zzemv(new zzenh(zzcgj, context, zzemx, zzffe), zzffe.zzL());
    }

    public final synchronized String zze() {
        return this.zza.zza();
    }

    public final synchronized String zzf() {
        return this.zza.zzb();
    }

    public final void zzg(zzl zzl) throws RemoteException {
        this.zza.zzd(zzl, 1);
    }

    public final synchronized void zzh(zzl zzl, int i) throws RemoteException {
        this.zza.zzd(zzl, i);
    }

    public final synchronized boolean zzi() throws RemoteException {
        return this.zza.zze();
    }
}
