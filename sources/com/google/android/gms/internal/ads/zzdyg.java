package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.ConnectionResult;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdyg extends zzdya {
    private String zzg;
    private int zzh = 1;

    public zzdyg(Context context) {
        this.zzf = new zzbty(context, zzu.zzt().zzb(), this, this);
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.zzb) {
            if (!this.zzd) {
                this.zzd = true;
                try {
                    int i = this.zzh;
                    if (i == 2) {
                        this.zzf.zzp().zze(this.zze, new zzdxz(this));
                    } else if (i == 3) {
                        this.zzf.zzp().zzh(this.zzg, new zzdxz(this));
                    } else {
                        this.zza.zzd(new zzdyp(1));
                    }
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zza.zzd(new zzdyp(1));
                } catch (Throwable th) {
                    zzu.zzo().zzw(th, "RemoteUrlAndCacheKeyClientTask.onConnected");
                    this.zza.zzd(new zzdyp(1));
                }
            }
        }
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zzm.zze("Cannot connect to remote service, fallback to local instance.");
        this.zza.zzd(new zzdyp(1));
    }

    public final ListenableFuture zza(zzbvb zzbvb) {
        synchronized (this.zzb) {
            int i = this.zzh;
            if (i != 1 && i != 2) {
                ListenableFuture zzg2 = zzgcj.zzg(new zzdyp(2));
                return zzg2;
            } else if (this.zzc) {
                zzbzt zzbzt = this.zza;
                return zzbzt;
            } else {
                this.zzh = 2;
                this.zzc = true;
                this.zze = zzbvb;
                this.zzf.checkAvailabilityAndConnect();
                this.zza.addListener(new zzdye(this), zzbzo.zzf);
                zzbzt zzbzt2 = this.zza;
                return zzbzt2;
            }
        }
    }

    public final ListenableFuture zzd(String str) {
        synchronized (this.zzb) {
            int i = this.zzh;
            if (i != 1 && i != 3) {
                ListenableFuture zzg2 = zzgcj.zzg(new zzdyp(2));
                return zzg2;
            } else if (this.zzc) {
                zzbzt zzbzt = this.zza;
                return zzbzt;
            } else {
                this.zzh = 3;
                this.zzc = true;
                this.zzg = str;
                this.zzf.checkAvailabilityAndConnect();
                this.zza.addListener(new zzdyf(this), zzbzo.zzf);
                zzbzt zzbzt2 = this.zza;
                return zzbzt2;
            }
        }
    }
}
