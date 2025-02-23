package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class r implements SQLiteEventStore.Producer {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ AutoCloseable f2810a;

    public /* synthetic */ r(AutoCloseable autoCloseable, int i) {
        this.a = i;
        this.f2810a = autoCloseable;
    }

    public final Object produce() {
        int i = this.a;
        AutoCloseable autoCloseable = this.f2810a;
        switch (i) {
            case 0:
                return ((SchemaManager) autoCloseable).getWritableDatabase();
            default:
                return ((SQLiteDatabase) autoCloseable).beginTransaction();
        }
    }
}
