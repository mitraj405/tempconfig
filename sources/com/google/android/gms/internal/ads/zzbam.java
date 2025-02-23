package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzbam implements Runnable {
    public final /* synthetic */ zzbap zza;
    public final /* synthetic */ zzbag zzb;
    public final /* synthetic */ zzbah zzc;
    public final /* synthetic */ zzbzt zzd;

    public /* synthetic */ zzbam(zzbap zzbap, zzbag zzbag, zzbah zzbah, zzbzt zzbzt) {
        this.zza = zzbap;
        this.zzb = zzbag;
        this.zzc = zzbah;
        this.zzd = zzbzt;
    }

    public final void run() {
        zzbae zzbae;
        zzbap zzbap = this.zza;
        zzbag zzbag = this.zzb;
        zzbzt zzbzt = this.zzd;
        try {
            zzbaj zzq = zzbag.zzq();
            boolean zzp = zzbag.zzp();
            zzbah zzbah = this.zzc;
            if (zzp) {
                zzbae = zzq.zzg(zzbah);
            } else {
                zzbae = zzq.zzf(zzbah);
            }
            if (!zzbae.zze()) {
                zzbzt.zzd(new RuntimeException("No entry contents."));
                zzbar.zze(zzbap.zzc);
                return;
            }
            zzbao zzbao = new zzbao(zzbap, zzbae.zzc(), 1);
            int read = zzbao.read();
            if (read != -1) {
                zzbao.unread(read);
                zzbzt.zzc(zzbat.zzb(zzbao, zzbae.zzd(), zzbae.zzg(), zzbae.zza(), zzbae.zzf()));
                return;
            }
            throw new IOException("Unable to read from cache.");
        } catch (RemoteException | IOException e) {
            zzm.zzh("Unable to obtain a cache service instance.", e);
            zzbzt.zzd(e);
            zzbar.zze(zzbap.zzc);
        }
    }
}
