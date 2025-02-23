package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class a implements SQLiteEventStore.Function {
    public final /* synthetic */ int a;

    public /* synthetic */ a(int i) {
        this.a = i;
    }

    public final Object apply(Object obj) {
        switch (this.a) {
            case 0:
                return SQLiteEventStore.lambda$clearDb$13((SQLiteDatabase) obj);
            case 1:
                return SQLiteEventStore.lambda$getDb$0((Throwable) obj);
            default:
                return SQLiteEventStore.lambda$ensureBeginTransaction$25((Throwable) obj);
        }
    }
}
