package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class o implements SQLiteEventStore.Function {
    public final /* synthetic */ int a;

    public /* synthetic */ o(int i) {
        this.a = i;
    }

    public final Object apply(Object obj) {
        switch (this.a) {
            case 0:
                return SQLiteEventStore.lambda$recordLogEventDropped$17((Cursor) obj);
            case 1:
                return SQLiteEventStore.lambda$loadActiveContexts$9((Cursor) obj);
            default:
                return SQLiteEventStore.lambda$getTransportContextId$2((Cursor) obj);
        }
    }
}
