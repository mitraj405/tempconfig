package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class b implements SQLiteEventStore.Function {
    public final /* synthetic */ int a;

    public /* synthetic */ b(int i) {
        this.a = i;
    }

    public final Object apply(Object obj) {
        switch (this.a) {
            case 0:
                return SQLiteEventStore.lambda$getNextCallTime$5((Cursor) obj);
            default:
                return Boolean.valueOf(((Cursor) obj).moveToNext());
        }
    }
}
