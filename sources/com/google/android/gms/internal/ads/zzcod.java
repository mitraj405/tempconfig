package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzcod implements Runnable {
    public final /* synthetic */ zzcej zza;
    public final /* synthetic */ JSONObject zzb;

    public /* synthetic */ zzcod(zzcej zzcej, JSONObject jSONObject) {
        this.zza = zzcej;
        this.zzb = jSONObject;
    }

    public final void run() {
        this.zza.zzl("AFMA_updateActiveView", this.zzb);
    }
}
