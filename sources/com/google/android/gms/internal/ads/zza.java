package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zza {
    public static final /* synthetic */ int zzi = 0;
    public final long zza;
    public final int zzb;
    @Deprecated
    public final Uri[] zzc;
    public final zzbc[] zzd;
    public final int[] zze;
    public final long[] zzf;
    public final long zzg;
    public final boolean zzh;

    static {
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
        Integer.toString(6, 36);
        Integer.toString(7, 36);
        Integer.toString(8, 36);
    }

    public zza(long j) {
        this(0, -1, -1, new int[0], new zzbc[0], new long[0], 0, false);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zza.class == obj.getClass()) {
            zza zza2 = (zza) obj;
            if (this.zzb != zza2.zzb || !Arrays.equals(this.zzd, zza2.zzd) || !Arrays.equals(this.zze, zza2.zze) || !Arrays.equals(this.zzf, zza2.zzf)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = Arrays.hashCode(this.zzd) + (((this.zzb * 31) - 1) * 961);
        int hashCode2 = Arrays.hashCode(this.zze) + (hashCode * 31);
        return (Arrays.hashCode(this.zzf) + (hashCode2 * 31)) * 961;
    }

    public final int zza(int i) {
        int i2;
        int i3 = i + 1;
        while (true) {
            int[] iArr = this.zze;
            if (i3 >= iArr.length || (i2 = iArr[i3]) == 0 || i2 == 1) {
                return i3;
            }
            i3++;
        }
        return i3;
    }

    public final zza zzb(int i) {
        int[] iArr = this.zze;
        int length = iArr.length;
        int max = Math.max(0, length);
        int[] copyOf = Arrays.copyOf(iArr, max);
        Arrays.fill(copyOf, length, max, 0);
        long[] jArr = this.zzf;
        int length2 = jArr.length;
        int max2 = Math.max(0, length2);
        long[] copyOf2 = Arrays.copyOf(jArr, max2);
        Arrays.fill(copyOf2, length2, max2, -9223372036854775807L);
        return new zza(0, 0, -1, copyOf, (zzbc[]) Arrays.copyOf(this.zzd, 0), copyOf2, 0, false);
    }

    private zza(long j, int i, int i2, int[] iArr, zzbc[] zzbcArr, long[] jArr, long j2, boolean z) {
        Uri uri;
        int length = iArr.length;
        int length2 = zzbcArr.length;
        int i3 = 0;
        zzdi.zzd(length == length2);
        this.zza = 0;
        this.zzb = i;
        this.zze = iArr;
        this.zzd = zzbcArr;
        this.zzf = jArr;
        this.zzg = 0;
        this.zzh = false;
        this.zzc = new Uri[length2];
        while (true) {
            Uri[] uriArr = this.zzc;
            if (i3 < uriArr.length) {
                zzbc zzbc = zzbcArr[i3];
                if (zzbc == null) {
                    uri = null;
                } else {
                    zzax zzax = zzbc.zzb;
                    zzax.getClass();
                    uri = zzax.zza;
                }
                uriArr[i3] = uri;
                i3++;
            } else {
                return;
            }
        }
    }
}
