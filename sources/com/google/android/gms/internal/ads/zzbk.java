package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzbk implements Parcelable {
    public static final Parcelable.Creator<zzbk> CREATOR = new zzbi();
    public final long zza;
    private final zzbj[] zzb;

    public zzbk(long j, zzbj... zzbjArr) {
        this.zza = j;
        this.zzb = zzbjArr;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzbk.class == obj.getClass()) {
            zzbk zzbk = (zzbk) obj;
            if (!Arrays.equals(this.zzb, zzbk.zzb) || this.zza != zzbk.zza) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        long j = this.zza;
        return (Arrays.hashCode(this.zzb) * 31) + ((int) (j ^ (j >>> 32)));
    }

    public final String toString() {
        String str;
        long j = this.zza;
        int i = (j > -9223372036854775807L ? 1 : (j == -9223372036854775807L ? 0 : -1));
        String arrays = Arrays.toString(this.zzb);
        if (i == 0) {
            str = "";
        } else {
            str = C0709Uj.h(", presentationTimeUs=", j);
        }
        return lf.j("entries=", arrays, str);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zzb.length);
        for (zzbj writeParcelable : this.zzb) {
            parcel.writeParcelable(writeParcelable, 0);
        }
        parcel.writeLong(this.zza);
    }

    public final int zza() {
        return this.zzb.length;
    }

    public final zzbj zzb(int i) {
        return this.zzb[i];
    }

    public final zzbk zzc(zzbj... zzbjArr) {
        int length = zzbjArr.length;
        if (length == 0) {
            return this;
        }
        long j = this.zza;
        zzbj[] zzbjArr2 = this.zzb;
        int i = zzet.zza;
        int length2 = zzbjArr2.length;
        Object[] copyOf = Arrays.copyOf(zzbjArr2, length2 + length);
        System.arraycopy(zzbjArr, 0, copyOf, length2, length);
        return new zzbk(j, (zzbj[]) copyOf);
    }

    public final zzbk zzd(zzbk zzbk) {
        if (zzbk == null) {
            return this;
        }
        return zzc(zzbk.zzb);
    }

    public zzbk(Parcel parcel) {
        this.zzb = new zzbj[parcel.readInt()];
        int i = 0;
        while (true) {
            zzbj[] zzbjArr = this.zzb;
            if (i < zzbjArr.length) {
                zzbjArr[i] = (zzbj) parcel.readParcelable(zzbj.class.getClassLoader());
                i++;
            } else {
                this.zza = parcel.readLong();
                return;
            }
        }
    }

    public zzbk(List list) {
        this(-9223372036854775807L, (zzbj[]) list.toArray(new zzbj[0]));
    }
}
