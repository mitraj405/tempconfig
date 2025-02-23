package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdyc extends zzdya {
    private final Context zzg;
    private final Executor zzh;

    public zzdyc(Context context, Executor executor) {
        this.zzg = context;
        this.zzh = executor;
        this.zzf = new zzbty(context, zzu.zzt().zzb(), this, this);
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.zzb) {
            if (!this.zzd) {
                this.zzd = true;
                try {
                    this.zzf.zzp().zzf(this.zze, new zzdxz(this));
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zza.zzd(new zzdyp(1));
                } catch (Throwable th) {
                    zzu.zzo().zzw(th, "RemoteSignalsClientTask.onConnected");
                    this.zza.zzd(new zzdyp(1));
                }
            }
        }
    }

    public final ListenableFuture zza(zzbvb zzbvb) {
        synchronized (this.zzb) {
            if (this.zzc) {
                zzbzt zzbzt = this.zza;
                return zzbzt;
            }
            this.zzc = true;
            this.zze = zzbvb;
            this.zzf.checkAvailabilityAndConnect();
            this.zza.addListener(new zzdyb(this), zzbzo.zzf);
            zzdya.zzc(this.zzg, this.zza, this.zzh);
            zzbzt zzbzt2 = this.zza;
            return zzbzt2;
        }
    }
}
