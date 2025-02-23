package com.google.android.gms.internal.ads;

import android.util.Base64;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzu;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzffv {
    public zzffv() {
        try {
            zzgev.zza();
        } catch (GeneralSecurityException e) {
            zze.zza("Failed to Configure Aead. ".concat(e.toString()));
            zzu.zzo().zzw(e, "CryptoUtils.registerAead");
        }
    }

    public static final String zza() {
        zzgwl zzt = zzgwm.zzt();
        try {
            zzgdr.zzb(zzgej.zzb(zzgeb.zza(zzgmg.zzb().zza("AES128_GCM"))), zzgdq.zzb(zzt));
        } catch (IOException | GeneralSecurityException e) {
            zze.zza("Failed to generate key".concat(e.toString()));
            zzu.zzo().zzw(e, "CryptoUtils.generateKey");
        }
        String encodeToString = Base64.encodeToString(zzt.zzb().zzA(), 11);
        zzt.zzc();
        return encodeToString;
    }

    public static final String zzb(byte[] bArr, byte[] bArr2, String str, zzdsf zzdsf) {
        zzgej zzc = zzc(str);
        if (zzc == null) {
            return null;
        }
        try {
            byte[] zza = ((zzgdo) zzc.zzd(zzgnp.zza(), zzgdo.class)).zza(bArr, bArr2);
            zzdsf.zzb().put("ds", C0515Ga.AVLBLTY_ONLY);
            return new String(zza, "UTF-8");
        } catch (UnsupportedEncodingException | UnsupportedOperationException | GeneralSecurityException e) {
            zze.zza("Failed to decrypt ".concat(e.toString()));
            zzu.zzo().zzw(e, "CryptoUtils.decrypt");
            zzdsf.zzb().put("dsf", e.toString());
            return null;
        }
    }

    private static final zzgej zzc(String str) {
        try {
            return zzgdr.zza(zzgdp.zzb(Base64.decode(str, 11)));
        } catch (IOException | GeneralSecurityException e) {
            zze.zza("Failed to get keysethandle".concat(e.toString()));
            zzu.zzo().zzw(e, "CryptoUtils.getHandle");
            return null;
        }
    }
}
