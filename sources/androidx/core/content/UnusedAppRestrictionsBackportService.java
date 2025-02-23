package androidx.core.content;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import defpackage.qf;

public abstract class UnusedAppRestrictionsBackportService extends Service {
    public final a a = new a();

    public class a extends qf.a {
        public a() {
        }
    }

    public abstract void a();

    public final IBinder onBind(Intent intent) {
        return this.a;
    }
}
