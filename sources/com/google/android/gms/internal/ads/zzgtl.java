package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgtl extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzgtl zza;
    private static volatile zzgzr zzb;
    private String zzc = "";
    /* access modifiers changed from: private */
    public int zzd;
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public int zzf;

    static {
        zzgtl zzgtl = new zzgtl();
        zza = zzgtl;
        zzgxy.zzcb(zzgtl.class, zzgtl);
    }

    private zzgtl() {
    }

    public static zzgtk zza() {
        return (zzgtk) zza.zzaZ();
    }

    public static /* synthetic */ void zzd(zzgtl zzgtl, String str) {
        str.getClass();
        zzgtl.zzc = str;
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzc", "zzd", "zze", "zzf"});
            case 3:
                return new zzgtl();
            case 4:
                return new zzgtk((zzgti) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzgtl.class) {
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
