package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zzbh;
import com.google.android.gms.ads.internal.client.zzbk;
import com.google.android.gms.ads.internal.client.zzbt;
import com.google.android.gms.ads.internal.client.zzby;
import com.google.android.gms.ads.internal.client.zzcb;
import com.google.android.gms.ads.internal.client.zzcf;
import com.google.android.gms.ads.internal.client.zzci;
import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.client.zzdu;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzfk;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzems extends zzbt {
    private final zzq zza;
    private final Context zzb;
    private final zzfco zzc;
    private final String zzd;
    private final VersionInfoParcel zze;
    private final zzemk zzf;
    private final zzfdo zzg;
    private final zzauo zzh;
    private final zzdsk zzi;
    /* access modifiers changed from: private */
    public zzdfo zzj;
    private boolean zzk = ((Boolean) zzba.zzc().zza(zzbbw.zzav)).booleanValue();

    public zzems(Context context, zzq zzq, String str, zzfco zzfco, zzemk zzemk, zzfdo zzfdo, VersionInfoParcel versionInfoParcel, zzauo zzauo, zzdsk zzdsk) {
        this.zza = zzq;
        this.zzd = str;
        this.zzb = context;
        this.zzc = zzfco;
        this.zzf = zzemk;
        this.zzg = zzfdo;
        this.zze = versionInfoParcel;
        this.zzh = zzauo;
        this.zzi = zzdsk;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000f, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized boolean zze() {
        /*
            r1 = this;
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzdfo r0 = r1.zzj     // Catch:{ all -> 0x0011 }
            if (r0 == 0) goto L_0x000e
            boolean r0 = r0.zza()     // Catch:{ all -> 0x0011 }
            if (r0 != 0) goto L_0x000e
            monitor-exit(r1)
            r0 = 1
            return r0
        L_0x000e:
            monitor-exit(r1)
            r0 = 0
            return r0
        L_0x0011:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzems.zze():boolean");
    }

    public final synchronized void zzB() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        zzdfo zzdfo = this.zzj;
        if (zzdfo != null) {
            zzdfo.zzn().zzc((Context) null);
        }
    }

    public final void zzD(zzbh zzbh) {
        Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        this.zzf.zzj(zzbh);
    }

    public final void zzE(zzby zzby) {
        Preconditions.checkMainThread("setAdMetadataListener must be called on the main UI thread.");
    }

    public final void zzG(zzcb zzcb) {
        Preconditions.checkMainThread("setAppEventListener must be called on the main UI thread.");
        this.zzf.zzm(zzcb);
    }

    public final void zzJ(zzci zzci) {
        this.zzf.zzn(zzci);
    }

    public final synchronized void zzL(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zzk = z;
    }

    public final synchronized void zzO(zzbcr zzbcr) {
        Preconditions.checkMainThread("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzc.zzi(zzbcr);
    }

    public final void zzP(zzdg zzdg) {
        Preconditions.checkMainThread("setPaidEventListener must be called on the main UI thread.");
        try {
            if (!zzdg.zzf()) {
                this.zzi.zze();
            }
        } catch (RemoteException e) {
            zzm.zzf("Error in making CSI ping for reporting paid event callback", e);
        }
        this.zzf.zzl(zzdg);
    }

    public final void zzS(zzbvt zzbvt) {
        this.zzg.zzm(zzbvt);
    }

    public final synchronized void zzW(IObjectWrapper iObjectWrapper) {
        if (this.zzj == null) {
            zzm.zzj("Interstitial can not be shown before loaded.");
            this.zzf.zzq(zzfgi.zzd(9, (String) null, (zze) null));
            return;
        }
        if (((Boolean) zzba.zzc().zza(zzbbw.zzct)).booleanValue()) {
            this.zzh.zzc().zzn(new Throwable().getStackTrace());
        }
        this.zzj.zzc(this.zzk, (Activity) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final synchronized void zzX() {
        Preconditions.checkMainThread("showInterstitial must be called on the main UI thread.");
        if (this.zzj == null) {
            zzm.zzj("Interstitial can not be shown before loaded.");
            this.zzf.zzq(zzfgi.zzd(9, (String) null, (zze) null));
            return;
        }
        if (((Boolean) zzba.zzc().zza(zzbbw.zzct)).booleanValue()) {
            this.zzh.zzc().zzn(new Throwable().getStackTrace());
        }
        this.zzj.zzc(this.zzk, (Activity) null);
    }

    public final synchronized boolean zzY() {
        return false;
    }

    public final synchronized boolean zzZ() {
        return this.zzc.zza();
    }

    public final synchronized boolean zzaa() {
        Preconditions.checkMainThread("isLoaded must be called on the main UI thread.");
        return zze();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008a, code lost:
        return false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0064  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzab(com.google.android.gms.ads.internal.client.zzl r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            com.google.android.gms.internal.ads.zzbdc r0 = com.google.android.gms.internal.ads.zzbdq.zzi     // Catch:{ all -> 0x008b }
            java.lang.Object r0 = r0.zze()     // Catch:{ all -> 0x008b }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x008b }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x008b }
            r1 = 0
            if (r0 == 0) goto L_0x0024
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zzkl     // Catch:{ all -> 0x008b }
            com.google.android.gms.internal.ads.zzbbu r2 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x008b }
            java.lang.Object r0 = r2.zza(r0)     // Catch:{ all -> 0x008b }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x008b }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x008b }
            if (r0 == 0) goto L_0x0024
            r0 = 1
            goto L_0x0025
        L_0x0024:
            r0 = r1
        L_0x0025:
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r2 = r5.zze     // Catch:{ all -> 0x008b }
            int r2 = r2.clientJarVersion     // Catch:{ all -> 0x008b }
            com.google.android.gms.internal.ads.zzbbn r3 = com.google.android.gms.internal.ads.zzbbw.zzkm     // Catch:{ all -> 0x008b }
            com.google.android.gms.internal.ads.zzbbu r4 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x008b }
            java.lang.Object r3 = r4.zza(r3)     // Catch:{ all -> 0x008b }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ all -> 0x008b }
            int r3 = r3.intValue()     // Catch:{ all -> 0x008b }
            if (r2 < r3) goto L_0x003d
            if (r0 != 0) goto L_0x0042
        L_0x003d:
            java.lang.String r0 = "loadAd must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch:{ all -> 0x008b }
        L_0x0042:
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ all -> 0x008b }
            android.content.Context r0 = r5.zzb     // Catch:{ all -> 0x008b }
            boolean r0 = com.google.android.gms.ads.internal.util.zzt.zzH(r0)     // Catch:{ all -> 0x008b }
            r2 = 0
            if (r0 == 0) goto L_0x0064
            com.google.android.gms.ads.internal.client.zzc r0 = r6.zzs     // Catch:{ all -> 0x008b }
            if (r0 != 0) goto L_0x0064
            java.lang.String r6 = "Failed to load the ad because app ID is missing."
            com.google.android.gms.ads.internal.util.client.zzm.zzg(r6)     // Catch:{ all -> 0x008b }
            com.google.android.gms.internal.ads.zzemk r6 = r5.zzf     // Catch:{ all -> 0x008b }
            if (r6 == 0) goto L_0x0089
            r0 = 4
            com.google.android.gms.ads.internal.client.zze r0 = com.google.android.gms.internal.ads.zzfgi.zzd(r0, r2, r2)     // Catch:{ all -> 0x008b }
            r6.zzdB(r0)     // Catch:{ all -> 0x008b }
            goto L_0x0089
        L_0x0064:
            boolean r0 = r5.zze()     // Catch:{ all -> 0x008b }
            if (r0 != 0) goto L_0x0089
            android.content.Context r0 = r5.zzb     // Catch:{ all -> 0x008b }
            boolean r1 = r6.zzf     // Catch:{ all -> 0x008b }
            com.google.android.gms.internal.ads.zzfgd.zza(r0, r1)     // Catch:{ all -> 0x008b }
            r5.zzj = r2     // Catch:{ all -> 0x008b }
            com.google.android.gms.internal.ads.zzfco r0 = r5.zzc     // Catch:{ all -> 0x008b }
            java.lang.String r1 = r5.zzd     // Catch:{ all -> 0x008b }
            com.google.android.gms.ads.internal.client.zzq r2 = r5.zza     // Catch:{ all -> 0x008b }
            com.google.android.gms.internal.ads.zzfch r3 = new com.google.android.gms.internal.ads.zzfch     // Catch:{ all -> 0x008b }
            r3.<init>(r2)     // Catch:{ all -> 0x008b }
            com.google.android.gms.internal.ads.zzemr r2 = new com.google.android.gms.internal.ads.zzemr     // Catch:{ all -> 0x008b }
            r2.<init>(r5)     // Catch:{ all -> 0x008b }
            boolean r6 = r0.zzb(r6, r1, r3, r2)     // Catch:{ all -> 0x008b }
            monitor-exit(r5)
            return r6
        L_0x0089:
            monitor-exit(r5)
            return r1
        L_0x008b:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzems.zzab(com.google.android.gms.ads.internal.client.zzl):boolean");
    }

    public final Bundle zzd() {
        Preconditions.checkMainThread("getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }

    public final zzq zzg() {
        return null;
    }

    public final zzbh zzi() {
        return this.zzf.zzg();
    }

    public final zzcb zzj() {
        return this.zzf.zzi();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.google.android.gms.ads.internal.client.zzdn zzk() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zzgc     // Catch:{ all -> 0x0021 }
            com.google.android.gms.internal.ads.zzbbu r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x0021 }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x0021 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0021 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0021 }
            if (r0 != 0) goto L_0x0014
            goto L_0x001e
        L_0x0014:
            com.google.android.gms.internal.ads.zzdfo r0 = r2.zzj     // Catch:{ all -> 0x0021 }
            if (r0 == 0) goto L_0x001e
            com.google.android.gms.internal.ads.zzcwj r0 = r0.zzm()     // Catch:{ all -> 0x0021 }
            monitor-exit(r2)
            return r0
        L_0x001e:
            monitor-exit(r2)
            r0 = 0
            return r0
        L_0x0021:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzems.zzk():com.google.android.gms.ads.internal.client.zzdn");
    }

    public final zzdq zzl() {
        return null;
    }

    public final IObjectWrapper zzn() {
        return null;
    }

    public final synchronized String zzr() {
        return this.zzd;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String zzs() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzdfo r0 = r2.zzj     // Catch:{ all -> 0x0018 }
            if (r0 == 0) goto L_0x0015
            com.google.android.gms.internal.ads.zzcwj r1 = r0.zzm()     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x0015
            com.google.android.gms.internal.ads.zzcwj r0 = r0.zzm()     // Catch:{ all -> 0x0018 }
            java.lang.String r0 = r0.zzg()     // Catch:{ all -> 0x0018 }
            monitor-exit(r2)
            return r0
        L_0x0015:
            monitor-exit(r2)
            r0 = 0
            return r0
        L_0x0018:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzems.zzs():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String zzt() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzdfo r0 = r2.zzj     // Catch:{ all -> 0x0018 }
            if (r0 == 0) goto L_0x0015
            com.google.android.gms.internal.ads.zzcwj r1 = r0.zzm()     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x0015
            com.google.android.gms.internal.ads.zzcwj r0 = r0.zzm()     // Catch:{ all -> 0x0018 }
            java.lang.String r0 = r0.zzg()     // Catch:{ all -> 0x0018 }
            monitor-exit(r2)
            return r0
        L_0x0015:
            monitor-exit(r2)
            r0 = 0
            return r0
        L_0x0018:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzems.zzt():java.lang.String");
    }

    public final synchronized void zzx() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        zzdfo zzdfo = this.zzj;
        if (zzdfo != null) {
            zzdfo.zzn().zza((Context) null);
        }
    }

    public final void zzy(zzl zzl, zzbk zzbk) {
        this.zzf.zzk(zzbk);
        zzab(zzl);
    }

    public final synchronized void zzz() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        zzdfo zzdfo = this.zzj;
        if (zzdfo != null) {
            zzdfo.zzn().zzb((Context) null);
        }
    }

    public final void zzA() {
    }

    public final void zzC(zzbe zzbe) {
    }

    public final void zzF(zzq zzq) {
    }

    public final void zzH(zzazs zzazs) {
    }

    public final void zzI(zzw zzw) {
    }

    public final void zzK(zzdu zzdu) {
    }

    public final void zzM(zzbsw zzbsw) {
    }

    public final void zzN(boolean z) {
    }

    public final void zzR(String str) {
    }

    public final void zzT(String str) {
    }

    public final void zzU(zzfk zzfk) {
    }

    public final void zzac(zzcf zzcf) {
    }

    public final void zzQ(zzbsz zzbsz, String str) {
    }
}
