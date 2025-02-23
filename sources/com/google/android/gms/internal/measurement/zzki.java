package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.0.2 */
final class zzki implements zzkq {
    private zzkq[] zza;

    public zzki(zzkq... zzkqArr) {
        this.zza = zzkqArr;
    }

    public final zzkr zza(Class<?> cls) {
        for (zzkq zzkq : this.zza) {
            if (zzkq.zzb(cls)) {
                return zzkq.zza(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    public final boolean zzb(Class<?> cls) {
        for (zzkq zzb : this.zza) {
            if (zzb.zzb(cls)) {
                return true;
            }
        }
        return false;
    }
}
