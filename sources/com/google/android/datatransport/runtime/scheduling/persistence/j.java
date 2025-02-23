package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.util.Map;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class j implements SQLiteEventStore.Function {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Object f2802a;

    public /* synthetic */ j(Object obj, int i) {
        this.a = i;
        this.f2802a = obj;
    }

    public final Object apply(Object obj) {
        int i = this.a;
        Object obj2 = this.f2802a;
        switch (i) {
            case 0:
                return SQLiteEventStore.lambda$loadMetadata$16((Map) obj2, (Cursor) obj);
            default:
                return ((SQLiteEventStore) obj2).lambda$cleanUp$11((Cursor) obj);
        }
    }
}
