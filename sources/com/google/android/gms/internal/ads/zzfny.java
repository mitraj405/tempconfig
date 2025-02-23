package com.google.android.gms.internal.ads;

import java.util.HashSet;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfny extends zzfnu {
    public zzfny(zzfnn zzfnn, HashSet hashSet, JSONObject jSONObject, long j) {
        super(zzfnn, hashSet, jSONObject, j);
    }

    private final void zzc(String str) {
        zzfml zza = zzfml.zza();
        if (zza != null) {
            for (zzflu zzflu : zza.zzc()) {
                if (this.zza.contains(zzflu.zzh())) {
                    zzflu.zzg().zzd(str, this.zzc);
                }
            }
        }
    }

    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        return this.zzb.toString();
    }

    public final /* synthetic */ void onPostExecute(Object obj) {
        String str = (String) obj;
        zzc(str);
        super.onPostExecute(str);
    }

    public final void zza(String str) {
        zzc(str);
        super.onPostExecute(str);
    }
}
