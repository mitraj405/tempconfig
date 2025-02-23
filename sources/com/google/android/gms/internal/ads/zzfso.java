package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfso extends zzfsz {
    private final String zza;
    private final String zzb;

    public /* synthetic */ zzfso(String str, String str2, zzfsn zzfsn) {
        this.zza = str;
        this.zzb = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfsz) {
            zzfsz zzfsz = (zzfsz) obj;
            String str = this.zza;
            if (str != null ? str.equals(zzfsz.zzb()) : zzfsz.zzb() == null) {
                String str2 = this.zzb;
                if (str2 != null ? str2.equals(zzfsz.zza()) : zzfsz.zza() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i;
        String str = this.zza;
        int i2 = 0;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        String str2 = this.zzb;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return ((i ^ 1000003) * 1000003) ^ i2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("OverlayDisplayDismissRequest{sessionToken=");
        sb.append(this.zza);
        sb.append(", appId=");
        return C0709Uj.j(sb, this.zzb, "}");
    }

    public final String zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zza;
    }
}
