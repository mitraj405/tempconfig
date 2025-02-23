package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdRequest;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzanq {
    public final int zza;
    public final String zzb;
    public final int zzc;
    public final List zzd;
    public final byte[] zze;

    public zzanq(int i, String str, int i2, List list, byte[] bArr) {
        List list2;
        this.zza = i;
        this.zzb = str;
        this.zzc = i2;
        if (list == null) {
            list2 = Collections.emptyList();
        } else {
            list2 = Collections.unmodifiableList(list);
        }
        this.zzd = list2;
        this.zze = bArr;
    }

    public final int zza() {
        int i = this.zzc;
        if (i == 2) {
            return 2048;
        }
        if (i != 3) {
            return 0;
        }
        return AdRequest.MAX_CONTENT_URL_LENGTH;
    }
}
