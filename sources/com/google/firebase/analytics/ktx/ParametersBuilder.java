package com.google.firebase.analytics.ktx;

import android.os.Bundle;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-measurement-api@@22.0.2 */
public final class ParametersBuilder {
    private final Bundle zza = new Bundle();

    public final Bundle getBundle() {
        return this.zza;
    }

    public final void param(String str, double d) {
        C1177ig.f(str, "key");
        this.zza.putDouble(str, d);
    }

    public final void param(String str, long j) {
        C1177ig.f(str, "key");
        this.zza.putLong(str, j);
    }

    public final void param(String str, Bundle bundle) {
        C1177ig.f(str, "key");
        C1177ig.f(bundle, "value");
        this.zza.putBundle(str, bundle);
    }

    public final void param(String str, String str2) {
        C1177ig.f(str, "key");
        C1177ig.f(str2, "value");
        this.zza.putString(str, str2);
    }

    public final void param(String str, Bundle[] bundleArr) {
        C1177ig.f(str, "key");
        C1177ig.f(bundleArr, "value");
        this.zza.putParcelableArray(str, (Parcelable[]) bundleArr);
    }
}
