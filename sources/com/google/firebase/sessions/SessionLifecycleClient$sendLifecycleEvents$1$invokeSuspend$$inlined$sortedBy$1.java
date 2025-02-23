package com.google.firebase.sessions;

import android.os.Message;
import java.util.Comparator;

/* compiled from: Comparisons.kt */
public final class SessionLifecycleClient$sendLifecycleEvents$1$invokeSuspend$$inlined$sortedBy$1<T> implements Comparator {
    public final int compare(T t, T t2) {
        Long valueOf = Long.valueOf(((Message) t).getWhen());
        Long valueOf2 = Long.valueOf(((Message) t2).getWhen());
        if (valueOf == valueOf2) {
            return 0;
        }
        if (valueOf == null) {
            return -1;
        }
        if (valueOf2 == null) {
            return 1;
        }
        return valueOf.compareTo(valueOf2);
    }
}
