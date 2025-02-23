package com.google.android.gms.internal.ads;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzguc extends zzgxy implements zzgzk {
    public static final /* synthetic */ int zza = 0;
    /* access modifiers changed from: private */
    public static final zzguc zzb;
    private static volatile zzgzr zzc;
    private String zzd = "";
    private zzgyk zze = zzgxy.zzbK();

    static {
        zzguc zzguc = new zzguc();
        zzb = zzguc;
        zzgxy.zzcb(zzguc.class, zzguc);
    }

    private zzguc() {
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zzd", "zze", zzgtc.class});
            case 3:
                return new zzguc();
            case 4:
                return new zzgub((zzgua) null);
            case 5:
                return zzb;
            case 6:
                zzgzr zzgzr = zzc;
                if (zzgzr == null) {
                    synchronized (zzguc.class) {
                        zzgzr = zzc;
                        if (zzgzr == null) {
                            zzgzr = new zzgxt(zzb);
                            zzc = zzgzr;
                        }
                    }
                }
                return zzgzr;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
