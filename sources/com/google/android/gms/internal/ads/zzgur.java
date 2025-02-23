package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgur implements zzgdo {
    private final zzgvj zza;
    private final zzgem zzb;
    private final int zzc;
    private final byte[] zzd;

    private zzgur(zzgvj zzgvj, zzgem zzgem, int i, byte[] bArr) {
        this.zza = zzgvj;
        this.zzb = zzgem;
        this.zzc = i;
        this.zzd = bArr;
    }

    public static zzgdo zzb(zzgff zzgff) throws GeneralSecurityException {
        zzguk zzguk = new zzguk(zzgff.zzd().zzd(zzgdx.zza()), zzgff.zzb().zzd());
        String valueOf = String.valueOf(zzgff.zzb().zzg());
        return new zzgur(zzguk, new zzgvo(new zzgvn("HMAC".concat(valueOf), new SecretKeySpec(zzgff.zze().zzd(zzgdx.zza()), "HMAC")), zzgff.zzb().zze()), zzgff.zzb().zze(), zzgff.zzc().zzc());
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzd;
        int i = this.zzc;
        int length = bArr3.length;
        int length2 = bArr.length;
        if (length2 < i + length) {
            throw new GeneralSecurityException("Decryption failed (ciphertext too short).");
        } else if (zzgoa.zzc(bArr3, bArr)) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, this.zzd.length, length2 - this.zzc);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, length2 - this.zzc, length2);
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            byte[] copyOf = Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8);
            byte[][] bArr4 = {bArr2, copyOfRange, copyOf};
            if (MessageDigest.isEqual(((zzgvo) this.zzb).zzc(zzgup.zzb(bArr4)), copyOfRange2)) {
                return this.zza.zza(copyOfRange);
            }
            throw new GeneralSecurityException("invalid MAC");
        } else {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
    }
}
