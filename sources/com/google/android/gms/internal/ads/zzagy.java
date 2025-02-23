package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzagy implements zzbj {
    public static final Parcelable.Creator<zzagy> CREATOR = new zzagw();
    public final float zza;
    public final int zzb;

    public zzagy(float f, int i) {
        this.zza = f;
        this.zzb = i;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzagy.class == obj.getClass()) {
            zzagy zzagy = (zzagy) obj;
            if (this.zza == zzagy.zza && this.zzb == zzagy.zzb) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return ((Float.valueOf(this.zza).hashCode() + 527) * 31) + this.zzb;
    }

    public final String toString() {
        return "smta: captureFrameRate=" + this.zza + ", svcTemporalLayerCount=" + this.zzb;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.zza);
        parcel.writeInt(this.zzb);
    }

    public /* synthetic */ zzagy(Parcel parcel, zzagx zzagx) {
        this.zza = parcel.readFloat();
        this.zzb = parcel.readInt();
    }

    public final /* synthetic */ void zza(zzbf zzbf) {
    }
}
