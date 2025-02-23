package com.google.android.gms.internal.ads;

import java.util.HashSet;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public abstract class zzfnu extends zzfnv {
    protected final HashSet zza;
    protected final JSONObject zzb;
    protected final long zzc;

    public zzfnu(zzfnn zzfnn, HashSet hashSet, JSONObject jSONObject, long j) {
        super(zzfnn);
        this.zza = new HashSet(hashSet);
        this.zzb = jSONObject;
        this.zzc = j;
    }
}
