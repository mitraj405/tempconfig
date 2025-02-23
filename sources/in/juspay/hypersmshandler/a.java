package in.juspay.hypersmshandler;

import com.google.android.gms.tasks.OnSuccessListener;
import in.juspay.hyper.constants.LogLevel;
import in.juspay.hyper.constants.LogSubCategory;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class a implements OnSuccessListener {
    public final /* synthetic */ Tracker a;

    public /* synthetic */ a(Tracker tracker) {
        this.a = tracker;
    }

    public final void onSuccess(Object obj) {
        this.a.trackAction(LogSubCategory.Action.SYSTEM, LogLevel.DEBUG, "sms_consent", "sms_consent_listener", "SmsConsent listener started successfully");
    }
}
