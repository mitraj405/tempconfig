package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.ScheduledFuture;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class k implements OnCompleteListener {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Object f2859a;

    public /* synthetic */ k(Object obj, int i) {
        this.a = i;
        this.f2859a = obj;
    }

    public final void onComplete(Task task) {
        int i = this.a;
        Object obj = this.f2859a;
        switch (i) {
            case 0:
                WakeLockHolder.completeWakefulIntent((Intent) obj);
                return;
            default:
                ((ScheduledFuture) obj).cancel(false);
                return;
        }
    }
}
