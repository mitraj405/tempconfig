package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.0.2 */
final class zzkh implements zzlk {
    private static final zzkq zza = new zzkg();
    private final zzkq zzb;

    public zzkh() {
        this(new zzki(zzjl.zza(), zza));
    }

    public final <T> zzll<T> zza(Class<T> cls) {
        zziz<?> zziz;
        zzln.zza((Class<?>) cls);
        zzkr zza2 = this.zzb.zza(cls);
        if (zza2.zzc()) {
            return zzkz.zza(zzln.zza(), zzja.zza(), zza2.zza());
        }
        zzlb zza3 = zzld.zza();
        zzkd zza4 = zzkf.zza();
        zzmf<?, ?> zza5 = zzln.zza();
        boolean z = true;
        if (zzkj.zza[zza2.zzb().ordinal()] == 1) {
            z = false;
        }
        if (z) {
            zziz = zzja.zza();
        } else {
            zziz = null;
        }
        return zzkx.zza(cls, zza2, zza3, zza4, zza5, zziz, zzko.zza());
    }

    private zzkh(zzkq zzkq) {
        this.zzb = (zzkq) zzjm.zza(zzkq, "messageInfoFactory");
    }
}
