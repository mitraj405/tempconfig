package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzy implements Comparator<zzx>, Parcelable {
    public static final Parcelable.Creator<zzy> CREATOR = new zzv();
    public final String zza;
    public final int zzb;
    private final zzx[] zzc;
    private int zzd;

    public zzy(Parcel parcel) {
        this.zza = parcel.readString();
        zzx[] zzxArr = (zzx[]) parcel.createTypedArray(zzx.CREATOR);
        int i = zzet.zza;
        this.zzc = zzxArr;
        this.zzb = zzxArr.length;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzx zzx = (zzx) obj;
        zzx zzx2 = (zzx) obj2;
        UUID uuid = zzk.zza;
        if (!uuid.equals(zzx.zza)) {
            return zzx.zza.compareTo(zzx2.zza);
        }
        if (!uuid.equals(zzx2.zza)) {
            return 1;
        }
        return 0;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzy.class == obj.getClass()) {
            zzy zzy = (zzy) obj;
            if (!zzet.zzG(this.zza, zzy.zza) || !Arrays.equals(this.zzc, zzy.zzc)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int i2 = this.zzd;
        if (i2 != 0) {
            return i2;
        }
        String str = this.zza;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        int hashCode = (i * 31) + Arrays.hashCode(this.zzc);
        this.zzd = hashCode;
        return hashCode;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zza);
        parcel.writeTypedArray(this.zzc, 0);
    }

    public final zzx zza(int i) {
        return this.zzc[i];
    }

    public final zzy zzb(String str) {
        if (zzet.zzG(this.zza, str)) {
            return this;
        }
        return new zzy(str, false, this.zzc);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.google.android.gms.internal.ads.zzx[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzy(java.lang.String r1, boolean r2, com.google.android.gms.internal.ads.zzx... r3) {
        /*
            r0 = this;
            r0.<init>()
            r0.zza = r1
            if (r2 == 0) goto L_0x000e
            java.lang.Object r1 = r3.clone()
            r3 = r1
            com.google.android.gms.internal.ads.zzx[] r3 = (com.google.android.gms.internal.ads.zzx[]) r3
        L_0x000e:
            r0.zzc = r3
            int r1 = r3.length
            r0.zzb = r1
            java.util.Arrays.sort(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzy.<init>(java.lang.String, boolean, com.google.android.gms.internal.ads.zzx[]):void");
    }

    public zzy(String str, zzx... zzxArr) {
        this((String) null, true, zzxArr);
    }

    public zzy(List list) {
        this((String) null, false, (zzx[]) list.toArray(new zzx[0]));
    }
}
