package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzcoo implements Runnable {
    public final /* synthetic */ zzcop zza;
    public final /* synthetic */ JSONObject zzb;

    public /* synthetic */ zzcoo(zzcop zzcop, JSONObject jSONObject) {
        this.zza = zzcop;
        this.zzb = jSONObject;
    }

    public final void run() {
        this.zza.zzd(this.zzb);
    }
}
