package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgky {
    private static final Logger zza = Logger.getLogger(zzgky.class.getName());
    private static final zzgky zzb = new zzgky();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final ConcurrentMap zzd = new ConcurrentHashMap();

    public static zzgky zzc() {
        return zzb;
    }

    private final synchronized zzgdz zzg(String str) throws GeneralSecurityException {
        if (this.zzc.containsKey(str)) {
        } else {
            throw new GeneralSecurityException("No key manager found for key type ".concat(String.valueOf(str)));
        }
        return (zzgdz) this.zzc.get(str);
    }

    private final synchronized void zzh(zzgdz zzgdz, boolean z, boolean z2) throws GeneralSecurityException {
        String str = ((zzglh) zzgdz).zza;
        if (this.zzd.containsKey(str)) {
            if (!((Boolean) this.zzd.get(str)).booleanValue()) {
                throw new GeneralSecurityException("New keys are already disallowed for key type ".concat(str));
            }
        }
        zzgdz zzgdz2 = (zzgdz) this.zzc.get(str);
        if (zzgdz2 != null) {
            if (!zzgdz2.getClass().equals(zzgdz.getClass())) {
                zza.logp(Level.WARNING, "com.google.crypto.tink.internal.KeyManagerRegistry", "insertKeyManager", "Attempted overwrite of a registered key manager for key type ".concat(str));
                throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", new Object[]{str, zzgdz2.getClass().getName(), zzgdz.getClass().getName()}));
            }
        }
        this.zzc.putIfAbsent(str, zzgdz);
        this.zzd.put(str, Boolean.TRUE);
    }

    public final zzgdz zza(String str, Class cls) throws GeneralSecurityException {
        zzgdz zzg = zzg(str);
        if (zzg.zzb().equals(cls)) {
            return zzg;
        }
        String name = cls.getName();
        String valueOf = String.valueOf(zzg.getClass());
        String obj = zzg.zzb().toString();
        StringBuilder b = C0437ME.b("Primitive type ", name, " not supported by key manager of type ", valueOf, ", which only supports: ");
        b.append(obj);
        throw new GeneralSecurityException(b.toString());
    }

    public final zzgdz zzb(String str) throws GeneralSecurityException {
        return zzg(str);
    }

    public final synchronized void zzd(zzgdz zzgdz, boolean z) throws GeneralSecurityException {
        zzf(zzgdz, 1, true);
    }

    public final boolean zze(String str) {
        return ((Boolean) this.zzd.get(str)).booleanValue();
    }

    public final synchronized void zzf(zzgdz zzgdz, int i, boolean z) throws GeneralSecurityException {
        if (zzgkr.zza(i)) {
            zzh(zzgdz, false, true);
        } else {
            throw new GeneralSecurityException("Cannot register key manager: FIPS compatibility insufficient");
        }
    }
}
