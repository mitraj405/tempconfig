package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
public class ApiExceptionMapper implements StatusExceptionMapper {
    public final Exception getException(Status status) {
        return ApiExceptionUtil.fromStatus(status);
    }
}
