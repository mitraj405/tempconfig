package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzadq {
    private final byte[] zza = new byte[10];
    private boolean zzb;
    private int zzc;
    private long zzd;
    private int zze;
    private int zzf;
    private int zzg;

    public final void zza(zzadp zzadp, zzado zzado) {
        if (this.zzc > 0) {
            zzadp.zzs(this.zzd, this.zze, this.zzf, this.zzg, zzado);
            this.zzc = 0;
        }
    }

    public final void zzb() {
        this.zzb = false;
        this.zzc = 0;
    }

    public final void zzc(zzadp zzadp, long j, int i, int i2, int i3, zzado zzado) {
        boolean z;
        if (this.zzg <= i2 + i3) {
            z = true;
        } else {
            z = false;
        }
        zzdi.zzg(z, "TrueHD chunk samples must be contiguous in the sample queue.");
        if (this.zzb) {
            int i4 = this.zzc;
            int i5 = i4 + 1;
            this.zzc = i5;
            if (i4 == 0) {
                this.zzd = j;
                this.zze = i;
                this.zzf = 0;
            }
            this.zzf += i2;
            this.zzg = i3;
            if (i5 >= 16) {
                zza(zzadp, zzado);
            }
        }
    }

    public final void zzd(zzacl zzacl) throws IOException {
        if (!this.zzb) {
            zzacl.zzh(this.zza, 0, 10);
            zzacl.zzj();
            byte[] bArr = this.zza;
            int i = zzabj.zza;
            if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111 && (bArr[7] & 254) == 186) {
                this.zzb = true;
            }
        }
    }
}
