package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzghp extends zzgew {
    private final zzghr zza;
    private final zzgvr zzb;
    private final Integer zzc;

    private zzghp(zzghr zzghr, zzgvr zzgvr, Integer num) {
        this.zza = zzghr;
        this.zzb = zzgvr;
        this.zzc = num;
    }

    public static zzghp zza(zzghr zzghr, Integer num) throws GeneralSecurityException {
        zzgvr zzgvr;
        if (zzghr.zzb() == zzghq.zza) {
            if (num != null) {
                zzgvr = zzgvr.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
            } else {
                throw new GeneralSecurityException("For given Variant TINK the value of idRequirement must be non-null");
            }
        } else if (zzghr.zzb() != zzghq.zzb) {
            throw new GeneralSecurityException("Unknown Variant: ".concat(zzghr.zzb().toString()));
        } else if (num == null) {
            zzgvr = zzgvr.zzb(new byte[0]);
        } else {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        return new zzghp(zzghr, zzgvr, num);
    }

    public final zzghr zzb() {
        return this.zza;
    }

    public final zzgvr zzc() {
        return this.zzb;
    }

    public final Integer zzd() {
        return this.zzc;
    }
}
