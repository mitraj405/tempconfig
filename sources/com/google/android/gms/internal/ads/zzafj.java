package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzafj implements zzbj {
    public static final Parcelable.Creator<zzafj> CREATOR = new zzafi();
    public final int zza;
    public final String zzb;
    public final String zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final byte[] zzh;

    public zzafj(int i, String str, String str2, int i2, int i3, int i4, int i5, byte[] bArr) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = i2;
        this.zze = i3;
        this.zzf = i4;
        this.zzg = i5;
        this.zzh = bArr;
    }

    public static zzafj zzb(zzek zzek) {
        int zzg2 = zzek.zzg();
        String zze2 = zzbn.zze(zzek.zzA(zzek.zzg(), zzfuj.zza));
        String zzA = zzek.zzA(zzek.zzg(), zzfuj.zzc);
        int zzg3 = zzek.zzg();
        int zzg4 = zzek.zzg();
        int zzg5 = zzek.zzg();
        int zzg6 = zzek.zzg();
        int zzg7 = zzek.zzg();
        byte[] bArr = new byte[zzg7];
        zzek.zzG(bArr, 0, zzg7);
        return new zzafj(zzg2, zze2, zzA, zzg3, zzg4, zzg5, zzg6, bArr);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzafj.class == obj.getClass()) {
            zzafj zzafj = (zzafj) obj;
            if (this.zza == zzafj.zza && this.zzb.equals(zzafj.zzb) && this.zzc.equals(zzafj.zzc) && this.zzd == zzafj.zzd && this.zze == zzafj.zze && this.zzf == zzafj.zzf && this.zzg == zzafj.zzg && Arrays.equals(this.zzh, zzafj.zzh)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.zzb.hashCode() + ((this.zza + 527) * 31);
        int hashCode2 = this.zzc.hashCode() + (hashCode * 31);
        return Arrays.hashCode(this.zzh) + (((((((((hashCode2 * 31) + this.zzd) * 31) + this.zze) * 31) + this.zzf) * 31) + this.zzg) * 31);
    }

    public final String toString() {
        return "Picture: mimeType=" + this.zzb + ", description=" + this.zzc;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeString(this.zzc);
        parcel.writeInt(this.zzd);
        parcel.writeInt(this.zze);
        parcel.writeInt(this.zzf);
        parcel.writeInt(this.zzg);
        parcel.writeByteArray(this.zzh);
    }

    public final void zza(zzbf zzbf) {
        zzbf.zza(this.zzh, this.zza);
    }

    public zzafj(Parcel parcel) {
        this.zza = parcel.readInt();
        String readString = parcel.readString();
        int i = zzet.zza;
        this.zzb = readString;
        this.zzc = parcel.readString();
        this.zzd = parcel.readInt();
        this.zze = parcel.readInt();
        this.zzf = parcel.readInt();
        this.zzg = parcel.readInt();
        this.zzh = parcel.createByteArray();
    }
}
