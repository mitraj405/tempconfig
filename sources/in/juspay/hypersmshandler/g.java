package in.juspay.hypersmshandler;

import com.google.android.gms.tasks.OnFailureListener;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class g implements OnFailureListener {
    public final /* synthetic */ SmsRetriever a;

    public /* synthetic */ g(SmsRetriever smsRetriever) {
        this.a = smsRetriever;
    }

    public final void onFailure(Exception exc) {
        this.a.a(exc);
    }
}
