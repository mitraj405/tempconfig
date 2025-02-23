package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzecv extends zzecz {
    private final String zza;
    private final String zzb;
    private final Drawable zzc;

    public zzecv(String str, String str2, Drawable drawable) {
        if (str != null) {
            this.zza = str;
            if (str2 != null) {
                this.zzb = str2;
                this.zzc = drawable;
                return;
            }
            throw new NullPointerException("Null imageUrl");
        }
        throw new NullPointerException("Null advertiserName");
    }

    public final boolean equals(Object obj) {
        Drawable drawable;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzecz) {
            zzecz zzecz = (zzecz) obj;
            if (!this.zza.equals(zzecz.zzb()) || !this.zzb.equals(zzecz.zzc()) || ((drawable = this.zzc) != null ? !drawable.equals(zzecz.zza()) : zzecz.zza() != null)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int hashCode = ((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode();
        Drawable drawable = this.zzc;
        if (drawable == null) {
            i = 0;
        } else {
            i = drawable.hashCode();
        }
        return (hashCode * 1000003) ^ i;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzc);
        return "OfflineAdAssets{advertiserName=" + this.zza + ", imageUrl=" + this.zzb + ", icon=" + valueOf + "}";
    }

    public final Drawable zza() {
        return this.zzc;
    }

    public final String zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzb;
    }
}
