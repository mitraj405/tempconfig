package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzaei implements zzack {
    private final zzek zza = new zzek(4);
    private final zzadk zzb = new zzadk(-1, -1, "image/avif");

    private final boolean zza(zzacl zzacl, int i) throws IOException {
        this.zza.zzH(4);
        ((zzaby) zzacl).zzm(this.zza.zzM(), 0, 4, false);
        if (this.zza.zzu() == ((long) i)) {
            return true;
        }
        return false;
    }

    public final int zzb(zzacl zzacl, zzadf zzadf) throws IOException {
        return this.zzb.zzb(zzacl, zzadf);
    }

    public final /* synthetic */ List zzd() {
        return zzfxr.zzm();
    }

    public final void zze(zzacn zzacn) {
        this.zzb.zze(zzacn);
    }

    public final void zzi(long j, long j2) {
        this.zzb.zzi(j, j2);
    }

    public final boolean zzj(zzacl zzacl) throws IOException {
        ((zzaby) zzacl).zzl(4, false);
        if (!zza(zzacl, 1718909296) || !zza(zzacl, 1635150182)) {
            return false;
        }
        return true;
    }

    public final /* synthetic */ zzack zzc() {
        return this;
    }

    public final void zzf() {
    }
}
