package androidx.activity;

import android.content.Intent;
import android.content.IntentSender;
import androidx.activity.ComponentActivity;

/* compiled from: ComponentActivity */
public final class b implements Runnable {
    public final /* synthetic */ IntentSender.SendIntentException a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ComponentActivity.a f823a;
    public final /* synthetic */ int c;

    public b(ComponentActivity.a aVar, int i, IntentSender.SendIntentException sendIntentException) {
        this.f823a = aVar;
        this.c = i;
        this.a = sendIntentException;
    }

    public final void run() {
        this.f823a.a(this.c, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", this.a));
    }
}
