package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzdnh implements zzber {
    final /* synthetic */ String zza = NativeCustomFormatAd.ASSET_NAME_VIDEO;
    final /* synthetic */ zzdni zzb;

    public zzdnh(zzdni zzdni, String str) {
        this.zzb = zzdni;
    }

    public final JSONObject zza() {
        return null;
    }

    public final JSONObject zzb() {
        return null;
    }

    public final void zzc() {
        zzdni zzdni = this.zzb;
        if (zzdni.zzd != null) {
            zzdni.zzd.zzF(this.zza);
        }
    }

    public final void zzd(MotionEvent motionEvent) {
    }
}
