package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzex implements zzbj {
    public static final Parcelable.Creator<zzex> CREATOR = new zzev();
    public final String zza;
    public final byte[] zzb;
    public final int zzc;
    public final int zzd;

    public zzex(String str, byte[] bArr, int i, int i2) {
        this.zza = str;
        this.zzb = bArr;
        this.zzc = i;
        this.zzd = i2;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzex.class == obj.getClass()) {
            zzex zzex = (zzex) obj;
            if (!this.zza.equals(zzex.zza) || !Arrays.equals(this.zzb, zzex.zzb) || this.zzc != zzex.zzc || this.zzd != zzex.zzd) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((((Arrays.hashCode(this.zzb) + ((this.zza.hashCode() + 527) * 31)) * 31) + this.zzc) * 31) + this.zzd;
    }

    public final String toString() {
        String str;
        int i = this.zzd;
        if (i == 1) {
            str = zzet.zzA(this.zzb);
        } else if (i == 23) {
            str = String.valueOf(Float.intBitsToFloat(zzgap.zzd(this.zzb)));
        } else if (i != 67) {
            byte[] bArr = this.zzb;
            int length = bArr.length;
            StringBuilder sb = new StringBuilder(length + length);
            for (int i2 = 0; i2 < bArr.length; i2++) {
                sb.append(Character.forDigit((bArr[i2] >> 4) & 15, 16));
                sb.append(Character.forDigit(bArr[i2] & Ascii.SI, 16));
            }
            str = sb.toString();
        } else {
            str = String.valueOf(zzgap.zzd(this.zzb));
        }
        String str2 = this.zza;
        return "mdta: key=" + str2 + ", value=" + str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zza);
        parcel.writeByteArray(this.zzb);
        parcel.writeInt(this.zzc);
        parcel.writeInt(this.zzd);
    }

    public /* synthetic */ zzex(Parcel parcel, zzew zzew) {
        String readString = parcel.readString();
        int i = zzet.zza;
        this.zza = readString;
        this.zzb = parcel.createByteArray();
        this.zzc = parcel.readInt();
        this.zzd = parcel.readInt();
    }

    public final /* synthetic */ void zza(zzbf zzbf) {
    }
}
