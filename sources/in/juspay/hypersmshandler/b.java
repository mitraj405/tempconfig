package in.juspay.hypersmshandler;

import com.google.android.gms.tasks.OnFailureListener;
import in.juspay.hyper.constants.LogCategory;
import in.juspay.hyper.constants.LogSubCategory;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class b implements OnFailureListener {
    public final /* synthetic */ Tracker a;

    public /* synthetic */ b(Tracker tracker) {
        this.a = tracker;
    }

    public final void onFailure(Exception exc) {
        this.a.trackAndLogException("SmsConsentHandler", LogCategory.API_CALL, LogSubCategory.ApiCall.SDK, "sms_consent", "SmsConsent listener failed to start", exc);
    }
}
