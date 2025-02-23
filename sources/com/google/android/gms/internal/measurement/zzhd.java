package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
final class zzhd extends zzgz<Long> {
    public zzhd(zzhh zzhh, String str, Long l, boolean z) {
        super(zzhh, str, l);
    }

    /* access modifiers changed from: private */
    /* renamed from: zzb */
    public final Long zza(Object obj) {
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof String) {
            try {
                return Long.valueOf(Long.parseLong((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        super.zzb();
        String.valueOf(obj);
        return null;
    }
}
