package androidx.work.impl.background.systemalarm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: CommandHandler */
public final class a implements rb {
    public static final /* synthetic */ int c = 0;
    public final Context a;

    /* renamed from: a  reason: collision with other field name */
    public final Object f2668a = new Object();

    /* renamed from: a  reason: collision with other field name */
    public final HashMap f2669a = new HashMap();

    static {
        zi.e("CommandHandler");
    }

    public a(Context context) {
        this.a = context;
    }

    public static Intent a(Context context, String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent b(Context context, String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_SCHEDULE_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public final void c(int i, Intent intent, d dVar) {
        boolean z;
        boolean z2;
        String action = intent.getAction();
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            zi c2 = zi.c();
            String.format("Handling constraints changed %s", new Object[]{intent});
            c2.a(new Throwable[0]);
            b bVar = new b(this.a, i, dVar);
            ArrayList e = ((C0236jE) dVar.a.f594a.n()).e();
            int i2 = ConstraintProxy.a;
            Iterator it = e.iterator();
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = false;
            while (it.hasNext()) {
                T6 t6 = ((C0214hE) it.next()).f2988a;
                z3 |= t6.c;
                z4 |= t6.f541a;
                z5 |= t6.d;
                if (t6.f539a != Em.NOT_REQUIRED) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z6 |= z2;
                if (z3 && z4 && z5 && z6) {
                    break;
                }
            }
            int i3 = ConstraintProxyUpdateReceiver.a;
            Intent intent2 = new Intent("androidx.work.impl.background.systemalarm.UpdateProxies");
            Context context = bVar.f2671a;
            intent2.setComponent(new ComponentName(context, ConstraintProxyUpdateReceiver.class));
            intent2.putExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", z3).putExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", z4).putExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", z5).putExtra("KEY_NETWORK_STATE_PROXY_ENABLED", z6);
            context.sendBroadcast(intent2);
            MD md = bVar.f2670a;
            md.b(e);
            ArrayList arrayList = new ArrayList(e.size());
            long currentTimeMillis = System.currentTimeMillis();
            Iterator it2 = e.iterator();
            while (it2.hasNext()) {
                C0214hE hEVar = (C0214hE) it2.next();
                String str = hEVar.f2991a;
                if (currentTimeMillis >= hEVar.a() && (!hEVar.b() || md.a(str))) {
                    arrayList.add(hEVar);
                }
            }
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                String str2 = ((C0214hE) it3.next()).f2991a;
                Intent a2 = a(context, str2);
                zi c3 = zi.c();
                String.format("Creating a delay_met command for workSpec with id (%s)", new Object[]{str2});
                int i4 = b.b;
                c3.a(new Throwable[0]);
                dVar.d(new d.b(bVar.a, a2, dVar));
            }
            md.c();
        } else if ("ACTION_RESCHEDULE".equals(action)) {
            zi c4 = zi.c();
            String.format("Handling reschedule %s, %s", new Object[]{intent, Integer.valueOf(i)});
            c4.a(new Throwable[0]);
            dVar.a.h();
        } else {
            Bundle extras = intent.getExtras();
            String[] strArr = {"KEY_WORKSPEC_ID"};
            if (extras == null || extras.isEmpty() || extras.get(strArr[0]) == null) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                zi c5 = zi.c();
                String.format("Invalid request for %s, requires %s.", new Object[]{action, "KEY_WORKSPEC_ID"});
                c5.b(new Throwable[0]);
            } else if ("ACTION_SCHEDULE_WORK".equals(action)) {
                String string = intent.getExtras().getString("KEY_WORKSPEC_ID");
                zi c6 = zi.c();
                String.format("Handling schedule work for %s", new Object[]{string});
                c6.a(new Throwable[0]);
                WorkDatabase workDatabase = dVar.a.f594a;
                workDatabase.c();
                try {
                    C0214hE i5 = ((C0236jE) workDatabase.n()).i(string);
                    if (i5 == null) {
                        zi.c().f(new Throwable[0]);
                    } else if (i5.f2989a.a()) {
                        zi.c().f(new Throwable[0]);
                    } else {
                        long a3 = i5.a();
                        boolean b = i5.b();
                        Context context2 = this.a;
                        VD vd = dVar.a;
                        if (!b) {
                            zi c7 = zi.c();
                            String.format("Setting up Alarms for %s at %s", new Object[]{string, Long.valueOf(a3)});
                            c7.a(new Throwable[0]);
                            C0265m0.b(context2, vd, string, a3);
                        } else {
                            zi c8 = zi.c();
                            String.format("Opportunistically setting an alarm for %s at %s", new Object[]{string, Long.valueOf(a3)});
                            c8.a(new Throwable[0]);
                            C0265m0.b(context2, vd, string, a3);
                            Intent intent3 = new Intent(context2, SystemAlarmService.class);
                            intent3.setAction("ACTION_CONSTRAINTS_CHANGED");
                            dVar.d(new d.b(i, intent3, dVar));
                        }
                        workDatabase.h();
                    }
                } finally {
                    workDatabase.f();
                }
            } else if ("ACTION_DELAY_MET".equals(action)) {
                Bundle extras2 = intent.getExtras();
                synchronized (this.f2668a) {
                    String string2 = extras2.getString("KEY_WORKSPEC_ID");
                    zi c9 = zi.c();
                    String.format("Handing delay met for %s", new Object[]{string2});
                    c9.a(new Throwable[0]);
                    if (!this.f2669a.containsKey(string2)) {
                        c cVar = new c(this.a, i, string2, dVar);
                        this.f2669a.put(string2, cVar);
                        cVar.d();
                    } else {
                        zi c10 = zi.c();
                        String.format("WorkSpec %s is already being handled for ACTION_DELAY_MET", new Object[]{string2});
                        c10.a(new Throwable[0]);
                    }
                }
            } else if ("ACTION_STOP_WORK".equals(action)) {
                String string3 = intent.getExtras().getString("KEY_WORKSPEC_ID");
                zi c11 = zi.c();
                String.format("Handing stopWork work for %s", new Object[]{string3});
                c11.a(new Throwable[0]);
                VD vd2 = dVar.a;
                vd2.f595a.c(new C0187ey(vd2, string3, false));
                int i6 = C0265m0.a;
                bz bzVar = (bz) dVar.a.f594a.k();
                Zy a4 = bzVar.a(string3);
                if (a4 != null) {
                    C0265m0.a(this.a, a4.a, string3);
                    zi c12 = zi.c();
                    String.format("Removing SystemIdInfo for workSpecId (%s)", new Object[]{string3});
                    c12.a(new Throwable[0]);
                    bzVar.b(string3);
                }
                dVar.e(string3, false);
            } else if ("ACTION_EXECUTION_COMPLETED".equals(action)) {
                Bundle extras3 = intent.getExtras();
                String string4 = extras3.getString("KEY_WORKSPEC_ID");
                boolean z7 = extras3.getBoolean("KEY_NEEDS_RESCHEDULE");
                zi c13 = zi.c();
                String.format("Handling onExecutionCompleted %s, %s", new Object[]{intent, Integer.valueOf(i)});
                c13.a(new Throwable[0]);
                e(string4, z7);
            } else {
                zi c14 = zi.c();
                String.format("Ignoring intent %s", new Object[]{intent});
                c14.f(new Throwable[0]);
            }
        }
    }

    public final void e(String str, boolean z) {
        synchronized (this.f2668a) {
            rb rbVar = (rb) this.f2669a.remove(str);
            if (rbVar != null) {
                rbVar.e(str, z);
            }
        }
    }
}
