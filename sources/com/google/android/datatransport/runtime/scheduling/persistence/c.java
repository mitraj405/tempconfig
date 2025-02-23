package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class c implements SQLiteEventStore.Function {
    public final /* synthetic */ SQLiteEventStore a;

    public /* synthetic */ c(SQLiteEventStore sQLiteEventStore) {
        this.a = sQLiteEventStore;
    }

    public final Object apply(Object obj) {
        return this.a.lambda$recordFailure$3((Cursor) obj);
    }
}
