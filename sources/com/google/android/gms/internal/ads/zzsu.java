package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzsu {
    public final String zza;
    public final boolean zzb;
    public final boolean zzc;

    public zzsu(String str, boolean z, boolean z2) {
        this.zza = str;
        this.zzb = z;
        this.zzc = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == zzsu.class) {
            zzsu zzsu = (zzsu) obj;
            if (TextUtils.equals(this.zza, zzsu.zza) && this.zzb == zzsu.zzb && this.zzc == zzsu.zzc) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int hashCode = this.zza.hashCode() + 31;
        int i2 = 1237;
        if (true != this.zzb) {
            i = 1237;
        } else {
            i = 1231;
        }
        int i3 = ((hashCode * 31) + i) * 31;
        if (true == this.zzc) {
            i2 = 1231;
        }
        return i3 + i2;
    }
}
