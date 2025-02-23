package com.google.android.gms.internal.ads;

import android.system.ErrnoException;
import android.system.OsConstants;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzgh {
    /* access modifiers changed from: private */
    public static boolean zzb(Throwable th) {
        if (!(th instanceof ErrnoException) || ((ErrnoException) th).errno != OsConstants.EACCES) {
            return false;
        }
        return true;
    }
}
