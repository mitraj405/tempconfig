package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbsm;
import com.google.android.gms.internal.ads.zzdeq;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzz extends zzbsm {
    private final AdOverlayInfoParcel zza;
    private final Activity zzb;
    private boolean zzc = false;
    private boolean zzd = false;
    private boolean zze = false;

    public zzz(Activity activity, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.zza = adOverlayInfoParcel;
        this.zzb = activity;
    }

    private final synchronized void zzb() {
        if (!this.zzd) {
            zzp zzp = this.zza.zzc;
            if (zzp != null) {
                zzp.zzdu(4);
            }
            this.zzd = true;
        }
    }

    public final boolean zzH() throws RemoteException {
        return false;
    }

    public final void zzl(Bundle bundle) {
        zzp zzp;
        if (((Boolean) zzba.zzc().zza(zzbbw.zzhY)).booleanValue() && !this.zze) {
            this.zzb.requestWindowFeature(1);
        }
        boolean z = false;
        if (bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false)) {
            z = true;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.zza;
        if (adOverlayInfoParcel == null) {
            this.zzb.finish();
        } else if (z) {
            this.zzb.finish();
        } else {
            if (bundle == null) {
                zza zza2 = adOverlayInfoParcel.zzb;
                if (zza2 != null) {
                    zza2.onAdClicked();
                }
                zzdeq zzdeq = this.zza.zzu;
                if (zzdeq != null) {
                    zzdeq.zzdG();
                }
                if (!(this.zzb.getIntent() == null || !this.zzb.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true) || (zzp = this.zza.zzc) == null)) {
                    zzp.zzdr();
                }
            }
            Activity activity = this.zzb;
            AdOverlayInfoParcel adOverlayInfoParcel2 = this.zza;
            zzu.zzh();
            zzc zzc2 = adOverlayInfoParcel2.zza;
            if (!zza.zzb(activity, zzc2, adOverlayInfoParcel2.zzi, zzc2.zzi)) {
                this.zzb.finish();
            }
        }
    }

    public final void zzm() throws RemoteException {
        if (this.zzb.isFinishing()) {
            zzb();
        }
    }

    public final void zzo() throws RemoteException {
        zzp zzp = this.zza.zzc;
        if (zzp != null) {
            zzp.zzdk();
        }
        if (this.zzb.isFinishing()) {
            zzb();
        }
    }

    public final void zzr() throws RemoteException {
        if (this.zzc) {
            this.zzb.finish();
            return;
        }
        this.zzc = true;
        zzp zzp = this.zza.zzc;
        if (zzp != null) {
            zzp.zzdH();
        }
    }

    public final void zzs(Bundle bundle) throws RemoteException {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzc);
    }

    public final void zzu() throws RemoteException {
        if (this.zzb.isFinishing()) {
            zzb();
        }
    }

    public final void zzv() throws RemoteException {
        zzp zzp = this.zza.zzc;
        if (zzp != null) {
            zzp.zzdt();
        }
    }

    public final void zzx() throws RemoteException {
        this.zze = true;
    }

    public final void zzi() throws RemoteException {
    }

    public final void zzq() throws RemoteException {
    }

    public final void zzt() throws RemoteException {
    }

    public final void zzk(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzh(int i, int i2, Intent intent) throws RemoteException {
    }

    public final void zzp(int i, String[] strArr, int[] iArr) {
    }
}
