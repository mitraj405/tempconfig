package in.juspay.hypersdk.lifecycle;

import in.juspay.hypersdk.core.JuspayServices;
import in.juspay.hypersdk.ui.RequestPermissionDelegate;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class HyperRequestPermissionDelegate implements RequestPermissionDelegate {
    private final JuspayServices juspayServices;
    private final Queue<RequestQueueData> requestQueue = new ConcurrentLinkedQueue();

    public static class RequestQueueData {
        int requestCode;
        String[] requests;

        public RequestQueueData(String[] strArr, int i) {
            this.requests = strArr;
            this.requestCode = i;
        }
    }

    public HyperRequestPermissionDelegate(JuspayServices juspayServices2) {
        this.juspayServices = juspayServices2;
    }

    public void clearQueue() {
        this.requestQueue.clear();
    }

    public void fragmentAttached() {
        for (RequestQueueData next : this.requestQueue) {
            requestPermission(next.requests, next.requestCode);
        }
    }

    public void requestPermission(String[] strArr, int i) {
        HyperFragment fragment = this.juspayServices.getFragment();
        if (fragment == null || !fragment.isAdded()) {
            this.requestQueue.add(new RequestQueueData(strArr, i));
        } else {
            fragment.requestPermissions(strArr, i);
        }
    }
}
