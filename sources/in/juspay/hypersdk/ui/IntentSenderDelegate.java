package in.juspay.hypersdk.ui;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;

public interface IntentSenderDelegate {
    void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle);
}
