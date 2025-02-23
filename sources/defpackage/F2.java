package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* renamed from: F2  reason: default package */
/* compiled from: BatteryChargingTracker */
public final class F2 extends n3<Boolean> {
    static {
        zi.e("BatteryChrgTracker");
    }

    public F2(Context context, TaskExecutor taskExecutor) {
        super(context, taskExecutor);
    }

    public final Object a() {
        Intent registerReceiver = this.f492a.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z = false;
        if (registerReceiver == null) {
            zi.c().b(new Throwable[0]);
            return null;
        }
        int intExtra = registerReceiver.getIntExtra("status", -1);
        if (intExtra == 2 || intExtra == 5) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    public final IntentFilter e() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.os.action.CHARGING");
        intentFilter.addAction("android.os.action.DISCHARGING");
        return intentFilter;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0041, code lost:
        if (r6.equals("android.os.action.DISCHARGING") == false) goto L_0x0023;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f(android.content.Intent r6) {
        /*
            r5 = this;
            java.lang.String r6 = r6.getAction()
            if (r6 != 0) goto L_0x0007
            return
        L_0x0007:
            zi r0 = defpackage.zi.c()
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r3 = 0
            r2[r3] = r6
            java.lang.String r4 = "Received %s"
            java.lang.String.format(r4, r2)
            java.lang.Throwable[] r2 = new java.lang.Throwable[r3]
            r0.a(r2)
            int r0 = r6.hashCode()
            r2 = -1
            switch(r0) {
                case -1886648615: goto L_0x0044;
                case -54942926: goto L_0x003b;
                case 948344062: goto L_0x0030;
                case 1019184907: goto L_0x0025;
                default: goto L_0x0023;
            }
        L_0x0023:
            r1 = r2
            goto L_0x004e
        L_0x0025:
            java.lang.String r0 = "android.intent.action.ACTION_POWER_CONNECTED"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x002e
            goto L_0x0023
        L_0x002e:
            r1 = 3
            goto L_0x004e
        L_0x0030:
            java.lang.String r0 = "android.os.action.CHARGING"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x0039
            goto L_0x0023
        L_0x0039:
            r1 = 2
            goto L_0x004e
        L_0x003b:
            java.lang.String r0 = "android.os.action.DISCHARGING"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x004e
            goto L_0x0023
        L_0x0044:
            java.lang.String r0 = "android.intent.action.ACTION_POWER_DISCONNECTED"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x004d
            goto L_0x0023
        L_0x004d:
            r1 = r3
        L_0x004e:
            switch(r1) {
                case 0: goto L_0x0064;
                case 1: goto L_0x005e;
                case 2: goto L_0x0058;
                case 3: goto L_0x0052;
                default: goto L_0x0051;
            }
        L_0x0051:
            goto L_0x0069
        L_0x0052:
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            r5.b(r6)
            goto L_0x0069
        L_0x0058:
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            r5.b(r6)
            goto L_0x0069
        L_0x005e:
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            r5.b(r6)
            goto L_0x0069
        L_0x0064:
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            r5.b(r6)
        L_0x0069:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.F2.f(android.content.Intent):void");
    }
}
