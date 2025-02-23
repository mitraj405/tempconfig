package in.juspay.hypersmshandler;

import android.app.Activity;
import com.google.android.gms.tasks.OnSuccessListener;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class f implements OnSuccessListener {
    public final /* synthetic */ Activity a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ SmsRetriever f5515a;

    public /* synthetic */ f(SmsRetriever smsRetriever, Activity activity) {
        this.f5515a = smsRetriever;
        this.a = activity;
    }

    public final void onSuccess(Object obj) {
        this.f5515a.a(this.a, (Void) obj);
    }
}
