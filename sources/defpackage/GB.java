package defpackage;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatController;
import com.google.firebase.installations.FirebaseInstallations;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import java.util.concurrent.Callable;

/* renamed from: GB  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class GB implements Callable {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Object f228a;

    public /* synthetic */ GB(Object obj, int i) {
        this.a = i;
        this.f228a = obj;
    }

    public final Object call() {
        int i = this.a;
        Object obj = this.f228a;
        switch (i) {
            case 0:
                return ((UserMetadata) obj).lambda$setUserId$0();
            case 1:
                return ((DefaultHeartBeatController) obj).lambda$registerHeartBeat$0();
            case 2:
                return ((FirebaseInstallations) obj).deleteFirebaseInstallationId();
            case 3:
                return ((FirebaseRemoteConfig) obj).getInfo();
            default:
                return ((RemoteConfigComponent) obj).getDefault();
        }
    }
}
