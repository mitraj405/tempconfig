package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzguz {
    public static final zzguz zza = new zzguz(new zzgva());
    public static final zzguz zzb = new zzguz(new zzgve());
    private final zzguy zzc;

    static {
        new zzguz(new zzgvg());
        new zzguz(new zzgvf());
        new zzguz(new zzgvb());
        new zzguz(new zzgvd());
        new zzguz(new zzgvc());
    }

    public zzguz(zzgvh zzgvh) {
        zzguy zzgux;
        if (zzgks.zzb()) {
            zzgux = new zzgux(zzgvh, (zzguw) null);
        } else if ("The Android Project".equals(System.getProperty("java.vendor"))) {
            zzgux = new zzgut(zzgvh, (zzgus) null);
        } else {
            zzgux = new zzguv(zzgvh, (zzguu) null);
        }
        this.zzc = zzgux;
    }

    public static List zzb(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String provider : strArr) {
            Provider provider2 = Security.getProvider(provider);
            if (provider2 != null) {
                arrayList.add(provider2);
            }
        }
        return arrayList;
    }

    public final Object zza(String str) throws GeneralSecurityException {
        return this.zzc.zza(str);
    }
}
