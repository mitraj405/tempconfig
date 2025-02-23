package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.JsonReader;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.internal.ads.zzbvb;
import com.google.android.gms.internal.ads.zzdyq;
import com.google.android.gms.internal.ads.zzgbq;
import com.google.android.gms.internal.ads.zzgcj;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStreamReader;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzav implements zzgbq {
    public final /* synthetic */ zzbvb zza;

    public /* synthetic */ zzav(zzbvb zzbvb) {
        this.zza = zzbvb;
    }

    public final ListenableFuture zza(Object obj) {
        zzdyq zzdyq = (zzdyq) obj;
        zzay zzay = new zzay(new JsonReader(new InputStreamReader(zzdyq.zzb())), zzdyq.zza());
        try {
            zzay.zzb = zzay.zzb().zzi(this.zza.zza).toString();
        } catch (JSONException unused) {
            zzay.zzb = "{}";
        }
        return zzgcj.zzh(zzay);
    }
}
