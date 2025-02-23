package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzub extends zztw {
    public static final Object zzc = new Object();
    private final Object zzd;
    /* access modifiers changed from: private */
    public final Object zze;

    private zzub(zzcc zzcc, Object obj, Object obj2) {
        super(zzcc);
        this.zzd = obj;
        this.zze = obj2;
    }

    public static zzub zzq(zzbc zzbc) {
        return new zzub(new zzuc(zzbc), zzcb.zza, zzc);
    }

    public static zzub zzr(zzcc zzcc, Object obj, Object obj2) {
        return new zzub(zzcc, obj, obj2);
    }

    public final int zza(Object obj) {
        Object obj2;
        if (zzc.equals(obj) && (obj2 = this.zze) != null) {
            obj = obj2;
        }
        return this.zzb.zza(obj);
    }

    public final zzca zzd(int i, zzca zzca, boolean z) {
        this.zzb.zzd(i, zzca, z);
        if (zzet.zzG(zzca.zzb, this.zze) && z) {
            zzca.zzb = zzc;
        }
        return zzca;
    }

    public final zzcb zze(int i, zzcb zzcb, long j) {
        this.zzb.zze(i, zzcb, j);
        if (zzet.zzG(zzcb.zzb, this.zzd)) {
            zzcb.zzb = zzcb.zza;
        }
        return zzcb;
    }

    public final Object zzf(int i) {
        Object zzf = this.zzb.zzf(i);
        if (zzet.zzG(zzf, this.zze)) {
            return zzc;
        }
        return zzf;
    }

    public final zzub zzp(zzcc zzcc) {
        return new zzub(zzcc, this.zzd, this.zze);
    }
}
