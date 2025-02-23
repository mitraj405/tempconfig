package com.google.firebase.crashlytics.ktx;

import androidx.annotation.Keep;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Keep
/* compiled from: FirebaseCrashlytics.kt */
public final class FirebaseCrashlyticsKtxRegistrar implements ComponentRegistrar {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* compiled from: FirebaseCrashlytics.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public List<Component<?>> getComponents() {
        return C1477xa.a;
    }
}
