package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.0.2 */
final class zzjl implements zzkq {
    private static final zzjl zza = new zzjl();

    private zzjl() {
    }

    public static zzjl zza() {
        return zza;
    }

    public final boolean zzb(Class<?> cls) {
        return zzjk.class.isAssignableFrom(cls);
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [java.lang.Class<?>, java.lang.Class] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zzkr zza(java.lang.Class<?> r4) {
        /*
            r3 = this;
            java.lang.Class<com.google.android.gms.internal.measurement.zzjk> r0 = com.google.android.gms.internal.measurement.zzjk.class
            boolean r1 = r0.isAssignableFrom(r4)
            if (r1 == 0) goto L_0x002b
            java.lang.Class r0 = r4.asSubclass(r0)     // Catch:{ Exception -> 0x001a }
            com.google.android.gms.internal.measurement.zzjk r0 = com.google.android.gms.internal.measurement.zzjk.zza(r0)     // Catch:{ Exception -> 0x001a }
            int r1 = com.google.android.gms.internal.measurement.zzjk.zze.zzc     // Catch:{ Exception -> 0x001a }
            r2 = 0
            java.lang.Object r0 = r0.zza((int) r1, (java.lang.Object) r2, (java.lang.Object) r2)     // Catch:{ Exception -> 0x001a }
            com.google.android.gms.internal.measurement.zzkr r0 = (com.google.android.gms.internal.measurement.zzkr) r0     // Catch:{ Exception -> 0x001a }
            return r0
        L_0x001a:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r4 = r4.getName()
            java.lang.String r2 = "Unable to get message info for "
            java.lang.String r4 = r2.concat(r4)
            r1.<init>(r4, r0)
            throw r1
        L_0x002b:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r4 = r4.getName()
            java.lang.String r1 = "Unsupported message type: "
            java.lang.String r4 = r1.concat(r4)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjl.zza(java.lang.Class):com.google.android.gms.internal.measurement.zzkr");
    }
}
