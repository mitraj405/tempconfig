package androidx.work.impl.foreground;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.ForegroundInfo;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: SystemForegroundDispatcher */
public final class a implements LD, rb {
    public static final /* synthetic */ int c = 0;
    public final MD a;

    /* renamed from: a  reason: collision with other field name */
    public final VD f2692a;

    /* renamed from: a  reason: collision with other field name */
    public final Context f2693a;

    /* renamed from: a  reason: collision with other field name */
    public C0030a f2694a;

    /* renamed from: a  reason: collision with other field name */
    public final TaskExecutor f2695a;

    /* renamed from: a  reason: collision with other field name */
    public final Object f2696a = new Object();

    /* renamed from: a  reason: collision with other field name */
    public final HashMap f2697a;

    /* renamed from: a  reason: collision with other field name */
    public final HashSet f2698a;

    /* renamed from: a  reason: collision with other field name */
    public final LinkedHashMap f2699a;

    /* renamed from: c  reason: collision with other field name */
    public String f2700c;

    /* renamed from: androidx.work.impl.foreground.a$a  reason: collision with other inner class name */
    /* compiled from: SystemForegroundDispatcher */
    public interface C0030a {
    }

    static {
        zi.e("SystemFgDispatcher");
    }

    public a(Context context) {
        this.f2693a = context;
        VD e = VD.e(context);
        this.f2692a = e;
        TaskExecutor taskExecutor = e.f595a;
        this.f2695a = taskExecutor;
        this.f2700c = null;
        this.f2699a = new LinkedHashMap();
        this.f2698a = new HashSet();
        this.f2697a = new HashMap();
        this.a = new MD(context, taskExecutor, this);
        e.f598a.a(this);
    }

    public static Intent b(Context context, String str, ForegroundInfo foregroundInfo) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_NOTIFY");
        intent.putExtra("KEY_NOTIFICATION_ID", foregroundInfo.a);
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", foregroundInfo.b);
        intent.putExtra("KEY_NOTIFICATION", foregroundInfo.f2636a);
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public static Intent c(Context context, String str, ForegroundInfo foregroundInfo) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction("ACTION_START_FOREGROUND");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NOTIFICATION_ID", foregroundInfo.a);
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", foregroundInfo.b);
        intent.putExtra("KEY_NOTIFICATION", foregroundInfo.f2636a);
        intent.putExtra("KEY_WORKSPEC_ID", str);
        return intent;
    }

    public final void d(Intent intent) {
        int i = 0;
        int intExtra = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int intExtra2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        Notification notification = (Notification) intent.getParcelableExtra("KEY_NOTIFICATION");
        zi c2 = zi.c();
        String.format("Notifying with (id: %s, workSpecId: %s, notificationType: %s)", new Object[]{Integer.valueOf(intExtra), stringExtra, Integer.valueOf(intExtra2)});
        c2.a(new Throwable[0]);
        if (notification != null && this.f2694a != null) {
            ForegroundInfo foregroundInfo = new ForegroundInfo(intExtra, intExtra2, notification);
            LinkedHashMap linkedHashMap = this.f2699a;
            linkedHashMap.put(stringExtra, foregroundInfo);
            if (TextUtils.isEmpty(this.f2700c)) {
                this.f2700c = stringExtra;
                SystemForegroundService systemForegroundService = (SystemForegroundService) this.f2694a;
                systemForegroundService.f2689a.post(new Wy(systemForegroundService, intExtra, notification, intExtra2));
                return;
            }
            SystemForegroundService systemForegroundService2 = (SystemForegroundService) this.f2694a;
            systemForegroundService2.f2689a.post(new Xy(systemForegroundService2, intExtra, notification));
            if (intExtra2 != 0 && Build.VERSION.SDK_INT >= 29) {
                for (Map.Entry value : linkedHashMap.entrySet()) {
                    i |= ((ForegroundInfo) value.getValue()).b;
                }
                ForegroundInfo foregroundInfo2 = (ForegroundInfo) linkedHashMap.get(this.f2700c);
                if (foregroundInfo2 != null) {
                    SystemForegroundService systemForegroundService3 = (SystemForegroundService) this.f2694a;
                    systemForegroundService3.f2689a.post(new Wy(systemForegroundService3, foregroundInfo2.a, foregroundInfo2.f2636a, i));
                }
            }
        }
    }

    public final void e(String str, boolean z) {
        boolean z2;
        Map.Entry entry;
        synchronized (this.f2696a) {
            try {
                C0214hE hEVar = (C0214hE) this.f2697a.remove(str);
                if (hEVar != null) {
                    z2 = this.f2698a.remove(hEVar);
                } else {
                    z2 = false;
                }
                if (z2) {
                    this.a.b(this.f2698a);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        ForegroundInfo foregroundInfo = (ForegroundInfo) this.f2699a.remove(str);
        if (str.equals(this.f2700c) && this.f2699a.size() > 0) {
            Iterator it = this.f2699a.entrySet().iterator();
            Object next = it.next();
            while (true) {
                entry = (Map.Entry) next;
                if (!it.hasNext()) {
                    break;
                }
                next = it.next();
            }
            this.f2700c = (String) entry.getKey();
            if (this.f2694a != null) {
                ForegroundInfo foregroundInfo2 = (ForegroundInfo) entry.getValue();
                C0030a aVar = this.f2694a;
                SystemForegroundService systemForegroundService = (SystemForegroundService) aVar;
                systemForegroundService.f2689a.post(new Wy(systemForegroundService, foregroundInfo2.a, foregroundInfo2.f2636a, foregroundInfo2.b));
                SystemForegroundService systemForegroundService2 = (SystemForegroundService) this.f2694a;
                systemForegroundService2.f2689a.post(new Yy(systemForegroundService2, foregroundInfo2.a));
            }
        }
        C0030a aVar2 = this.f2694a;
        if (foregroundInfo != null && aVar2 != null) {
            zi c2 = zi.c();
            String.format("Removing Notification (id: %s, workSpecId: %s ,notificationType: %s)", new Object[]{Integer.valueOf(foregroundInfo.a), str, Integer.valueOf(foregroundInfo.b)});
            c2.a(new Throwable[0]);
            SystemForegroundService systemForegroundService3 = (SystemForegroundService) aVar2;
            systemForegroundService3.f2689a.post(new Yy(systemForegroundService3, foregroundInfo.a));
        }
    }

    public final void f(ArrayList arrayList) {
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                zi c2 = zi.c();
                String.format("Constraints unmet for WorkSpec %s", new Object[]{str});
                c2.a(new Throwable[0]);
                VD vd = this.f2692a;
                vd.f595a.c(new C0187ey(vd, str, true));
            }
        }
    }

    public final void a(List<String> list) {
    }
}
