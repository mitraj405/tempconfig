package defpackage;

import android.content.Intent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.EnhancedIntentService;

/* renamed from: Ea  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class Ea implements OnCompleteListener {
    public final /* synthetic */ Intent a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ EnhancedIntentService f133a;

    public /* synthetic */ Ea(EnhancedIntentService enhancedIntentService, Intent intent) {
        this.f133a = enhancedIntentService;
        this.a = intent;
    }

    public final void onComplete(Task task) {
        this.f133a.lambda$onStartCommand$1(this.a, task);
    }
}
