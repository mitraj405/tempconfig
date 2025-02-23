package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
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
public final class zzfdy implements zzena {
    private final Context zza;
    /* access modifiers changed from: private */
    public final Executor zzb;
    private final zzcgj zzc;
    /* access modifiers changed from: private */
    public final zzfdo zzd;
    /* access modifiers changed from: private */
    public final zzfcc zze;
    private final zzfey zzf;
    /* access modifiers changed from: private */
    public final zzfki zzg;
    private final zzffe zzh;
    private ListenableFuture zzi;

    public zzfdy(Context context, Executor executor, zzcgj zzcgj, zzfcc zzfcc, zzfdo zzfdo, zzffe zzffe, zzfey zzfey) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcgj;
        this.zze = zzfcc;
        this.zzd = zzfdo;
        this.zzh = zzffe;
        this.zzf = zzfey;
        this.zzg = zzcgj.zzz();
    }

    /* access modifiers changed from: private */
    public final zzdot zzk(zzfca zzfca) {
        zzdot zzi2 = this.zzc.zzi();
        zzcvy zzcvy = new zzcvy();
        zzcvy.zze(this.zza);
        zzcvy.zzi(((zzfdx) zzfca).zza);
        zzcvy.zzh(this.zzf);
        zzi2.zzd(zzcvy.zzj());
        zzi2.zzc(new zzdci().zzn());
        return zzi2;
    }

    public final boolean zza() {
        throw null;
    }

    public final boolean zzb(zzl zzl, String str, zzemy zzemy, zzemz zzemz) throws RemoteException {
        zzfkf zzfkf;
        zzbvu zzbvu = new zzbvu(zzl, str);
        if (zzbvu.zzb == null) {
            zzm.zzg("Ad unit ID should not be null for rewarded video ad.");
            this.zzb.execute(new zzfdr(this));
            return false;
        }
        ListenableFuture listenableFuture = this.zzi;
        if (listenableFuture != null && !listenableFuture.isDone()) {
            return false;
        }
        if (((Boolean) zzbdl.zzc.zze()).booleanValue()) {
            zzfcc zzfcc = this.zze;
            if (zzfcc.zzd() != null) {
                zzfkf zzh2 = ((zzdou) zzfcc.zzd()).zzh();
                zzh2.zzi(5);
                zzh2.zzb(zzbvu.zza.zzp);
                zzh2.zzf(zzbvu.zza.zzm);
                zzfkf = zzh2;
                zzfgd.zza(this.zza, zzbvu.zza.zzf);
                if (((Boolean) zzba.zzc().zza(zzbbw.zzia)).booleanValue() && zzbvu.zza.zzf) {
                    this.zzc.zzl().zzo(true);
                }
                Bundle zza2 = zzdrv.zza(new Pair(zzdrt.PUBLIC_API_CALL.zza(), Long.valueOf(zzbvu.zza.zzz)), new Pair(zzdrt.DYNAMITE_ENTER.zza(), Long.valueOf(zzu.zzB().currentTimeMillis())));
                zzffe zzffe = this.zzh;
                zzffe.zzt(zzbvu.zzb);
                zzffe.zzs(zzq.zzd());
                zzffe.zzH(zzbvu.zza);
                zzffe.zzA(zza2);
                Context context = this.zza;
                zzffg zzJ = zzffe.zzJ();
                zzfju zzb2 = zzfjt.zzb(context, zzfke.zzf(zzJ), 5, zzbvu.zza);
                zzfdx zzfdx = new zzfdx((zzfdw) null);
                zzfdx.zza = zzJ;
                ListenableFuture zzc2 = this.zze.zzc(new zzfcd(zzfdx, (zzbvb) null), new zzfds(this), (Object) null);
                this.zzi = zzc2;
                zzgcj.zzr(zzc2, new zzfdv(this, zzemz, zzfkf, zzb2, zzfdx), this.zzb);
                return true;
            }
        }
        zzfkf = null;
        zzfgd.zza(this.zza, zzbvu.zza.zzf);
        this.zzc.zzl().zzo(true);
        Bundle zza22 = zzdrv.zza(new Pair(zzdrt.PUBLIC_API_CALL.zza(), Long.valueOf(zzbvu.zza.zzz)), new Pair(zzdrt.DYNAMITE_ENTER.zza(), Long.valueOf(zzu.zzB().currentTimeMillis())));
        zzffe zzffe2 = this.zzh;
        zzffe2.zzt(zzbvu.zzb);
        zzffe2.zzs(zzq.zzd());
        zzffe2.zzH(zzbvu.zza);
        zzffe2.zzA(zza22);
        Context context2 = this.zza;
        zzffg zzJ2 = zzffe2.zzJ();
        zzfju zzb22 = zzfjt.zzb(context2, zzfke.zzf(zzJ2), 5, zzbvu.zza);
        zzfdx zzfdx2 = new zzfdx((zzfdw) null);
        zzfdx2.zza = zzJ2;
        ListenableFuture zzc22 = this.zze.zzc(new zzfcd(zzfdx2, (zzbvb) null), new zzfds(this), (Object) null);
        this.zzi = zzc22;
        zzgcj.zzr(zzc22, new zzfdv(this, zzemz, zzfkf, zzb22, zzfdx2), this.zzb);
        return true;
    }

    public final /* synthetic */ void zzi() {
        this.zzd.zzdB(zzfgi.zzd(6, (String) null, (zze) null));
    }

    public final void zzj(int i) {
        this.zzh.zzp().zza(i);
    }
}
