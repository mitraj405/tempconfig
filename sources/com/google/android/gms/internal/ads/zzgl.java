package com.google.android.gms.internal.ads;

import com.facebook.ads.AdError;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public class zzgl extends zzft {
    public final int zzb;

    public zzgl(zzfy zzfy, int i, int i2) {
        super(zzb(AdError.REMOTE_ADS_SERVICE_ERROR, 1));
        this.zzb = 1;
    }

    public static zzgl zza(IOException iOException, zzfy zzfy, int i) {
        int i2;
        String message = iOException.getMessage();
        if (iOException instanceof SocketTimeoutException) {
            i2 = AdError.CACHE_ERROR_CODE;
        } else if (iOException instanceof InterruptedIOException) {
            i2 = 1004;
        } else if (message == null || !zzfuf.zza(message).matches("cleartext.*not permitted.*")) {
            i2 = 2001;
        } else {
            i2 = 2007;
        }
        if (i2 == 2007) {
            return new zzgk(iOException, zzfy);
        }
        return new zzgl(iOException, zzfy, i2, i);
    }

    private static int zzb(int i, int i2) {
        if (i != 2000) {
            return i;
        }
        if (i2 != 1) {
            return 2000;
        }
        return AdError.INTERNAL_ERROR_CODE;
    }

    public zzgl(IOException iOException, zzfy zzfy, int i, int i2) {
        super((Throwable) iOException, zzb(i, i2));
        this.zzb = i2;
    }

    public zzgl(String str, zzfy zzfy, int i, int i2) {
        super(str, zzb(i, i2));
        this.zzb = i2;
    }

    public zzgl(String str, IOException iOException, zzfy zzfy, int i, int i2) {
        super(str, iOException, zzb(i, i2));
        this.zzb = i2;
    }
}
