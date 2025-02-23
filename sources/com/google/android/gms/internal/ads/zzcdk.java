package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzcdk implements zzfs {
    private final zzfs zza;
    private final long zzb;
    private final zzfs zzc;
    private long zzd;
    private Uri zze;

    public zzcdk(zzfs zzfs, int i, zzfs zzfs2) {
        this.zza = zzfs;
        this.zzb = (long) i;
        this.zzc = zzfs2;
    }

    public final int zza(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        long j = this.zzd;
        long j2 = this.zzb;
        if (j < j2) {
            int zza2 = this.zza.zza(bArr, i, (int) Math.min((long) i2, j2 - j));
            long j3 = this.zzd + ((long) zza2);
            this.zzd = j3;
            i3 = zza2;
            j = j3;
        } else {
            i3 = 0;
        }
        if (j < this.zzb) {
            return i3;
        }
        int zza3 = this.zzc.zza(bArr, i + i3, i2 - i3);
        int i4 = i3 + zza3;
        this.zzd += (long) zza3;
        return i4;
    }

    public final long zzb(zzfy zzfy) throws IOException {
        zzfy zzfy2;
        long j;
        long j2;
        zzfy zzfy3 = zzfy;
        this.zze = zzfy3.zza;
        long j3 = zzfy3.zze;
        long j4 = this.zzb;
        zzfy zzfy4 = null;
        if (j3 >= j4) {
            zzfy2 = null;
        } else {
            long j5 = zzfy3.zzf;
            long j6 = j4 - j3;
            if (j5 != -1) {
                j6 = Math.min(j5, j6);
            }
            zzfy2 = new zzfy(zzfy3.zza, j3, j6, (String) null);
        }
        long j7 = zzfy3.zzf;
        if (j7 == -1 || zzfy3.zze + j7 > this.zzb) {
            long max = Math.max(this.zzb, zzfy3.zze);
            long j8 = zzfy3.zzf;
            if (j8 != -1) {
                j2 = Math.min(j8, (zzfy3.zze + j8) - this.zzb);
            } else {
                j2 = -1;
            }
            zzfy4 = new zzfy(zzfy3.zza, max, j2, (String) null);
        }
        long j9 = 0;
        if (zzfy2 != null) {
            j = this.zza.zzb(zzfy2);
        } else {
            j = 0;
        }
        if (zzfy4 != null) {
            j9 = this.zzc.zzb(zzfy4);
        }
        this.zzd = zzfy3.zze;
        if (j == -1 || j9 == -1) {
            return -1;
        }
        return j + j9;
    }

    public final Uri zzc() {
        return this.zze;
    }

    public final void zzd() throws IOException {
        this.zza.zzd();
        this.zzc.zzd();
    }

    public final Map zze() {
        return zzfxu.zzd();
    }

    public final void zzf(zzgu zzgu) {
    }
}
