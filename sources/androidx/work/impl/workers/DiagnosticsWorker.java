package androidx.work.impl.workers;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class DiagnosticsWorker extends Worker {
    static {
        zi.e("DiagnosticsWrkr");
    }

    public DiagnosticsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    /* JADX INFO: finally extract failed */
    public static String b(YD yd, C0256lE lEVar, az azVar, ArrayList arrayList) {
        Integer num;
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\n Id \t Class Name\t %s\t State\t Unique Name\t Tags\t", new Object[]{"Job Id"}));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C0214hE hEVar = (C0214hE) it.next();
            Zy a = ((bz) azVar).a(hEVar.f2991a);
            if (a != null) {
                num = Integer.valueOf(a.a);
            } else {
                num = null;
            }
            String str = hEVar.f2991a;
            ZD zd = (ZD) yd;
            zd.getClass();
            bu c = bu.c(1, "SELECT name FROM workname WHERE work_spec_id=?");
            if (str == null) {
                c.h(1);
            } else {
                c.j(1, str);
            }
            Zt zt = zd.f761a;
            zt.b();
            Cursor g = zt.g(c);
            try {
                ArrayList arrayList2 = new ArrayList(g.getCount());
                while (g.moveToNext()) {
                    arrayList2.add(g.getString(0));
                }
                g.close();
                c.release();
                ArrayList a2 = ((mE) lEVar).a(hEVar.f2991a);
                sb.append(String.format("\n%s\t %s\t %s\t %s\t %s\t %s\t", new Object[]{hEVar.f2991a, hEVar.f2995b, num, hEVar.f2989a.name(), TextUtils.join(",", arrayList2), TextUtils.join(",", a2)}));
            } catch (Throwable th) {
                g.close();
                c.release();
                throw th;
            }
        }
        return sb.toString();
    }

    public final ListenableWorker.Result doWork() {
        bu buVar;
        ArrayList arrayList;
        az azVar;
        C0256lE lEVar;
        YD yd;
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        WorkDatabase workDatabase = VD.e(getApplicationContext()).f594a;
        C0224iE n = workDatabase.n();
        YD l = workDatabase.l();
        C0256lE o = workDatabase.o();
        az k = workDatabase.k();
        C0236jE jEVar = (C0236jE) n;
        jEVar.getClass();
        bu c = bu.c(1, "SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE period_start_time >= ? AND state IN (2, 3, 5) ORDER BY period_start_time DESC");
        c.e(1, System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1));
        Zt zt = jEVar.a;
        zt.b();
        Cursor g = zt.g(c);
        try {
            int N = C1354qp.N(g, "required_network_type");
            int N2 = C1354qp.N(g, "requires_charging");
            int N3 = C1354qp.N(g, "requires_device_idle");
            int N4 = C1354qp.N(g, "requires_battery_not_low");
            int N5 = C1354qp.N(g, "requires_storage_not_low");
            int N6 = C1354qp.N(g, "trigger_content_update_delay");
            int N7 = C1354qp.N(g, "trigger_max_content_delay");
            int N8 = C1354qp.N(g, "content_uri_triggers");
            int N9 = C1354qp.N(g, FacebookMediationAdapter.KEY_ID);
            int N10 = C1354qp.N(g, RemoteConfigConstants.ResponseFieldKey.STATE);
            az azVar2 = k;
            int N11 = C1354qp.N(g, "worker_class_name");
            YD yd2 = l;
            int N12 = C1354qp.N(g, "input_merger_class_name");
            C0256lE lEVar2 = o;
            int N13 = C1354qp.N(g, "input");
            C0236jE jEVar2 = jEVar;
            int N14 = C1354qp.N(g, "output");
            buVar = c;
            try {
                int N15 = C1354qp.N(g, "initial_delay");
                int N16 = C1354qp.N(g, "interval_duration");
                int N17 = C1354qp.N(g, "flex_duration");
                int N18 = C1354qp.N(g, "run_attempt_count");
                int N19 = C1354qp.N(g, "backoff_policy");
                int N20 = C1354qp.N(g, "backoff_delay_duration");
                int N21 = C1354qp.N(g, "period_start_time");
                int N22 = C1354qp.N(g, "minimum_retention_duration");
                int N23 = C1354qp.N(g, "schedule_requested_at");
                int N24 = C1354qp.N(g, "run_in_foreground");
                int N25 = C1354qp.N(g, "out_of_quota_policy");
                int i2 = N14;
                ArrayList arrayList2 = new ArrayList(g.getCount());
                while (true) {
                    arrayList = arrayList2;
                    if (!g.moveToNext()) {
                        break;
                    }
                    String string = g.getString(N9);
                    String string2 = g.getString(N11);
                    int i3 = N11;
                    T6 t6 = new T6();
                    int i4 = N;
                    t6.f539a = oE.c(g.getInt(N));
                    if (g.getInt(N2) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    t6.f541a = z;
                    if (g.getInt(N3) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    t6.f542b = z2;
                    if (g.getInt(N4) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    t6.c = z3;
                    if (g.getInt(N5) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    t6.d = z4;
                    int i5 = N2;
                    int i6 = N3;
                    t6.f538a = g.getLong(N6);
                    t6.b = g.getLong(N7);
                    t6.f540a = oE.a(g.getBlob(N8));
                    C0214hE hEVar = new C0214hE(string, string2);
                    hEVar.f2989a = oE.e(g.getInt(N10));
                    hEVar.f2997c = g.getString(N12);
                    hEVar.f2990a = Data.a(g.getBlob(N13));
                    int i7 = i2;
                    hEVar.f2994b = Data.a(g.getBlob(i7));
                    i2 = i7;
                    int i8 = N12;
                    int i9 = N15;
                    hEVar.f2987a = g.getLong(i9);
                    int i10 = N13;
                    int i11 = N16;
                    hEVar.f2993b = g.getLong(i11);
                    int i12 = i5;
                    int i13 = N10;
                    int i14 = N17;
                    hEVar.f2996c = g.getLong(i14);
                    int i15 = N18;
                    hEVar.a = g.getInt(i15);
                    int i16 = N19;
                    int i17 = i11;
                    hEVar.b = oE.b(g.getInt(i16));
                    N17 = i14;
                    int i18 = i13;
                    int i19 = N20;
                    hEVar.d = g.getLong(i19);
                    int i20 = i15;
                    int i21 = i16;
                    int i22 = N21;
                    hEVar.e = g.getLong(i22);
                    int i23 = i19;
                    N21 = i22;
                    int i24 = N22;
                    hEVar.f = g.getLong(i24);
                    int i25 = i20;
                    int i26 = N23;
                    hEVar.g = g.getLong(i26);
                    int i27 = N24;
                    if (g.getInt(i27) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    hEVar.f2992a = z5;
                    int i28 = N25;
                    int i29 = i26;
                    hEVar.c = oE.d(g.getInt(i28));
                    hEVar.f2988a = t6;
                    ArrayList arrayList3 = arrayList;
                    arrayList3.add(hEVar);
                    N25 = i28;
                    N13 = i10;
                    N2 = i12;
                    N16 = i17;
                    N18 = i25;
                    N23 = i29;
                    N24 = i27;
                    N22 = i24;
                    N15 = i9;
                    N12 = i8;
                    N3 = i6;
                    N = i4;
                    arrayList2 = arrayList3;
                    N11 = i3;
                    int i30 = i21;
                    N20 = i23;
                    N10 = i18;
                    N19 = i30;
                }
                ArrayList arrayList4 = arrayList;
                g.close();
                buVar.release();
                ArrayList d = jEVar2.d();
                ArrayList b = jEVar2.b();
                if (!arrayList4.isEmpty()) {
                    i = 0;
                    zi.c().d(new Throwable[0]);
                    zi c2 = zi.c();
                    azVar = azVar2;
                    yd = yd2;
                    lEVar = lEVar2;
                    b(yd, lEVar, azVar, arrayList4);
                    c2.d(new Throwable[0]);
                } else {
                    azVar = azVar2;
                    yd = yd2;
                    lEVar = lEVar2;
                    i = 0;
                }
                if (!d.isEmpty()) {
                    zi.c().d(new Throwable[i]);
                    zi c3 = zi.c();
                    b(yd, lEVar, azVar, d);
                    c3.d(new Throwable[i]);
                }
                if (!b.isEmpty()) {
                    zi.c().d(new Throwable[i]);
                    zi c4 = zi.c();
                    b(yd, lEVar, azVar, b);
                    c4.d(new Throwable[i]);
                }
                return new ListenableWorker.Result.c();
            } catch (Throwable th) {
                th = th;
                g.close();
                buVar.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            buVar = c;
            g.close();
            buVar.release();
            throw th;
        }
    }
}
