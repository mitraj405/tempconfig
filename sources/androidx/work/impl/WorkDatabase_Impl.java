package androidx.work.impl;

import android.content.Context;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import defpackage.Ly;
import defpackage.au;
import defpackage.rz;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public final class WorkDatabase_Impl extends WorkDatabase {
    public static final /* synthetic */ int b = 0;
    public volatile L8 a;

    /* renamed from: a  reason: collision with other field name */
    public volatile ZD f2653a;

    /* renamed from: a  reason: collision with other field name */
    public volatile C0137aq f2654a;

    /* renamed from: a  reason: collision with other field name */
    public volatile bz f2655a;

    /* renamed from: a  reason: collision with other field name */
    public volatile C0157cE f2656a;

    /* renamed from: a  reason: collision with other field name */
    public volatile C0236jE f2657a;

    /* renamed from: a  reason: collision with other field name */
    public volatile mE f2658a;

    public class a extends au.a {
        public a() {
        }

        public final void a(C0408yd ydVar) {
            ydVar.c("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            ydVar.c("CREATE INDEX IF NOT EXISTS `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
            ydVar.c("CREATE INDEX IF NOT EXISTS `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
            ydVar.c("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `period_start_time` INTEGER NOT NULL, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `out_of_quota_policy` INTEGER NOT NULL, `required_network_type` INTEGER, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB, PRIMARY KEY(`id`))");
            ydVar.c("CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
            ydVar.c("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `WorkSpec` (`period_start_time`)");
            ydVar.c("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            ydVar.c("CREATE INDEX IF NOT EXISTS `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
            ydVar.c("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            ydVar.c("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            ydVar.c("CREATE INDEX IF NOT EXISTS `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
            ydVar.c("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            ydVar.c("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
            ydVar.c("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            ydVar.c("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c103703e120ae8cc73c9248622f3cd1e')");
        }

        public final au.b b(C0408yd ydVar) {
            C0408yd ydVar2 = ydVar;
            HashMap hashMap = new HashMap(2);
            hashMap.put("work_spec_id", new rz.a(1, "work_spec_id", "TEXT", (String) null, true, 1));
            hashMap.put("prerequisite_id", new rz.a(2, "prerequisite_id", "TEXT", (String) null, true, 1));
            HashSet hashSet = new HashSet(2);
            hashSet.add(new rz.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{FacebookMediationAdapter.KEY_ID})));
            hashSet.add(new rz.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"prerequisite_id"}), Arrays.asList(new String[]{FacebookMediationAdapter.KEY_ID})));
            HashSet hashSet2 = new HashSet(2);
            hashSet2.add(new rz.d(Arrays.asList(new String[]{"work_spec_id"}), "index_Dependency_work_spec_id", false));
            hashSet2.add(new rz.d(Arrays.asList(new String[]{"prerequisite_id"}), "index_Dependency_prerequisite_id", false));
            rz rzVar = new rz("Dependency", hashMap, hashSet, hashSet2);
            rz a2 = rz.a(ydVar2, "Dependency");
            if (!rzVar.equals(a2)) {
                return new au.b("Dependency(androidx.work.impl.model.Dependency).\n Expected:\n" + rzVar + "\n Found:\n" + a2, false);
            }
            HashMap hashMap2 = new HashMap(25);
            hashMap2.put(FacebookMediationAdapter.KEY_ID, new rz.a(1, FacebookMediationAdapter.KEY_ID, "TEXT", (String) null, true, 1));
            hashMap2.put(RemoteConfigConstants.ResponseFieldKey.STATE, new rz.a(0, RemoteConfigConstants.ResponseFieldKey.STATE, "INTEGER", (String) null, true, 1));
            hashMap2.put("worker_class_name", new rz.a(0, "worker_class_name", "TEXT", (String) null, true, 1));
            hashMap2.put("input_merger_class_name", new rz.a(0, "input_merger_class_name", "TEXT", (String) null, false, 1));
            hashMap2.put("input", new rz.a(0, "input", "BLOB", (String) null, true, 1));
            hashMap2.put("output", new rz.a(0, "output", "BLOB", (String) null, true, 1));
            hashMap2.put("initial_delay", new rz.a(0, "initial_delay", "INTEGER", (String) null, true, 1));
            hashMap2.put("interval_duration", new rz.a(0, "interval_duration", "INTEGER", (String) null, true, 1));
            hashMap2.put("flex_duration", new rz.a(0, "flex_duration", "INTEGER", (String) null, true, 1));
            hashMap2.put("run_attempt_count", new rz.a(0, "run_attempt_count", "INTEGER", (String) null, true, 1));
            hashMap2.put("backoff_policy", new rz.a(0, "backoff_policy", "INTEGER", (String) null, true, 1));
            hashMap2.put("backoff_delay_duration", new rz.a(0, "backoff_delay_duration", "INTEGER", (String) null, true, 1));
            hashMap2.put("period_start_time", new rz.a(0, "period_start_time", "INTEGER", (String) null, true, 1));
            hashMap2.put("minimum_retention_duration", new rz.a(0, "minimum_retention_duration", "INTEGER", (String) null, true, 1));
            hashMap2.put("schedule_requested_at", new rz.a(0, "schedule_requested_at", "INTEGER", (String) null, true, 1));
            hashMap2.put("run_in_foreground", new rz.a(0, "run_in_foreground", "INTEGER", (String) null, true, 1));
            hashMap2.put("out_of_quota_policy", new rz.a(0, "out_of_quota_policy", "INTEGER", (String) null, true, 1));
            hashMap2.put("required_network_type", new rz.a(0, "required_network_type", "INTEGER", (String) null, false, 1));
            hashMap2.put("requires_charging", new rz.a(0, "requires_charging", "INTEGER", (String) null, true, 1));
            hashMap2.put("requires_device_idle", new rz.a(0, "requires_device_idle", "INTEGER", (String) null, true, 1));
            hashMap2.put("requires_battery_not_low", new rz.a(0, "requires_battery_not_low", "INTEGER", (String) null, true, 1));
            hashMap2.put("requires_storage_not_low", new rz.a(0, "requires_storage_not_low", "INTEGER", (String) null, true, 1));
            hashMap2.put("trigger_content_update_delay", new rz.a(0, "trigger_content_update_delay", "INTEGER", (String) null, true, 1));
            hashMap2.put("trigger_max_content_delay", new rz.a(0, "trigger_max_content_delay", "INTEGER", (String) null, true, 1));
            hashMap2.put("content_uri_triggers", new rz.a(0, "content_uri_triggers", "BLOB", (String) null, false, 1));
            HashSet hashSet3 = new HashSet(0);
            HashSet hashSet4 = new HashSet(2);
            hashSet4.add(new rz.d(Arrays.asList(new String[]{"schedule_requested_at"}), "index_WorkSpec_schedule_requested_at", false));
            hashSet4.add(new rz.d(Arrays.asList(new String[]{"period_start_time"}), "index_WorkSpec_period_start_time", false));
            rz rzVar2 = new rz("WorkSpec", hashMap2, hashSet3, hashSet4);
            rz a3 = rz.a(ydVar2, "WorkSpec");
            if (!rzVar2.equals(a3)) {
                return new au.b("WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n" + rzVar2 + "\n Found:\n" + a3, false);
            }
            HashMap hashMap3 = new HashMap(2);
            hashMap3.put("tag", new rz.a(1, "tag", "TEXT", (String) null, true, 1));
            hashMap3.put("work_spec_id", new rz.a(2, "work_spec_id", "TEXT", (String) null, true, 1));
            HashSet hashSet5 = new HashSet(1);
            hashSet5.add(new rz.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{FacebookMediationAdapter.KEY_ID})));
            HashSet hashSet6 = new HashSet(1);
            hashSet6.add(new rz.d(Arrays.asList(new String[]{"work_spec_id"}), "index_WorkTag_work_spec_id", false));
            rz rzVar3 = new rz("WorkTag", hashMap3, hashSet5, hashSet6);
            rz a4 = rz.a(ydVar2, "WorkTag");
            if (!rzVar3.equals(a4)) {
                return new au.b("WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n" + rzVar3 + "\n Found:\n" + a4, false);
            }
            HashMap hashMap4 = new HashMap(2);
            hashMap4.put("work_spec_id", new rz.a(1, "work_spec_id", "TEXT", (String) null, true, 1));
            hashMap4.put("system_id", new rz.a(0, "system_id", "INTEGER", (String) null, true, 1));
            HashSet hashSet7 = new HashSet(1);
            hashSet7.add(new rz.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{FacebookMediationAdapter.KEY_ID})));
            rz rzVar4 = new rz("SystemIdInfo", hashMap4, hashSet7, new HashSet(0));
            rz a5 = rz.a(ydVar2, "SystemIdInfo");
            if (!rzVar4.equals(a5)) {
                return new au.b("SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n" + rzVar4 + "\n Found:\n" + a5, false);
            }
            HashMap hashMap5 = new HashMap(2);
            hashMap5.put(AppMeasurementSdk.ConditionalUserProperty.NAME, new rz.a(1, AppMeasurementSdk.ConditionalUserProperty.NAME, "TEXT", (String) null, true, 1));
            hashMap5.put("work_spec_id", new rz.a(2, "work_spec_id", "TEXT", (String) null, true, 1));
            HashSet hashSet8 = new HashSet(1);
            hashSet8.add(new rz.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{FacebookMediationAdapter.KEY_ID})));
            HashSet hashSet9 = new HashSet(1);
            hashSet9.add(new rz.d(Arrays.asList(new String[]{"work_spec_id"}), "index_WorkName_work_spec_id", false));
            rz rzVar5 = new rz("WorkName", hashMap5, hashSet8, hashSet9);
            rz a6 = rz.a(ydVar2, "WorkName");
            if (!rzVar5.equals(a6)) {
                return new au.b("WorkName(androidx.work.impl.model.WorkName).\n Expected:\n" + rzVar5 + "\n Found:\n" + a6, false);
            }
            HashMap hashMap6 = new HashMap(2);
            hashMap6.put("work_spec_id", new rz.a(1, "work_spec_id", "TEXT", (String) null, true, 1));
            hashMap6.put("progress", new rz.a(0, "progress", "BLOB", (String) null, true, 1));
            HashSet hashSet10 = new HashSet(1);
            hashSet10.add(new rz.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{FacebookMediationAdapter.KEY_ID})));
            rz rzVar6 = new rz("WorkProgress", hashMap6, hashSet10, new HashSet(0));
            rz a7 = rz.a(ydVar2, "WorkProgress");
            if (!rzVar6.equals(a7)) {
                return new au.b("WorkProgress(androidx.work.impl.model.WorkProgress).\n Expected:\n" + rzVar6 + "\n Found:\n" + a7, false);
            }
            HashMap hashMap7 = new HashMap(2);
            hashMap7.put("key", new rz.a(1, "key", "TEXT", (String) null, true, 1));
            hashMap7.put("long_value", new rz.a(0, "long_value", "INTEGER", (String) null, false, 1));
            rz rzVar7 = new rz("Preference", hashMap7, new HashSet(0), new HashSet(0));
            rz a8 = rz.a(ydVar2, "Preference");
            if (rzVar7.equals(a8)) {
                return new au.b((String) null, true);
            }
            return new au.b("Preference(androidx.work.impl.model.Preference).\n Expected:\n" + rzVar7 + "\n Found:\n" + a8, false);
        }
    }

    public final og d() {
        return new og(this, new HashMap(0), new HashMap(0), "Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName", "WorkProgress", "Preference");
    }

    public final Ly e(b8 b8Var) {
        au auVar = new au(b8Var, new a());
        Context context = b8Var.f2732a;
        if (context != null) {
            return b8Var.a.a(new Ly.b(context, b8Var.f2733a, auVar, false));
        }
        throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
    }

    public final K8 i() {
        L8 l8;
        if (this.a != null) {
            return this.a;
        }
        synchronized (this) {
            if (this.a == null) {
                this.a = new L8(this);
            }
            l8 = this.a;
        }
        return l8;
    }

    public final Zp j() {
        C0137aq aqVar;
        if (this.f2654a != null) {
            return this.f2654a;
        }
        synchronized (this) {
            if (this.f2654a == null) {
                this.f2654a = new C0137aq(this);
            }
            aqVar = this.f2654a;
        }
        return aqVar;
    }

    public final az k() {
        bz bzVar;
        if (this.f2655a != null) {
            return this.f2655a;
        }
        synchronized (this) {
            if (this.f2655a == null) {
                this.f2655a = new bz(this);
            }
            bzVar = this.f2655a;
        }
        return bzVar;
    }

    public final YD l() {
        ZD zd;
        if (this.f2653a != null) {
            return this.f2653a;
        }
        synchronized (this) {
            if (this.f2653a == null) {
                this.f2653a = new ZD(this);
            }
            zd = this.f2653a;
        }
        return zd;
    }

    public final C0146bE m() {
        C0157cE cEVar;
        if (this.f2656a != null) {
            return this.f2656a;
        }
        synchronized (this) {
            if (this.f2656a == null) {
                this.f2656a = new C0157cE(this);
            }
            cEVar = this.f2656a;
        }
        return cEVar;
    }

    public final C0224iE n() {
        C0236jE jEVar;
        if (this.f2657a != null) {
            return this.f2657a;
        }
        synchronized (this) {
            if (this.f2657a == null) {
                this.f2657a = new C0236jE(this);
            }
            jEVar = this.f2657a;
        }
        return jEVar;
    }

    public final C0256lE o() {
        mE mEVar;
        if (this.f2658a != null) {
            return this.f2658a;
        }
        synchronized (this) {
            if (this.f2658a == null) {
                this.f2658a = new mE(this);
            }
            mEVar = this.f2658a;
        }
        return mEVar;
    }
}
