package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.formats.OnAdManagerAdViewLoadedListener;
import com.google.android.gms.ads.internal.client.zzbu;
import com.google.android.gms.ads.internal.client.zzg;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzbhk extends zzbgn {
    /* access modifiers changed from: private */
    public final OnAdManagerAdViewLoadedListener zza;

    public zzbhk(OnAdManagerAdViewLoadedListener onAdManagerAdViewLoadedListener) {
        this.zza = onAdManagerAdViewLoadedListener;
    }

    public final void zze(zzbu zzbu, IObjectWrapper iObjectWrapper) {
        AdListener adListener;
        if (zzbu != null && iObjectWrapper != null) {
            AdManagerAdView adManagerAdView = new AdManagerAdView((Context) ObjectWrapper.unwrap(iObjectWrapper));
            AppEventListener appEventListener = null;
            try {
                if (zzbu.zzi() instanceof zzg) {
                    zzg zzg = (zzg) zzbu.zzi();
                    if (zzg != null) {
                        adListener = zzg.zzb();
                    } else {
                        adListener = null;
                    }
                    adManagerAdView.setAdListener(adListener);
                }
            } catch (RemoteException e) {
                zzm.zzh("", e);
            }
            try {
                if (zzbu.zzj() instanceof zzayk) {
                    zzayk zzayk = (zzayk) zzbu.zzj();
                    if (zzayk != null) {
                        appEventListener = zzayk.zzb();
                    }
                    adManagerAdView.setAppEventListener(appEventListener);
                }
            } catch (RemoteException e2) {
                zzm.zzh("", e2);
            }
            zzf.zza.post(new zzbhj(this, adManagerAdView, zzbu));
        }
    }
}
