package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzctc {
    private final zzdxu zza;
    private final zzffg zzb;
    private final zzfjl zzc;
    private final zzclw zzd;
    private final zzeiu zze;
    /* access modifiers changed from: private */
    public final zzdby zzf;
    private zzfex zzg;
    private final zzdzc zzh;
    private final zzcvu zzi;
    private final Executor zzj;
    private final zzdym zzk;
    private final zzeey zzl;
    private final zzdzs zzm;
    private final zzdzz zzn;

    public zzctc(zzdxu zzdxu, zzffg zzffg, zzfjl zzfjl, zzclw zzclw, zzeiu zzeiu, zzdby zzdby, zzfex zzfex, zzdzc zzdzc, zzcvu zzcvu, Executor executor, zzdym zzdym, zzeey zzeey, zzdzs zzdzs, zzdzz zzdzz) {
        this.zza = zzdxu;
        this.zzb = zzffg;
        this.zzc = zzfjl;
        this.zzd = zzclw;
        this.zze = zzeiu;
        this.zzf = zzdby;
        this.zzg = zzfex;
        this.zzh = zzdzc;
        this.zzi = zzcvu;
        this.zzj = executor;
        this.zzk = zzdym;
        this.zzl = zzeey;
        this.zzm = zzdzs;
        this.zzn = zzdzz;
    }

    public final zze zza(Throwable th) {
        return zzfgi.zzb(th, this.zzl);
    }

    public final zzdby zzc() {
        return this.zzf;
    }

    public final /* synthetic */ zzfex zzd(zzfex zzfex) throws Exception {
        this.zzd.zza(zzfex);
        return zzfex;
    }

    public final ListenableFuture zze(zzfhb zzfhb) {
        zzfiq zza2 = this.zzc.zzb(zzfjf.GET_CACHE_KEY, this.zzi.zzc()).zzf(new zzcsy(this, zzfhb)).zza();
        zzgcj.zzr(zza2, new zzcta(this), this.zzj);
        return zza2;
    }

    public final /* synthetic */ ListenableFuture zzf(zzfhb zzfhb, zzbvb zzbvb) throws Exception {
        zzbvb.zzi = zzfhb;
        return this.zzh.zza(zzbvb);
    }

    public final /* synthetic */ ListenableFuture zzg(ListenableFuture listenableFuture, ListenableFuture listenableFuture2, ListenableFuture listenableFuture3) throws Exception {
        return this.zzn.zzc((zzbvb) listenableFuture.get(), (JSONObject) listenableFuture2.get(), (zzbvd) listenableFuture3.get());
    }

    public final ListenableFuture zzh(zzbvb zzbvb) {
        zzfiq zza2 = this.zzc.zzb(zzfjf.NOTIFY_CACHE_HIT, this.zzh.zzg(zzbvb)).zza();
        zzgcj.zzr(zza2, new zzctb(this), this.zzj);
        return zza2;
    }

    public final ListenableFuture zzi(ListenableFuture listenableFuture) {
        zzfjc zzf2 = this.zzc.zzb(zzfjf.RENDERER, listenableFuture).zze(new zzcst(this)).zzf(this.zze);
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzeT)).booleanValue()) {
            zzf2 = zzf2.zzi((long) ((Integer) zzba.zzc().zza(zzbbw.zzeU)).intValue(), TimeUnit.SECONDS);
        }
        return zzf2.zza();
    }

    public final ListenableFuture zzj() {
        zzl zzl2 = this.zzb.zzd;
        if (zzl2.zzx == null && zzl2.zzs == null) {
            return zzk(this.zzi.zzc());
        }
        zzfjl zzfjl = this.zzc;
        zzdxu zzdxu = this.zza;
        return zzfiv.zzc(zzdxu.zza(), zzfjf.PRELOADED_LOADER, zzfjl).zza();
    }

    public final ListenableFuture zzk(ListenableFuture listenableFuture) {
        zzfex zzfex = this.zzg;
        if (zzfex != null) {
            zzfjl zzfjl = this.zzc;
            return zzfiv.zzc(zzgcj.zzh(zzfex), zzfjf.SERVER_TRANSACTION, zzfjl).zza();
        }
        zzu.zzc().zzj();
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzkF)).booleanValue() || ((Boolean) zzbdy.zzc.zze()).booleanValue()) {
            zzfjc zzb2 = this.zzc.zzb(zzfjf.SERVER_TRANSACTION, listenableFuture);
            zzdym zzdym = this.zzk;
            Objects.requireNonNull(zzdym);
            return zzb2.zzf(new zzcsz(zzdym)).zza();
        }
        zzdzs zzdzs = this.zzm;
        Objects.requireNonNull(zzdzs);
        ListenableFuture zzn2 = zzgcj.zzn(listenableFuture, new zzcsu(zzdzs), this.zzj);
        zzfjc zzb3 = this.zzc.zzb(zzfjf.BUILD_URL, zzn2);
        zzdzc zzdzc = this.zzh;
        Objects.requireNonNull(zzdzc);
        zzfiq zza2 = zzb3.zzf(new zzcsv(zzdzc)).zza();
        return this.zzc.zza(zzfjf.SERVER_TRANSACTION, listenableFuture, zzn2, zza2).zza(new zzcsw(this, listenableFuture, zzn2, zza2)).zzf(new zzcsx()).zza();
    }

    public final void zzl(zzfex zzfex) {
        this.zzg = zzfex;
    }
}
