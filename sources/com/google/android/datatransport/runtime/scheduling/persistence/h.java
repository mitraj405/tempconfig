package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class h implements SQLiteEventStore.Function {
    public final /* synthetic */ SQLiteEventStore a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f2801a;

    public /* synthetic */ h(SQLiteEventStore sQLiteEventStore, String str) {
        this.a = sQLiteEventStore;
        this.f2801a = str;
    }

    public final Object apply(Object obj) {
        return this.a.lambda$recordFailure$4(this.f2801a, "SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name", (SQLiteDatabase) obj);
    }
}
