package defpackage;

import android.os.Handler;
import com.google.android.gms.common.util.BiConsumer;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.momagic.C0835h;
import com.momagic.H;

/* renamed from: E6  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class E6 implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ int c;

    /* renamed from: c  reason: collision with other field name */
    public final /* synthetic */ Object f130c;

    public /* synthetic */ E6(Object obj, int i, Object obj2, Object obj3) {
        this.c = i;
        this.a = obj;
        this.b = obj2;
        this.f130c = obj3;
    }

    public final void run() {
        int i = this.c;
        Object obj = this.f130c;
        Object obj2 = this.b;
        Object obj3 = this.a;
        switch (i) {
            case 0:
                ((BiConsumer) obj3).accept((String) obj2, (ConfigContainer) obj);
                return;
            default:
                C1203jp jpVar = (C1203jp) obj3;
                Handler handler = (Handler) obj2;
                Runnable runnable = (Runnable) obj;
                try {
                    String str = jpVar.f5535i;
                    String str2 = jpVar.f5538l;
                    if (str != null && !str.isEmpty()) {
                        jpVar.f5524a = H.j(str);
                    }
                    if (str2 != null && !str2.isEmpty()) {
                        jpVar.f5527b = H.j(str2);
                    }
                    handler.post(runnable);
                    return;
                } catch (Exception e) {
                    H.r(C0835h.f4046a, e.toString(), "NotificationExecutorService", "executeNotification");
                    return;
                }
        }
    }
}
