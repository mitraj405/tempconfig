package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzdd;
import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.client.zzdn;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfec extends zzbwf {
    private final zzfdy zza;
    private final zzfdo zzb;
    private final String zzc;
    /* access modifiers changed from: private */
    public final zzfey zzd;
    private final Context zze;
    private final VersionInfoParcel zzf;
    private final zzauo zzg;
    private final zzdsk zzh;
    /* access modifiers changed from: private */
    public zzdop zzi;
    private boolean zzj = ((Boolean) zzba.zzc().zza(zzbbw.zzav)).booleanValue();

    public zzfec(String str, zzfdy zzfdy, Context context, zzfdo zzfdo, zzfey zzfey, VersionInfoParcel versionInfoParcel, zzauo zzauo, zzdsk zzdsk) {
        this.zzc = str;
        this.zza = zzfdy;
        this.zzb = zzfdo;
        this.zzd = zzfey;
        this.zze = context;
        this.zzf = versionInfoParcel;
        this.zzg = zzauo;
        this.zzh = zzdsk;
    }

    private final synchronized void zzu(zzl zzl, zzbwn zzbwn, int i) throws RemoteException {
        boolean z = false;
        if (((Boolean) zzbdq.zzk.zze()).booleanValue()) {
            if (((Boolean) zzba.zzc().zza(zzbbw.zzkl)).booleanValue()) {
                z = true;
            }
        }
        if (this.zzf.clientJarVersion < ((Integer) zzba.zzc().zza(zzbbw.zzkm)).intValue() || !z) {
            Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        }
        this.zzb.zzk(zzbwn);
        zzu.zzp();
        if (zzt.zzH(this.zze)) {
            if (zzl.zzs == null) {
                zzm.zzg("Failed to load the ad because app ID is missing.");
                this.zzb.zzdB(zzfgi.zzd(4, (String) null, (zze) null));
                return;
            }
        }
        if (this.zzi == null) {
            zzfdq zzfdq = new zzfdq((String) null);
            this.zza.zzj(i);
            this.zza.zzb(zzl, this.zzc, zzfdq, new zzfeb(this));
        }
    }

    public final Bundle zzb() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzdop zzdop = this.zzi;
        if (zzdop != null) {
            return zzdop.zza();
        }
        return new Bundle();
    }

    public final zzdn zzc() {
        zzdop zzdop;
        if (((Boolean) zzba.zzc().zza(zzbbw.zzgc)).booleanValue() && (zzdop = this.zzi) != null) {
            return zzdop.zzm();
        }
        return null;
    }

    public final zzbwd zzd() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzdop zzdop = this.zzi;
        if (zzdop != null) {
            return zzdop.zzc();
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String zze() throws android.os.RemoteException {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzdop r0 = r2.zzi     // Catch:{ all -> 0x0018 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfec.zze():java.lang.String");
    }

    public final synchronized void zzf(zzl zzl, zzbwn zzbwn) throws RemoteException {
        zzu(zzl, zzbwn, 2);
    }

    public final synchronized void zzg(zzl zzl, zzbwn zzbwn) throws RemoteException {
        zzu(zzl, zzbwn, 3);
    }

    public final synchronized void zzh(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zzj = z;
    }

    public final void zzi(zzdd zzdd) {
        if (zzdd == null) {
            this.zzb.zzg((OnAdMetadataChangedListener) null);
        } else {
            this.zzb.zzg(new zzfea(this, zzdd));
        }
    }

    public final void zzj(zzdg zzdg) {
        Preconditions.checkMainThread("setOnPaidEventListener must be called on the main UI thread.");
        try {
            if (!zzdg.zzf()) {
                this.zzh.zze();
            }
        } catch (RemoteException e) {
            zzm.zzf("Error in making CSI ping for reporting paid event callback", e);
        }
        this.zzb.zzi(zzdg);
    }

    public final void zzk(zzbwj zzbwj) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzb.zzj(zzbwj);
    }

    public final synchronized void zzl(zzbwu zzbwu) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzfey zzfey = this.zzd;
        zzfey.zza = zzbwu.zza;
        zzfey.zzb = zzbwu.zzb;
    }

    public final synchronized void zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzn(iObjectWrapper, this.zzj);
    }

    public final synchronized void zzn(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzi == null) {
            zzm.zzj("Rewarded can not be shown before loaded");
            this.zzb.zzq(zzfgi.zzd(9, (String) null, (zze) null));
            return;
        }
        if (((Boolean) zzba.zzc().zza(zzbbw.zzct)).booleanValue()) {
            this.zzg.zzc().zzn(new Throwable().getStackTrace());
        }
        this.zzi.zzh(z, (Activity) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final boolean zzo() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzdop zzdop = this.zzi;
        if (zzdop == null || zzdop.zzf()) {
            return false;
        }
        return true;
    }

    public final void zzp(zzbwo zzbwo) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzb.zzo(zzbwo);
    }
}
