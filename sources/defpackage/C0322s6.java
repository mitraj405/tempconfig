package defpackage;

import java.util.concurrent.ThreadFactory;

/* renamed from: s6  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0322s6 implements ThreadFactory {
    public final /* synthetic */ String c;

    public /* synthetic */ C0322s6(String str) {
        this.c = str;
    }

    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.c);
        thread.setPriority(10);
        return thread;
    }
}
