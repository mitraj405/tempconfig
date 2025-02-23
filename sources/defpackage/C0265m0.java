package defpackage;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.a;

/* renamed from: m0  reason: default package and case insensitive filesystem */
/* compiled from: Alarms */
public final class C0265m0 {
    public static final /* synthetic */ int a = 0;

    static {
        zi.e("Alarms");
    }

    public static void a(Context context, int i, String str) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent service = PendingIntent.getService(context, i, a.a(context, str), 603979776);
        if (service != null && alarmManager != null) {
            zi c = zi.c();
            String.format("Cancelling existing alarm with (workSpecId, systemId) (%s, %s)", new Object[]{str, Integer.valueOf(i)});
            c.a(new Throwable[0]);
            alarmManager.cancel(service);
        }
    }

    /* JADX INFO: finally extract failed */
    public static void b(Context context, VD vd, String str, long j) {
        int i;
        int i2;
        WorkDatabase workDatabase = vd.f594a;
        bz bzVar = (bz) workDatabase.k();
        Zy a2 = bzVar.a(str);
        if (a2 != null) {
            a(context, a2.a, str);
            int i3 = a2.a;
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            PendingIntent service = PendingIntent.getService(context, i3, a.a(context, str), 201326592);
            if (alarmManager != null) {
                alarmManager.setExact(0, j, service);
                return;
            }
            return;
        }
        synchronized (rf.class) {
            workDatabase.c();
            try {
                Long a3 = ((C0137aq) workDatabase.j()).a("next_alarm_manager_id");
                if (a3 != null) {
                    i = a3.intValue();
                } else {
                    i = 0;
                }
                if (i == Integer.MAX_VALUE) {
                    i2 = 0;
                } else {
                    i2 = i + 1;
                }
                ((C0137aq) workDatabase.j()).b(new Yp("next_alarm_manager_id", (long) i2));
                workDatabase.h();
            } finally {
                workDatabase.f();
            }
        }
        Zy zy = new Zy(str, i);
        Zt zt = bzVar.a;
        zt.b();
        zt.c();
        try {
            bzVar.f2750a.e(zy);
            zt.h();
            zt.f();
            AlarmManager alarmManager2 = (AlarmManager) context.getSystemService("alarm");
            PendingIntent service2 = PendingIntent.getService(context, i, a.a(context, str), 201326592);
            if (alarmManager2 != null) {
                alarmManager2.setExact(0, j, service2);
            }
        } catch (Throwable th) {
            zt.f();
            throw th;
        }
    }
}
