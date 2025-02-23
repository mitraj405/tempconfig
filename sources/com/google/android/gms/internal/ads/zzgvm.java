package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Mac;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzgvm extends ThreadLocal {
    final /* synthetic */ zzgvn zza;

    public zzgvm(zzgvn zzgvn) {
        this.zza = zzgvn;
    }

    /* renamed from: zza */
    public final Mac initialValue() {
        try {
            Mac mac = (Mac) zzguz.zzb.zza(this.zza.zzb);
            mac.init(this.zza.zzc);
            return mac;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
