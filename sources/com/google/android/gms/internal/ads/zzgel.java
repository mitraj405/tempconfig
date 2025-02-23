package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgel {
    private static final CopyOnWriteArrayList zza = new CopyOnWriteArrayList();

    public static zzgek zza(String str) throws GeneralSecurityException {
        Iterator it = zza.iterator();
        while (it.hasNext()) {
            zzgek zzgek = (zzgek) it.next();
            if (zzgek.zza()) {
                return zzgek;
            }
        }
        throw new GeneralSecurityException("No KMS client does support: ".concat(String.valueOf(str)));
    }
}
