package com.google.android.gms.internal.ads;

import com.google.android.gms.security.ProviderInstaller;
import java.security.GeneralSecurityException;
import java.security.Provider;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzgut implements zzguy {
    private final zzgvh zza;

    public /* synthetic */ zzgut(zzgvh zzgvh, zzgus zzgus) {
        this.zza = zzgvh;
    }

    public final Object zza(String str) throws GeneralSecurityException {
        for (Provider zza2 : zzguz.zzb(ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL")) {
            try {
                return this.zza.zza(str, zza2);
            } catch (Exception unused) {
            }
        }
        return this.zza.zza(str, (Provider) null);
    }
}
