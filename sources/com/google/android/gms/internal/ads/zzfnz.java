package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.HashSet;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfnz extends zzfnu {
    public zzfnz(zzfnn zzfnn, HashSet hashSet, JSONObject jSONObject, long j) {
        super(zzfnn, hashSet, jSONObject, j);
    }

    public final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        if (zzfnf.zzg(this.zzb, this.zzd.zza())) {
            return null;
        }
        this.zzd.zze(this.zzb);
        return this.zzb.toString();
    }

    /* renamed from: zza */
    public final void onPostExecute(String str) {
        zzfml zza;
        if (!TextUtils.isEmpty(str) && (zza = zzfml.zza()) != null) {
            for (zzflu zzflu : zza.zzc()) {
                if (this.zza.contains(zzflu.zzh())) {
                    zzflu.zzg().zzh(str, this.zzc);
                }
            }
        }
        super.onPostExecute(str);
    }
}
