package com.google.firebase.crashlytics.internal.send;

import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class a implements TransportScheduleCallback {
    public final /* synthetic */ TaskCompletionSource a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ CrashlyticsReportWithSessionId f2844a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ReportQueue f2845a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f2846a;

    public /* synthetic */ a(ReportQueue reportQueue, TaskCompletionSource taskCompletionSource, boolean z, CrashlyticsReportWithSessionId crashlyticsReportWithSessionId) {
        this.f2845a = reportQueue;
        this.a = taskCompletionSource;
        this.f2846a = z;
        this.f2844a = crashlyticsReportWithSessionId;
    }

    public final void onSchedule(Exception exc) {
        this.f2845a.lambda$sendReport$1(this.a, this.f2846a, this.f2844a, exc);
    }
}
