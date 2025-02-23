package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgor implements zzgnk {
    private static final zzgor zza = new zzgor();

    private zzgor() {
    }

    public static void zzd() throws GeneralSecurityException {
        zzgmh.zza().zzf(zza);
    }

    public final Class zza() {
        return zzgoo.class;
    }

    public final Class zzb() {
        return zzgoo.class;
    }

    public final /* bridge */ /* synthetic */ Object zzc(zzgnj zzgnj) throws GeneralSecurityException {
        if (zzgnj.zzc() != null) {
            for (List<zzgnh> it : zzgnj.zze()) {
                for (zzgnh zzd : it) {
                    zzgoo zzgoo = (zzgoo) zzd.zzd();
                }
            }
            return new zzgoq(zzgnj, (zzgop) null);
        }
        throw new GeneralSecurityException("no primary in primitive set");
    }
}
