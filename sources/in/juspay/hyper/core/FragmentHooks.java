package in.juspay.hyper.core;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;

public interface FragmentHooks {
    void requestPermission(String[] strArr, int i);

    void startActivityForResult(Intent intent, int i, Bundle bundle);

    void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle);
}
