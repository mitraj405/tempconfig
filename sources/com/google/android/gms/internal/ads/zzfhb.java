package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "PoolConfigurationCreator")
/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfhb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfhb> CREATOR = new zzfhc();
    public final Context zza;
    public final zzfgy zzb;
    @SafeParcelable.Field(id = 2)
    public final int zzc;
    @SafeParcelable.Field(id = 3)
    public final int zzd;
    @SafeParcelable.Field(id = 4)
    public final int zze;
    @SafeParcelable.Field(id = 5)
    public final String zzf;
    public final int zzg;
    private final zzfgy[] zzh;
    @SafeParcelable.Field(getter = "getFormatInt", id = 1)
    private final int zzi;
    @SafeParcelable.Field(getter = "getPoolDiscardStrategyInt", id = 6)
    private final int zzj;
    @SafeParcelable.Field(getter = "getPrecacheStartTriggerInt", id = 7)
    private final int zzk;
    private final int[] zzl;
    private final int[] zzm;

    @SafeParcelable.Constructor
    public zzfhb(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) int i3, @SafeParcelable.Param(id = 4) int i4, @SafeParcelable.Param(id = 5) String str, @SafeParcelable.Param(id = 6) int i5, @SafeParcelable.Param(id = 7) int i6) {
        zzfgy[] values = zzfgy.values();
        this.zzh = values;
        int[] zza2 = zzfgz.zza();
        this.zzl = zza2;
        int[] zza3 = zzfha.zza();
        this.zzm = zza3;
        this.zza = null;
        this.zzi = i;
        this.zzb = values[i];
        this.zzc = i2;
        this.zzd = i3;
        this.zze = i4;
        this.zzf = str;
        this.zzj = i5;
        this.zzg = zza2[i5];
        this.zzk = i6;
        int i7 = zza3[i6];
    }

    public static zzfhb zza(zzfgy zzfgy, Context context) {
        if (zzfgy == zzfgy.Rewarded) {
            return new zzfhb(context, zzfgy, ((Integer) zzba.zzc().zza(zzbbw.zzfI)).intValue(), ((Integer) zzba.zzc().zza(zzbbw.zzfO)).intValue(), ((Integer) zzba.zzc().zza(zzbbw.zzfQ)).intValue(), (String) zzba.zzc().zza(zzbbw.zzfS), (String) zzba.zzc().zza(zzbbw.zzfK), (String) zzba.zzc().zza(zzbbw.zzfM));
        } else if (zzfgy == zzfgy.Interstitial) {
            return new zzfhb(context, zzfgy, ((Integer) zzba.zzc().zza(zzbbw.zzfJ)).intValue(), ((Integer) zzba.zzc().zza(zzbbw.zzfP)).intValue(), ((Integer) zzba.zzc().zza(zzbbw.zzfR)).intValue(), (String) zzba.zzc().zza(zzbbw.zzfT), (String) zzba.zzc().zza(zzbbw.zzfL), (String) zzba.zzc().zza(zzbbw.zzfN));
        } else if (zzfgy != zzfgy.AppOpen) {
            return null;
        } else {
            return new zzfhb(context, zzfgy, ((Integer) zzba.zzc().zza(zzbbw.zzfW)).intValue(), ((Integer) zzba.zzc().zza(zzbbw.zzfY)).intValue(), ((Integer) zzba.zzc().zza(zzbbw.zzfZ)).intValue(), (String) zzba.zzc().zza(zzbbw.zzfU), (String) zzba.zzc().zza(zzbbw.zzfV), (String) zzba.zzc().zza(zzbbw.zzfX));
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zzi;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        SafeParcelWriter.writeInt(parcel, 2, this.zzc);
        SafeParcelWriter.writeInt(parcel, 3, this.zzd);
        SafeParcelWriter.writeInt(parcel, 4, this.zze);
        SafeParcelWriter.writeString(parcel, 5, this.zzf, false);
        SafeParcelWriter.writeInt(parcel, 6, this.zzj);
        SafeParcelWriter.writeInt(parcel, 7, this.zzk);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    private zzfhb(Context context, zzfgy zzfgy, int i, int i2, int i3, String str, String str2, String str3) {
        int i4;
        this.zzh = zzfgy.values();
        this.zzl = zzfgz.zza();
        this.zzm = zzfha.zza();
        this.zza = context;
        this.zzi = zzfgy.ordinal();
        this.zzb = zzfgy;
        this.zzc = i;
        this.zzd = i2;
        this.zze = i3;
        this.zzf = str;
        if ("oldest".equals(str2)) {
            i4 = 1;
        } else if (!"lru".equals(str2) && "lfu".equals(str2)) {
            i4 = 3;
        } else {
            i4 = 2;
        }
        this.zzg = i4;
        this.zzj = i4 - 1;
        "onAdClosed".equals(str3);
        this.zzk = 0;
    }
}
