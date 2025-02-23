package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class k implements SQLiteEventStore.Function {
    public final /* synthetic */ int a;

    public /* synthetic */ k(int i) {
        this.a = i;
    }

    public final Object apply(Object obj) {
        switch (this.a) {
            case 0:
                return SQLiteEventStore.lambda$readPayload$15((Cursor) obj);
            default:
                return SQLiteEventStore.lambda$loadActiveContexts$10((SQLiteDatabase) obj);
        }
    }
}
