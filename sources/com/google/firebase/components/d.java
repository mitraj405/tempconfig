package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.Collections;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class d implements Provider {
    public final /* synthetic */ int a;

    public /* synthetic */ d(int i) {
        this.a = i;
    }

    public final Object get() {
        switch (this.a) {
            case 0:
                return OptionalProvider.lambda$static$1();
            default:
                return Collections.emptySet();
        }
    }
}
