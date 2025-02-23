package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzbpq extends zzbor {
    private final Adapter zza;
    private final zzbvy zzb;

    public zzbpq(Adapter adapter, zzbvy zzbvy) {
        this.zza = adapter;
        this.zzb = zzbvy;
    }

    public final void zze() throws RemoteException {
        zzbvy zzbvy = this.zzb;
        if (zzbvy != null) {
            zzbvy.zze(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzf() throws RemoteException {
        zzbvy zzbvy = this.zzb;
        if (zzbvy != null) {
            zzbvy.zzf(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzg(int i) throws RemoteException {
        zzbvy zzbvy = this.zzb;
        if (zzbvy != null) {
            zzbvy.zzg(ObjectWrapper.wrap(this.zza), i);
        }
    }

    public final void zzo() throws RemoteException {
        zzbvy zzbvy = this.zzb;
        if (zzbvy != null) {
            zzbvy.zzi(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzp() throws RemoteException {
        zzbvy zzbvy = this.zzb;
        if (zzbvy != null) {
            zzbvy.zzj(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzt(zzbwd zzbwd) throws RemoteException {
        zzbvy zzbvy = this.zzb;
        if (zzbvy != null) {
            zzbvy.zzm(ObjectWrapper.wrap(this.zza), new zzbvz(zzbwd.zzf(), zzbwd.zze()));
        }
    }

    public final void zzu() throws RemoteException {
        zzbvy zzbvy = this.zzb;
        if (zzbvy != null) {
            zzbvy.zzn(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzy() throws RemoteException {
        zzbvy zzbvy = this.zzb;
        if (zzbvy != null) {
            zzbvy.zzo(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzm() throws RemoteException {
    }

    public final void zzn() throws RemoteException {
    }

    public final void zzv() throws RemoteException {
    }

    public final void zzw() throws RemoteException {
    }

    public final void zzx() throws RemoteException {
    }

    public final void zzh(zze zze) throws RemoteException {
    }

    public final void zzj(int i) throws RemoteException {
    }

    public final void zzk(zze zze) {
    }

    public final void zzl(String str) {
    }

    public final void zzs(zzbvz zzbvz) throws RemoteException {
    }

    public final void zzi(int i, String str) throws RemoteException {
    }

    public final void zzq(String str, String str2) throws RemoteException {
    }

    public final void zzr(zzbfx zzbfx, String str) throws RemoteException {
    }
}
