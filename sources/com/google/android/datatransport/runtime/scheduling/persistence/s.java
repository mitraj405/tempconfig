package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class s implements SchemaManager.Migration {
    public final /* synthetic */ int a;

    public /* synthetic */ s(int i) {
        this.a = i;
    }

    public final void upgrade(SQLiteDatabase sQLiteDatabase) {
        switch (this.a) {
            case 0:
                SchemaManager.lambda$static$0(sQLiteDatabase);
                return;
            default:
                SchemaManager.lambda$static$4(sQLiteDatabase);
                return;
        }
    }
}
