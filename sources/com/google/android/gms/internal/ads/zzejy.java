package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzejy implements zzeev {
    private final zzelc zza;
    private final zzdqb zzb;

    public zzejy(zzelc zzelc, zzdqb zzdqb) {
        this.zza = zzelc;
        this.zzb = zzdqb;
    }

    public final zzeew zza(String str, JSONObject jSONObject) throws zzffn {
        zzbql zzbql;
        if (((Boolean) zzba.zzc().zza(zzbbw.zzbu)).booleanValue()) {
            try {
                zzbql = this.zzb.zzb(str);
            } catch (RemoteException e) {
                zzm.zzh("Coundn't create RTB adapter: ", e);
                zzbql = null;
            }
        } else {
            zzbql = this.zza.zza(str);
        }
        if (zzbql == null) {
            return null;
        }
        return new zzeew(zzbql, new zzegp(), str);
    }
}
