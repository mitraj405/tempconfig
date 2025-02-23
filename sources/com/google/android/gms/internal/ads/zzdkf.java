package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdkf implements View.OnClickListener {
    String zza;
    Long zzb;
    WeakReference zzc;
    private final zzdoa zzd;
    private final Clock zze;
    private zzbgx zzf;
    private zzbix zzg;

    public zzdkf(zzdoa zzdoa, Clock clock) {
        this.zzd = zzdoa;
        this.zze = clock;
    }

    private final void zzd() {
        View view;
        this.zza = null;
        this.zzb = null;
        WeakReference weakReference = this.zzc;
        if (weakReference != null && (view = (View) weakReference.get()) != null) {
            view.setClickable(false);
            view.setOnClickListener((View.OnClickListener) null);
            this.zzc = null;
        }
    }

    public final void onClick(View view) {
        WeakReference weakReference = this.zzc;
        if (weakReference != null && weakReference.get() == view) {
            if (!(this.zza == null || this.zzb == null)) {
                HashMap hashMap = new HashMap();
                hashMap.put(FacebookMediationAdapter.KEY_ID, this.zza);
                hashMap.put("time_interval", String.valueOf(this.zze.currentTimeMillis() - this.zzb.longValue()));
                hashMap.put("messageType", "onePointFiveClick");
                this.zzd.zzj("sendMessageToNativeJs", hashMap);
            }
            zzd();
        }
    }

    public final zzbgx zza() {
        return this.zzf;
    }

    public final void zzb() {
        if (this.zzf != null && this.zzb != null) {
            zzd();
            try {
                this.zzf.zze();
            } catch (RemoteException e) {
                zzm.zzl("#007 Could not call remote method.", e);
            }
        }
    }

    public final void zzc(zzbgx zzbgx) {
        this.zzf = zzbgx;
        zzbix zzbix = this.zzg;
        if (zzbix != null) {
            this.zzd.zzn("/unconfirmedClick", zzbix);
        }
        zzdke zzdke = new zzdke(this, zzbgx);
        this.zzg = zzdke;
        this.zzd.zzl("/unconfirmedClick", zzdke);
    }
}
