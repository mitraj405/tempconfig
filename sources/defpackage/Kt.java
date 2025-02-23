package defpackage;

import android.os.Process;

/* renamed from: Kt  reason: default package */
/* compiled from: RestErrorHandler */
public final class Kt implements Runnable {
    public final void run() {
        Process.killProcess(Process.myPid());
    }
}
