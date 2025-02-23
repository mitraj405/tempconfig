package org.spongycastle.jcajce.provider.asymmetric.util;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;

public class PrimeCertaintyCalculator {
    private PrimeCertaintyCalculator() {
    }

    public static int a(int i) {
        if (i <= 1024) {
            return 80;
        }
        return (((i - 1) / UserMetadata.MAX_ATTRIBUTE_SIZE) * 16) + 96;
    }
}
