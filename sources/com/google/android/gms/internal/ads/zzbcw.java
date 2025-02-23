package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzbcw extends QueryInfoGenerationCallback {
    final /* synthetic */ String zza;
    final /* synthetic */ zzbcx zzb;

    public zzbcw(zzbcx zzbcx, String str) {
        this.zza = str;
        this.zzb = zzbcx;
    }

    public final void onFailure(String str) {
        zzm.zzj("Failed to generate query info for Custom Tab error: ".concat(String.valueOf(str)));
        try {
            zzbcx zzbcx = this.zzb;
            zzbcx.zze.a(zzbcx.zzc(this.zza, str).toString());
        } catch (JSONException e) {
            zzm.zzh("Error creating PACT Error Response JSON: ", e);
        }
    }

    public final void onSuccess(QueryInfo queryInfo) {
        String query = queryInfo.getQuery();
        try {
            zzbcx zzbcx = this.zzb;
            zzbcx.zze.a(zzbcx.zzd(this.zza, query).toString());
        } catch (JSONException e) {
            zzm.zzh("Error creating PACT Signal Response JSON: ", e);
        }
    }
}
