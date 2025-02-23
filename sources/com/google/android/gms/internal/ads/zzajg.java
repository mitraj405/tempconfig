package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzajg implements zzack {
    private zzacn zza;
    private zzajo zzb;
    private boolean zzc;

    private final boolean zza(zzacl zzacl) throws IOException {
        zzaji zzaji = new zzaji();
        if (zzaji.zzb(zzacl, true) && (zzaji.zza & 2) == 2) {
            int min = Math.min(zzaji.zze, 8);
            zzek zzek = new zzek(min);
            ((zzaby) zzacl).zzm(zzek.zzM(), 0, min, false);
            zzek.zzK(0);
            if (zzek.zzb() >= 5 && zzek.zzm() == 127 && zzek.zzu() == 1179402563) {
                this.zzb = new zzajf();
            } else {
                zzek.zzK(0);
                try {
                    if (zzadv.zzd(1, zzek, true)) {
                        this.zzb = new zzajq();
                    }
                } catch (zzbo unused) {
                }
                zzek.zzK(0);
                if (zzajk.zzd(zzek)) {
                    this.zzb = new zzajk();
                }
            }
            return true;
        }
        return false;
    }

    public final int zzb(zzacl zzacl, zzadf zzadf) throws IOException {
        zzdi.zzb(this.zza);
        if (this.zzb == null) {
            if (zza(zzacl)) {
                zzacl.zzj();
            } else {
                throw zzbo.zza("Failed to determine bitstream type", (Throwable) null);
            }
        }
        if (!this.zzc) {
            zzadp zzw = this.zza.zzw(0, 1);
            this.zza.zzD();
            this.zzb.zzh(this.zza, zzw);
            this.zzc = true;
        }
        return this.zzb.zze(zzacl, zzadf);
    }

    public final /* synthetic */ List zzd() {
        return zzfxr.zzm();
    }

    public final void zze(zzacn zzacn) {
        this.zza = zzacn;
    }

    public final void zzi(long j, long j2) {
        zzajo zzajo = this.zzb;
        if (zzajo != null) {
            zzajo.zzj(j, j2);
        }
    }

    public final boolean zzj(zzacl zzacl) throws IOException {
        try {
            return zza(zzacl);
        } catch (zzbo unused) {
            return false;
        }
    }

    public final /* synthetic */ zzack zzc() {
        return this;
    }

    public final void zzf() {
    }
}
