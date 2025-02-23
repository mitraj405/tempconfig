package defpackage;

import android.content.Context;
import android.content.Intent;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.messaging.ServiceStarter;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.Callable;

/* renamed from: hj  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0217hj implements Callable {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Object f2999a;
    public final /* synthetic */ Object b;

    public /* synthetic */ C0217hj(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.f2999a = obj2;
    }

    public final Object call() {
        int i = this.a;
        Object obj = this.f2999a;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                return C0281nj.c((InputStream) obj2, (String) obj);
            case 1:
                As as = new As(C1517zn.b(new ByteArrayInputStream(((String) obj).getBytes())));
                String[] strArr = Tg.b;
                return C0281nj.d(new Ug(as), (String) obj2, true);
            case 2:
                return ((UserMetadata) obj2).lambda$updateRolloutsState$1((List) obj);
            default:
                return Integer.valueOf(ServiceStarter.getInstance().startMessagingService((Context) obj2, (Intent) obj));
        }
    }

    public /* synthetic */ C0217hj(String str, String str2) {
        this.a = 1;
        this.f2999a = str;
        this.b = str2;
    }
}
