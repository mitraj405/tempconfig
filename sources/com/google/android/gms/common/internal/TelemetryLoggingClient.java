package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
public interface TelemetryLoggingClient extends HasApiKey<TelemetryLoggingOptions> {
    @KeepForSdk
    Task<Void> log(TelemetryData telemetryData);
}
