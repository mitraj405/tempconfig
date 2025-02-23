package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.zzu;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdti implements AppEventListener, zzczo, zza, zzcwq, zzcxk, zzcxl, zzcye, zzcwt, zzfjm {
    private final List zza;
    private final zzdsw zzb;
    private long zzc;

    public zzdti(zzdsw zzdsw, zzcgj zzcgj) {
        this.zzb = zzdsw;
        this.zza = Collections.singletonList(zzcgj);
    }

    private final void zzg(Class cls, String str, Object... objArr) {
        this.zzb.zza(this.zza, "Event-".concat(cls.getSimpleName()), str, objArr);
    }

    public final void onAdClicked() {
        zzg(zza.class, "onAdClicked", new Object[0]);
    }

    public final void onAppEvent(String str, String str2) {
        zzg(AppEventListener.class, "onAppEvent", str, str2);
    }

    public final void zza() {
        zzg(zzcwq.class, "onAdClosed", new Object[0]);
    }

    public final void zzb() {
        zzg(zzcwq.class, "onAdLeftApplication", new Object[0]);
    }

    public final void zzc() {
        zzg(zzcwq.class, "onAdOpened", new Object[0]);
    }

    public final void zzd(zzfjf zzfjf, String str) {
        zzg(zzfje.class, "onTaskSucceeded", str);
    }

    public final void zzdB(zze zze) {
        zzg(zzcwt.class, "onAdFailedToLoad", Integer.valueOf(zze.zza), zze.zzb, zze.zzc);
    }

    public final void zzdC(zzfjf zzfjf, String str) {
        zzg(zzfje.class, "onTaskCreated", str);
    }

    public final void zzdD(zzfjf zzfjf, String str, Throwable th) {
        zzg(zzfje.class, "onTaskFailed", str, th.getClass().getSimpleName());
    }

    public final void zzdE(zzfjf zzfjf, String str) {
        zzg(zzfje.class, "onTaskStarted", str);
    }

    public final void zzdj(Context context) {
        zzg(zzcxl.class, "onDestroy", context);
    }

    public final void zzdl(Context context) {
        zzg(zzcxl.class, "onPause", context);
    }

    public final void zzdm(Context context) {
        zzg(zzcxl.class, "onResume", context);
    }

    public final void zzdn(zzbvb zzbvb) {
        this.zzc = zzu.zzB().elapsedRealtime();
        zzg(zzczo.class, "onAdRequest", new Object[0]);
    }

    public final void zzds(zzbvn zzbvn, String str, String str2) {
        zzg(zzcwq.class, "onRewarded", zzbvn, str, str2);
    }

    public final void zze() {
        zzg(zzcwq.class, "onRewardedVideoCompleted", new Object[0]);
    }

    public final void zzf() {
        zzg(zzcwq.class, "onRewardedVideoStarted", new Object[0]);
    }

    public final void zzr() {
        zzg(zzcxk.class, "onAdImpression", new Object[0]);
    }

    public final void zzs() {
        long elapsedRealtime = zzu.zzB().elapsedRealtime() - this.zzc;
        com.google.android.gms.ads.internal.util.zze.zza("Ad Request Latency : " + elapsedRealtime);
        zzg(zzcye.class, "onAdLoaded", new Object[0]);
    }

    public final void zzdo(zzfex zzfex) {
    }
}
