package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.util.List;
import java.util.Map;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class n implements SQLiteEventStore.Function {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ SQLiteEventStore f2805a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Object f2806a;
    public final /* synthetic */ Object b;

    public /* synthetic */ n(SQLiteEventStore sQLiteEventStore, Object obj, Object obj2, int i) {
        this.a = i;
        this.f2805a = sQLiteEventStore;
        this.f2806a = obj;
        this.b = obj2;
    }

    public final Object apply(Object obj) {
        int i = this.a;
        SQLiteEventStore sQLiteEventStore = this.f2805a;
        Object obj2 = this.b;
        Object obj3 = this.f2806a;
        switch (i) {
            case 0:
                return sQLiteEventStore.lambda$loadClientMetrics$19((Map) obj3, (ClientMetrics.Builder) obj2, (Cursor) obj);
            case 1:
                return sQLiteEventStore.lambda$persist$1((EventInternal) obj3, (TransportContext) obj2, (SQLiteDatabase) obj);
            default:
                return sQLiteEventStore.lambda$loadEvents$14((List) obj3, (TransportContext) obj2, (Cursor) obj);
        }
    }
}
