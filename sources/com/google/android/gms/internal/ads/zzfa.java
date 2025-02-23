package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfa implements zzbj {
    public static final Parcelable.Creator<zzfa> CREATOR = new zzey();
    public final float zza;
    public final float zzb;

    public zzfa(float f, float f2) {
        boolean z = false;
        if (f >= -90.0f && f <= 90.0f && f2 >= -180.0f && f2 <= 180.0f) {
            z = true;
        }
        zzdi.zze(z, "Invalid latitude or longitude");
        this.zza = f;
        this.zzb = f2;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzfa.class == obj.getClass()) {
            zzfa zzfa = (zzfa) obj;
            if (this.zza == zzfa.zza && this.zzb == zzfa.zzb) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return ((Float.valueOf(this.zza).hashCode() + 527) * 31) + Float.valueOf(this.zzb).hashCode();
    }

    public final String toString() {
        return "xyz: latitude=" + this.zza + ", longitude=" + this.zzb;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.zza);
        parcel.writeFloat(this.zzb);
    }

    public /* synthetic */ zzfa(Parcel parcel, zzez zzez) {
        this.zza = parcel.readFloat();
        this.zzb = parcel.readFloat();
    }

    public final /* synthetic */ void zza(zzbf zzbf) {
    }
}
