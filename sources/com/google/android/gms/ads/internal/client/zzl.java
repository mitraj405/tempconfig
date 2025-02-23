package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.util.client.zzn;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

@SafeParcelable.Class(creator = "AdRequestParcelCreator")
/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzl> CREATOR = new zzn();
    @SafeParcelable.Field(id = 1)
    public final int zza;
    @SafeParcelable.Field(id = 2)
    @Deprecated
    public final long zzb;
    @SafeParcelable.Field(id = 3)
    public final Bundle zzc;
    @SafeParcelable.Field(id = 4)
    @Deprecated
    public final int zzd;
    @SafeParcelable.Field(id = 5)
    public final List zze;
    @SafeParcelable.Field(id = 6)
    public final boolean zzf;
    @SafeParcelable.Field(id = 7)
    public final int zzg;
    @SafeParcelable.Field(id = 8)
    public final boolean zzh;
    @SafeParcelable.Field(id = 9)
    public final String zzi;
    @SafeParcelable.Field(id = 10)
    public final zzfh zzj;
    @SafeParcelable.Field(id = 11)
    public final Location zzk;
    @SafeParcelable.Field(id = 12)
    public final String zzl;
    @SafeParcelable.Field(id = 13)
    public final Bundle zzm;
    @SafeParcelable.Field(id = 14)
    public final Bundle zzn;
    @SafeParcelable.Field(id = 15)
    public final List zzo;
    @SafeParcelable.Field(id = 16)
    public final String zzp;
    @SafeParcelable.Field(id = 17)
    public final String zzq;
    @SafeParcelable.Field(id = 18)
    @Deprecated
    public final boolean zzr;
    @SafeParcelable.Field(id = 19)
    public final zzc zzs;
    @SafeParcelable.Field(id = 20)
    public final int zzt;
    @SafeParcelable.Field(id = 21)
    public final String zzu;
    @SafeParcelable.Field(id = 22)
    public final List zzv;
    @SafeParcelable.Field(id = 23)
    public final int zzw;
    @SafeParcelable.Field(id = 24)
    public final String zzx;
    @SafeParcelable.Field(id = 25)
    public final int zzy;
    @SafeParcelable.Field(id = 26)
    public final long zzz;

    @SafeParcelable.Constructor
    public zzl(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) long j, @SafeParcelable.Param(id = 3) Bundle bundle, @SafeParcelable.Param(id = 4) int i2, @SafeParcelable.Param(id = 5) List list, @SafeParcelable.Param(id = 6) boolean z, @SafeParcelable.Param(id = 7) int i3, @SafeParcelable.Param(id = 8) boolean z2, @SafeParcelable.Param(id = 9) String str, @SafeParcelable.Param(id = 10) zzfh zzfh, @SafeParcelable.Param(id = 11) Location location, @SafeParcelable.Param(id = 12) String str2, @SafeParcelable.Param(id = 13) Bundle bundle2, @SafeParcelable.Param(id = 14) Bundle bundle3, @SafeParcelable.Param(id = 15) List list2, @SafeParcelable.Param(id = 16) String str3, @SafeParcelable.Param(id = 17) String str4, @SafeParcelable.Param(id = 18) boolean z3, @SafeParcelable.Param(id = 19) zzc zzc2, @SafeParcelable.Param(id = 20) int i4, @SafeParcelable.Param(id = 21) String str5, @SafeParcelable.Param(id = 22) List list3, @SafeParcelable.Param(id = 23) int i5, @SafeParcelable.Param(id = 24) String str6, @SafeParcelable.Param(id = 25) int i6, @SafeParcelable.Param(id = 26) long j2) {
        this.zza = i;
        this.zzb = j;
        this.zzc = bundle == null ? new Bundle() : bundle;
        this.zzd = i2;
        this.zze = list;
        this.zzf = z;
        this.zzg = i3;
        this.zzh = z2;
        this.zzi = str;
        this.zzj = zzfh;
        this.zzk = location;
        this.zzl = str2;
        this.zzm = bundle2 == null ? new Bundle() : bundle2;
        this.zzn = bundle3;
        this.zzo = list2;
        this.zzp = str3;
        this.zzq = str4;
        this.zzr = z3;
        this.zzs = zzc2;
        this.zzt = i4;
        this.zzu = str5;
        this.zzv = list3 == null ? new ArrayList() : list3;
        this.zzw = i5;
        this.zzx = str6;
        this.zzy = i6;
        this.zzz = j2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzl)) {
            return false;
        }
        zzl zzl2 = (zzl) obj;
        if (this.zza != zzl2.zza || this.zzb != zzl2.zzb || !zzn.zza(this.zzc, zzl2.zzc) || this.zzd != zzl2.zzd || !Objects.equal(this.zze, zzl2.zze) || this.zzf != zzl2.zzf || this.zzg != zzl2.zzg || this.zzh != zzl2.zzh || !Objects.equal(this.zzi, zzl2.zzi) || !Objects.equal(this.zzj, zzl2.zzj) || !Objects.equal(this.zzk, zzl2.zzk) || !Objects.equal(this.zzl, zzl2.zzl) || !zzn.zza(this.zzm, zzl2.zzm) || !zzn.zza(this.zzn, zzl2.zzn) || !Objects.equal(this.zzo, zzl2.zzo) || !Objects.equal(this.zzp, zzl2.zzp) || !Objects.equal(this.zzq, zzl2.zzq) || this.zzr != zzl2.zzr || this.zzt != zzl2.zzt || !Objects.equal(this.zzu, zzl2.zzu) || !Objects.equal(this.zzv, zzl2.zzv) || this.zzw != zzl2.zzw || !Objects.equal(this.zzx, zzl2.zzx) || this.zzy != zzl2.zzy || this.zzz != zzl2.zzz) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Long.valueOf(this.zzb), this.zzc, Integer.valueOf(this.zzd), this.zze, Boolean.valueOf(this.zzf), Integer.valueOf(this.zzg), Boolean.valueOf(this.zzh), this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzo, this.zzp, this.zzq, Boolean.valueOf(this.zzr), Integer.valueOf(this.zzt), this.zzu, this.zzv, Integer.valueOf(this.zzw), this.zzx, Integer.valueOf(this.zzy), Long.valueOf(this.zzz));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        SafeParcelWriter.writeLong(parcel, 2, this.zzb);
        SafeParcelWriter.writeBundle(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.writeStringList(parcel, 5, this.zze, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzf);
        SafeParcelWriter.writeInt(parcel, 7, this.zzg);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzh);
        SafeParcelWriter.writeString(parcel, 9, this.zzi, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzj, i, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzk, i, false);
        SafeParcelWriter.writeString(parcel, 12, this.zzl, false);
        SafeParcelWriter.writeBundle(parcel, 13, this.zzm, false);
        SafeParcelWriter.writeBundle(parcel, 14, this.zzn, false);
        SafeParcelWriter.writeStringList(parcel, 15, this.zzo, false);
        SafeParcelWriter.writeString(parcel, 16, this.zzp, false);
        SafeParcelWriter.writeString(parcel, 17, this.zzq, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzr);
        SafeParcelWriter.writeParcelable(parcel, 19, this.zzs, i, false);
        SafeParcelWriter.writeInt(parcel, 20, this.zzt);
        SafeParcelWriter.writeString(parcel, 21, this.zzu, false);
        SafeParcelWriter.writeStringList(parcel, 22, this.zzv, false);
        SafeParcelWriter.writeInt(parcel, 23, this.zzw);
        SafeParcelWriter.writeString(parcel, 24, this.zzx, false);
        SafeParcelWriter.writeInt(parcel, 25, this.zzy);
        SafeParcelWriter.writeLong(parcel, 26, this.zzz);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
