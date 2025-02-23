package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.view.InputEvent;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeep {
    private MeasurementManagerFutures zza;
    private final Context zzb;

    public zzeep(Context context) {
        this.zzb = context;
    }

    public final ListenableFuture zza() {
        try {
            MeasurementManagerFutures.a a = MeasurementManagerFutures.a(this.zzb);
            this.zza = a;
            if (a == null) {
                return zzgcj.zzg(new IllegalStateException("MeasurementManagerFutures is null"));
            }
            return a.b();
        } catch (Exception e) {
            return zzgcj.zzg(e);
        }
    }

    public final ListenableFuture zzb(Uri uri, InputEvent inputEvent) {
        try {
            MeasurementManagerFutures measurementManagerFutures = this.zza;
            Objects.requireNonNull(measurementManagerFutures);
            return measurementManagerFutures.c(uri, inputEvent);
        } catch (Exception e) {
            return zzgcj.zzg(e);
        }
    }
}
