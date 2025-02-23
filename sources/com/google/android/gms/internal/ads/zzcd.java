package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcd {
    public final int zza;
    public final String zzb;
    public final int zzc;
    private final zzaf[] zzd;
    private int zze;

    static {
        Integer.toString(0, 36);
        Integer.toString(1, 36);
    }

    public zzcd(String str, zzaf... zzafArr) {
        boolean z;
        int length = zzafArr.length;
        int i = 1;
        if (length > 0) {
            z = true;
        } else {
            z = false;
        }
        zzdi.zzd(z);
        this.zzb = str;
        this.zzd = zzafArr;
        this.zza = length;
        int zzb2 = zzbn.zzb(zzafArr[0].zzm);
        this.zzc = zzb2 == -1 ? zzbn.zzb(zzafArr[0].zzl) : zzb2;
        String zzc2 = zzc(zzafArr[0].zzd);
        int i2 = zzafArr[0].zzf | 16384;
        while (true) {
            zzaf[] zzafArr2 = this.zzd;
            if (i >= zzafArr2.length) {
                return;
            }
            if (!zzc2.equals(zzc(zzafArr2[i].zzd))) {
                zzaf[] zzafArr3 = this.zzd;
                zzd("languages", zzafArr3[0].zzd, zzafArr3[i].zzd, i);
                return;
            }
            zzaf[] zzafArr4 = this.zzd;
            if (i2 != (zzafArr4[i].zzf | 16384)) {
                zzd("role flags", Integer.toBinaryString(zzafArr4[0].zzf), Integer.toBinaryString(this.zzd[i].zzf), i);
                return;
            }
            i++;
        }
    }

    private static String zzc(String str) {
        if (str == null || str.equals("und")) {
            return "";
        }
        return str;
    }

    private static void zzd(String str, String str2, String str3, int i) {
        StringBuilder b = C0437ME.b("Different ", str, " combined in one TrackGroup: '", str2, "' (track 0) and '");
        b.append(str3);
        b.append("' (track ");
        b.append(i);
        b.append(")");
        zzea.zzd("TrackGroup", "", new IllegalStateException(b.toString()));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzcd.class == obj.getClass()) {
            zzcd zzcd = (zzcd) obj;
            if (!this.zzb.equals(zzcd.zzb) || !Arrays.equals(this.zzd, zzcd.zzd)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zze;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.zzd) + ((this.zzb.hashCode() + 527) * 31);
        this.zze = hashCode;
        return hashCode;
    }

    public final int zza(zzaf zzaf) {
        int i = 0;
        while (true) {
            zzaf[] zzafArr = this.zzd;
            if (i >= zzafArr.length) {
                return -1;
            }
            if (zzaf == zzafArr[i]) {
                return i;
            }
            i++;
        }
    }

    public final zzaf zzb(int i) {
        return this.zzd[i];
    }
}
