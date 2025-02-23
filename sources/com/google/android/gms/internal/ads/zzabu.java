package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public class zzabu {
    protected final zzabo zza;
    protected final zzabt zzb;
    protected zzabq zzc;
    private final int zzd;

    public zzabu(zzabr zzabr, zzabt zzabt, long j, long j2, long j3, long j4, long j5, long j6, int i) {
        this.zzb = zzabt;
        this.zzd = i;
        this.zza = new zzabo(zzabr, j, 0, j3, j4, j5, j6);
    }

    public static final int zzf(zzacl zzacl, long j, zzadf zzadf) {
        if (j == zzacl.zzf()) {
            return 0;
        }
        zzadf.zza = j;
        return 1;
    }

    public static final boolean zzg(zzacl zzacl, long j) throws IOException {
        long zzf = j - zzacl.zzf();
        if (zzf < 0 || zzf > PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            return false;
        }
        ((zzaby) zzacl).zzo((int) zzf, false);
        return true;
    }

    public final int zza(zzacl zzacl, zzadf zzadf) throws IOException {
        while (true) {
            zzabq zzabq = this.zzc;
            zzdi.zzb(zzabq);
            long zzb2 = zzabq.zzf;
            int i = this.zzd;
            long zzc2 = zzabq.zzh;
            if (zzabq.zzg - zzb2 <= ((long) i)) {
                zzc(false, zzb2);
                return zzf(zzacl, zzb2, zzadf);
            } else if (!zzg(zzacl, zzc2)) {
                return zzf(zzacl, zzc2, zzadf);
            } else {
                zzacl.zzj();
                zzabs zza2 = this.zzb.zza(zzacl, zzabq.zzb);
                int zza3 = zza2.zzb;
                if (zza3 == -3) {
                    zzc(false, zzc2);
                    return zzf(zzacl, zzc2, zzadf);
                } else if (zza3 == -2) {
                    zzabq.zzh(zzabq, zza2.zzc, zza2.zzd);
                } else if (zza3 != -1) {
                    zzg(zzacl, zza2.zzd);
                    zzc(true, zza2.zzd);
                    return zzf(zzacl, zza2.zzd, zzadf);
                } else {
                    zzabq.zzg(zzabq, zza2.zzc, zza2.zzd);
                }
            }
        }
    }

    public final zzadi zzb() {
        return this.zza;
    }

    public final void zzc(boolean z, long j) {
        this.zzc = null;
        this.zzb.zzb();
    }

    public final void zzd(long j) {
        long j2 = j;
        zzabq zzabq = this.zzc;
        if (zzabq == null || zzabq.zza != j2) {
            zzabo zzabo = this.zza;
            zzabq zzabq2 = r1;
            zzabq zzabq3 = new zzabq(j, zzabo.zzf(j2), 0, zzabo.zzc, zzabo.zzd, zzabo.zze, zzabo.zzf);
            this.zzc = zzabq2;
        }
    }

    public final boolean zze() {
        if (this.zzc != null) {
            return true;
        }
        return false;
    }
}
