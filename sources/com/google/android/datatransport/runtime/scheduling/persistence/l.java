package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.util.HashMap;
import java.util.Map;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class l implements SQLiteEventStore.Function {
    public final /* synthetic */ ClientMetrics.Builder a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ SQLiteEventStore f2803a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Map f2804a;

    public /* synthetic */ l(SQLiteEventStore sQLiteEventStore, HashMap hashMap, ClientMetrics.Builder builder) {
        this.f2803a = sQLiteEventStore;
        this.f2804a = hashMap;
        this.a = builder;
    }

    public final Object apply(Object obj) {
        Map map = this.f2804a;
        return this.f2803a.lambda$loadClientMetrics$20("SELECT log_source, reason, events_dropped_count FROM log_event_dropped", map, this.a, (SQLiteDatabase) obj);
    }
}
