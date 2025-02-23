package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgid extends zzgex {
    private final zzgib zza;
    private final String zzb;
    private final zzgia zzc;
    private final zzgex zzd;

    public /* synthetic */ zzgid(zzgib zzgib, String str, zzgia zzgia, zzgex zzgex, zzgic zzgic) {
        this.zza = zzgib;
        this.zzb = str;
        this.zzc = zzgia;
        this.zzd = zzgex;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgid)) {
            return false;
        }
        zzgid zzgid = (zzgid) obj;
        if (!zzgid.zzc.equals(this.zzc) || !zzgid.zzd.equals(this.zzd) || !zzgid.zzb.equals(this.zzb) || !zzgid.zza.equals(this.zza)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzgid.class, this.zzb, this.zzc, this.zzd, this.zza});
    }

    public final String toString() {
        zzgib zzgib = this.zza;
        zzgex zzgex = this.zzd;
        String valueOf = String.valueOf(this.zzc);
        String valueOf2 = String.valueOf(zzgex);
        String valueOf3 = String.valueOf(zzgib);
        return "LegacyKmsEnvelopeAead Parameters (kekUri: " + this.zzb + ", dekParsingStrategy: " + valueOf + ", dekParametersForNewKeys: " + valueOf2 + ", variant: " + valueOf3 + ")";
    }

    public final boolean zza() {
        if (this.zza != zzgib.zzb) {
            return true;
        }
        return false;
    }

    public final zzgex zzb() {
        return this.zzd;
    }

    public final zzgib zzc() {
        return this.zza;
    }

    public final String zzd() {
        return this.zzb;
    }
}
