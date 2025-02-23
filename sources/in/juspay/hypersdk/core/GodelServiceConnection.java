package in.juspay.hypersdk.core;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.google.firebase.sessions.settings.RemoteSettings;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.constants.LogCategory;
import in.juspay.hyper.constants.LogSubCategory;

class GodelServiceConnection implements ServiceConnection {
    private static final String TAG = "GodelServiceConnection";
    boolean isBound = false;
    private final JuspayServices juspayServices;
    private Messenger messenger = null;
    private Message pendingMsg = null;

    public GodelServiceConnection(JuspayServices juspayServices2) {
        this.juspayServices = juspayServices2;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            sdkTracker.trackAction(LogSubCategory.Action.SYSTEM, "info", Labels.System.GODEL_SERVICE_CONNECTION, "gsc_on_service_connected", "Successfully connected to " + componentName.getPackageName() + RemoteSettings.FORWARD_SLASH_STRING + componentName.getClassName());
            this.messenger = new Messenger(iBinder);
            this.isBound = true;
            request(this.pendingMsg);
        } catch (Exception e) {
            sdkTracker.trackAndLogException(TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.MPIN_UTIL, "Exception while trying to send message", e);
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.messenger = null;
        this.isBound = false;
    }

    public void request(int i, Bundle bundle, Handler handler) {
        this.juspayServices.getSdkTracker().trackAction(LogSubCategory.Action.SYSTEM, "info", Labels.System.GODEL_SERVICE_CONNECTION, "gsc_request", "Sending request to MPIN SDK");
        Message obtain = Message.obtain((Handler) null, i);
        obtain.setData(bundle);
        obtain.replyTo = new Messenger(handler);
        request(obtain);
    }

    public void request(Message message) {
        if (this.isBound) {
            this.messenger.send(message);
        } else {
            this.pendingMsg = message;
        }
    }
}
