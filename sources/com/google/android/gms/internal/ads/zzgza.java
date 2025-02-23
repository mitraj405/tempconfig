package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzgza implements zzgzh {
    private final zzgzh[] zza;

    public zzgza(zzgzh... zzgzhArr) {
        this.zza = zzgzhArr;
    }

    public final zzgzg zzb(Class cls) {
        for (int i = 0; i < 2; i++) {
            zzgzh zzgzh = this.zza[i];
            if (zzgzh.zzc(cls)) {
                return zzgzh.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    public final boolean zzc(Class cls) {
        for (int i = 0; i < 2; i++) {
            if (this.zza[i].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
