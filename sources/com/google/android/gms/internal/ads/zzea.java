package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import android.util.Log;
import java.net.UnknownHostException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzea {
    private static final Object zza = new Object();

    public static String zza(String str, Throwable th) {
        String str2;
        if (th != null) {
            synchronized (zza) {
                Throwable th2 = th;
                while (true) {
                    if (th2 == null) {
                        str2 = Log.getStackTraceString(th).trim().replace("\t", "    ");
                        break;
                    } else if (th2 instanceof UnknownHostException) {
                        str2 = "UnknownHostException (no network)";
                        break;
                    } else {
                        th2 = th2.getCause();
                    }
                }
            }
        } else {
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        String replace = str2.replace("\n", "\n  ");
        return str + "\n  " + replace + "\n";
    }

    public static void zzb(String str, String str2) {
        synchronized (zza) {
            zza(str2, (Throwable) null);
        }
    }

    public static void zzc(String str, String str2) {
        synchronized (zza) {
            zza(str2, (Throwable) null);
        }
    }

    public static void zzd(String str, String str2, Throwable th) {
        synchronized (zza) {
            zza(str2, th);
        }
    }

    public static void zze(String str, String str2) {
        synchronized (zza) {
            zza(str2, (Throwable) null);
        }
    }

    public static void zzf(String str, String str2) {
        synchronized (zza) {
            zza(str2, (Throwable) null);
        }
    }

    public static void zzg(String str, String str2, Throwable th) {
        synchronized (zza) {
            zza(str2, th);
        }
    }
}
