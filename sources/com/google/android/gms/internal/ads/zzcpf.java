package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzbu;
import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.client.zzdn;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcpf extends zzazo {
    private final zzcpe zza;
    private final zzbu zzb;
    private final zzfaj zzc;
    private boolean zzd = ((Boolean) zzba.zzc().zza(zzbbw.zzay)).booleanValue();
    private final zzdsk zze;

    public zzcpf(zzcpe zzcpe, zzbu zzbu, zzfaj zzfaj, zzdsk zzdsk) {
        this.zza = zzcpe;
        this.zzb = zzbu;
        this.zzc = zzfaj;
        this.zze = zzdsk;
    }

    public final zzbu zze() {
        return this.zzb;
    }

    public final zzdn zzf() {
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzgc)).booleanValue()) {
            return null;
        }
        return this.zza.zzm();
    }

    public final void zzg(boolean z) {
        this.zzd = z;
    }

    public final void zzh(zzdg zzdg) {
        Preconditions.checkMainThread("setOnPaidEventListener must be called on the main UI thread.");
        if (this.zzc != null) {
            try {
                if (!zzdg.zzf()) {
                    this.zze.zze();
                }
            } catch (RemoteException e) {
                zzm.zzf("Error in making CSI ping for reporting paid event callback", e);
            }
            this.zzc.zzn(zzdg);
        }
    }

    public final void zzi(IObjectWrapper iObjectWrapper, zzazw zzazw) {
        try {
            this.zzc.zzp(zzazw);
            this.zza.zzd((Activity) ObjectWrapper.unwrap(iObjectWrapper), zzazw, this.zzd);
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }
}
