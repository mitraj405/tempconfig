package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzx implements Parcelable {
    public static final Parcelable.Creator<zzx> CREATOR = new zzw();
    public final UUID zza;
    public final String zzb;
    public final String zzc;
    public final byte[] zzd;
    private int zze;

    public zzx(Parcel parcel) {
        this.zza = new UUID(parcel.readLong(), parcel.readLong());
        this.zzb = parcel.readString();
        String readString = parcel.readString();
        int i = zzet.zza;
        this.zzc = readString;
        this.zzd = parcel.createByteArray();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzx)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        zzx zzx = (zzx) obj;
        if (!zzet.zzG(this.zzb, zzx.zzb) || !zzet.zzG(this.zzc, zzx.zzc) || !zzet.zzG(this.zza, zzx.zza) || !Arrays.equals(this.zzd, zzx.zzd)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i;
        int i2 = this.zze;
        if (i2 != 0) {
            return i2;
        }
        int hashCode = this.zza.hashCode() * 31;
        String str = this.zzb;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        int g = lf.g(this.zzc, (hashCode + i) * 31, 31) + Arrays.hashCode(this.zzd);
        this.zze = g;
        return g;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.zza.getMostSignificantBits());
        parcel.writeLong(this.zza.getLeastSignificantBits());
        parcel.writeString(this.zzb);
        parcel.writeString(this.zzc);
        parcel.writeByteArray(this.zzd);
    }

    public zzx(UUID uuid, String str, String str2, byte[] bArr) {
        uuid.getClass();
        this.zza = uuid;
        this.zzb = null;
        this.zzc = zzbn.zze(str2);
        this.zzd = bArr;
    }
}
