package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfyh {
    public static ArrayList zza(int i) {
        zzfwo.zza(i, "initialArraySize");
        return new ArrayList(i);
    }

    public static List zzb(List list, zzful zzful) {
        if (list instanceof RandomAccess) {
            return new zzfye(list, zzful);
        }
        return new zzfyg(list, zzful);
    }
}
