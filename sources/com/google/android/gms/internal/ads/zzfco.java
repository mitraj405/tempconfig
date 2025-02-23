package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfco implements zzena {
    private final Context zza;
    /* access modifiers changed from: private */
    public final Executor zzb;
    private final zzcgj zzc;
    /* access modifiers changed from: private */
    public final zzemk zzd;
    /* access modifiers changed from: private */
    public final zzfdo zze;
    private zzbcr zzf;
    /* access modifiers changed from: private */
    public final zzfki zzg;
    private final zzffe zzh;
    /* access modifiers changed from: private */
    public ListenableFuture zzi;

    public zzfco(Context context, Executor executor, zzcgj zzcgj, zzemk zzemk, zzfdo zzfdo, zzffe zzffe) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcgj;
        this.zzd = zzemk;
        this.zzh = zzffe;
        this.zze = zzfdo;
        this.zzg = zzcgj.zzz();
    }

    public final boolean zza() {
        ListenableFuture listenableFuture = this.zzi;
        if (listenableFuture == null || listenableFuture.isDone()) {
            return false;
        }
        return true;
    }

    public final boolean zzb(zzl zzl, String str, zzemy zzemy, zzemz zzemz) {
        zzdgp zzf2;
        zzfkf zzfkf;
        if (str == null) {
            zzm.zzg("Ad unit ID should not be null for interstitial ad.");
            this.zzb.execute(new zzfci(this));
            return false;
        } else if (zza()) {
            return false;
        } else {
            if (((Boolean) zzba.zzc().zza(zzbbw.zzia)).booleanValue() && zzl.zzf) {
                this.zzc.zzl().zzo(true);
            }
            zzq zzq = ((zzfch) zzemy).zza;
            Bundle zza2 = zzdrv.zza(new Pair(zzdrt.PUBLIC_API_CALL.zza(), Long.valueOf(zzl.zzz)), new Pair(zzdrt.DYNAMITE_ENTER.zza(), Long.valueOf(zzu.zzB().currentTimeMillis())));
            zzffe zzffe = this.zzh;
            zzffe.zzt(str);
            zzffe.zzs(zzq);
            zzffe.zzH(zzl);
            zzffe.zzA(zza2);
            Context context = this.zza;
            zzffg zzJ = zzffe.zzJ();
            zzfju zzb2 = zzfjt.zzb(context, zzfke.zzf(zzJ), 4, zzl);
            if (((Boolean) zzba.zzc().zza(zzbbw.zzhr)).booleanValue()) {
                zzdgo zzg2 = this.zzc.zzg();
                zzcvy zzcvy = new zzcvy();
                zzcvy.zze(this.zza);
                zzcvy.zzi(zzJ);
                zzg2.zze(zzcvy.zzj());
                zzdci zzdci = new zzdci();
                zzdci.zzj(this.zzd, this.zzb);
                zzdci.zzk(this.zzd, this.zzb);
                zzg2.zzd(zzdci.zzn());
                zzg2.zzc(new zzekt(this.zzf));
                zzf2 = zzg2.zzf();
            } else {
                zzdci zzdci2 = new zzdci();
                zzfdo zzfdo = this.zze;
                if (zzfdo != null) {
                    zzdci2.zze(zzfdo, this.zzb);
                    zzdci2.zzf(this.zze, this.zzb);
                    zzdci2.zzb(this.zze, this.zzb);
                }
                zzdgo zzg3 = this.zzc.zzg();
                zzcvy zzcvy2 = new zzcvy();
                zzcvy2.zze(this.zza);
                zzcvy2.zzi(zzJ);
                zzg3.zze(zzcvy2.zzj());
                zzdci2.zzj(this.zzd, this.zzb);
                zzdci2.zze(this.zzd, this.zzb);
                zzdci2.zzf(this.zzd, this.zzb);
                zzdci2.zzb(this.zzd, this.zzb);
                zzdci2.zza(this.zzd, this.zzb);
                zzdci2.zzl(this.zzd, this.zzb);
                zzdci2.zzk(this.zzd, this.zzb);
                zzdci2.zzi(this.zzd, this.zzb);
                zzdci2.zzc(this.zzd, this.zzb);
                zzg3.zzd(zzdci2.zzn());
                zzg3.zzc(new zzekt(this.zzf));
                zzf2 = zzg3.zzf();
            }
            zzdgp zzdgp = zzf2;
            if (((Boolean) zzbdl.zzc.zze()).booleanValue()) {
                zzfkf zzf3 = zzdgp.zzf();
                zzf3.zzi(4);
                zzf3.zzb(zzl.zzp);
                zzf3.zzf(zzl.zzm);
                zzfkf = zzf3;
            } else {
                zzfkf = null;
            }
            zzctc zza3 = zzdgp.zza();
            ListenableFuture zzi2 = zza3.zzi(zza3.zzj());
            this.zzi = zzi2;
            zzgcj.zzr(zzi2, new zzfcn(this, zzemz, zzfkf, zzb2, zzdgp), this.zzb);
            return true;
        }
    }

    public final /* synthetic */ void zzh() {
        this.zzd.zzdB(zzfgi.zzd(6, (String) null, (zze) null));
    }

    public final void zzi(zzbcr zzbcr) {
        this.zzf = zzbcr;
    }
}
