package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zzbh;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfax implements zzena {
    private final Context zza;
    private final Executor zzb;
    private final zzcgj zzc;
    private final zzemk zzd;
    private final zzemo zze;
    private final ViewGroup zzf;
    private zzbcr zzg;
    /* access modifiers changed from: private */
    public final zzczj zzh;
    /* access modifiers changed from: private */
    public final zzfki zzi;
    /* access modifiers changed from: private */
    public final zzdbp zzj;
    private final zzffe zzk;
    private ListenableFuture zzl;
    /* access modifiers changed from: private */
    public boolean zzm = true;
    /* access modifiers changed from: private */
    public zze zzn = null;
    private zzemz zzo = null;

    public zzfax(Context context, Executor executor, zzq zzq, zzcgj zzcgj, zzemk zzemk, zzemo zzemo, zzffe zzffe, zzdbp zzdbp) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcgj;
        this.zzd = zzemk;
        this.zze = zzemo;
        this.zzk = zzffe;
        this.zzh = zzcgj.zzf();
        this.zzi = zzcgj.zzz();
        this.zzf = new FrameLayout(context);
        this.zzj = zzdbp;
        zzffe.zzs(zzq);
    }

    /* access modifiers changed from: private */
    public final void zzu() {
        this.zzl = null;
        if (((Boolean) zzba.zzc().zza(zzbbw.zzhp)).booleanValue()) {
            this.zzb.execute(new zzfat(this));
        }
        zzemz zzemz = this.zzo;
        if (zzemz != null) {
            zzemz.zza();
        }
    }

    public final boolean zza() {
        ListenableFuture listenableFuture = this.zzl;
        if (listenableFuture == null || listenableFuture.isDone()) {
            return false;
        }
        return true;
    }

    public final boolean zzb(zzl zzl2, String str, zzemy zzemy, zzemz zzemz) throws RemoteException {
        zzcql zzcql;
        if (str == null) {
            zzm.zzg("Ad unit ID should not be null for banner ad.");
            this.zzb.execute(new zzfav(this));
            return false;
        }
        if (!zza()) {
            if (((Boolean) zzba.zzc().zza(zzbbw.zzia)).booleanValue() && zzl2.zzf) {
                this.zzc.zzl().zzo(true);
            }
            Bundle zza2 = zzdrv.zza(new Pair(zzdrt.PUBLIC_API_CALL.zza(), Long.valueOf(zzl2.zzz)), new Pair(zzdrt.DYNAMITE_ENTER.zza(), Long.valueOf(zzu.zzB().currentTimeMillis())));
            zzffe zzffe = this.zzk;
            zzffe.zzt(str);
            zzffe.zzH(zzl2);
            zzffe.zzA(zza2);
            Context context = this.zza;
            zzffg zzJ = zzffe.zzJ();
            zzfju zzb2 = zzfjt.zzb(context, zzfke.zzf(zzJ), 3, zzl2);
            zzfkf zzfkf = null;
            if (!((Boolean) zzbdy.zze.zze()).booleanValue() || !this.zzk.zzh().zzk) {
                if (((Boolean) zzba.zzc().zza(zzbbw.zzhp)).booleanValue()) {
                    zzcqk zze2 = this.zzc.zze();
                    zzcvy zzcvy = new zzcvy();
                    zzcvy.zze(this.zza);
                    zzcvy.zzi(zzJ);
                    zze2.zzi(zzcvy.zzj());
                    zzdci zzdci = new zzdci();
                    zzdci.zzj(this.zzd, this.zzb);
                    zzdci.zzk(this.zzd, this.zzb);
                    zze2.zzf(zzdci.zzn());
                    zze2.zze(new zzekt(this.zzg));
                    zze2.zzd(new zzdhg(zzdjm.zza, (zzbh) null));
                    zze2.zzg(new zzcrm(this.zzh, this.zzj));
                    zze2.zzc(new zzcph(this.zzf));
                    zzcql = zze2.zzk();
                } else {
                    zzcqk zze3 = this.zzc.zze();
                    zzcvy zzcvy2 = new zzcvy();
                    zzcvy2.zze(this.zza);
                    zzcvy2.zzi(zzJ);
                    zze3.zzi(zzcvy2.zzj());
                    zzdci zzdci2 = new zzdci();
                    zzdci2.zzj(this.zzd, this.zzb);
                    zzdci2.zza(this.zzd, this.zzb);
                    zzdci2.zza(this.zze, this.zzb);
                    zzdci2.zzl(this.zzd, this.zzb);
                    zzdci2.zzd(this.zzd, this.zzb);
                    zzdci2.zze(this.zzd, this.zzb);
                    zzdci2.zzf(this.zzd, this.zzb);
                    zzdci2.zzb(this.zzd, this.zzb);
                    zzdci2.zzk(this.zzd, this.zzb);
                    zzdci2.zzi(this.zzd, this.zzb);
                    zze3.zzf(zzdci2.zzn());
                    zze3.zze(new zzekt(this.zzg));
                    zze3.zzd(new zzdhg(zzdjm.zza, (zzbh) null));
                    zze3.zzg(new zzcrm(this.zzh, this.zzj));
                    zze3.zzc(new zzcph(this.zzf));
                    zzcql = zze3.zzk();
                }
                if (((Boolean) zzbdl.zzc.zze()).booleanValue()) {
                    zzfkf = zzcql.zzj();
                    zzfkf.zzi(3);
                    zzfkf.zzb(zzl2.zzp);
                    zzfkf.zzf(zzl2.zzm);
                }
                this.zzo = zzemz;
                zzctc zzd2 = zzcql.zzd();
                ListenableFuture zzi2 = zzd2.zzi(zzd2.zzj());
                this.zzl = zzi2;
                zzgcj.zzr(zzi2, new zzfaw(this, zzfkf, zzb2, zzcql), this.zzb);
                return true;
            }
            zzemk zzemk = this.zzd;
            if (zzemk != null) {
                zzemk.zzdB(zzfgi.zzd(7, (String) null, (zze) null));
            }
        } else if (!this.zzk.zzS()) {
            this.zzm = true;
        }
        return false;
    }

    public final ViewGroup zzc() {
        return this.zzf;
    }

    public final zzffe zzg() {
        return this.zzk;
    }

    public final /* synthetic */ void zzk() {
        this.zzd.zzdB(this.zzn);
    }

    public final /* synthetic */ void zzl() {
        this.zzd.zzdB(zzfgi.zzd(6, (String) null, (zze) null));
    }

    public final void zzm() {
        this.zzh.zzd(this.zzj.zzc());
    }

    public final void zzn() {
        this.zzh.zze(this.zzj.zzd());
    }

    public final void zzo(zzbe zzbe) {
        this.zze.zza(zzbe);
    }

    public final void zzp(zzczc zzczc) {
        this.zzh.zzo(zzczc, this.zzb);
    }

    public final void zzq(zzbcr zzbcr) {
        this.zzg = zzbcr;
    }

    public final void zzr() {
        synchronized (this) {
            ListenableFuture listenableFuture = this.zzl;
            if (listenableFuture != null && listenableFuture.isDone()) {
                try {
                    zzcpk zzcpk = (zzcpk) this.zzl.get();
                    this.zzl = null;
                    this.zzf.removeAllViews();
                    if (zzcpk.zzd() != null) {
                        ViewParent parent = zzcpk.zzd().getParent();
                        if (parent instanceof ViewGroup) {
                            String str = "";
                            if (zzcpk.zzm() != null) {
                                str = zzcpk.zzm().zzg();
                            }
                            zzm.zzj("Banner view provided from " + str + " already has a parent view. Removing its old parent.");
                            ((ViewGroup) parent).removeView(zzcpk.zzd());
                        }
                    }
                    zzbbn zzbbn = zzbbw.zzhp;
                    if (((Boolean) zzba.zzc().zza(zzbbn)).booleanValue()) {
                        zzday zzo2 = zzcpk.zzo();
                        zzo2.zza(this.zzd);
                        zzo2.zzc(this.zze);
                    }
                    this.zzf.addView(zzcpk.zzd());
                    this.zzo.zzb(zzcpk);
                    if (((Boolean) zzba.zzc().zza(zzbbn)).booleanValue()) {
                        Executor executor = this.zzb;
                        zzemk zzemk = this.zzd;
                        Objects.requireNonNull(zzemk);
                        executor.execute(new zzfau(zzemk));
                    }
                    if (zzcpk.zza() >= 0) {
                        this.zzm = false;
                        this.zzh.zzd(zzcpk.zza());
                        this.zzh.zze(zzcpk.zzc());
                    } else {
                        this.zzm = true;
                        this.zzh.zzd(zzcpk.zzc());
                    }
                } catch (InterruptedException | ExecutionException e) {
                    zzu();
                    com.google.android.gms.ads.internal.util.zze.zzb("Error occurred while refreshing the ad. Making a new ad request.", e);
                    this.zzm = true;
                    this.zzh.zza();
                }
            } else if (this.zzl != null) {
                com.google.android.gms.ads.internal.util.zze.zza("Show timer went off but there is an ongoing ad request.");
                this.zzm = true;
            } else {
                com.google.android.gms.ads.internal.util.zze.zza("No ad request was in progress or an ad was cached when show timer went off. Hence requesting a new ad.");
                this.zzm = true;
                this.zzh.zza();
            }
        }
    }

    public final boolean zzt() {
        ViewParent parent = this.zzf.getParent();
        if (!(parent instanceof View)) {
            return false;
        }
        View view = (View) parent;
        zzu.zzp();
        return zzt.zzW(view, view.getContext());
    }
}
