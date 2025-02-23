package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzamj {
    private final zzadp zza;
    private boolean zzb;
    private boolean zzc;
    private boolean zzd;
    private int zze;
    private int zzf;
    private long zzg;
    private long zzh;

    public zzamj(zzadp zzadp) {
        this.zza = zzadp;
    }

    public final void zza(byte[] bArr, int i, int i2) {
        boolean z;
        if (this.zzc) {
            int i3 = this.zzf;
            int i4 = (i + 1) - i3;
            if (i4 < i2) {
                if (((bArr[i4] & 192) >> 6) == 0) {
                    z = true;
                } else {
                    z = false;
                }
                this.zzd = z;
                this.zzc = false;
                return;
            }
            this.zzf = (i2 - i) + i3;
        }
    }

    public final void zzb(long j, int i, boolean z) {
        boolean z2;
        if (this.zzh != -9223372036854775807L) {
            z2 = true;
        } else {
            z2 = false;
        }
        zzdi.zzf(z2);
        if (this.zze == 182 && z && this.zzb) {
            this.zza.zzs(this.zzh, this.zzd ? 1 : 0, (int) (j - this.zzg), i, (zzado) null);
        }
        if (this.zze != 179) {
            this.zzg = j;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(int r5, long r6) {
        /*
            r4 = this;
            r4.zze = r5
            r0 = 0
            r4.zzd = r0
            r1 = 1
            r2 = 182(0xb6, float:2.55E-43)
            if (r5 == r2) goto L_0x0012
            r3 = 179(0xb3, float:2.51E-43)
            if (r5 != r3) goto L_0x0010
            r5 = r3
            goto L_0x0012
        L_0x0010:
            r3 = r0
            goto L_0x0013
        L_0x0012:
            r3 = r1
        L_0x0013:
            r4.zzb = r3
            if (r5 != r2) goto L_0x0018
            goto L_0x0019
        L_0x0018:
            r1 = r0
        L_0x0019:
            r4.zzc = r1
            r4.zzf = r0
            r4.zzh = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamj.zzc(int, long):void");
    }

    public final void zzd() {
        this.zzb = false;
        this.zzc = false;
        this.zzd = false;
        this.zze = -1;
    }
}
