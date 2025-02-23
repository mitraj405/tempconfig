package com.google.android.ump;

import androidx.annotation.RecentlyNonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.google.android.ump:user-messaging-platform@@3.0.0 */
public class FormError {
    private final int zza;
    private final String zzb;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.ump:user-messaging-platform@@3.0.0 */
    public @interface ErrorCode {
        public static final int INTERNAL_ERROR = 1;
        public static final int INTERNET_ERROR = 2;
        public static final int INVALID_OPERATION = 3;
        public static final int TIME_OUT = 4;
    }

    public FormError(int i, @RecentlyNonNull String str) {
        this.zza = i;
        this.zzb = str;
    }

    public int getErrorCode() {
        return this.zza;
    }

    @RecentlyNonNull
    public String getMessage() {
        return this.zzb;
    }
}
