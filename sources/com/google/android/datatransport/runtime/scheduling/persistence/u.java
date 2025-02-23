package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class u implements SchemaManager.Migration {
    public final /* synthetic */ int a;

    public /* synthetic */ u(int i) {
        this.a = i;
    }

    public final void upgrade(SQLiteDatabase sQLiteDatabase) {
        switch (this.a) {
            case 0:
                sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
                return;
            default:
                SchemaManager.lambda$static$6(sQLiteDatabase);
                return;
        }
    }
}
