package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.overlay.zzp;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfaj implements zzcwt, zzcyp, zzfbz, zzp, zzczb, zzcxg, zzdeq {
    private final zzfgq zza;
    private final AtomicReference zzb = new AtomicReference();
    private final AtomicReference zzc = new AtomicReference();
    private final AtomicReference zzd = new AtomicReference();
    private final AtomicReference zze = new AtomicReference();
    private final AtomicReference zzf = new AtomicReference();
    private final AtomicReference zzg = new AtomicReference();
    private zzfaj zzh = null;

    public zzfaj(zzfgq zzfgq) {
        this.zza = zzfgq;
    }

    public static zzfaj zzi(zzfaj zzfaj) {
        zzfaj zzfaj2 = new zzfaj(zzfaj.zza);
        zzfaj2.zzh = zzfaj;
        return zzfaj2;
    }

    public final void zzdB(zze zze2) {
        zzfaj zzfaj = this.zzh;
        if (zzfaj != null) {
            zzfaj.zzdB(zze2);
            return;
        }
        zzfbq.zza(this.zzb, new zzfae(zze2));
        zzfbq.zza(this.zzb, new zzfaf(zze2));
    }

    public final void zzdG() {
        zzfaj zzfaj = this.zzh;
        if (zzfaj != null) {
            zzfaj.zzdG();
        } else {
            zzfbq.zza(this.zzd, new zzfaa());
        }
    }

    public final void zzdq() {
        zzfaj zzfaj = this.zzh;
        if (zzfaj != null) {
            zzfaj.zzdq();
        } else {
            zzfbq.zza(this.zzf, new zzezx());
        }
    }

    public final void zzdr() {
        zzfaj zzfaj = this.zzh;
        if (zzfaj != null) {
            zzfaj.zzdr();
            return;
        }
        zzfbq.zza(this.zzf, new zzfai());
        zzfbq.zza(this.zzd, new zzezv());
        zzfbq.zza(this.zzd, new zzezw());
    }

    public final void zzdt() {
        zzfaj zzfaj = this.zzh;
        if (zzfaj != null) {
            zzfaj.zzdt();
        } else {
            zzfbq.zza(this.zzf, new zzfah());
        }
    }

    public final void zzdu(int i) {
        zzfaj zzfaj = this.zzh;
        if (zzfaj != null) {
            zzfaj.zzdu(i);
        } else {
            zzfbq.zza(this.zzf, new zzfad(i));
        }
    }

    public final void zzg() {
        zzfaj zzfaj = this.zzh;
        if (zzfaj != null) {
            zzfaj.zzg();
        } else {
            zzfbq.zza(this.zze, new zzfag());
        }
    }

    public final void zzh(zzs zzs) {
        zzfaj zzfaj = this.zzh;
        if (zzfaj != null) {
            zzfaj.zzh(zzs);
        } else {
            zzfbq.zza(this.zzg, new zzezu(zzs));
        }
    }

    public final void zzj() {
        zzfaj zzfaj = this.zzh;
        if (zzfaj != null) {
            zzfaj.zzj();
            return;
        }
        this.zza.zza();
        zzfbq.zza(this.zzc, new zzfab());
        zzfbq.zza(this.zzd, new zzfac());
    }

    public final void zzk(zzazp zzazp) {
        zzfaj zzfaj = this.zzh;
        if (zzfaj != null) {
            zzfaj.zzk(zzazp);
        } else {
            zzfbq.zza(this.zzb, new zzezz(zzazp));
        }
    }

    public final void zzl(zzfbz zzfbz) {
        this.zzh = (zzfaj) zzfbz;
    }

    public final void zzm(zzp zzp) {
        this.zzf.set(zzp);
    }

    public final void zzn(zzdg zzdg) {
        this.zzg.set(zzdg);
    }

    public final void zzo(zzazs zzazs) {
        this.zzb.set(zzazs);
    }

    public final void zzp(zzazw zzazw) {
        this.zzd.set(zzazw);
    }

    public final void zzq(zze zze2) {
        zzfaj zzfaj = this.zzh;
        if (zzfaj != null) {
            zzfaj.zzq(zze2);
        } else {
            zzfbq.zza(this.zzd, new zzezy(zze2));
        }
    }

    public final void zzdH() {
    }

    public final void zzdf() {
    }

    public final void zzdk() {
    }
}
