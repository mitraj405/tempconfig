package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfsb extends zzfrz {
    private static zzfsb zzc;

    private zzfsb(Context context) {
        super(context, "paidv1_id", "paidv1_creation_time", "PaidV1LifecycleImpl");
    }

    public static final zzfsb zzj(Context context) {
        zzfsb zzfsb;
        synchronized (zzfsb.class) {
            if (zzc == null) {
                zzc = new zzfsb(context);
            }
            zzfsb = zzc;
        }
        return zzfsb;
    }

    public final zzfry zzh(long j, boolean z) throws IOException {
        zzfry zzb;
        synchronized (zzfsb.class) {
            zzb = zzb((String) null, (String) null, j, z);
        }
        return zzb;
    }

    public final zzfry zzi(String str, String str2, long j, boolean z) throws IOException {
        zzfry zzb;
        synchronized (zzfsb.class) {
            zzb = zzb(str, str2, j, z);
        }
        return zzb;
    }

    public final void zzk() throws IOException {
        synchronized (zzfsb.class) {
            zzf(false);
        }
    }

    public final void zzl() throws IOException {
        synchronized (zzfsb.class) {
            zzf(true);
        }
    }
}
