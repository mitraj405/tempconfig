package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfd implements zzbj {
    public static final Parcelable.Creator<zzfd> CREATOR = new zzfb();
    public final long zza;
    public final long zzb;
    public final long zzc;

    public zzfd(long j, long j2, long j3) {
        this.zza = j;
        this.zzb = j2;
        this.zzc = j3;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfd)) {
            return false;
        }
        zzfd zzfd = (zzfd) obj;
        if (this.zza == zzfd.zza && this.zzb == zzfd.zzb && this.zzc == zzfd.zzc) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        long j = this.zza;
        long j2 = this.zzc;
        long j3 = this.zzb;
        return ((((((int) (j ^ (j >>> 32))) + 527) * 31) + ((int) ((j3 >>> 32) ^ j3))) * 31) + ((int) (j2 ^ (j2 >>> 32)));
    }

    public final String toString() {
        return "Mp4Timestamp: creation time=" + this.zza + ", modification time=" + this.zzb + ", timescale=" + this.zzc;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.zza);
        parcel.writeLong(this.zzb);
        parcel.writeLong(this.zzc);
    }

    public /* synthetic */ zzfd(Parcel parcel, zzfc zzfc) {
        this.zza = parcel.readLong();
        this.zzb = parcel.readLong();
        this.zzc = parcel.readLong();
    }

    public final /* synthetic */ void zza(zzbf zzbf) {
    }
}
