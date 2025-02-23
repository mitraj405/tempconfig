package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@SafeParcelable.Class(creator = "AppMetadataCreator")
@SafeParcelable.Reserved({1, 17, 20, 33})
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzo> CREATOR = new zzn();
    @SafeParcelable.Field(id = 2)
    public final String zza;
    @SafeParcelable.Field(id = 32)
    public final int zzaa;
    @SafeParcelable.Field(id = 34)
    public final long zzab;
    @SafeParcelable.Field(id = 35)
    public final String zzac;
    @SafeParcelable.Field(defaultValue = "", id = 36)
    public final String zzad;
    @SafeParcelable.Field(id = 13)
    @Deprecated
    private final long zzae;
    @SafeParcelable.Field(id = 24)
    private final String zzaf;
    @SafeParcelable.Field(id = 3)
    public final String zzb;
    @SafeParcelable.Field(id = 4)
    public final String zzc;
    @SafeParcelable.Field(id = 5)
    public final String zzd;
    @SafeParcelable.Field(id = 6)
    public final long zze;
    @SafeParcelable.Field(id = 7)
    public final long zzf;
    @SafeParcelable.Field(id = 8)
    public final String zzg;
    @SafeParcelable.Field(defaultValue = "true", id = 9)
    public final boolean zzh;
    @SafeParcelable.Field(id = 10)
    public final boolean zzi;
    @SafeParcelable.Field(defaultValueUnchecked = "Integer.MIN_VALUE", id = 11)
    public final long zzj;
    @SafeParcelable.Field(id = 12)
    public final String zzk;
    @SafeParcelable.Field(id = 14)
    public final long zzl;
    @SafeParcelable.Field(id = 15)
    public final int zzm;
    @SafeParcelable.Field(defaultValue = "true", id = 16)
    public final boolean zzn;
    @SafeParcelable.Field(id = 18)
    public final boolean zzo;
    @SafeParcelable.Field(id = 19)
    public final String zzp;
    @SafeParcelable.Field(id = 21)
    public final Boolean zzq;
    @SafeParcelable.Field(id = 22)
    public final long zzr;
    @SafeParcelable.Field(id = 23)
    public final List<String> zzs;
    @SafeParcelable.Field(defaultValue = "", id = 25)
    public final String zzt;
    @SafeParcelable.Field(defaultValue = "", id = 26)
    public final String zzu;
    @SafeParcelable.Field(id = 27)
    public final String zzv;
    @SafeParcelable.Field(defaultValue = "false", id = 28)
    public final boolean zzw;
    @SafeParcelable.Field(id = 29)
    public final long zzx;
    @SafeParcelable.Field(defaultValue = "100", id = 30)
    public final int zzy;
    @SafeParcelable.Field(defaultValue = "", id = 31)
    public final String zzz;

    public zzo(String str, String str2, String str3, long j, String str4, long j2, long j3, String str5, boolean z, boolean z2, String str6, long j4, long j5, int i, boolean z3, boolean z4, String str7, Boolean bool, long j6, List<String> list, String str8, String str9, String str10, String str11, boolean z5, long j7, int i2, String str12, int i3, long j8, String str13, String str14) {
        Preconditions.checkNotEmpty(str);
        this.zza = str;
        this.zzb = TextUtils.isEmpty(str2) ? null : str2;
        this.zzc = str3;
        this.zzj = j;
        this.zzd = str4;
        this.zze = j2;
        this.zzf = j3;
        this.zzg = str5;
        this.zzh = z;
        this.zzi = z2;
        this.zzk = str6;
        this.zzae = j4;
        this.zzl = j5;
        this.zzm = i;
        this.zzn = z3;
        this.zzo = z4;
        this.zzp = str7;
        this.zzq = bool;
        this.zzr = j6;
        this.zzs = list;
        this.zzaf = null;
        this.zzt = str9;
        this.zzu = str10;
        this.zzv = str11;
        this.zzw = z5;
        this.zzx = j7;
        this.zzy = i2;
        this.zzz = str12;
        this.zzaa = i3;
        this.zzab = j8;
        this.zzac = str13;
        this.zzad = str14;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzd, false);
        SafeParcelWriter.writeLong(parcel, 6, this.zze);
        SafeParcelWriter.writeLong(parcel, 7, this.zzf);
        SafeParcelWriter.writeString(parcel, 8, this.zzg, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzh);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzi);
        SafeParcelWriter.writeLong(parcel, 11, this.zzj);
        SafeParcelWriter.writeString(parcel, 12, this.zzk, false);
        SafeParcelWriter.writeLong(parcel, 13, this.zzae);
        SafeParcelWriter.writeLong(parcel, 14, this.zzl);
        SafeParcelWriter.writeInt(parcel, 15, this.zzm);
        SafeParcelWriter.writeBoolean(parcel, 16, this.zzn);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzo);
        SafeParcelWriter.writeString(parcel, 19, this.zzp, false);
        SafeParcelWriter.writeBooleanObject(parcel, 21, this.zzq, false);
        SafeParcelWriter.writeLong(parcel, 22, this.zzr);
        SafeParcelWriter.writeStringList(parcel, 23, this.zzs, false);
        SafeParcelWriter.writeString(parcel, 24, this.zzaf, false);
        SafeParcelWriter.writeString(parcel, 25, this.zzt, false);
        SafeParcelWriter.writeString(parcel, 26, this.zzu, false);
        SafeParcelWriter.writeString(parcel, 27, this.zzv, false);
        SafeParcelWriter.writeBoolean(parcel, 28, this.zzw);
        SafeParcelWriter.writeLong(parcel, 29, this.zzx);
        SafeParcelWriter.writeInt(parcel, 30, this.zzy);
        SafeParcelWriter.writeString(parcel, 31, this.zzz, false);
        SafeParcelWriter.writeInt(parcel, 32, this.zzaa);
        SafeParcelWriter.writeLong(parcel, 34, this.zzab);
        SafeParcelWriter.writeString(parcel, 35, this.zzac, false);
        SafeParcelWriter.writeString(parcel, 36, this.zzad, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzo(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) String str3, @SafeParcelable.Param(id = 5) String str4, @SafeParcelable.Param(id = 6) long j, @SafeParcelable.Param(id = 7) long j2, @SafeParcelable.Param(id = 8) String str5, @SafeParcelable.Param(id = 9) boolean z, @SafeParcelable.Param(id = 10) boolean z2, @SafeParcelable.Param(id = 11) long j3, @SafeParcelable.Param(id = 12) String str6, @SafeParcelable.Param(id = 13) long j4, @SafeParcelable.Param(id = 14) long j5, @SafeParcelable.Param(id = 15) int i, @SafeParcelable.Param(id = 16) boolean z3, @SafeParcelable.Param(id = 18) boolean z4, @SafeParcelable.Param(id = 19) String str7, @SafeParcelable.Param(id = 21) Boolean bool, @SafeParcelable.Param(id = 22) long j6, @SafeParcelable.Param(id = 23) List<String> list, @SafeParcelable.Param(id = 24) String str8, @SafeParcelable.Param(id = 25) String str9, @SafeParcelable.Param(id = 26) String str10, @SafeParcelable.Param(id = 27) String str11, @SafeParcelable.Param(id = 28) boolean z5, @SafeParcelable.Param(id = 29) long j7, @SafeParcelable.Param(id = 30) int i2, @SafeParcelable.Param(id = 31) String str12, @SafeParcelable.Param(id = 32) int i3, @SafeParcelable.Param(id = 34) long j8, @SafeParcelable.Param(id = 35) String str13, @SafeParcelable.Param(id = 36) String str14) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzj = j3;
        this.zzd = str4;
        this.zze = j;
        this.zzf = j2;
        this.zzg = str5;
        this.zzh = z;
        this.zzi = z2;
        this.zzk = str6;
        this.zzae = j4;
        this.zzl = j5;
        this.zzm = i;
        this.zzn = z3;
        this.zzo = z4;
        this.zzp = str7;
        this.zzq = bool;
        this.zzr = j6;
        this.zzs = list;
        this.zzaf = str8;
        this.zzt = str9;
        this.zzu = str10;
        this.zzv = str11;
        this.zzw = z5;
        this.zzx = j7;
        this.zzy = i2;
        this.zzz = str12;
        this.zzaa = i3;
        this.zzab = j8;
        this.zzac = str13;
        this.zzad = str14;
    }
}
