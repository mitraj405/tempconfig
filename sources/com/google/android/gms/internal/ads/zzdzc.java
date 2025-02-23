package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdzc {
    private final zzgcu zza;
    private final zzdyg zzb;
    private final zzhew zzc;
    private final zzfki zzd;
    private final Context zze;
    private final VersionInfoParcel zzf;

    public zzdzc(zzgcu zzgcu, zzdyg zzdyg, zzhew zzhew, zzfki zzfki, Context context, VersionInfoParcel versionInfoParcel) {
        this.zza = zzgcu;
        this.zzb = zzdyg;
        this.zzc = zzhew;
        this.zzd = zzfki;
        this.zze = context;
        this.zzf = versionInfoParcel;
    }

    private final ListenableFuture zzh(zzbvb zzbvb, zzdzb zzdzb, zzdzb zzdzb2, zzgbq zzgbq) {
        ListenableFuture listenableFuture;
        String str = zzbvb.zzd;
        zzu.zzp();
        if (zzt.zzC(str)) {
            listenableFuture = zzgcj.zzg(new zzdyp(1));
        } else {
            listenableFuture = zzgcj.zzf(zzdzb.zza(zzbvb), ExecutionException.class, new zzdza(), this.zza);
        }
        return zzgcj.zzf(zzgcj.zzn(zzgcj.zzn(zzgca.zzu(listenableFuture), new zzdyy(), this.zza), zzgbq, this.zza), zzdyp.class, new zzdyz(this, zzdzb2, zzbvb, zzgbq), this.zza);
    }

    public final ListenableFuture zza(zzbvb zzbvb) {
        zzdyv zzdyv = new zzdyv(zzbvb);
        zzdyg zzdyg = this.zzb;
        Objects.requireNonNull(zzdyg);
        return zzh(zzbvb, new zzdyw(zzdyg), new zzdyx(this), zzdyv);
    }

    public final ListenableFuture zzb(JSONObject jSONObject) {
        return zzgcj.zzn(zzgca.zzu(zzgcj.zzh(jSONObject)), zzu.zzf().zza(this.zze, this.zzf, this.zzd).zza("AFMA_getAdDictionary", zzbnl.zza, new zzdyr()), this.zza);
    }

    public final /* synthetic */ ListenableFuture zzc(zzdzb zzdzb, zzbvb zzbvb, zzgbq zzgbq, zzdyp zzdyp) throws Exception {
        return zzgcj.zzn(zzdzb.zza(zzbvb), zzgbq, this.zza);
    }

    public final /* synthetic */ ListenableFuture zzd(zzbvb zzbvb) {
        return ((zzeay) this.zzc.zzb()).zzb(zzbvb, Binder.getCallingUid());
    }

    public final /* synthetic */ ListenableFuture zze(zzbvb zzbvb) {
        return this.zzb.zzd(zzbvb.zzh);
    }

    public final /* synthetic */ ListenableFuture zzf(zzbvb zzbvb) {
        return ((zzeay) this.zzc.zzb()).zzi(zzbvb.zzh);
    }

    public final ListenableFuture zzg(zzbvb zzbvb) {
        return zzh(zzbvb, new zzdyt(this), new zzdyu(this), new zzdys());
    }
}
