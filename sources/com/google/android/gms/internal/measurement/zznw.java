package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
public final class zznw implements Supplier<zznv> {
    private static zznw zza = new zznw();
    private final Supplier<zznv> zzb = Suppliers.ofInstance(new zzny());

    public static boolean zza() {
        return ((zznv) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zznv) zza.get()).zzb();
    }

    public static boolean zzc() {
        return ((zznv) zza.get()).zzc();
    }

    public final /* synthetic */ Object get() {
        return this.zzb.get();
    }
}
