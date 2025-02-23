package com.google.android.gms.common.internal;

import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.errorprone.annotations.FormatMethod;
import com.google.errorprone.annotations.FormatString;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
public final class GmsLogger {
    private final String zza;
    private final String zzb;

    @KeepForSdk
    public GmsLogger(String str) {
        this(str, (String) null);
    }

    private final String zza(String str) {
        String str2 = this.zzb;
        if (str2 == null) {
            return str;
        }
        return str2.concat(str);
    }

    @FormatMethod
    private final String zzb(String str, Object... objArr) {
        String str2 = this.zzb;
        String format = String.format(str, objArr);
        if (str2 == null) {
            return format;
        }
        return str2.concat(format);
    }

    @KeepForSdk
    public boolean canLog(int i) {
        return Log.isLoggable(this.zza, i);
    }

    @KeepForSdk
    public boolean canLogPii() {
        return false;
    }

    @KeepForSdk
    public void d(String str, String str2) {
        if (canLog(3)) {
            zza(str2);
        }
    }

    @KeepForSdk
    public void e(String str, String str2) {
        if (canLog(6)) {
            zza(str2);
        }
    }

    @FormatMethod
    @KeepForSdk
    public void efmt(String str, @FormatString String str2, Object... objArr) {
        if (canLog(6)) {
            zzb(str2, objArr);
        }
    }

    @KeepForSdk
    public void i(String str, String str2) {
        if (canLog(4)) {
            zza(str2);
        }
    }

    @KeepForSdk
    public void pii(String str, String str2) {
    }

    @KeepForSdk
    public void v(String str, String str2) {
        if (canLog(2)) {
            zza(str2);
        }
    }

    @KeepForSdk
    public void w(String str, String str2) {
        if (canLog(5)) {
            zza(str2);
        }
    }

    @FormatMethod
    @KeepForSdk
    public void wfmt(String str, @FormatString String str2, Object... objArr) {
        if (canLog(5)) {
            zzb(str2, objArr);
        }
    }

    @KeepForSdk
    public void wtf(String str, String str2, Throwable th) {
        if (canLog(7)) {
            zza(str2);
            zza(str2);
        }
    }

    @KeepForSdk
    public GmsLogger(String str, String str2) {
        Preconditions.checkNotNull(str, "log tag cannot be null");
        Preconditions.checkArgument(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.zza = str;
        this.zzb = (str2 == null || str2.length() <= 0) ? null : str2;
    }

    @KeepForSdk
    public void pii(String str, String str2, Throwable th) {
    }

    @KeepForSdk
    public void d(String str, String str2, Throwable th) {
        if (canLog(3)) {
            zza(str2);
        }
    }

    @KeepForSdk
    public void e(String str, String str2, Throwable th) {
        if (canLog(6)) {
            zza(str2);
        }
    }

    @KeepForSdk
    public void i(String str, String str2, Throwable th) {
        if (canLog(4)) {
            zza(str2);
        }
    }

    @KeepForSdk
    public void v(String str, String str2, Throwable th) {
        if (canLog(2)) {
            zza(str2);
        }
    }

    @KeepForSdk
    public void w(String str, String str2, Throwable th) {
        if (canLog(5)) {
            zza(str2);
        }
    }
}
