package com.google.android.gms.internal.ads;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzadk implements zzack {
    private final int zza;
    private final int zzb;
    private final String zzc;
    private int zzd;
    private int zze;
    private zzacn zzf;
    private zzadp zzg;

    public zzadk(int i, int i2, String str) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = str;
    }

    public final int zzb(zzacl zzacl, zzadf zzadf) throws IOException {
        int i = this.zze;
        if (i == 1) {
            zzadp zzadp = this.zzg;
            zzadp.getClass();
            int zzf2 = zzadp.zzf(zzacl, UserMetadata.MAX_ATTRIBUTE_SIZE, true);
            if (zzf2 == -1) {
                this.zze = 2;
                this.zzg.zzs(0, 1, this.zzd, 0, (zzado) null);
                this.zzd = 0;
            } else {
                this.zzd += zzf2;
            }
            return 0;
        } else if (i == 2) {
            return -1;
        } else {
            throw new IllegalStateException();
        }
    }

    public final /* synthetic */ List zzd() {
        return zzfxr.zzm();
    }

    public final void zze(zzacn zzacn) {
        this.zzf = zzacn;
        zzadp zzw = zzacn.zzw(UserMetadata.MAX_ATTRIBUTE_SIZE, 4);
        this.zzg = zzw;
        zzad zzad = new zzad();
        zzad.zzX(this.zzc);
        zzw.zzl(zzad.zzad());
        this.zzf.zzD();
        this.zzf.zzO(new zzadl(-9223372036854775807L));
        this.zze = 1;
    }

    public final void zzi(long j, long j2) {
        if (j == 0 || this.zze == 1) {
            this.zze = 1;
            this.zzd = 0;
        }
    }

    public final boolean zzj(zzacl zzacl) throws IOException {
        boolean z;
        if (this.zza == -1 || this.zzb == -1) {
            z = false;
        } else {
            z = true;
        }
        zzdi.zzf(z);
        zzek zzek = new zzek(this.zzb);
        ((zzaby) zzacl).zzm(zzek.zzM(), 0, this.zzb, false);
        if (zzek.zzq() == this.zza) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ zzack zzc() {
        return this;
    }

    public final void zzf() {
    }
}
