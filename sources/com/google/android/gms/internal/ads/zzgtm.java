package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgtm extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzgtm zza;
    private static volatile zzgzr zzb;
    /* access modifiers changed from: private */
    public int zzc;
    private zzgyk zzd = zzgxy.zzbK();

    static {
        zzgtm zzgtm = new zzgtm();
        zza = zzgtm;
        zzgxy.zzcb(zzgtm.class, zzgtm);
    }

    private zzgtm() {
    }

    public static zzgtj zza() {
        return (zzgtj) zza.zzaZ();
    }

    public static /* synthetic */ void zze(zzgtm zzgtm, zzgtl zzgtl) {
        zzgtl.getClass();
        zzgyk zzgyk = zzgtm.zzd;
        if (!zzgyk.zzc()) {
            zzgtm.zzd = zzgxy.zzbL(zzgyk);
        }
        zzgtm.zzd.add(zzgtl);
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzc", "zzd", zzgtl.class});
            case 3:
                return new zzgtm();
            case 4:
                return new zzgtj((zzgti) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzgtm.class) {
                        zzgzr = zzb;
                        if (zzgzr == null) {
                            zzgzr = new zzgxt(zza);
                            zzb = zzgzr;
                        }
                    }
                }
                return zzgzr;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
