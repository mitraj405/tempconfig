package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
final class zzhc extends zzgz<Boolean> {
    public zzhc(zzhh zzhh, String str, Boolean bool, boolean z) {
        super(zzhh, str, bool);
    }

    public final /* synthetic */ Object zza(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (zzfy.zzc.matcher(str).matches()) {
                return Boolean.TRUE;
            }
            if (zzfy.zzd.matcher(str).matches()) {
                return Boolean.FALSE;
            }
        }
        super.zzb();
        String.valueOf(obj);
        return null;
    }
}
