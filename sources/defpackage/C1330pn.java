package defpackage;

import java.util.concurrent.ThreadFactory;

/* renamed from: pn  reason: default package and case insensitive filesystem */
/* compiled from: OSTaskManager */
public final class C1330pn implements ThreadFactory {
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName("OS_PENDING_EXECUTOR_" + thread.getId());
        return thread;
    }
}
