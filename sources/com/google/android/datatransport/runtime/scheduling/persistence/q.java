package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class q implements SQLiteEventStore.Function {
    public final /* synthetic */ long a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ LogEventDropped.Reason f2808a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f2809a;

    public /* synthetic */ q(long j, LogEventDropped.Reason reason, String str) {
        this.f2809a = str;
        this.f2808a = reason;
        this.a = j;
    }

    public final Object apply(Object obj) {
        return SQLiteEventStore.lambda$recordLogEventDropped$18(this.f2809a, this.f2808a, this.a, (SQLiteDatabase) obj);
    }
}
