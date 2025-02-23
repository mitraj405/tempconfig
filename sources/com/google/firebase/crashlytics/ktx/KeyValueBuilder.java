package com.google.firebase.crashlytics.ktx;

import com.google.firebase.crashlytics.FirebaseCrashlytics;

/* compiled from: KeyValueBuilder.kt */
public final class KeyValueBuilder {
    private final FirebaseCrashlytics crashlytics;

    public KeyValueBuilder(FirebaseCrashlytics firebaseCrashlytics) {
        C1177ig.f(firebaseCrashlytics, "crashlytics");
        this.crashlytics = firebaseCrashlytics;
    }

    public final void key(String str, boolean z) {
        C1177ig.f(str, "key");
        this.crashlytics.setCustomKey(str, z);
    }

    public final void key(String str, double d) {
        C1177ig.f(str, "key");
        this.crashlytics.setCustomKey(str, d);
    }

    public final void key(String str, float f) {
        C1177ig.f(str, "key");
        this.crashlytics.setCustomKey(str, f);
    }

    public final void key(String str, int i) {
        C1177ig.f(str, "key");
        this.crashlytics.setCustomKey(str, i);
    }

    public final void key(String str, long j) {
        C1177ig.f(str, "key");
        this.crashlytics.setCustomKey(str, j);
    }

    public final void key(String str, String str2) {
        C1177ig.f(str, "key");
        C1177ig.f(str2, "value");
        this.crashlytics.setCustomKey(str, str2);
    }
}
