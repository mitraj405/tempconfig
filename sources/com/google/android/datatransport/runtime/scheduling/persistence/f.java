package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class f implements SQLiteEventStore.Function {
    public final /* synthetic */ long a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ SQLiteEventStore f2799a;

    public /* synthetic */ f(SQLiteEventStore sQLiteEventStore, long j) {
        this.f2799a = sQLiteEventStore;
        this.a = j;
    }

    public final Object apply(Object obj) {
        return this.f2799a.lambda$cleanUp$12(this.a, (SQLiteDatabase) obj);
    }
}
