package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzghz {
    private zzgib zza;
    private String zzb;
    private zzgia zzc;
    private zzgex zzd;

    private zzghz() {
        throw null;
    }

    public /* synthetic */ zzghz(zzghy zzghy) {
    }

    public final zzghz zza(zzgex zzgex) {
        this.zzd = zzgex;
        return this;
    }

    public final zzghz zzb(zzgia zzgia) {
        this.zzc = zzgia;
        return this;
    }

    public final zzghz zzc(String str) {
        this.zzb = str;
        return this;
    }

    public final zzghz zzd(zzgib zzgib) {
        this.zza = zzgib;
        return this;
    }

    public final zzgid zze() throws GeneralSecurityException {
        if (this.zza == null) {
            this.zza = zzgib.zzb;
        }
        if (this.zzb != null) {
            zzgia zzgia = this.zzc;
            if (zzgia != null) {
                zzgex zzgex = this.zzd;
                if (zzgex == null) {
                    throw new GeneralSecurityException("dekParametersForNewKeys must be set");
                } else if (zzgex.zza()) {
                    throw new GeneralSecurityException("dekParametersForNewKeys must not have ID Requirements");
                } else if ((zzgia.equals(zzgia.zza) && (zzgex instanceof zzggo)) || ((zzgia.equals(zzgia.zzc) && (zzgex instanceof zzghh)) || ((zzgia.equals(zzgia.zzb) && (zzgex instanceof zzgiw)) || ((zzgia.equals(zzgia.zzd) && (zzgex instanceof zzgfp)) || ((zzgia.equals(zzgia.zze) && (zzgex instanceof zzggb)) || (zzgia.equals(zzgia.zzf) && (zzgex instanceof zzghb))))))) {
                    return new zzgid(this.zza, this.zzb, this.zzc, this.zzd, (zzgic) null);
                } else {
                    throw new GeneralSecurityException(C1058d.A("Cannot use parsing strategy ", this.zzc.toString(), " when new keys are picked according to ", String.valueOf(this.zzd), "."));
                }
            } else {
                throw new GeneralSecurityException("dekParsingStrategy must be set");
            }
        } else {
            throw new GeneralSecurityException("kekUri must be set");
        }
    }
}
