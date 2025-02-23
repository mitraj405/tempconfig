package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdtp {
    private final zzbjw zza;

    public zzdtp(zzbjw zzbjw) {
        this.zza = zzbjw;
    }

    private final void zzs(zzdto zzdto) throws RemoteException {
        String zza2 = zzdto.zza(zzdto);
        zzm.zzi("Dispatching AFMA event on publisher webview: ".concat(zza2));
        this.zza.zzb(zza2);
    }

    public final void zza() throws RemoteException {
        zzs(new zzdto("initialize", (zzdtn) null));
    }

    public final void zzb(long j) throws RemoteException {
        zzdto zzdto = new zzdto("interstitial", (zzdtn) null);
        zzdto.zza = Long.valueOf(j);
        zzdto.zzc = "onAdClicked";
        this.zza.zzb(zzdto.zza(zzdto));
    }

    public final void zzc(long j) throws RemoteException {
        zzdto zzdto = new zzdto("interstitial", (zzdtn) null);
        zzdto.zza = Long.valueOf(j);
        zzdto.zzc = "onAdClosed";
        zzs(zzdto);
    }

    public final void zzd(long j, int i) throws RemoteException {
        zzdto zzdto = new zzdto("interstitial", (zzdtn) null);
        zzdto.zza = Long.valueOf(j);
        zzdto.zzc = "onAdFailedToLoad";
        zzdto.zzd = Integer.valueOf(i);
        zzs(zzdto);
    }

    public final void zze(long j) throws RemoteException {
        zzdto zzdto = new zzdto("interstitial", (zzdtn) null);
        zzdto.zza = Long.valueOf(j);
        zzdto.zzc = "onAdLoaded";
        zzs(zzdto);
    }

    public final void zzf(long j) throws RemoteException {
        zzdto zzdto = new zzdto("interstitial", (zzdtn) null);
        zzdto.zza = Long.valueOf(j);
        zzdto.zzc = "onNativeAdObjectNotAvailable";
        zzs(zzdto);
    }

    public final void zzg(long j) throws RemoteException {
        zzdto zzdto = new zzdto("interstitial", (zzdtn) null);
        zzdto.zza = Long.valueOf(j);
        zzdto.zzc = "onAdOpened";
        zzs(zzdto);
    }

    public final void zzh(long j) throws RemoteException {
        zzdto zzdto = new zzdto("creation", (zzdtn) null);
        zzdto.zza = Long.valueOf(j);
        zzdto.zzc = "nativeObjectCreated";
        zzs(zzdto);
    }

    public final void zzi(long j) throws RemoteException {
        zzdto zzdto = new zzdto("creation", (zzdtn) null);
        zzdto.zza = Long.valueOf(j);
        zzdto.zzc = "nativeObjectNotCreated";
        zzs(zzdto);
    }

    public final void zzj(long j) throws RemoteException {
        zzdto zzdto = new zzdto("rewarded", (zzdtn) null);
        zzdto.zza = Long.valueOf(j);
        zzdto.zzc = "onAdClicked";
        zzs(zzdto);
    }

    public final void zzk(long j) throws RemoteException {
        zzdto zzdto = new zzdto("rewarded", (zzdtn) null);
        zzdto.zza = Long.valueOf(j);
        zzdto.zzc = "onRewardedAdClosed";
        zzs(zzdto);
    }

    public final void zzl(long j, zzbwd zzbwd) throws RemoteException {
        zzdto zzdto = new zzdto("rewarded", (zzdtn) null);
        zzdto.zza = Long.valueOf(j);
        zzdto.zzc = "onUserEarnedReward";
        zzdto.zze = zzbwd.zzf();
        zzdto.zzf = Integer.valueOf(zzbwd.zze());
        zzs(zzdto);
    }

    public final void zzm(long j, int i) throws RemoteException {
        zzdto zzdto = new zzdto("rewarded", (zzdtn) null);
        zzdto.zza = Long.valueOf(j);
        zzdto.zzc = "onRewardedAdFailedToLoad";
        zzdto.zzd = Integer.valueOf(i);
        zzs(zzdto);
    }

    public final void zzn(long j, int i) throws RemoteException {
        zzdto zzdto = new zzdto("rewarded", (zzdtn) null);
        zzdto.zza = Long.valueOf(j);
        zzdto.zzc = "onRewardedAdFailedToShow";
        zzdto.zzd = Integer.valueOf(i);
        zzs(zzdto);
    }

    public final void zzo(long j) throws RemoteException {
        zzdto zzdto = new zzdto("rewarded", (zzdtn) null);
        zzdto.zza = Long.valueOf(j);
        zzdto.zzc = "onAdImpression";
        zzs(zzdto);
    }

    public final void zzp(long j) throws RemoteException {
        zzdto zzdto = new zzdto("rewarded", (zzdtn) null);
        zzdto.zza = Long.valueOf(j);
        zzdto.zzc = "onRewardedAdLoaded";
        zzs(zzdto);
    }

    public final void zzq(long j) throws RemoteException {
        zzdto zzdto = new zzdto("rewarded", (zzdtn) null);
        zzdto.zza = Long.valueOf(j);
        zzdto.zzc = "onNativeAdObjectNotAvailable";
        zzs(zzdto);
    }

    public final void zzr(long j) throws RemoteException {
        zzdto zzdto = new zzdto("rewarded", (zzdtn) null);
        zzdto.zza = Long.valueOf(j);
        zzdto.zzc = "onRewardedAdOpened";
        zzs(zzdto);
    }
}
