package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Pair;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzcb;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzenh implements zzena {
    private final zzffe zza;
    /* access modifiers changed from: private */
    public final zzcgj zzb;
    private final Context zzc;
    /* access modifiers changed from: private */
    public final zzemx zzd;
    /* access modifiers changed from: private */
    public final zzfki zze;
    private zzcsj zzf;

    public zzenh(zzcgj zzcgj, Context context, zzemx zzemx, zzffe zzffe) {
        this.zzb = zzcgj;
        this.zzc = context;
        this.zzd = zzemx;
        this.zza = zzffe;
        this.zze = zzcgj.zzz();
        zzffe.zzv(zzemx.zzd());
    }

    public final boolean zza() {
        zzcsj zzcsj = this.zzf;
        if (zzcsj == null || !zzcsj.zzf()) {
            return false;
        }
        return true;
    }

    public final boolean zzb(zzl zzl, String str, zzemy zzemy, zzemz zzemz) throws RemoteException {
        zzfkf zzfkf;
        zzu.zzp();
        if (zzt.zzH(this.zzc) && zzl.zzs == null) {
            zzm.zzg("Failed to load the ad because app ID is missing.");
            this.zzb.zzB().execute(new zzenc(this));
            return false;
        } else if (str == null) {
            zzm.zzg("Ad unit ID should not be null for NativeAdLoader.");
            this.zzb.zzB().execute(new zzend(this));
            return false;
        } else {
            zzfgd.zza(this.zzc, zzl.zzf);
            if (((Boolean) zzba.zzc().zza(zzbbw.zzia)).booleanValue() && zzl.zzf) {
                this.zzb.zzl().zzo(true);
            }
            int i = ((zzenb) zzemy).zza;
            long currentTimeMillis = zzu.zzB().currentTimeMillis();
            String zza2 = zzdrt.PUBLIC_API_CALL.zza();
            Long valueOf = Long.valueOf(currentTimeMillis);
            Bundle zza3 = zzdrv.zza(new Pair(zza2, valueOf), new Pair(zzdrt.DYNAMITE_ENTER.zza(), valueOf));
            zzffe zzffe = this.zza;
            zzffe.zzH(zzl);
            zzffe.zzA(zza3);
            zzffe.zzC(i);
            Context context = this.zzc;
            zzffg zzJ = zzffe.zzJ();
            zzfju zzb2 = zzfjt.zzb(context, zzfke.zzf(zzJ), 8, zzl);
            zzcb zzcb = zzJ.zzn;
            if (zzcb != null) {
                this.zzd.zzd().zzm(zzcb);
            }
            zzdhk zzh = this.zzb.zzh();
            zzcvy zzcvy = new zzcvy();
            zzcvy.zze(this.zzc);
            zzcvy.zzi(zzJ);
            zzh.zzf(zzcvy.zzj());
            zzdci zzdci = new zzdci();
            zzdci.zzk(this.zzd.zzd(), this.zzb.zzB());
            zzh.zze(zzdci.zzn());
            zzh.zzd(this.zzd.zzc());
            zzh.zzc(new zzcph((ViewGroup) null));
            zzdhl zzg = zzh.zzg();
            if (((Boolean) zzbdl.zzc.zze()).booleanValue()) {
                zzfkf zzf2 = zzg.zzf();
                zzf2.zzi(8);
                zzf2.zzb(zzl.zzp);
                zzf2.zzf(zzl.zzm);
                zzfkf = zzf2;
            } else {
                zzfkf = null;
            }
            this.zzb.zzy().zzc(1);
            zzgcu zzgcu = zzbzo.zza;
            zzhfk.zzb(zzgcu);
            ScheduledExecutorService zzC = this.zzb.zzC();
            zzctc zza4 = zzg.zza();
            zzcsj zzcsj = new zzcsj(zzgcu, zzC, zza4.zzi(zza4.zzj()));
            this.zzf = zzcsj;
            zzcsj.zze(new zzeng(this, zzemz, zzfkf, zzb2, zzg));
            return true;
        }
    }

    public final /* synthetic */ void zzf() {
        this.zzd.zza().zzdB(zzfgi.zzd(4, (String) null, (zze) null));
    }

    public final /* synthetic */ void zzg() {
        this.zzd.zza().zzdB(zzfgi.zzd(6, (String) null, (zze) null));
    }
}
