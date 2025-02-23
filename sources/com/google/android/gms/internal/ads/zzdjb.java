package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.client.zzel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdjb {
    private int zza;
    private zzdq zzb;
    private zzbew zzc;
    private View zzd;
    private List zze;
    private List zzf = Collections.emptyList();
    private zzel zzg;
    private Bundle zzh;
    private zzcej zzi;
    private zzcej zzj;
    private zzcej zzk;
    private zzeeo zzl;
    private ListenableFuture zzm;
    private zzbzt zzn;
    private View zzo;
    private View zzp;
    private IObjectWrapper zzq;
    private double zzr;
    private zzbfd zzs;
    private zzbfd zzt;
    private String zzu;
    private final SimpleArrayMap zzv = new SimpleArrayMap();
    private final SimpleArrayMap zzw = new SimpleArrayMap();
    private float zzx;
    private String zzy;

    public static zzdjb zzag(zzbox zzbox) {
        try {
            zzdja zzak = zzak(zzbox.zzg(), (zzbpb) null);
            zzbew zzh2 = zzbox.zzh();
            String zzo2 = zzbox.zzo();
            List zzr2 = zzbox.zzr();
            String zzm2 = zzbox.zzm();
            Bundle zzf2 = zzbox.zzf();
            String zzn2 = zzbox.zzn();
            IObjectWrapper zzl2 = zzbox.zzl();
            String zzq2 = zzbox.zzq();
            String zzp2 = zzbox.zzp();
            double zze2 = zzbox.zze();
            zzbfd zzi2 = zzbox.zzi();
            zzdjb zzdjb = new zzdjb();
            zzdjb.zza = 2;
            zzdjb.zzb = zzak;
            zzdjb.zzc = zzh2;
            zzdjb.zzd = (View) zzam(zzbox.zzj());
            zzdjb.zzZ("headline", zzo2);
            zzdjb.zze = zzr2;
            zzdjb.zzZ("body", zzm2);
            zzdjb.zzh = zzf2;
            zzdjb.zzZ("call_to_action", zzn2);
            zzdjb.zzo = (View) zzam(zzbox.zzk());
            zzdjb.zzq = zzl2;
            zzdjb.zzZ("store", zzq2);
            zzdjb.zzZ(FirebaseAnalytics.Param.PRICE, zzp2);
            zzdjb.zzr = zze2;
            zzdjb.zzs = zzi2;
            return zzdjb;
        } catch (RemoteException e) {
            zzm.zzk("Failed to get native ad from app install ad mapper", e);
            return null;
        }
    }

    public static zzdjb zzah(zzboy zzboy) {
        try {
            zzdja zzak = zzak(zzboy.zzf(), (zzbpb) null);
            zzbew zzg2 = zzboy.zzg();
            String zzo2 = zzboy.zzo();
            List zzp2 = zzboy.zzp();
            String zzm2 = zzboy.zzm();
            Bundle zze2 = zzboy.zze();
            String zzn2 = zzboy.zzn();
            IObjectWrapper zzk2 = zzboy.zzk();
            String zzl2 = zzboy.zzl();
            zzbfd zzh2 = zzboy.zzh();
            zzdjb zzdjb = new zzdjb();
            zzdjb.zza = 1;
            zzdjb.zzb = zzak;
            zzdjb.zzc = zzg2;
            zzdjb.zzd = (View) zzam(zzboy.zzi());
            zzdjb.zzZ("headline", zzo2);
            zzdjb.zze = zzp2;
            zzdjb.zzZ("body", zzm2);
            zzdjb.zzh = zze2;
            zzdjb.zzZ("call_to_action", zzn2);
            zzdjb.zzo = (View) zzam(zzboy.zzj());
            zzdjb.zzq = zzk2;
            zzdjb.zzZ("advertiser", zzl2);
            zzdjb.zzt = zzh2;
            return zzdjb;
        } catch (RemoteException e) {
            zzm.zzk("Failed to get native ad from content ad mapper", e);
            return null;
        }
    }

    public static zzdjb zzai(zzbox zzbox) {
        try {
            return zzal(zzak(zzbox.zzg(), (zzbpb) null), zzbox.zzh(), (View) zzam(zzbox.zzj()), zzbox.zzo(), zzbox.zzr(), zzbox.zzm(), zzbox.zzf(), zzbox.zzn(), (View) zzam(zzbox.zzk()), zzbox.zzl(), zzbox.zzq(), zzbox.zzp(), zzbox.zze(), zzbox.zzi(), (String) null, 0.0f);
        } catch (RemoteException e) {
            zzm.zzk("Failed to get native ad assets from app install ad mapper", e);
            return null;
        }
    }

    public static zzdjb zzaj(zzboy zzboy) {
        try {
            return zzal(zzak(zzboy.zzf(), (zzbpb) null), zzboy.zzg(), (View) zzam(zzboy.zzi()), zzboy.zzo(), zzboy.zzp(), zzboy.zzm(), zzboy.zze(), zzboy.zzn(), (View) zzam(zzboy.zzj()), zzboy.zzk(), (String) null, (String) null, -1.0d, zzboy.zzh(), zzboy.zzl(), 0.0f);
        } catch (RemoteException e) {
            zzm.zzk("Failed to get native ad assets from content ad mapper", e);
            return null;
        }
    }

    private static zzdja zzak(zzdq zzdq, zzbpb zzbpb) {
        if (zzdq == null) {
            return null;
        }
        return new zzdja(zzdq, zzbpb);
    }

    private static zzdjb zzal(zzdq zzdq, zzbew zzbew, View view, String str, List list, String str2, Bundle bundle, String str3, View view2, IObjectWrapper iObjectWrapper, String str4, String str5, double d, zzbfd zzbfd, String str6, float f) {
        zzdjb zzdjb = new zzdjb();
        zzdjb.zza = 6;
        zzdjb.zzb = zzdq;
        zzdjb.zzc = zzbew;
        zzdjb.zzd = view;
        String str7 = str;
        zzdjb.zzZ("headline", str);
        zzdjb.zze = list;
        String str8 = str2;
        zzdjb.zzZ("body", str2);
        zzdjb.zzh = bundle;
        String str9 = str3;
        zzdjb.zzZ("call_to_action", str3);
        zzdjb.zzo = view2;
        zzdjb.zzq = iObjectWrapper;
        String str10 = str4;
        zzdjb.zzZ("store", str4);
        String str11 = str5;
        zzdjb.zzZ(FirebaseAnalytics.Param.PRICE, str5);
        zzdjb.zzr = d;
        zzdjb.zzs = zzbfd;
        zzdjb.zzZ("advertiser", str6);
        zzdjb.zzR(f);
        return zzdjb;
    }

    private static Object zzam(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return null;
        }
        return ObjectWrapper.unwrap(iObjectWrapper);
    }

    public static zzdjb zzt(zzbpb zzbpb) {
        try {
            return zzal(zzak(zzbpb.zzj(), zzbpb), zzbpb.zzk(), (View) zzam(zzbpb.zzm()), zzbpb.zzs(), zzbpb.zzv(), zzbpb.zzq(), zzbpb.zzi(), zzbpb.zzr(), (View) zzam(zzbpb.zzn()), zzbpb.zzo(), zzbpb.zzu(), zzbpb.zzt(), zzbpb.zze(), zzbpb.zzl(), zzbpb.zzp(), zzbpb.zzf());
        } catch (RemoteException e) {
            zzm.zzk("Failed to get native ad assets from unified ad mapper", e);
            return null;
        }
    }

    public final synchronized String zzA() {
        return this.zzu;
    }

    public final synchronized String zzB() {
        return zzF("headline");
    }

    public final synchronized String zzC() {
        return this.zzy;
    }

    public final synchronized String zzD() {
        return zzF(FirebaseAnalytics.Param.PRICE);
    }

    public final synchronized String zzE() {
        return zzF("store");
    }

    public final synchronized String zzF(String str) {
        return (String) this.zzw.get(str);
    }

    public final synchronized List zzG() {
        return this.zze;
    }

    public final synchronized List zzH() {
        return this.zzf;
    }

    public final synchronized void zzI() {
        zzcej zzcej = this.zzi;
        if (zzcej != null) {
            zzcej.destroy();
            this.zzi = null;
        }
        zzcej zzcej2 = this.zzj;
        if (zzcej2 != null) {
            zzcej2.destroy();
            this.zzj = null;
        }
        zzcej zzcej3 = this.zzk;
        if (zzcej3 != null) {
            zzcej3.destroy();
            this.zzk = null;
        }
        ListenableFuture listenableFuture = this.zzm;
        if (listenableFuture != null) {
            listenableFuture.cancel(false);
            this.zzm = null;
        }
        zzbzt zzbzt = this.zzn;
        if (zzbzt != null) {
            zzbzt.cancel(false);
            this.zzn = null;
        }
        this.zzl = null;
        this.zzv.clear();
        this.zzw.clear();
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
        this.zze = null;
        this.zzh = null;
        this.zzo = null;
        this.zzp = null;
        this.zzq = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
    }

    public final synchronized void zzJ(zzbew zzbew) {
        this.zzc = zzbew;
    }

    public final synchronized void zzK(String str) {
        this.zzu = str;
    }

    public final synchronized void zzL(zzel zzel) {
        this.zzg = zzel;
    }

    public final synchronized void zzM(zzbfd zzbfd) {
        this.zzs = zzbfd;
    }

    public final synchronized void zzN(String str, zzbeq zzbeq) {
        if (zzbeq == null) {
            this.zzv.remove(str);
        } else {
            this.zzv.put(str, zzbeq);
        }
    }

    public final synchronized void zzO(zzcej zzcej) {
        this.zzj = zzcej;
    }

    public final synchronized void zzP(List list) {
        this.zze = list;
    }

    public final synchronized void zzQ(zzbfd zzbfd) {
        this.zzt = zzbfd;
    }

    public final synchronized void zzR(float f) {
        this.zzx = f;
    }

    public final synchronized void zzS(List list) {
        this.zzf = list;
    }

    public final synchronized void zzT(zzcej zzcej) {
        this.zzk = zzcej;
    }

    public final synchronized void zzU(ListenableFuture listenableFuture) {
        this.zzm = listenableFuture;
    }

    public final synchronized void zzV(String str) {
        this.zzy = str;
    }

    public final synchronized void zzW(zzeeo zzeeo) {
        this.zzl = zzeeo;
    }

    public final synchronized void zzX(zzbzt zzbzt) {
        this.zzn = zzbzt;
    }

    public final synchronized void zzY(double d) {
        this.zzr = d;
    }

    public final synchronized void zzZ(String str, String str2) {
        if (str2 == null) {
            this.zzw.remove(str);
        } else {
            this.zzw.put(str, str2);
        }
    }

    public final synchronized double zza() {
        return this.zzr;
    }

    public final synchronized void zzaa(int i) {
        this.zza = i;
    }

    public final synchronized void zzab(zzdq zzdq) {
        this.zzb = zzdq;
    }

    public final synchronized void zzac(View view) {
        this.zzo = view;
    }

    public final synchronized void zzad(zzcej zzcej) {
        this.zzi = zzcej;
    }

    public final synchronized void zzae(View view) {
        this.zzp = view;
    }

    public final synchronized boolean zzaf() {
        if (this.zzj != null) {
            return true;
        }
        return false;
    }

    public final synchronized float zzb() {
        return this.zzx;
    }

    public final synchronized int zzc() {
        return this.zza;
    }

    public final synchronized Bundle zzd() {
        if (this.zzh == null) {
            this.zzh = new Bundle();
        }
        return this.zzh;
    }

    public final synchronized View zze() {
        return this.zzd;
    }

    public final synchronized View zzf() {
        return this.zzo;
    }

    public final synchronized View zzg() {
        return this.zzp;
    }

    public final synchronized SimpleArrayMap zzh() {
        return this.zzv;
    }

    public final synchronized SimpleArrayMap zzi() {
        return this.zzw;
    }

    public final synchronized zzdq zzj() {
        return this.zzb;
    }

    public final synchronized zzel zzk() {
        return this.zzg;
    }

    public final synchronized zzbew zzl() {
        return this.zzc;
    }

    public final zzbfd zzm() {
        List list = this.zze;
        if (list == null || list.isEmpty()) {
            return null;
        }
        Object obj = this.zze.get(0);
        if (obj instanceof IBinder) {
            return zzbfc.zzg((IBinder) obj);
        }
        return null;
    }

    public final synchronized zzbfd zzn() {
        return this.zzs;
    }

    public final synchronized zzbfd zzo() {
        return this.zzt;
    }

    public final synchronized zzbzt zzp() {
        return this.zzn;
    }

    public final synchronized zzcej zzq() {
        return this.zzj;
    }

    public final synchronized zzcej zzr() {
        return this.zzk;
    }

    public final synchronized zzcej zzs() {
        return this.zzi;
    }

    public final synchronized zzeeo zzu() {
        return this.zzl;
    }

    public final synchronized IObjectWrapper zzv() {
        return this.zzq;
    }

    public final synchronized ListenableFuture zzw() {
        return this.zzm;
    }

    public final synchronized String zzx() {
        return zzF("advertiser");
    }

    public final synchronized String zzy() {
        return zzF("body");
    }

    public final synchronized String zzz() {
        return zzF("call_to_action");
    }
}
