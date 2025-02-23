package com.google.firebase.crashlytics.internal.send;

import java.util.concurrent.CountDownLatch;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ ReportQueue a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ CountDownLatch f2847a;

    public /* synthetic */ b(ReportQueue reportQueue, CountDownLatch countDownLatch) {
        this.a = reportQueue;
        this.f2847a = countDownLatch;
    }

    public final void run() {
        this.a.lambda$flushScheduledReportsIfAble$0(this.f2847a);
    }
}
