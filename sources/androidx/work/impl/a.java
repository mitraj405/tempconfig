package androidx.work.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;

/* compiled from: WorkDatabaseMigrations */
public final class a {
    public static final C0028a a = new C0028a();

    /* renamed from: a  reason: collision with other field name */
    public static final b f2659a = new b();

    /* renamed from: a  reason: collision with other field name */
    public static final c f2660a = new c();

    /* renamed from: a  reason: collision with other field name */
    public static final d f2661a = new d();

    /* renamed from: a  reason: collision with other field name */
    public static final e f2662a = new e();

    /* renamed from: a  reason: collision with other field name */
    public static final f f2663a = new f();

    /* renamed from: a  reason: collision with other field name */
    public static final g f2664a = new g();

    /* renamed from: androidx.work.impl.a$a  reason: collision with other inner class name */
    /* compiled from: WorkDatabaseMigrations */
    public class C0028a extends pl {
        public C0028a() {
            super(1, 2);
        }

        public final void a(C0408yd ydVar) {
            ydVar.c("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            ydVar.c("INSERT INTO SystemIdInfo(work_spec_id, system_id) SELECT work_spec_id, alarm_id AS system_id FROM alarmInfo");
            ydVar.c("DROP TABLE IF EXISTS alarmInfo");
            ydVar.c("INSERT OR IGNORE INTO worktag(tag, work_spec_id) SELECT worker_class_name AS tag, id AS work_spec_id FROM workspec");
        }
    }

    /* compiled from: WorkDatabaseMigrations */
    public class b extends pl {
        public b() {
            super(3, 4);
        }

        public final void a(C0408yd ydVar) {
            ydVar.c("UPDATE workspec SET schedule_requested_at=0 WHERE state NOT IN (2, 3, 5) AND schedule_requested_at=-1 AND interval_duration<>0");
        }
    }

    /* compiled from: WorkDatabaseMigrations */
    public class c extends pl {
        public c() {
            super(4, 5);
        }

        public final void a(C0408yd ydVar) {
            ydVar.c("ALTER TABLE workspec ADD COLUMN `trigger_content_update_delay` INTEGER NOT NULL DEFAULT -1");
            ydVar.c("ALTER TABLE workspec ADD COLUMN `trigger_max_content_delay` INTEGER NOT NULL DEFAULT -1");
        }
    }

    /* compiled from: WorkDatabaseMigrations */
    public class d extends pl {
        public d() {
            super(6, 7);
        }

        public final void a(C0408yd ydVar) {
            ydVar.c("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        }
    }

    /* compiled from: WorkDatabaseMigrations */
    public class e extends pl {
        public e() {
            super(7, 8);
        }

        public final void a(C0408yd ydVar) {
            ydVar.c("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `workspec` (`period_start_time`)");
        }
    }

    /* compiled from: WorkDatabaseMigrations */
    public class f extends pl {
        public f() {
            super(8, 9);
        }

        public final void a(C0408yd ydVar) {
            ydVar.c("ALTER TABLE workspec ADD COLUMN `run_in_foreground` INTEGER NOT NULL DEFAULT 0");
        }
    }

    /* compiled from: WorkDatabaseMigrations */
    public class g extends pl {
        public g() {
            super(11, 12);
        }

        public final void a(C0408yd ydVar) {
            ydVar.c("ALTER TABLE workspec ADD COLUMN `out_of_quota_policy` INTEGER NOT NULL DEFAULT 0");
        }
    }

    /* compiled from: WorkDatabaseMigrations */
    public static class h extends pl {
        public final Context a;

        public h(Context context, int i, int i2) {
            super(i, i2);
            this.a = context;
        }

        public final void a(C0408yd ydVar) {
            if (this.b >= 10) {
                ydVar.f3431a.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", 1});
                return;
            }
            this.a.getSharedPreferences("androidx.work.util.preferences", 0).edit().putBoolean("reschedule_needed", true).apply();
        }
    }

    /* compiled from: WorkDatabaseMigrations */
    public static class i extends pl {
        public final Context a;

        public i(Context context) {
            super(9, 10);
            this.a = context;
        }

        public final void a(C0408yd ydVar) {
            ydVar.c("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
            Context context = this.a;
            SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.preferences", 0);
            boolean contains = sharedPreferences.contains("reschedule_needed");
            SQLiteDatabase sQLiteDatabase = ydVar.f3431a;
            if (contains || sharedPreferences.contains("last_cancel_all_time_ms")) {
                long j = 0;
                long j2 = sharedPreferences.getLong("last_cancel_all_time_ms", 0);
                if (sharedPreferences.getBoolean("reschedule_needed", false)) {
                    j = 1;
                }
                ydVar.a();
                try {
                    sQLiteDatabase.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"last_cancel_all_time_ms", Long.valueOf(j2)});
                    sQLiteDatabase.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", Long.valueOf(j)});
                    sharedPreferences.edit().clear().apply();
                    ydVar.j();
                } finally {
                    ydVar.b();
                }
            }
            SharedPreferences sharedPreferences2 = context.getSharedPreferences("androidx.work.util.id", 0);
            if (sharedPreferences2.contains("next_job_scheduler_id") || sharedPreferences2.contains("next_job_scheduler_id")) {
                int i = sharedPreferences2.getInt("next_job_scheduler_id", 0);
                int i2 = sharedPreferences2.getInt("next_alarm_manager_id", 0);
                ydVar.a();
                try {
                    sQLiteDatabase.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_job_scheduler_id", Integer.valueOf(i)});
                    sQLiteDatabase.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"next_alarm_manager_id", Integer.valueOf(i2)});
                    sharedPreferences2.edit().clear().apply();
                    ydVar.j();
                } finally {
                    ydVar.b();
                }
            }
        }
    }
}
