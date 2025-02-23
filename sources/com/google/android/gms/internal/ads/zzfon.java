package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfon extends zzfoj {
    private final String zza;
    private final boolean zzb;
    private final boolean zzc;

    public /* synthetic */ zzfon(String str, boolean z, boolean z2, zzfom zzfom) {
        this.zza = str;
        this.zzb = z;
        this.zzc = z2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfoj) {
            zzfoj zzfoj = (zzfoj) obj;
            if (this.zza.equals(zzfoj.zzb()) && this.zzb == zzfoj.zzd() && this.zzc == zzfoj.zzc()) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int hashCode = this.zza.hashCode() ^ 1000003;
        int i2 = 1237;
        if (true != this.zzb) {
            i = 1237;
        } else {
            i = 1231;
        }
        int i3 = ((hashCode * 1000003) ^ i) * 1000003;
        if (true == this.zzc) {
            i2 = 1231;
        }
        return i3 ^ i2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AdShield2Options{clientVersion=");
        sb.append(this.zza);
        sb.append(", shouldGetAdvertisingId=");
        sb.append(this.zzb);
        sb.append(", isGooglePlayServicesAvailable=");
        return xx.G(sb, this.zzc, "}");
    }

    public final String zzb() {
        return this.zza;
    }

    public final boolean zzc() {
        return this.zzc;
    }

    public final boolean zzd() {
        return this.zzb;
    }
}
