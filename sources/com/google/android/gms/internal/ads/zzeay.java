package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Objects;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeay extends zzbuj {
    private final Context zza;
    private final zzgcu zzb;
    private final zzebq zzc;
    private final zzclv zzd;
    private final ArrayDeque zze;
    private final zzfki zzf;
    private final zzbvj zzg;

    public zzeay(Context context, zzgcu zzgcu, zzbvj zzbvj, zzclv zzclv, zzebq zzebq, ArrayDeque arrayDeque, zzebn zzebn, zzfki zzfki) {
        zzbbw.zza(context);
        this.zza = context;
        this.zzb = zzgcu;
        this.zzg = zzbvj;
        this.zzc = zzebq;
        this.zzd = zzclv;
        this.zze = arrayDeque;
        this.zzf = zzfki;
    }

    private final synchronized zzeav zzk(String str) {
        Iterator it = this.zze.iterator();
        while (it.hasNext()) {
            zzeav zzeav = (zzeav) it.next();
            if (zzeav.zzc.equals(str)) {
                it.remove();
                return zzeav;
            }
        }
        return null;
    }

    private static ListenableFuture zzl(ListenableFuture listenableFuture, zzfjl zzfjl, zzbno zzbno, zzfkf zzfkf, zzfju zzfju) {
        zzbne zza2 = zzbno.zza("AFMA_getAdDictionary", zzbnl.zza, new zzeaq());
        zzfke.zzd(listenableFuture, zzfju);
        zzfiq zza3 = zzfjl.zzb(zzfjf.BUILD_URL, listenableFuture).zzf(zza2).zza();
        zzfke.zzc(zza3, zzfkf, zzfju);
        return zza3;
    }

    private static ListenableFuture zzm(zzbvb zzbvb, zzfjl zzfjl, zzewr zzewr) {
        zzeak zzeak = new zzeak(zzewr, zzbvb);
        return zzfjl.zzb(zzfjf.GMS_SIGNALS, zzgcj.zzh(zzbvb.zza)).zzf(zzeak).zze(new zzeal()).zza();
    }

    private final synchronized void zzn(zzeav zzeav) {
        zzo();
        this.zze.addLast(zzeav);
    }

    private final synchronized void zzo() {
        int intValue = ((Long) zzbdz.zzc.zze()).intValue();
        while (this.zze.size() >= intValue) {
            this.zze.removeFirst();
        }
    }

    private final void zzp(ListenableFuture listenableFuture, zzbuu zzbuu, zzbvb zzbvb) {
        zzgcj.zzr(zzgcj.zzn(listenableFuture, new zzear(this), zzbzo.zza), new zzeau(this, zzbuu, zzbvb), zzbzo.zzf);
    }

    public final ListenableFuture zzb(zzbvb zzbvb, int i) {
        if (!((Boolean) zzbdz.zza.zze()).booleanValue()) {
            return zzgcj.zzg(new Exception("Split request is disabled."));
        }
        zzfhb zzfhb = zzbvb.zzi;
        if (zzfhb == null) {
            return zzgcj.zzg(new Exception("Pool configuration missing from request."));
        }
        if (zzfhb.zzc == 0 || zzfhb.zzd == 0) {
            return zzgcj.zzg(new Exception("Caching is disabled."));
        }
        zzbno zzb2 = zzu.zzf().zzb(this.zza, VersionInfoParcel.forPackage(), this.zzf);
        zzewr zzr = this.zzd.zzr(zzbvb, i);
        zzfjl zzc2 = zzr.zzc();
        ListenableFuture zzm = zzm(zzbvb, zzc2, zzr);
        zzfkf zzd2 = zzr.zzd();
        zzfju zza2 = zzfjt.zza(this.zza, 9);
        ListenableFuture zzl = zzl(zzm, zzc2, zzb2, zzd2, zza2);
        return zzc2.zza(zzfjf.GET_URL_AND_CACHE_KEY, zzm, zzl).zza(new zzeao(this, zzl, zzm, zzbvb, zza2)).zza();
    }

    public final ListenableFuture zzc(zzbvb zzbvb, int i) {
        zzeav zzeav;
        zzfju zzfju;
        zzfiq zzfiq;
        zzbno zzb2 = zzu.zzf().zzb(this.zza, VersionInfoParcel.forPackage(), this.zzf);
        zzewr zzr = this.zzd.zzr(zzbvb, i);
        zzbne zza2 = zzb2.zza("google.afma.response.normalize", zzeax.zza, zzbnl.zzb);
        if (!((Boolean) zzbdz.zza.zze()).booleanValue()) {
            String str = zzbvb.zzj;
            zzeav = null;
            if (str != null && !str.isEmpty()) {
                zze.zza("Request contained a PoolKey but split request is disabled.");
            }
        } else {
            zzeav = zzk(zzbvb.zzh);
            if (zzeav == null) {
                zze.zza("Request contained a PoolKey but no matching parameters were found.");
            }
        }
        if (zzeav == null) {
            zzfju = zzfjt.zza(this.zza, 9);
        } else {
            zzfju = zzeav.zzd;
        }
        zzfkf zzd2 = zzr.zzd();
        zzd2.zzd(zzbvb.zza.getStringArrayList("ad_types"));
        zzebp zzebp = new zzebp(zzbvb.zzg, zzd2, zzfju);
        zzebm zzebm = new zzebm(this.zza, zzbvb.zzb.afmaVersion, this.zzg, i);
        zzfjl zzc2 = zzr.zzc();
        zzfju zza3 = zzfjt.zza(this.zza, 11);
        if (zzeav == null) {
            ListenableFuture zzm = zzm(zzbvb, zzc2, zzr);
            ListenableFuture zzl = zzl(zzm, zzc2, zzb2, zzd2, zzfju);
            zzfju zza4 = zzfjt.zza(this.zza, 10);
            zzfiq zza5 = zzc2.zza(zzfjf.HTTP, zzl, zzm).zza(new zzeam(zzl, zzbvb, zzm)).zze(zzebp).zze(new zzfka(zza4)).zze(zzebm).zza();
            zzfke.zza(zza5, zzd2, zza4);
            zzfke.zzd(zza5, zza3);
            zzfiq = zzc2.zza(zzfjf.PRE_PROCESS, zzm, zzl, zza5).zza(new zzean(zzbvb, zza5, zzm, zzl)).zzf(zza2).zza();
        } else {
            zzebo zzebo = new zzebo(zzeav.zzb, zzeav.zza);
            zzfju zza6 = zzfjt.zza(this.zza, 10);
            zzfiq zza7 = zzc2.zzb(zzfjf.HTTP, zzgcj.zzh(zzebo)).zze(zzebp).zze(new zzfka(zza6)).zze(zzebm).zza();
            zzfke.zza(zza7, zzd2, zza6);
            ListenableFuture zzh = zzgcj.zzh(zzeav);
            zzfke.zzd(zza7, zza3);
            zzfiq = zzc2.zza(zzfjf.PRE_PROCESS, zza7, zzh).zza(new zzeaj(zza7, zzh)).zzf(zza2).zza();
        }
        zzfke.zza(zzfiq, zzd2, zza3);
        return zzfiq;
    }

    public final ListenableFuture zzd(zzbvb zzbvb, int i) {
        zzbno zzb2 = zzu.zzf().zzb(this.zza, VersionInfoParcel.forPackage(), this.zzf);
        if (!((Boolean) zzbee.zza.zze()).booleanValue()) {
            return zzgcj.zzg(new Exception("Signal collection disabled."));
        }
        zzewr zzr = this.zzd.zzr(zzbvb, i);
        zzevr zza2 = zzr.zza();
        zzbne zza3 = zzb2.zza("google.afma.request.getSignals", zzbnl.zza, zzbnl.zzb);
        zzfju zza4 = zzfjt.zza(this.zza, 22);
        zzfiq zza5 = zzr.zzc().zzb(zzfjf.GET_SIGNALS, zzgcj.zzh(zzbvb.zza)).zze(new zzfka(zza4)).zzf(new zzeas(zza2, zzbvb)).zzb(zzfjf.JS_SIGNALS).zzf(zza3).zza();
        zzfkf zzd2 = zzr.zzd();
        zzd2.zzd(zzbvb.zza.getStringArrayList("ad_types"));
        zzd2.zzf(zzbvb.zza.getBundle("extras"));
        zzfke.zzb(zza5, zzd2, zza4);
        if (((Boolean) zzbds.zzg.zze()).booleanValue()) {
            zzebq zzebq = this.zzc;
            Objects.requireNonNull(zzebq);
            zza5.addListener(new zzeap(zzebq), this.zzb);
        }
        return zza5;
    }

    public final void zze(zzbvb zzbvb, zzbuu zzbuu) {
        zzp(zzb(zzbvb, Binder.getCallingUid()), zzbuu, zzbvb);
    }

    public final void zzf(zzbvb zzbvb, zzbuu zzbuu) {
        Bundle bundle;
        if (((Boolean) zzba.zzc().zza(zzbbw.zzbS)).booleanValue() && (bundle = zzbvb.zzm) != null) {
            bundle.putLong(zzdrt.SERVICE_CONNECTED.zza(), zzu.zzB().currentTimeMillis());
        }
        zzp(zzd(zzbvb, Binder.getCallingUid()), zzbuu, zzbvb);
    }

    public final void zzg(zzbvb zzbvb, zzbuu zzbuu) {
        Bundle bundle;
        if (((Boolean) zzba.zzc().zza(zzbbw.zzbS)).booleanValue() && (bundle = zzbvb.zzm) != null) {
            bundle.putLong(zzdrt.SERVICE_CONNECTED.zza(), zzu.zzB().currentTimeMillis());
        }
        ListenableFuture zzc2 = zzc(zzbvb, Binder.getCallingUid());
        zzp(zzc2, zzbuu, zzbvb);
        if (((Boolean) zzbds.zze.zze()).booleanValue()) {
            zzebq zzebq = this.zzc;
            Objects.requireNonNull(zzebq);
            zzc2.addListener(new zzeap(zzebq), this.zzb);
        }
    }

    public final void zzh(String str, zzbuu zzbuu) {
        zzp(zzi(str), zzbuu, (zzbvb) null);
    }

    public final ListenableFuture zzi(String str) {
        if (!((Boolean) zzbdz.zza.zze()).booleanValue()) {
            return zzgcj.zzg(new Exception("Split request is disabled."));
        }
        zzeat zzeat = new zzeat(this);
        if (zzk(str) == null) {
            return zzgcj.zzg(new Exception("URL to be removed not found for cache key: ".concat(String.valueOf(str))));
        }
        return zzgcj.zzh(zzeat);
    }

    public final /* synthetic */ InputStream zzj(ListenableFuture listenableFuture, ListenableFuture listenableFuture2, zzbvb zzbvb, zzfju zzfju) throws Exception {
        String zze2 = ((zzbvd) listenableFuture.get()).zze();
        String str = zzbvb.zzh;
        zzn(new zzeav((zzbvd) listenableFuture.get(), (JSONObject) listenableFuture2.get(), str, zze2, zzfju));
        return new ByteArrayInputStream(zze2.getBytes(zzfuj.zzc));
    }
}
