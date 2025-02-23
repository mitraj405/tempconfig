package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzafb extends zzacx {
    final /* synthetic */ zzadi zza;
    final /* synthetic */ zzafc zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzafb(zzafc zzafc, zzadi zzadi, zzadi zzadi2) {
        super(zzadi);
        this.zza = zzadi2;
        this.zzb = zzafc;
    }

    public final zzadg zzg(long j) {
        zzadg zzg = this.zza.zzg(j);
        zzadj zzadj = zzg.zza;
        zzadj zzadj2 = new zzadj(zzadj.zzb, this.zzb.zzb + zzadj.zzc);
        zzadj zzadj3 = zzg.zzb;
        long j2 = zzadj3.zzc;
        return new zzadg(zzadj2, new zzadj(zzadj3.zzb, this.zzb.zzb + j2));
    }
}
