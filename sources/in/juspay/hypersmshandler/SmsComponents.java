package in.juspay.hypersmshandler;

import android.content.Context;
import androidx.annotation.Keep;

@Keep
public interface SmsComponents {
    Context getContext();

    SmsEventInterface getSmsEventInterface();

    Tracker getTracker();
}
