package defpackage;

import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import java.util.concurrent.Executor;

/* renamed from: qt  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class qt implements RemovalListener {
    public final /* synthetic */ RemovalListener a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Executor f3204a;

    public /* synthetic */ qt(RemovalListener removalListener, Executor executor) {
        this.f3204a = executor;
        this.a = removalListener;
    }

    public final void onRemoval(RemovalNotification removalNotification) {
        this.f3204a.execute(new C0428zq(1, this.a, removalNotification));
    }
}
