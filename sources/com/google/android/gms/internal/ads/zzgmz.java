package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgmz {
    /* access modifiers changed from: private */
    public final Map zza;
    /* access modifiers changed from: private */
    public final Map zzb;

    private zzgmz() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }

    public final zzgmz zza(zzgmx zzgmx) throws GeneralSecurityException {
        if (zzgmx != null) {
            zzgnb zzgnb = new zzgnb(zzgmx.zzc(), zzgmx.zzd(), (zzgna) null);
            if (this.zza.containsKey(zzgnb)) {
                zzgmx zzgmx2 = (zzgmx) this.zza.get(zzgnb);
                if (!zzgmx2.equals(zzgmx) || !zzgmx.equals(zzgmx2)) {
                    throw new GeneralSecurityException("Attempt to register non-equal PrimitiveConstructor object for already existing object of type: ".concat(zzgnb.toString()));
                }
            } else {
                this.zza.put(zzgnb, zzgmx);
            }
            return this;
        }
        throw new NullPointerException("primitive constructor must be non-null");
    }

    public final zzgmz zzb(zzgnk zzgnk) throws GeneralSecurityException {
        Map map = this.zzb;
        Class zzb2 = zzgnk.zzb();
        if (map.containsKey(zzb2)) {
            zzgnk zzgnk2 = (zzgnk) this.zzb.get(zzb2);
            if (!zzgnk2.equals(zzgnk) || !zzgnk.equals(zzgnk2)) {
                throw new GeneralSecurityException("Attempt to register non-equal PrimitiveWrapper object or input class object for already existing object of type".concat(zzb2.toString()));
            }
        } else {
            this.zzb.put(zzb2, zzgnk);
        }
        return this;
    }

    public /* synthetic */ zzgmz(zzgmy zzgmy) {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }

    public /* synthetic */ zzgmz(zzgnd zzgnd, zzgmy zzgmy) {
        this.zza = new HashMap(zzgnd.zza);
        this.zzb = new HashMap(zzgnd.zzb);
    }
}
