package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzegh implements zzdgx {
    public final /* synthetic */ zzbzt zza;

    public /* synthetic */ zzegh(zzbzt zzbzt) {
        this.zza = zzbzt;
    }

    public final void zza(boolean z, Context context, zzcxd zzcxd) {
        zzbzt zzbzt = this.zza;
        try {
            zzu.zzi();
            zzn.zza(context, (AdOverlayInfoParcel) zzbzt.get(), true);
        } catch (Exception unused) {
        }
    }
}
