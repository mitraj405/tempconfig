package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzakb implements zzack {
    private final zzack zza;
    private final zzajy zzb;
    private zzakc zzc;

    public zzakb(zzack zzack, zzajy zzajy) {
        this.zza = zzack;
        this.zzb = zzajy;
    }

    public final int zzb(zzacl zzacl, zzadf zzadf) throws IOException {
        return this.zza.zzb(zzacl, zzadf);
    }

    public final zzack zzc() {
        return this.zza;
    }

    public final /* synthetic */ List zzd() {
        return zzfxr.zzm();
    }

    public final void zze(zzacn zzacn) {
        zzakc zzakc = new zzakc(zzacn, this.zzb);
        this.zzc = zzakc;
        this.zza.zze(zzakc);
    }

    public final void zzf() {
        this.zza.zzf();
    }

    public final void zzi(long j, long j2) {
        zzakc zzakc = this.zzc;
        if (zzakc != null) {
            zzakc.zza();
        }
        this.zza.zzi(j, j2);
    }

    public final boolean zzj(zzacl zzacl) throws IOException {
        return this.zza.zzj(zzacl);
    }
}
