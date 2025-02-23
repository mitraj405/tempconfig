package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class g implements SQLiteEventStore.Function {
    public final /* synthetic */ TransportContext a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ SQLiteEventStore f2800a;

    public /* synthetic */ g(SQLiteEventStore sQLiteEventStore, TransportContext transportContext) {
        this.f2800a = sQLiteEventStore;
        this.a = transportContext;
    }

    public final Object apply(Object obj) {
        return this.f2800a.lambda$loadBatch$8(this.a, (SQLiteDatabase) obj);
    }
}
