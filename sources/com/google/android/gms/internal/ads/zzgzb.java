package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzgzb implements zzhaf {
    private static final zzgzh zza = new zzgyz();
    private final zzgzh zzb;

    public zzgzb() {
        zzgzh zzgzh = zza;
        int i = zzgzt.zza;
        zzgza zzgza = new zzgza(zzgxr.zza(), zzgzh);
        byte[] bArr = zzgyl.zzb;
        this.zzb = zzgza;
    }

    public final zzhae zza(Class cls) {
        zzgxj zzgxj;
        int i = zzhag.zza;
        if (!zzgxy.class.isAssignableFrom(cls)) {
            int i2 = zzgzt.zza;
        }
        zzgzg zzb2 = this.zzb.zzb(cls);
        if (!zzb2.zzb()) {
            int i3 = zzgzt.zza;
            zzgzp zza2 = zzgzq.zza();
            zzgyw zza3 = zzgyx.zza();
            zzhas zzm = zzhag.zzm();
            if (zzb2.zzc() - 1 != 1) {
                zzgxj = zzgxl.zza();
            } else {
                zzgxj = null;
            }
            return zzgzm.zzm(cls, zzb2, zza2, zza3, zzm, zzgxj, zzgzf.zza());
        }
        int i4 = zzgzt.zza;
        return zzgzn.zzc(zzhag.zzm(), zzgxl.zza(), zzb2.zza());
    }
}
