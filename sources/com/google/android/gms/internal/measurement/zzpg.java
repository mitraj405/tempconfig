package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
public final class zzpg implements Supplier<zzpf> {
    private static zzpg zza = new zzpg();
    private final Supplier<zzpf> zzb = Suppliers.ofInstance(new zzpi());

    public static boolean zza() {
        return ((zzpf) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzpf) zza.get()).zzb();
    }

    public static boolean zzc() {
        return ((zzpf) zza.get()).zzc();
    }

    public static boolean zzd() {
        return ((zzpf) zza.get()).zzd();
    }

    public static boolean zze() {
        return ((zzpf) zza.get()).zze();
    }

    public static boolean zzf() {
        return ((zzpf) zza.get()).zzf();
    }

    public static boolean zzg() {
        return ((zzpf) zza.get()).zzg();
    }

    public static boolean zzh() {
        return ((zzpf) zza.get()).zzh();
    }

    public static boolean zzi() {
        return ((zzpf) zza.get()).zzi();
    }

    public final /* synthetic */ Object get() {
        return this.zzb.get();
    }
}
