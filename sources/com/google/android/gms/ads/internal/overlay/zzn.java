package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzdeq;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzn {
    public static final void zza(Context context, AdOverlayInfoParcel adOverlayInfoParcel, boolean z) {
        zzy zzy;
        if (adOverlayInfoParcel.zzk == 4 && adOverlayInfoParcel.zzc == null) {
            zza zza = adOverlayInfoParcel.zzb;
            if (zza != null) {
                zza.onAdClicked();
            }
            zzdeq zzdeq = adOverlayInfoParcel.zzu;
            if (zzdeq != null) {
                zzdeq.zzdG();
            }
            Activity zzi = adOverlayInfoParcel.zzd.zzi();
            zzc zzc = adOverlayInfoParcel.zza;
            if (!(zzc == null || !zzc.zzj || zzi == null)) {
                context = zzi;
            }
            zzu.zzh();
            zzc zzc2 = adOverlayInfoParcel.zza;
            zzaa zzaa = adOverlayInfoParcel.zzi;
            if (zzc2 != null) {
                zzy = zzc2.zzi;
            } else {
                zzy = null;
            }
            zza.zzb(context, zzc2, zzaa, zzy);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", adOverlayInfoParcel.zzm.isClientJar);
        intent.putExtra("shouldCallOnOverlayOpened", z);
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", adOverlayInfoParcel);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
        if (!PlatformVersion.isAtLeastLollipop()) {
            intent.addFlags(524288);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        zzu.zzp();
        zzt.zzT(context, intent);
    }
}
