package in.juspay.hypersdk.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import in.juspay.hypersdk.core.JuspayServices;
import in.juspay.hypersdk.ui.ActivityLaunchDelegate;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class HyperActivityLaunchDelegate implements ActivityLaunchDelegate {
    private final JuspayServices juspayServices;
    private final Queue<IntentQueueData> startActivityQueue = new ConcurrentLinkedQueue();

    public static class IntentQueueData {
        Bundle bundle;
        Intent intent;
        int requestCode;

        public IntentQueueData(Intent intent2, int i, Bundle bundle2) {
            this.intent = intent2;
            this.requestCode = i;
            this.bundle = bundle2;
        }
    }

    public HyperActivityLaunchDelegate(JuspayServices juspayServices2) {
        this.juspayServices = juspayServices2;
    }

    public void clearQueue() {
        this.startActivityQueue.clear();
    }

    public void fragmentAttached() {
        for (IntentQueueData next : this.startActivityQueue) {
            startActivityForResult(next.intent, next.requestCode, next.bundle);
        }
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        HyperFragment fragment = this.juspayServices.getFragment();
        if (fragment == null || !fragment.isAdded()) {
            this.startActivityQueue.add(new IntentQueueData(intent, i, bundle));
        } else {
            fragment.startActivityForResult(intent, i, bundle);
        }
    }
}
