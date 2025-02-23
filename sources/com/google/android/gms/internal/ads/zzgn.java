package com.google.android.gms.internal.ads;

import com.facebook.ads.AdError;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgn extends zzgl {
    public final int zzc;

    public zzgn(int i, String str, IOException iOException, Map map, zzfy zzfy, byte[] bArr) {
        super(lf.h("Response code: ", i), iOException, zzfy, AdError.INTERNAL_ERROR_2004, 1);
        this.zzc = i;
    }
}
