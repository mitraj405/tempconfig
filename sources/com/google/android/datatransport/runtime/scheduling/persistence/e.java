package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class e implements SQLiteEventStore.Function {
    public final /* synthetic */ SQLiteEventStore a;

    public /* synthetic */ e(SQLiteEventStore sQLiteEventStore) {
        this.a = sQLiteEventStore;
    }

    public final Object apply(Object obj) {
        return this.a.lambda$resetClientMetrics$23((SQLiteDatabase) obj);
    }
}
