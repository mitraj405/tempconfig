package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzafg implements zzbj {
    public static final Parcelable.Creator<zzafg> CREATOR = new zzaff();
    public final String zza;
    public final String zzb;
    public final long zzc;
    public final long zzd;
    public final byte[] zze;
    private int zzf;

    static {
        zzad zzad = new zzad();
        zzad.zzX("application/id3");
        zzad.zzad();
        zzad zzad2 = new zzad();
        zzad2.zzX("application/x-scte35");
        zzad2.zzad();
    }

    public zzafg(String str, String str2, long j, long j2, byte[] bArr) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = j;
        this.zzd = j2;
        this.zze = bArr;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzafg.class == obj.getClass()) {
            zzafg zzafg = (zzafg) obj;
            if (this.zzc != zzafg.zzc || this.zzd != zzafg.zzd || !zzet.zzG(this.zza, zzafg.zza) || !zzet.zzG(this.zzb, zzafg.zzb) || !Arrays.equals(this.zze, zzafg.zze)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int i2 = this.zzf;
        if (i2 != 0) {
            return i2;
        }
        String str = this.zza;
        int i3 = 0;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        String str2 = this.zzb;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        long j = this.zzc;
        long j2 = this.zzd;
        int hashCode = ((((((((i + 527) * 31) + i3) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + Arrays.hashCode(this.zze);
        this.zzf = hashCode;
        return hashCode;
    }

    public final String toString() {
        return "EMSG: scheme=" + this.zza + ", id=" + this.zzd + ", durationMs=" + this.zzc + ", value=" + this.zzb;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeLong(this.zzc);
        parcel.writeLong(this.zzd);
        parcel.writeByteArray(this.zze);
    }

    public zzafg(Parcel parcel) {
        String readString = parcel.readString();
        int i = zzet.zza;
        this.zza = readString;
        this.zzb = parcel.readString();
        this.zzc = parcel.readLong();
        this.zzd = parcel.readLong();
        this.zze = parcel.createByteArray();
    }

    public final /* synthetic */ void zza(zzbf zzbf) {
    }
}
