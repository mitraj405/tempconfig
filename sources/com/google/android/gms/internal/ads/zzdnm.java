package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdnm implements zzbix {
    private final zzbgh zza;
    private final zzdoa zzb;
    private final zzhew zzc;

    public zzdnm(zzdjm zzdjm, zzdjb zzdjb, zzdoa zzdoa, zzhew zzhew) {
        this.zza = zzdjm.zzc(zzdjb.zzA());
        this.zzb = zzdoa;
        this.zzc = zzhew;
    }

    public final void zza(Object obj, Map map) {
        String str = (String) map.get("asset");
        try {
            this.zza.zze((zzbfx) this.zzc.zzb(), str);
        } catch (RemoteException e) {
            zzm.zzk("Failed to call onCustomClick for asset " + str + ".", e);
        }
    }

    public final void zzb() {
        if (this.zza != null) {
            this.zzb.zzl("/nativeAdCustomClick", this);
        }
    }
}
