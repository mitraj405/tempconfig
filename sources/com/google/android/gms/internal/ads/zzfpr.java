package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "GassResponseParcelCreator")
/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfpr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfpr> CREATOR = new zzfps();
    @SafeParcelable.VersionField(id = 1)
    public final int zza;
    @SafeParcelable.Field(getter = "getAfmaSignalsAsBytes", id = 2, type = "byte[]")
    private zzasj zzb = null;
    private byte[] zzc;

    @SafeParcelable.Constructor
    public zzfpr(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) byte[] bArr) {
        this.zza = i;
        this.zzc = bArr;
        zzb();
    }

    private final void zzb() {
        zzasj zzasj = this.zzb;
        if (zzasj == null && this.zzc != null) {
            return;
        }
        if (zzasj != null && this.zzc == null) {
            return;
        }
        if (zzasj != null && this.zzc != null) {
            throw new IllegalStateException("Invalid internal representation - full");
        } else if (zzasj == null && this.zzc == null) {
            throw new IllegalStateException("Invalid internal representation - empty");
        } else {
            throw new IllegalStateException("Impossible");
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i2);
        byte[] bArr = this.zzc;
        if (bArr == null) {
            bArr = this.zzb.zzaV();
        }
        SafeParcelWriter.writeByteArray(parcel, 2, bArr, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzasj zza() {
        if (this.zzb == null) {
            try {
                this.zzb = zzasj.zze(this.zzc, zzgxi.zza());
                this.zzc = null;
            } catch (zzgyn | NullPointerException e) {
                throw new IllegalStateException(e);
            }
        }
        zzb();
        return this.zzb;
    }
}
