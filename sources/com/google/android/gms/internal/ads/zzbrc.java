package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzbrc implements zzp {
    final /* synthetic */ zzbre zza;

    public zzbrc(zzbre zzbre) {
        this.zza = zzbre;
    }

    public final void zzdH() {
        zzm.zze("AdMobCustomTabsAdapter overlay is resumed.");
    }

    public final void zzdk() {
        zzm.zze("AdMobCustomTabsAdapter overlay is paused.");
    }

    public final void zzdq() {
        zzm.zze("Delay close AdMobCustomTabsAdapter overlay.");
    }

    public final void zzdr() {
        zzm.zze("Opening AdMobCustomTabsAdapter overlay.");
        zzbre zzbre = this.zza;
        zzbre.zzb.onAdOpened(zzbre);
    }

    public final void zzdu(int i) {
        zzm.zze("AdMobCustomTabsAdapter overlay is closed.");
        zzbre zzbre = this.zza;
        zzbre.zzb.onAdClosed(zzbre);
    }

    public final void zzdt() {
    }
}
