package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzegq extends zzbvx implements zzcya {
    private zzbvy zza;
    private zzcxz zzb;
    private zzdfb zzc;

    public final synchronized void zza(zzcxz zzcxz) {
        this.zzb = zzcxz;
    }

    public final synchronized void zzc(zzbvy zzbvy) {
        this.zza = zzbvy;
    }

    public final synchronized void zzd(zzdfb zzdfb) {
        this.zzc = zzdfb;
    }

    public final synchronized void zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbvy zzbvy = this.zza;
        if (zzbvy != null) {
            ((zzejv) zzbvy).zzb.onAdClicked();
        }
    }

    public final synchronized void zzf(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbvy zzbvy = this.zza;
        if (zzbvy != null) {
            zzbvy.zzf(iObjectWrapper);
        }
    }

    public final synchronized void zzg(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        zzcxz zzcxz = this.zzb;
        if (zzcxz != null) {
            zzcxz.zza(i);
        }
    }

    public final synchronized void zzh(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbvy zzbvy = this.zza;
        if (zzbvy != null) {
            ((zzejv) zzbvy).zzc.zzb();
        }
    }

    public final synchronized void zzi(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzcxz zzcxz = this.zzb;
        if (zzcxz != null) {
            zzcxz.zzd();
        }
    }

    public final synchronized void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbvy zzbvy = this.zza;
        if (zzbvy != null) {
            ((zzejv) zzbvy).zza.zzdr();
        }
    }

    public final synchronized void zzk(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        zzdfb zzdfb = this.zzc;
        if (zzdfb != null) {
            zzm.zzj("Fail to initialize adapter ".concat(String.valueOf(((zzeju) zzdfb).zzc.zza)));
        }
    }

    public final synchronized void zzl(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzdfb zzdfb = this.zzc;
        if (zzdfb != null) {
            Executor zzc2 = ((zzeju) zzdfb).zzd.zzb;
            zzeew zzeew = ((zzeju) zzdfb).zzc;
            zzfel zzfel = ((zzeju) zzdfb).zzb;
            zzc2.execute(new zzejt((zzeju) zzdfb, ((zzeju) zzdfb).zza, zzfel, zzeew));
        }
    }

    public final synchronized void zzm(IObjectWrapper iObjectWrapper, zzbvz zzbvz) throws RemoteException {
        zzbvy zzbvy = this.zza;
        if (zzbvy != null) {
            ((zzejv) zzbvy).zzd.zza(zzbvz);
        }
    }

    public final synchronized void zzn(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbvy zzbvy = this.zza;
        if (zzbvy != null) {
            ((zzejv) zzbvy).zzc.zze();
        }
    }

    public final synchronized void zzo(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbvy zzbvy = this.zza;
        if (zzbvy != null) {
            ((zzejv) zzbvy).zzd.zzc();
        }
    }
}
