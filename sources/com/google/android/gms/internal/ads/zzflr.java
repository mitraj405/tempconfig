package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzflr {
    private final zzfmc zza;
    private final zzfmc zzb;
    private final boolean zzc;
    private final zzflv zzd;
    private final zzfly zze;

    private zzflr(zzflv zzflv, zzfly zzfly, zzfmc zzfmc, zzfmc zzfmc2, boolean z) {
        this.zzd = zzflv;
        this.zze = zzfly;
        this.zza = zzfmc;
        if (zzfmc2 == null) {
            this.zzb = zzfmc.NONE;
        } else {
            this.zzb = zzfmc2;
        }
        this.zzc = z;
    }

    public static zzflr zza(zzflv zzflv, zzfly zzfly, zzfmc zzfmc, zzfmc zzfmc2, boolean z) {
        zzfnj.zzc(zzflv, "CreativeType is null");
        zzfnj.zzc(zzfly, "ImpressionType is null");
        zzfnj.zzc(zzfmc, "Impression owner is null");
        if (zzfmc == zzfmc.NONE) {
            throw new IllegalArgumentException("Impression owner is none");
        } else if (zzflv == zzflv.DEFINED_BY_JAVASCRIPT && zzfmc == zzfmc.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        } else if (zzfly != zzfly.DEFINED_BY_JAVASCRIPT || zzfmc != zzfmc.NATIVE) {
            return new zzflr(zzflv, zzfly, zzfmc, zzfmc2, z);
        } else {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        }
    }

    public final JSONObject zzb() {
        JSONObject jSONObject = new JSONObject();
        zzfnf.zze(jSONObject, "impressionOwner", this.zza);
        zzfnf.zze(jSONObject, "mediaEventsOwner", this.zzb);
        zzfnf.zze(jSONObject, "creativeType", this.zzd);
        zzfnf.zze(jSONObject, "impressionType", this.zze);
        zzfnf.zze(jSONObject, "isolateVerificationScripts", Boolean.valueOf(this.zzc));
        return jSONObject;
    }
}
