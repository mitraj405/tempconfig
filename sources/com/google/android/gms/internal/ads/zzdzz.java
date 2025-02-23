package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.net.HttpHeaders;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdzz {
    public ListenableFuture zza;
    /* access modifiers changed from: private */
    public final zzczm zzb;
    private final zzdzh zzc;
    private final zzfjl zzd;
    private final zzffg zze;
    private final VersionInfoParcel zzf;
    private final zzfki zzg;
    private final zzfkf zzh;
    private final Context zzi;
    private final zzgcu zzj;

    public zzdzz(zzczm zzczm, zzdzh zzdzh, zzfjl zzfjl, zzffg zzffg, VersionInfoParcel versionInfoParcel, zzfki zzfki, zzfkf zzfkf, Context context, zzgcu zzgcu) {
        this.zzb = zzczm;
        this.zzc = zzdzh;
        this.zzd = zzfjl;
        this.zze = zzffg;
        this.zzf = versionInfoParcel;
        this.zzg = zzfki;
        this.zzh = zzfkf;
        this.zzi = context;
        this.zzj = zzgcu;
    }

    public final /* synthetic */ zzbug zza(zzbvb zzbvb, zzebk zzebk) {
        zzebk.zzc.put(HttpHeaders.CONTENT_TYPE, zzebk.zze);
        zzebk.zzc.put(HttpHeaders.USER_AGENT, zzu.zzp().zzc(this.zzi, zzbvb.zzb.afmaVersion));
        Bundle bundle = new Bundle();
        for (Map.Entry entry : zzebk.zzc.entrySet()) {
            bundle.putString((String) entry.getKey(), (String) entry.getValue());
        }
        return new zzbug(zzebk.zza, zzebk.zzb, bundle, zzebk.zzd, zzebk.zzf, zzbvb.zzd, zzbvb.zzh);
    }

    public final ListenableFuture zzc(zzbvb zzbvb, JSONObject jSONObject, zzbvd zzbvd) {
        this.zzb.zzdn(zzbvb);
        zzfjc zzb2 = this.zzd.zzb(zzfjf.PROXY, zzgcj.zzm(this.zzd.zzb(zzfjf.PREPARE_HTTP_REQUEST, zzgcj.zzh(new zzebo(jSONObject, zzbvd))).zze(new zzebp(zzbvb.zzg, this.zzh, zzfjt.zza(this.zzi, 9))).zza(), new zzdzv(this, zzbvb), this.zzj));
        zzdzh zzdzh = this.zzc;
        Objects.requireNonNull(zzdzh);
        zzfiq zza2 = zzb2.zzf(new zzdzw(zzdzh)).zza();
        this.zza = zza2;
        ListenableFuture zzn = zzgcj.zzn(this.zzd.zzb(zzfjf.PRE_PROCESS, zza2).zze(new zzdzu(jSONObject, zzbvd)).zzf(zzu.zzf().zza(this.zzi, this.zzf, this.zzg).zza("google.afma.response.normalize", zzeax.zza, zzbnl.zzb)).zza(), new zzdzx(this, zzbvb), this.zzj);
        zzgcj.zzr(zzn, new zzdzy(this), this.zzj);
        return zzn;
    }

    public final /* synthetic */ ListenableFuture zzd(zzbvb zzbvb, InputStream inputStream) throws Exception {
        return zzgcj.zzh(new zzfex(new zzfeu(this.zze), zzfew.zza(new InputStreamReader(inputStream), zzbvb)));
    }
}
