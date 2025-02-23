package in.juspay.hyper.core;

import android.app.Activity;
import android.content.Context;
import org.json.JSONObject;

public interface BridgeComponents {
    Activity getActivity();

    CallbackInvoker getCallbackInvoker();

    String getClientId();

    Context getContext();

    FileProviderInterface getFileProviderInterface();

    FragmentHooks getFragmentHooks();

    JsCallback getJsCallback();

    ReceiverInterface getReceiverInterface();

    JSONObject getSdkConfig();

    String getSdkName();

    TrackerInterface getTrackerInterface();
}
