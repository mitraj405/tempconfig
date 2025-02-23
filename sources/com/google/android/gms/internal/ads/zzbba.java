package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzbba {
    final /* synthetic */ zzbbb zza;
    private final byte[] zzb;
    private int zzc;

    public /* synthetic */ zzbba(zzbbb zzbbb, byte[] bArr, zzbaz zzbaz) {
        this.zza = zzbbb;
        this.zzb = bArr;
    }

    /* access modifiers changed from: private */
    public final synchronized void zzd() {
        try {
            zzbbb zzbbb = this.zza;
            if (zzbbb.zzb) {
                zzbbb.zza.zzj(this.zzb);
                this.zza.zza.zzi(0);
                this.zza.zza.zzg(this.zzc);
                this.zza.zza.zzh((int[]) null);
                this.zza.zza.zzf();
            }
        } catch (RemoteException e) {
            zzm.zzf("Clearcut log failed", e);
        }
    }

    public final zzbba zza(int i) {
        this.zzc = i;
        return this;
    }

    public final synchronized void zzc() {
        this.zza.zzc.execute(new zzbay(this));
    }
}
