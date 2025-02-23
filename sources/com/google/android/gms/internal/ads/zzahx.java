package com.google.android.gms.internal.ads;

import com.google.firebase.perf.util.Constants;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
class zzahx {
    public final int zzd;

    public zzahx(int i) {
        this.zzd = i;
    }

    public static int zze(int i) {
        return (i >> 24) & Constants.MAX_HOST_LENGTH;
    }

    public static String zzf(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append((char) ((i >> 24) & Constants.MAX_HOST_LENGTH));
        sb.append((char) ((i >> 16) & Constants.MAX_HOST_LENGTH));
        sb.append((char) ((i >> 8) & Constants.MAX_HOST_LENGTH));
        sb.append((char) (i & Constants.MAX_HOST_LENGTH));
        return sb.toString();
    }

    public String toString() {
        return zzf(this.zzd);
    }
}
