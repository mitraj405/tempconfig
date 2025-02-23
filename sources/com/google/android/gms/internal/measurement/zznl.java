package com.google.android.gms.internal.measurement;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
public final class zznl implements Supplier<zzno> {
    private static zznl zza = new zznl();
    private final Supplier<zzno> zzb = Suppliers.ofInstance(new zznn());

    public static boolean zza() {
        return ((zzno) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzno) zza.get()).zzb();
    }

    public final /* synthetic */ Object get() {
        return this.zzb.get();
    }
}
