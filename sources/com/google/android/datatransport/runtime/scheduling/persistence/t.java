package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class t implements SchemaManager.Migration {
    public final /* synthetic */ int a;

    public /* synthetic */ t(int i) {
        this.a = i;
    }

    public final void upgrade(SQLiteDatabase sQLiteDatabase) {
        switch (this.a) {
            case 0:
                SchemaManager.lambda$static$1(sQLiteDatabase);
                return;
            default:
                sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN product_id INTEGER");
                return;
        }
    }
}
