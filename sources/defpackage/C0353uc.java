package defpackage;

import com.google.android.gms.cloudmessaging.CloudMessage;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.messaging.FirebaseMessaging;

/* renamed from: uc  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0353uc implements OnSuccessListener, FirebaseInstanceIdInternal.NewTokenListener {
    public final /* synthetic */ FirebaseMessaging a;

    public /* synthetic */ C0353uc(FirebaseMessaging firebaseMessaging) {
        this.a = firebaseMessaging;
    }

    public final void onNewToken(String str) {
        this.a.lambda$new$1(str);
    }

    public final void onSuccess(Object obj) {
        this.a.lambda$handleProxiedNotificationData$5((CloudMessage) obj);
    }
}
