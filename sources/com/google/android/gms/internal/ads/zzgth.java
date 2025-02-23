package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgth extends zzgxy implements zzgzk {
    /* access modifiers changed from: private */
    public static final zzgth zza;
    private static volatile zzgzr zzb;
    /* access modifiers changed from: private */
    public int zzc;
    private zzgyk zzd = zzgxy.zzbK();

    static {
        zzgth zzgth = new zzgth();
        zza = zzgth;
        zzgxy.zzcb(zzgth.class, zzgth);
    }

    private zzgth() {
    }

    public static zzgte zzd() {
        return (zzgte) zza.zzaZ();
    }

    public static zzgth zzg(InputStream inputStream, zzgxi zzgxi) throws IOException {
        return (zzgth) zzgxy.zzbu(zza, inputStream, zzgxi);
    }

    public static /* synthetic */ void zzj(zzgth zzgth, zzgtg zzgtg) {
        zzgtg.getClass();
        zzgyk zzgyk = zzgth.zzd;
        if (!zzgyk.zzc()) {
            zzgth.zzd = zzgxy.zzbL(zzgyk);
        }
        zzgth.zzd.add(zzgtg);
    }

    public final int zza() {
        return this.zzd.size();
    }

    public final int zzc() {
        return this.zzc;
    }

    public final Object zzde(zzgxx zzgxx, Object obj, Object obj2) {
        switch (zzgxx.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzgxy.zzbS(zza, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzc", "zzd", zzgtg.class});
            case 3:
                return new zzgth();
            case 4:
                return new zzgte((zzgtd) null);
            case 5:
                return zza;
            case 6:
                zzgzr zzgzr = zzb;
                if (zzgzr == null) {
                    synchronized (zzgth.class) {
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

    public final zzgtg zze(int i) {
        return (zzgtg) this.zzd.get(i);
    }

    public final List zzh() {
        return this.zzd;
    }
}
