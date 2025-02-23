package in.juspay.hypersdk.core;

import android.webkit.JavascriptInterface;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.constants.LogCategory;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hyper.core.JuspayLogger;
import in.juspay.hypersdk.utils.Utils;
import org.json.JSONException;
import org.json.JSONObject;

public class HyperJsInterface extends JsInterface {
    private static final String LOG_TAG = "HyperJsInterface";

    public HyperJsInterface(JuspayServices juspayServices) {
        super(juspayServices);
    }

    @JavascriptInterface
    public String checkPermission(String[] strArr) {
        JSONObject jSONObject = new JSONObject();
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        for (String str : strArr) {
            try {
                jSONObject.put(str, Utils.checkIfGranted(this.juspayServices, str));
            } catch (JSONException e) {
                sdkTracker.trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.JBRIDGE, "Caught this exception while setting in JSON: ", e);
            }
        }
        return jSONObject.toString();
    }

    @JavascriptInterface
    public void downloadApps(String str) {
        JuspayLogger.e(LOG_TAG, "Method downloadApps() has empty body");
    }

    @JavascriptInterface
    public void hideKeyboard() {
        JuspayLogger.e(LOG_TAG, "Method hideKeyboard() has empty body");
    }

    @JavascriptInterface
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        JuspayLogger.e(LOG_TAG, "Please override onRequestPermissionsResult");
    }

    @JavascriptInterface
    public void requestPermission(String[] strArr, String str) {
        this.juspayServices.requestPermission(strArr, Integer.parseInt(str));
    }

    @JavascriptInterface
    public void setClickFeedback(String str) {
        JuspayLogger.e(LOG_TAG, "Method setClickFeedback(String) has empty body");
    }

    @JavascriptInterface
    public void exitApp(int i, String str) {
    }
}
