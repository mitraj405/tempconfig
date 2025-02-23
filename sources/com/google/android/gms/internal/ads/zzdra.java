package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.internal.ads.zzbbc;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdra implements zzczo, zzcye, zzcwt, zzcxk, zza, zzdca {
    private final zzbav zza;
    private boolean zzb = false;

    public zzdra(zzbav zzbav, zzfcg zzfcg) {
        this.zza = zzbav;
        zzbav.zzc(2);
        if (zzfcg != null) {
            zzbav.zzc(1101);
        }
    }

    public final synchronized void onAdClicked() {
        if (!this.zzb) {
            this.zza.zzc(7);
            this.zzb = true;
            return;
        }
        this.zza.zzc(8);
    }

    public final void zzdB(zze zze) {
        switch (zze.zza) {
            case 1:
                this.zza.zzc(101);
                return;
            case 2:
                this.zza.zzc(102);
                return;
            case 3:
                this.zza.zzc(5);
                return;
            case 4:
                this.zza.zzc(103);
                return;
            case 5:
                this.zza.zzc(104);
                return;
            case 6:
                this.zza.zzc(105);
                return;
            case 7:
                this.zza.zzc(106);
                return;
            default:
                this.zza.zzc(4);
                return;
        }
    }

    public final void zzdo(zzfex zzfex) {
        this.zza.zzb(new zzdqw(zzfex));
    }

    public final void zzh() {
        this.zza.zzc(1109);
    }

    public final void zzi(zzbbc.zzb zzb2) {
        this.zza.zzb(new zzdqz(zzb2));
        this.zza.zzc(1103);
    }

    public final void zzj(zzbbc.zzb zzb2) {
        this.zza.zzb(new zzdqx(zzb2));
        this.zza.zzc(1102);
    }

    public final void zzl(boolean z) {
        int i;
        if (true != z) {
            i = 1108;
        } else {
            i = 1107;
        }
        this.zza.zzc(i);
    }

    public final void zzm(zzbbc.zzb zzb2) {
        this.zza.zzb(new zzdqy(zzb2));
        this.zza.zzc(1104);
    }

    public final void zzn(boolean z) {
        int i;
        if (true != z) {
            i = 1106;
        } else {
            i = 1105;
        }
        this.zza.zzc(i);
    }

    public final synchronized void zzr() {
        this.zza.zzc(6);
    }

    public final void zzs() {
        this.zza.zzc(3);
    }

    public final void zzdn(zzbvb zzbvb) {
    }
}
