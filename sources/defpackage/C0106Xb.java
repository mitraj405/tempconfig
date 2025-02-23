package defpackage;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FcmBroadcastProcessor;

/* renamed from: Xb  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0106Xb implements Continuation {
    public final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Intent f674a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f675a;

    public /* synthetic */ C0106Xb(Context context, Intent intent, boolean z) {
        this.a = context;
        this.f674a = intent;
        this.f675a = z;
    }

    public final Object then(Task task) {
        return FcmBroadcastProcessor.lambda$startMessagingService$2(this.a, this.f674a, this.f675a, task);
    }
}
