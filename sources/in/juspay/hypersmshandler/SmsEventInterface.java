package in.juspay.hypersmshandler;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;

@Keep
public interface SmsEventInterface {

    @Keep
    public enum RetrieverEvents {
        ON_ATTACH,
        ON_RECEIVE,
        ON_EXECUTE
    }

    void onActivityResultEvent(String str);

    void onSentReceiverEvent(int i);

    void onSmsConsentEvent(Intent intent, int i, Bundle bundle);

    void onSmsReceiverEvent(String str);

    void onSmsRetrieverEvent(RetrieverEvents retrieverEvents, String str);
}
