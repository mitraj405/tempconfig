package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzgfa implements zzgdo {
    private final zzgnj zza;

    public /* synthetic */ zzgfa(zzgnj zzgnj, zzgez zzgez) {
        this.zza = zzgnj;
        if (zzgnj.zzg()) {
            zzglp zza2 = zzgmf.zzb().zza();
            zzglu zza3 = zzglx.zza(zzgnj);
            zza2.zza(zza3, "aead", "encrypt");
            zza2.zza(zza3, "aead", "decrypt");
        }
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length > 5) {
            for (zzgnh zzgnh : this.zza.zzf(Arrays.copyOf(bArr, 5))) {
                try {
                    byte[] zza2 = ((zzgdo) zzgnh.zzd()).zza(bArr, bArr2);
                    zzgnh.zza();
                    return zza2;
                } catch (GeneralSecurityException unused) {
                }
            }
        }
        for (zzgnh zzgnh2 : this.zza.zzf(zzgdt.zza)) {
            try {
                byte[] zza3 = ((zzgdo) zzgnh2.zzd()).zza(bArr, bArr2);
                zzgnh2.zza();
                return zza3;
            } catch (GeneralSecurityException unused2) {
            }
        }
        throw new GeneralSecurityException("decryption failed");
    }
}
