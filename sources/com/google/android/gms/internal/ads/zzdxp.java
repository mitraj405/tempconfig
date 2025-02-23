package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStreamReader;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdxp implements zzdyo {
    /* access modifiers changed from: private */
    public static final Pattern zza = Pattern.compile("Received error HTTP response code: (.*)");
    private final zzdwq zzb;
    private final zzgcu zzc;
    private final zzffg zzd;
    private final ScheduledExecutorService zze;
    /* access modifiers changed from: private */
    public final zzecd zzf;
    private final zzfkf zzg;
    private final Context zzh;

    public zzdxp(Context context, zzffg zzffg, zzdwq zzdwq, zzgcu zzgcu, ScheduledExecutorService scheduledExecutorService, zzecd zzecd, zzfkf zzfkf) {
        this.zzh = context;
        this.zzd = zzffg;
        this.zzb = zzdwq;
        this.zzc = zzgcu;
        this.zze = scheduledExecutorService;
        this.zzf = zzecd;
        this.zzg = zzfkf;
    }

    public final ListenableFuture zzb(zzbvb zzbvb) {
        Context context = this.zzh;
        ListenableFuture zzc2 = this.zzb.zzc(zzbvb);
        zzfju zza2 = zzfjt.zza(context, 11);
        zzfke.zzd(zzc2, zza2);
        ListenableFuture zzn = zzgcj.zzn(zzc2, new zzdxm(this), this.zzc);
        if (((Boolean) zzba.zzc().zza(zzbbw.zzeT)).booleanValue()) {
            zzbbn zzbbn = zzbbw.zzeU;
            Class<TimeoutException> cls = TimeoutException.class;
            zzn = zzgcj.zzf(zzgcj.zzo(zzn, (long) ((Integer) zzba.zzc().zza(zzbbn)).intValue(), TimeUnit.SECONDS, this.zze), cls, new zzdxn(), zzbzo.zzf);
        }
        zzfke.zza(zzn, this.zzg, zza2);
        zzgcj.zzr(zzn, new zzdxo(this), zzbzo.zzf);
        return zzn;
    }

    public final /* synthetic */ ListenableFuture zzc(zzdyq zzdyq) throws Exception {
        return zzgcj.zzh(new zzfex(new zzfeu(this.zzd), zzfew.zza(new InputStreamReader(zzdyq.zzb()), zzdyq.zza())));
    }
}
