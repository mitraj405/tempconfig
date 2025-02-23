package defpackage;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import java.util.Date;

/* renamed from: n7  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class n7 implements Continuation {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;

    public /* synthetic */ n7(Object obj, Date date) {
        this.a = obj;
        this.b = date;
    }

    public final Object then(Task task) {
        return ((ConfigFetchHandler) this.a).lambda$fetchIfCacheExpiredAndNotThrottled$3((Date) this.b, task);
    }
}
