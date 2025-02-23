package com.google.common.escape;

import com.google.common.annotations.GwtCompatible;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
final class Platform {
    private static final ThreadLocal<char[]> DEST_TL = new ThreadLocal<char[]>() {
        public char[] initialValue() {
            return new char[UserMetadata.MAX_ATTRIBUTE_SIZE];
        }
    };

    private Platform() {
    }

    public static char[] charBufferFromThreadLocal() {
        return DEST_TL.get();
    }
}
