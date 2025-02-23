package in.juspay.hypersdk.core;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.firebase.sessions.settings.RemoteSettings;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.constants.LogCategory;
import in.juspay.hyper.constants.LogSubCategory;
import java.util.HashMap;
import org.json.JSONObject;

public class MPINUtil {
    private static final String TAG = "MPINUtil";
    private static HashMap<String, MPINUtil> orchestrator;
    private final ComponentName component;
    private GodelServiceConnection connection;

    private MPINUtil(JuspayServices juspayServices, String str, String str2) {
        this.connection = new GodelServiceConnection(juspayServices);
        this.component = new ComponentName(str, str2);
    }

    private boolean bind(Context context) {
        Intent intent = new Intent();
        intent.setComponent(this.component);
        return context.bindService(intent, this.connection, 1);
    }

    public static void closeAllConnections(Context context) {
        HashMap<String, MPINUtil> hashMap = orchestrator;
        if (hashMap != null) {
            for (String closeConnection : hashMap.keySet()) {
                closeConnection(closeConnection, context);
            }
        }
        orchestrator = null;
    }

    public static void closeConnection(String str, Context context) {
        HashMap<String, MPINUtil> hashMap = orchestrator;
        if (hashMap != null && hashMap.containsKey(str)) {
            MPINUtil mPINUtil = orchestrator.get(str);
            if (mPINUtil != null) {
                mPINUtil.unbind(context);
            }
            orchestrator.remove(str);
        }
    }

    public static void communicate(String str, String str2, int i, Bundle bundle, JuspayServices juspayServices, String str3) {
        MPINUtil mPINUtil;
        String str4;
        SdkTracker sdkTracker = juspayServices.getSdkTracker();
        try {
            sdkTracker.trackAction(LogSubCategory.Action.SYSTEM, "info", Labels.System.MPIN_UTIL, "mpinutil_communicate", "Attempting to communicate to " + str + RemoteSettings.FORWARD_SLASH_STRING + str2);
            if (orchestrator == null) {
                orchestrator = new HashMap<>();
            }
            if (orchestrator.containsKey(str)) {
                sdkTracker.trackAction(LogSubCategory.Action.SYSTEM, "info", Labels.System.MPIN_UTIL, "mpinutil_communicate", "Fetching existing instance from orchestrator");
                mPINUtil = orchestrator.get(str);
            } else {
                MPINUtil mPINUtil2 = new MPINUtil(juspayServices, str, str2);
                sdkTracker.trackAction(LogSubCategory.Action.SYSTEM, "info", Labels.System.MPIN_UTIL, "mpinutil_communicate", "Creating new MPINUtil instance in orchestrator");
                if (!mPINUtil2.bind(juspayServices.getContext())) {
                    sdkTracker.trackAction(LogSubCategory.Action.SYSTEM, "info", Labels.System.MPIN_UTIL, "mpinutil_communicate", "Failed to bind to MPIN SDK. Reporting Bind Failure back to mApp");
                    reportBindFailure(i, juspayServices, str3);
                    return;
                }
                orchestrator.put(str, mPINUtil2);
                mPINUtil = mPINUtil2;
            }
            if (mPINUtil != null) {
                if (mPINUtil.connection != null) {
                    sdkTracker.trackAction(LogSubCategory.Action.SYSTEM, "info", Labels.System.MPIN_UTIL, "mpinutil_communicate", "Requesting a connection with MPIN SDK");
                    mPINUtil.connection.request(i, bundle, new GodelServiceResponseHandler(str3, juspayServices));
                    return;
                }
            }
            if (mPINUtil == null) {
                str4 = "mpinUtil";
            } else {
                str4 = "mpinUtil.connection";
            }
            sdkTracker.trackAction(LogSubCategory.Action.SYSTEM, "info", Labels.System.MPIN_UTIL, "mpinutil_communicate", str4.concat(" is null. Reporting Bind Failure back to mApp"));
            reportBindFailure(i, juspayServices, str3);
        } catch (Exception e) {
            SdkTracker sdkTracker2 = sdkTracker;
            sdkTracker2.trackAction(LogSubCategory.Action.SYSTEM, "info", Labels.System.MPIN_UTIL, "mpinutil_communicate", "Failed to bind to MPIN SDK. Reporting Bind Failure back to mApp");
            sdkTracker2.trackAndLogException(TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.MPIN_UTIL, "Exception while trying to connect", e);
            reportBindFailure(i, juspayServices, str3);
        }
    }

    public static void reportBindFailure(int i, JuspayServices juspayServices, String str) {
        if (str != null) {
            SdkTracker sdkTracker = juspayServices.getSdkTracker();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("code", i);
                jSONObject.put("error", true);
                jSONObject.put("message", "BIND_FAILURE");
            } catch (Exception e) {
                sdkTracker.trackAndLogException(TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.MPIN_UTIL, "Exception while creating bind failure response", e);
            }
            juspayServices.getJBridge().invokeCallbackInDUIWebview(str, jSONObject.toString());
        }
    }

    private void unbind(Context context) {
        GodelServiceConnection godelServiceConnection = this.connection;
        if (godelServiceConnection != null && godelServiceConnection.isBound) {
            try {
                context.unbindService(godelServiceConnection);
            } catch (Exception unused) {
            }
            this.connection = null;
        }
    }
}
