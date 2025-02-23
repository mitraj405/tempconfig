package defpackage;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.concurrent.Callable;

/* renamed from: ij  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0228ij implements Callable {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Object f3018a;

    public /* synthetic */ C0228ij(Object obj, int i) {
        this.a = i;
        this.f3018a = obj;
    }

    public final Object call() {
        int i = this.a;
        Object obj = this.f3018a;
        switch (i) {
            case 0:
                return new Lj((C0181ej) obj);
            default:
                return ((FirebaseRemoteConfig) obj).lambda$reset$6();
        }
    }
}
