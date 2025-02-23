package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.internal.ads.zzbbc;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfbi implements zzfcc {
    private final zzfcc zza;
    private final zzfcc zzb;
    private final zzfhq zzc;
    private final String zzd;
    private zzcvx zze;
    private final Executor zzf;

    public zzfbi(zzfcc zzfcc, zzfcc zzfcc2, zzfhq zzfhq, String str, Executor executor) {
        this.zza = zzfcc;
        this.zzb = zzfcc2;
        this.zzc = zzfhq;
        this.zzd = str;
        this.zzf = executor;
    }

    private final ListenableFuture zzg(zzfhd zzfhd, zzfcd zzfcd) {
        zzcvx zzcvx = zzfhd.zza;
        this.zze = zzcvx;
        if (zzfhd.zzc != null) {
            if (zzcvx.zzf() != null) {
                zzfhd.zzc.zzp().zzl(zzfhd.zza.zzf());
            }
            return zzgcj.zzh(zzfhd.zzc);
        }
        zzcvx.zzb().zzl(zzfhd.zzb);
        return ((zzfbs) this.zza).zzb(zzfcd, (zzfcb) null, zzfhd.zza);
    }

    /* renamed from: zza */
    public final synchronized zzcvx zzd() {
        return this.zze;
    }

    public final /* synthetic */ ListenableFuture zzb(zzfcd zzfcd, zzfbh zzfbh, zzfcb zzfcb, zzcvx zzcvx, zzfbn zzfbn) throws Exception {
        if (zzfbn != null) {
            zzfbh zzfbh2 = new zzfbh(zzfbh.zza, zzfbh.zzb, zzfbh.zzc, zzfbh.zzd, zzfbh.zze, zzfbh.zzf, zzfbn.zza);
            if (zzfbn.zzc != null) {
                this.zze = null;
                this.zzc.zze(zzfbh2);
                return zzg(zzfbn.zzc, zzfcd);
            }
            ListenableFuture zza2 = this.zzc.zza(zzfbh2);
            if (zza2 != null) {
                this.zze = null;
                return zzgcj.zzn(zza2, new zzfbe(this), this.zzf);
            }
            this.zzc.zze(zzfbh2);
            zzfcd = new zzfcd(zzfcd.zzb, zzfbn.zzb);
        }
        ListenableFuture zzb2 = ((zzfbs) this.zza).zzb(zzfcd, zzfcb, zzcvx);
        this.zze = zzcvx;
        return zzb2;
    }

    public final /* bridge */ /* synthetic */ ListenableFuture zzc(zzfcd zzfcd, zzfcb zzfcb, Object obj) {
        return zzf(zzfcd, zzfcb, (zzcvx) null);
    }

    public final /* synthetic */ ListenableFuture zze(zzfhn zzfhn) throws Exception {
        zzfhp zzfhp;
        if (zzfhn == null || zzfhn.zza == null || (zzfhp = zzfhn.zzb) == null) {
            throw new zzdwl(1, "Empty prefetch");
        }
        zzbbc.zzb.zzc zzd2 = zzbbc.zzb.zzd();
        zzbbc.zzb.zza.C0037zza zza2 = zzbbc.zzb.zza.zza();
        zza2.zzf(zzbbc.zzb.zzd.IN_MEMORY);
        zza2.zzh(zzbbc.zzb.zze.zzi());
        zzd2.zzd(zza2);
        zzfhn.zza.zza.zzb().zzc().zzm((zzbbc.zzb) zzd2.zzbr());
        return zzg(zzfhn.zza, ((zzfbh) zzfhp).zzb);
    }

    public final synchronized ListenableFuture zzf(zzfcd zzfcd, zzfcb zzfcb, zzcvx zzcvx) {
        zzfcd zzfcd2 = zzfcd;
        zzfcb zzfcb2 = zzfcb;
        synchronized (this) {
            zzcvw zza2 = zzfcb2.zza(zzfcd2.zzb);
            zza2.zza(new zzfbj(this.zzd));
            zzcvx zzcvx2 = (zzcvx) zza2.zzh();
            zzcvx2.zzg();
            zzcvx2.zzg();
            zzl zzl = zzcvx2.zzg().zzd;
            if (zzl.zzs == null) {
                if (zzl.zzx == null) {
                    zzffg zzg = zzcvx2.zzg();
                    zzfcb zzfcb3 = zzfcb;
                    zzfcd zzfcd3 = zzfcd;
                    ListenableFuture zzn = zzgcj.zzn(zzgca.zzu(((zzfbo) this.zzb).zzb(zzfcd2, zzfcb2, zzcvx2)), new zzfbf(this, zzfcd, new zzfbh(zzfcb3, zzfcd3, zzg.zzd, zzg.zzf, this.zzf, zzg.zzj, (zzfhe) null), zzfcb, zzcvx2), this.zzf);
                    return zzn;
                }
            }
            this.zze = zzcvx2;
            ListenableFuture zzb2 = ((zzfbs) this.zza).zzb(zzfcd2, zzfcb2, zzcvx2);
            return zzb2;
        }
    }
}
