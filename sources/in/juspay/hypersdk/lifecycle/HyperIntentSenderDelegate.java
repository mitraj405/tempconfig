package in.juspay.hypersdk.lifecycle;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import in.juspay.hypersdk.core.JuspayServices;
import in.juspay.hypersdk.ui.IntentSenderDelegate;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class HyperIntentSenderDelegate implements IntentSenderDelegate {
    private final Queue<IntentQueueData> intentSenderQueue = new ConcurrentLinkedQueue();
    private final JuspayServices juspayServices;

    public static class IntentQueueData {
        int extraFlags;
        Intent fillInIntent;
        int flagMask;
        int flagValues;
        IntentSender intentSender;
        Bundle options;
        int requestCode;

        public IntentQueueData(IntentSender intentSender2, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
            this.intentSender = intentSender2;
            this.requestCode = i;
            this.fillInIntent = intent;
            this.flagMask = i2;
            this.flagValues = i3;
            this.extraFlags = i4;
            this.options = bundle;
        }
    }

    public HyperIntentSenderDelegate(JuspayServices juspayServices2) {
        this.juspayServices = juspayServices2;
    }

    public void clearQueue() {
        this.intentSenderQueue.clear();
    }

    public void fragmentAttached() {
        for (IntentQueueData next : this.intentSenderQueue) {
            startIntentSenderForResult(next.intentSender, next.requestCode, next.fillInIntent, next.flagMask, next.flagValues, next.extraFlags, next.options);
        }
    }

    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        try {
            HyperFragment fragment = this.juspayServices.getFragment();
            if (fragment == null || !fragment.isAdded()) {
                this.intentSenderQueue.add(new IntentQueueData(intentSender, i, intent, i2, i3, i4, bundle));
            } else {
                fragment.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
