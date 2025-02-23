package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
public final class zzpa implements Supplier<zzoz> {
    private static zzpa zza = new zzpa();
    private final Supplier<zzoz> zzb = Suppliers.ofInstance(new zzpc());

    public static double zza() {
        return ((zzoz) zza.get()).zza();
    }

    public static long zzb() {
        return ((zzoz) zza.get()).zzb();
    }

    public static long zzc() {
        return ((zzoz) zza.get()).zzc();
    }

    public static long zzd() {
        return ((zzoz) zza.get()).zzd();
    }

    public static String zze() {
        return ((zzoz) zza.get()).zze();
    }

    public static boolean zzf() {
        return ((zzoz) zza.get()).zzf();
    }

    public final /* synthetic */ Object get() {
        return this.zzb.get();
    }
}
