package com.google.android.gms.internal.measurement;

import com.google.android.gms.ads.AdError;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@22.0.2 */
public final class zzax implements zzaq {
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj instanceof zzax;
    }

    public final zzaq zza(String str, zzh zzh, List<zzaq> list) {
        throw new IllegalStateException(String.format("Undefined has no function %s", new Object[]{str}));
    }

    public final zzaq zzc() {
        return zzaq.zzc;
    }

    public final Boolean zzd() {
        return Boolean.FALSE;
    }

    public final Double zze() {
        return Double.valueOf(Double.NaN);
    }

    public final String zzf() {
        return AdError.UNDEFINED_DOMAIN;
    }

    public final Iterator<zzaq> zzh() {
        return null;
    }
}
