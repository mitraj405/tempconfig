package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.InputEvent;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcni {
    zzbts zza;
    zzbts zzb;
    /* access modifiers changed from: private */
    public final Context zzc;
    private final zzg zzd;
    private final zzeep zze;
    private final zzdpq zzf;
    /* access modifiers changed from: private */
    public final zzgcu zzg;
    private final Executor zzh;
    private final ScheduledExecutorService zzi;

    public zzcni(Context context, zzg zzg2, zzeep zzeep, zzdpq zzdpq, zzgcu zzgcu, zzgcu zzgcu2, ScheduledExecutorService scheduledExecutorService) {
        this.zzc = context;
        this.zzd = zzg2;
        this.zze = zzeep;
        this.zzf = zzdpq;
        this.zzg = zzgcu;
        this.zzh = zzgcu2;
        this.zzi = scheduledExecutorService;
    }

    public static boolean zzj(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains((CharSequence) zzba.zzc().zza(zzbbw.zzjn));
    }

    private final ListenableFuture zzk(String str, InputEvent inputEvent, Random random) {
        try {
            if (!str.contains((CharSequence) zzba.zzc().zza(zzbbw.zzjn)) || this.zzd.zzS()) {
                return zzgcj.zzh(str);
            }
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            long nextInt = (long) random.nextInt(Integer.MAX_VALUE);
            buildUpon.appendQueryParameter((String) zzba.zzc().zza(zzbbw.zzjo), String.valueOf(nextInt));
            if (inputEvent != null) {
                return zzgcj.zzf(zzgcj.zzn(zzgca.zzu(this.zze.zza()), new zzcnc(this, buildUpon, str, inputEvent), this.zzh), Throwable.class, new zzcnd(this, buildUpon), this.zzg);
            }
            buildUpon.appendQueryParameter((String) zzba.zzc().zza(zzbbw.zzjp), "11");
            return zzgcj.zzh(buildUpon.toString());
        } catch (Exception e) {
            return zzgcj.zzg(e);
        }
    }

    public final ListenableFuture zzb(String str, Random random) {
        if (TextUtils.isEmpty(str)) {
            return zzgcj.zzh(str);
        }
        return zzgcj.zzf(zzk(str, this.zzf.zza(), random), Throwable.class, new zzcmz(this, str), this.zzg);
    }

    public final /* synthetic */ ListenableFuture zzc(String str, Throwable th) throws Exception {
        this.zzg.zza(new zzcnb(this, th));
        return zzgcj.zzh(str);
    }

    public final /* synthetic */ ListenableFuture zzd(Uri.Builder builder, String str, InputEvent inputEvent, Integer num) throws Exception {
        if (num.intValue() == 1) {
            Uri.Builder buildUpon = builder.build().buildUpon();
            buildUpon.appendQueryParameter((String) zzba.zzc().zza(zzbbw.zzjq), C0515Ga.AVLBLTY_ONLY);
            buildUpon.appendQueryParameter((String) zzba.zzc().zza(zzbbw.zzjp), "12");
            if (str.contains((CharSequence) zzba.zzc().zza(zzbbw.zzjr))) {
                buildUpon.authority((String) zzba.zzc().zza(zzbbw.zzjs));
            }
            return zzgcj.zzn(zzgca.zzu(this.zze.zzb(buildUpon.build(), inputEvent)), new zzcne(builder), this.zzh);
        }
        builder.appendQueryParameter((String) zzba.zzc().zza(zzbbw.zzjp), "10");
        return zzgcj.zzh(builder.toString());
    }

    public final /* synthetic */ ListenableFuture zze(Uri.Builder builder, Throwable th) throws Exception {
        this.zzg.zza(new zzcna(this, th));
        builder.appendQueryParameter((String) zzba.zzc().zza(zzbbw.zzjp), "9");
        return zzgcj.zzh(builder.toString());
    }

    public final /* synthetic */ void zzg(Throwable th) {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzju)).booleanValue()) {
            zzbts zzc2 = zzbtq.zzc(this.zzc);
            this.zzb = zzc2;
            zzc2.zzh(th, "AttributionReporting.getUpdatedUrlAndRegisterSource");
            return;
        }
        zzbts zza2 = zzbtq.zza(this.zzc);
        this.zza = zza2;
        zza2.zzh(th, "AttributionReportingSampled.getUpdatedUrlAndRegisterSource");
    }

    public final /* synthetic */ void zzh(Throwable th) {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzju)).booleanValue()) {
            zzbts zzc2 = zzbtq.zzc(this.zzc);
            this.zzb = zzc2;
            zzc2.zzh(th, "AttributionReporting");
            return;
        }
        zzbts zza2 = zzbtq.zza(this.zzc);
        this.zza = zza2;
        zza2.zzh(th, "AttributionReportingSampled");
    }

    public final void zzi(String str, zzfll zzfll, Random random) {
        if (!TextUtils.isEmpty(str)) {
            ListenableFuture zzk = zzk(str, this.zzf.zza(), random);
            zzbbn zzbbn = zzbbw.zzjt;
            zzgcj.zzr(zzgcj.zzo(zzk, (long) ((Integer) zzba.zzc().zza(zzbbn)).intValue(), TimeUnit.MILLISECONDS, this.zzi), new zzcnh(this, zzfll, str), this.zzg);
        }
    }
}
